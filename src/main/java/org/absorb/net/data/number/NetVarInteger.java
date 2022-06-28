package org.absorb.net.data.number;

import org.absorb.net.data.NetEntryData;
import org.absorb.net.data.NetSerializer;

import java.nio.ByteBuffer;

public class NetVarInteger implements NetSerializer<Integer> {

    private static final int SEGMENT_BITS = 0x7F;
    private static final int CONTINUE_BIT = 0x80;


    @Override
    public NetEntryData<Integer> read(int position, ByteBuffer buffer) {
        byte[] bytes = buffer.array();
        byte currentByte;
        int value = 0;
        int positionTo = position;
        int pos = 0;
        while (true) {
            if (positionTo >= bytes.length) {
                break;
            }
            currentByte = bytes[positionTo];
            value |= (currentByte & SEGMENT_BITS) << pos;
            positionTo++;
            if ((currentByte & CONTINUE_BIT)==0) {
                break;
            }
            pos += 7;
            if (pos >= 32) {
                throw new RuntimeException("VarInteger cannot be larger then 32 bits");
            }
        }

        return new NetEntryData<>(position, positionTo, value);
    }

    @Override
    public ByteBuffer write(Integer value) {
        byte[] bytes = new byte[0];
        while (true) {
            if ((value & ~SEGMENT_BITS)==0) {
                byte[] newBytes = new byte[bytes.length + 1];
                System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
                newBytes[bytes.length] = value.byteValue();
                return ByteBuffer.wrap(newBytes);
            }
            byte[] newBytes = new byte[bytes.length + 1];
            System.arraycopy(bytes, 0, newBytes, 0, bytes.length);
            newBytes[bytes.length] = (byte) ((value & SEGMENT_BITS) | CONTINUE_BIT);
            bytes = newBytes;
            value >>>= 7;
        }

        /*if ((value & (0xFFFFFFFF << 7))==0) {
            ByteBuffer buf = ByteBuffer.allocate(Byte.BYTES);
            buf.put(value.byteValue());
            return buf;
        }
        if ((value & (0xFFFFFFFF << 14))==0) {
            ByteBuffer buf = ByteBuffer.allocate(Short.BYTES);
            buf.putShort((short) ((value & 0x7F | 0x80) << 8 | (value >>> 7)));
            return buf;
        }
        if ((value & (0xFFFFFFFF << 21))==0) {
            ByteBuffer buf = ByteBuffer.allocate(3);
            buf.put((byte) (value & 0x7F | 0x80));
            buf.put((byte) ((value >>> 7) & 0x7F | 0x80));
            buf.put((byte) (value >>> 14));
            return buf;
        }
        if ((value & (0xFFFFFFFF << 28))==0) {
            ByteBuffer buf = ByteBuffer.allocate(Integer.BYTES);
            buf.putInt((value & 0x7F | 0x80) << 24 | (((value >>> 7) & 0x7F | 0x80) << 16)
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | (value >>> 21));
            return buf;
        }
        ByteBuffer buf = ByteBuffer.allocate(Integer.BYTES + 1);
        buf.putInt((value & 0x7F | 0x80) << 24 | ((value >>> 7) & 0x7F | 0x80) << 16
                | ((value >>> 14) & 0x7F | 0x80) << 8 | ((value >>> 21) & 0x7F | 0x80));
        buf.put((byte) (value >>> 28));
        return buf;*/

    }
}
