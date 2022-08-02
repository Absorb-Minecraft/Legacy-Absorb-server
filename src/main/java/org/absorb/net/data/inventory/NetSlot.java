package org.absorb.net.data.inventory;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.AbsorbManagers;
import org.absorb.files.nbt.compound.NBTCompoundBuilder;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.item.ItemStackBuilder;
import org.absorb.inventory.item.data.StackData;
import org.absorb.inventory.item.data.StackDataKey;
import org.absorb.inventory.slot.Slot;
import org.absorb.inventory.slot.UnknownSlot;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;
import org.absorb.net.data.NetSerializers;
import org.absorb.register.RegistryManager;
import org.absorb.utils.AsJson;
import org.spongepowered.configurate.ConfigurateException;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Optional;

public class NetSlot implements NetSerializer<Slot> {

    @Override
    public NetEntryData<Slot> read(int position, ByteBuffer bytes) {
        NetEntryData<Boolean> present = NetSerializers.BOOLEAN.read(position, bytes);
        if (!present.value()) {
            return new NetEntryData<>(position, present.endingPosition(), new UnknownSlot(null, null));
        }
        NetEntryData<Integer> itemId = NetSerializers.VAR_INTEGER.read(present.endingPosition(), bytes);
        NetEntryData<Byte> stackSize = NetSerializers.BYTE.read(itemId.endingPosition(), bytes);
        NetEntryData<NBTCompound> data = NetSerializers.NBT_COMPOUND_ENTRIES.read(stackSize.endingPosition(), bytes);

        ItemStackBuilder builder = new ItemStackBuilder()
                .setStackSize(stackSize.value())
                .setType(AbsorbManagers.getRegistryManager().getItemTypeWithNetworkId(itemId.value()));

        RegistryManager
                .getVanillaValues(StackDataKey.class)
                .forEach(key -> this.addToStack(builder, key, data.value()));

        ItemStack stack = builder.build();
        Slot slot = new UnknownSlot(null, stack);
        return new NetEntryData<>(position, data.endingPosition(), slot);
    }

    @Override
    public ByteBuffer write(Slot value) {
        Optional<ItemStack> opItem = value.getItem();
        if (opItem.isEmpty()) {
            return NetSerializers.BOOLEAN.write(false);
        }
        ItemStack stack = opItem.get();
        ByteBuffer present = NetSerializers.BOOLEAN.write(true);
        ByteBuffer itemId = NetSerializers.VAR_INTEGER.write(stack.getType().getNetworkId());
        ByteBuffer stackSize = NetSerializers.BYTE.write(stack.getStackSize());

        System.out.println("Item: " + stack.getType().getResourceKey().asFormatted());

        ByteBuffer ret = ByteBuffer.allocate(present.limit() + itemId.limit() + stackSize.limit());
        ret.put(present);
        ret.put(itemId);
        ret.put(stackSize);

        NBTCompoundBuilder builder = new NBTCompoundBuilder();
        stack.getData().forEach(stackData -> builder.add(stackData.asCompoundEntry()));

        ByteBuffer nbtBuffer = NetSerializers.NBT_COMPOUND_ENTRIES.write(builder.build());
        ByteBuffer temp = ByteBuffer.allocate(ret.limit() + nbtBuffer.limit());
        temp.put(ret.array());
        temp.put(nbtBuffer.array());

        System.out.println("SlotData");
        System.out.println("Present: " + Arrays.toString(present.array()));
        System.out.println("ItemId: " + Arrays.toString(itemId.array()));
        System.out.println("ItemCount: " + Arrays.toString(stackSize.array()));
        try {
            System.out.println("NBT: " + AsJson.asJson(builder.build()));
        } catch (ConfigurateException e) {
        }
        System.out.println("NBT: " + Arrays.toString(nbtBuffer.array()));
        return temp;
    }

    private <V, T> void addToStack(ItemStackBuilder builder, StackDataKey<V, T> key, NBTCompound data) {
        Object obj = data.get(key.getName());
        if (obj == null) {
            return;
        }
        StackData<V, T> dataKey = key.with((T) obj);
        builder.addData(dataKey);
    }
}
