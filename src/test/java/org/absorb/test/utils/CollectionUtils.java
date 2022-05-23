package org.absorb.test.utils;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static <T> void findMatch(Collection<T> expected, Collection<?> incoming) {
        if (expected.stream().allMatch(value -> value instanceof Comparable)) {
            Collection<Comparable<?>> expectedString =
                    expected.stream().map(value -> (Comparable<T>) value).collect(Collectors.toSet());
            Collection<Comparable<?>> incomingString =
                    incoming.stream().map(value -> (Comparable<T>) value).collect(Collectors.toSet());
            callMatchNaturalOrder(expectedString, incomingString);
            return;
        }
        if (expected.stream().allMatch(value -> value instanceof Map<?, ?>) && expected.stream().map(value -> (Map<?,
                ?>) value).allMatch(map -> map.containsKey("id"))) {
            Collection<Map<?, ?>> expectedMap = expected.stream().map(value -> (Map<?, ?>) value).collect(Collectors.toSet());
            Collection<Map<?, ?>> incomingMap = incoming.stream().map(value -> (Map<?, ?>) value).collect(Collectors.toSet());
            match(expectedMap, incomingMap, Comparator.comparing(map -> map.get("id").toString()));
            return;
        }
        System.out.println("Could not find a match for " + incoming.getClass().getName() + " -> using toString");

        match(expected, (Collection<T>) incoming, Comparator.comparing(Object::toString));
    }

    private static <T extends Comparable<T>> void callMatchNaturalOrder(Collection<?> expected,
                                                                        Collection<?> incoming) {
        match((Collection<T>) expected, (Collection<T>) incoming);
    }

    public static <T extends Comparable<T>> void match(Collection<T> expected, Collection<T> incoming) {
        match(expected, incoming, Comparator.naturalOrder());
    }

    public static <T> void match(Collection<T> expected, Collection<T> incoming, Comparator<T> comparator) throws IllegalArgumentException {
        if (expected.size() > incoming.size()) {
            throw new IllegalArgumentException("Expected was larger then incoming: Expected(" + expected.size() + "):" +
                    " Incoming(" + incoming.size() + ")");
        }
        TreeSet<T> expectedTree = new TreeSet<>(comparator);
        TreeSet<T> incomingTree = new TreeSet<>(comparator);
        expectedTree.addAll(expected);
        incomingTree.addAll(incoming);
        for (int a = 0; a < expected.size(); a++) {
            Object expectedValue = expectedTree.pollFirst();
            Object incomingValue = incomingTree.pollFirst();
            if (expectedValue==null && incomingValue==null) {
                continue;
            }
            if (expectedValue==null) {
                throw new IllegalArgumentException("Expected: 'null'\nIncoming: '" + incomingValue + "'");
            }
            if (incomingValue==null) {
                throw new IllegalArgumentException("Expected: '" + expectedValue + "\nIncoming: 'null'");
            }
            if (expectedValue instanceof Map<?, ?> expectedMap) {
                if (incomingValue instanceof Map<?, ?> incomingMap) {
                    match(expectedMap, incomingMap);
                    continue;
                }
                throw new IllegalArgumentException("Expected a Map however got " + incomingValue.getClass().getName());
            }
            if (expectedValue instanceof Collection<?> expectedCollection) {
                if (incomingValue instanceof Collection<?> incomingCollection) {
                    findMatch(expectedCollection, incomingCollection);
                    continue;
                }
                throw new IllegalArgumentException("Expected a Collection however got " + incomingValue.getClass().getName());
            }
            if (!expectedValue.equals(incomingValue)) {
                throw new IllegalArgumentException("Expected: '" + expectedValue + "'\nIncoming: '" + incomingValue + "'");
            }
        }


    }

    public static void match(Map<?, ?> expected, Map<?, ?> incoming) throws IllegalArgumentException {
        for (Map.Entry<?, ?> entry : expected.entrySet()) {
            if (!incoming.containsKey(entry.getKey())) {
                throw new IllegalArgumentException("Could not find key of '" + entry.getKey() + "' in " + incoming.entrySet());
            }
            Object value = incoming.get(entry.getKey());
            if (entry.getValue() instanceof Collection<?> collection) {
                if (!(value instanceof Collection<?> result)) {
                    throw new IllegalArgumentException("The value of '" + entry.getKey() + "' was excepted to be a " +
                            "Collection, however was a " + value.getClass().getName());
                }
                try {
                    findMatch(collection, result);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Failed on key: " + entry.getKey(), e);
                }
                continue;
            }
            if (entry.getValue() instanceof Map<?, ?> map) {
                if (!(value instanceof Map<?, ?> result)) {
                    throw new IllegalArgumentException("The value of '" + entry.getKey() + "' was excepted to be a " +
                            "Map, however was a " + value.getClass().getName());
                }
                try {
                    match(map, result);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Exception on key " + entry.getKey() + " -> map matching\nMap " +
                            "found in list with " + expected.entrySet(),
                            e);
                }
                continue;
            }
            if (!entry.getValue().equals(value)) {
                throw new IllegalArgumentException("The value of '" + entry.getKey() + "' does not match \n'" + entry.getValue() + "' as '" + entry.getValue().getClass().getName() + " \n(Yours was \n'" + value + "' as '" + value.getClass().getName() + "'\n)");
            }
        }
    }
}
