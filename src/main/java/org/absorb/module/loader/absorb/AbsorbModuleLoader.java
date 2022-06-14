package org.absorb.module.loader.absorb;

import org.absorb.AbsorbManagers;
import org.absorb.event.events.module.load.construct.ConstructModuleEvent;
import org.absorb.files.json.SimpleNode;
import org.absorb.module.loader.FileModuleLoader;
import org.absorb.module.version.StandardVersion;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

public class AbsorbModuleLoader implements FileModuleLoader<AbsorbModule> {

    public static final SimpleNode<String> NAME = SimpleNode.asString(true, "name");
    public static final SimpleNode<String> ID = SimpleNode.asString(true, "id");
    public static final SimpleNode<Integer> MAJOR_VERSION = SimpleNode.asInteger(true, "version", "major");
    public static final SimpleNode<Integer> MINOR_VERSION = SimpleNode.asInteger(true, "version", "minor");
    public static final SimpleNode<Integer> PATCH_VERSION = SimpleNode.asInteger(true, "version", "patch");
    public static final SimpleNode<String> MAIN_CLASS = SimpleNode.asString(true, "entry", "main");
    public static final SimpleNode<String> DESCRIPTION = SimpleNode.asString(false, "info", "description");

    public static final File MODULE_FOLDER = new File("Modules");

    private boolean disableCanLoadChecks;

    public boolean canLoadChecksEnabled() {
        return !this.disableCanLoadChecks;
    }

    public void setLoadCheckEnabled(boolean check) {
        this.disableCanLoadChecks = !check;
    }

    public @NotNull Collection<File> getCanLoad() {
        return this.getCanLoad(MODULE_FOLDER);
    }

    public @NotNull Collection<File> getCanLoad(@NotNull File folder) {
        File[] files = folder.listFiles();
        if (files==null) {
            return Collections.emptyList();
        }
        if (this.disableCanLoadChecks) {
            return Set.of(files);
        }
        return Arrays.stream(files).parallel().filter(this::canLoad).collect(Collectors.toSet());
    }

    @Override
    public boolean canLoad(@NotNull File module) {
        JarFile file;
        try {
            file = new JarFile(module);
        } catch (IOException e) {
            return false;
        }
        ZipEntry entry = file.getEntry("META-INF/absorb_module.json");
        InputStream stream;
        try {
            stream = file.getInputStream(entry);
        } catch (IOException e) {
            return false;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String json = br.lines().collect(Collectors.joining("\n"));
        ConfigurationNode node;
        try {
            node = JacksonConfigurationLoader.builder().buildAndLoadString(json);
            String projectName = NAME.getValue(node).orElse(null);
            if (projectName==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            String projectId = ID.getValue(node).orElse(null);
            if (projectId==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            String mainClass = MAIN_CLASS.getValue(node).orElse(null);
            if (mainClass==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            Integer versionMajor = MAJOR_VERSION.getValue(node).orElse(null);
            if (versionMajor==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            Integer versionMinor = MINOR_VERSION.getValue(node).orElse(null);
            if (versionMinor==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
            Integer versionPatch = PATCH_VERSION.getValue(node).orElse(null);
            if (versionPatch==null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }

        } catch (ConfigurateException e) {
            try {
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return false;
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public @NotNull AbsorbModule create(@NotNull File module) throws IOException {
        JarFile file;
        file = new JarFile(module);

        ZipEntry entry = file.getEntry("META-INF/absorb_module.json");
        InputStream stream;
        stream = file.getInputStream(entry);


        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String json = br.lines().collect(Collectors.joining("\n"));
        ConfigurationNode node;
        node = JacksonConfigurationLoader.builder().buildAndLoadString(json);
        String projectName = NAME.getValue(node).orElse(null);
        if (projectName==null) {
            file.close();
            throw new IOException("Project Name missing");
        }
        String projectId = ID.getValue(node).orElse(null);
        if (projectId==null) {
            file.close();

            throw new IOException("Project ID missing");
        }
        String mainClass = MAIN_CLASS.getValue(node).orElse(null);
        if (mainClass==null) {
            file.close();

            throw new IOException("Main class missing");
        }
        Integer versionMajor = MAJOR_VERSION.getValue(node).orElse(null);
        if (versionMajor==null) {
            file.close();

            throw new IOException("Major version missing");
        }
        Integer versionMinor = MINOR_VERSION.getValue(node).orElse(null);
        if (versionMinor==null) {
            file.close();

            throw new IOException("Minor version missing");
        }
        Integer versionPatch = PATCH_VERSION.getValue(node).orElse(null);
        if (versionPatch==null) {
            file.close();

            throw new IOException("Patch version missing");
        }
        String description = DESCRIPTION.getValue(node).orElse(null);

        file.close();

        return (AbsorbModule) new AbsorbModuleBuilder()
                .setFile(module)
                .setDisplayName(projectName)
                .setVersion(new StandardVersion(versionMajor, versionMinor, versionPatch))
                .setKeyName(projectId)
                .setMainClass(mainClass)
                .setDescription(description)
                .build();
    }

    @Override
    public void load(@NotNull AbsorbModule module) throws IOException {
        URLClassLoader urlLoader = new URLClassLoader(new URL[]{module.getFile().toURI().toURL()});
        JarFile jar = new JarFile(module.getFile());
        Enumeration<JarEntry> entries = jar.entries();
        Class<?> mainClass = null;
        while (entries.hasMoreElements()) {
            JarEntry current = entries.nextElement();
            if (current.isDirectory()) {
                continue;
            }
            if (!current.getName().endsWith(".class")) {
                continue;
            }
            Class<?> clazz;
            String className = current.getName().replaceAll("/", ".").substring(0,
                    current.getName().length() - 6);
            try {
                clazz = urlLoader.loadClass(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                continue;
            }
            if (className.equals(module.getMainClass())) {
                mainClass = clazz;
            }
        }
        if (mainClass==null) {
            throw new IOException("Could not find Main Class, jar was loaded for library use however this is not " +
                    "a supported way");
        }
        Object mainInstance;
        try {
            Constructor<?> cons = mainClass.getConstructor();
            mainInstance = cons.newInstance();
        } catch (NoSuchMethodException e) {
            throw new IOException("Main class should not have a constructor", e);
        } catch (InvocationTargetException | InstantiationException e) {
            throw new IOException(e);
        } catch (IllegalAccessException e) {
            throw new IOException("Main class should have a public constructor", e);
        }
        AbsorbManagers.getEventManager().registerAll(mainInstance);

        AbsorbManagers.getEventManager().callAsynced(new ConstructModuleEvent(module, this));
    }
}
