package org.absorb.net.data.inventory;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.AbsorbManagers;
import org.absorb.inventory.item.ItemStack;
import org.absorb.inventory.item.ItemStackBuilder;
import org.absorb.inventory.slot.Slot;
import org.absorb.inventory.slot.UnknownSlot;
import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.Serializer;
import org.absorb.net.data.Serializers;

import java.nio.ByteBuffer;
import java.util.Optional;

public class SlotSerializer implements Serializer<Slot> {
    @Override
    public NetEntryData<Slot> read(int position, ByteBuffer bytes) {
        NetEntryData<Boolean> present = Serializers.BOOLEAN.read(position, bytes);
        if (!present.value()) {
            return new NetEntryData<>(position, present.endingPosition(), new UnknownSlot(null, null));
        }
        NetEntryData<Integer> itemId = Serializers.VAR_INTEGER.read(present.endingPosition(), bytes);
        NetEntryData<Byte> stackSize = Serializers.BYTE.read(itemId.endingPosition(), bytes);
        NetEntryData<NBTCompound> data = Serializers.NBT_COMPOUND_ENTRIES.read(stackSize.endingPosition(), bytes);
//TODO conform data
        ItemStack stack =
                new ItemStackBuilder()
                        .setStackSize(stackSize.value())
                        .setType(AbsorbManagers.getRegistryManager().getItemTypeWithNetworkId(itemId.value()))
                        .build();
        Slot slot = new UnknownSlot(null, stack);
        return new NetEntryData<>(position, data.endingPosition(), slot);
    }

    @Override
    public ByteBuffer write(Slot value) {
        Optional<ItemStack> opItem = value.getItem();
        if (opItem.isEmpty()) {
            return Serializers.BOOLEAN.write(false);
        }
        ItemStack stack = opItem.get();
        ByteBuffer present = Serializers.BOOLEAN.write(true);
        ByteBuffer itemId = Serializers.VAR_INTEGER.write(stack.getType().getNetworkId());
        ByteBuffer stackSize = Serializers.BYTE.write(stack.getStackSize());
        //TODO - extra data
        ByteBuffer ret = ByteBuffer.allocate(present.limit() + itemId.limit() + stackSize.limit());
        ret.put(present);
        ret.put(itemId);
        ret.put(stackSize);
        return ret;
    }
}
