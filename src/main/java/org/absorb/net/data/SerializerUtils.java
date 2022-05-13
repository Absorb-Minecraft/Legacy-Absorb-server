package org.absorb.net.data;

import java.nio.ByteBuffer;

public final class SerializerUtils {

    private SerializerUtils() {
        throw new RuntimeException("Should not be running");
    }

    public static ByteBuffer collect(Iterable<? extends ByteBuffer> collection) {
        ByteBuffer buffer = ByteBuffer.allocate(0);
        for (ByteBuffer value : collection) {
            ByteBuffer temp = ByteBuffer.allocate(buffer.limit() + value.limit());
            temp.put(buffer);
            temp.put(value);
            buffer = temp;
        }
        return buffer;
    }

    public static ByteBuffer createPacket(int id, ByteBuffer... bytesToSend) {
        int count = 0;
        for (ByteBuffer bytes : bytesToSend) {
            count = count + bytes.capacity();
        }

        byte[] allBytesToSend = new byte[count];
        int previousTo = 0;
        for (ByteBuffer bytes : bytesToSend) {
            for (int index = 0; index < bytes.capacity(); index++) {
                allBytesToSend[previousTo + index] = bytes.get(index);
            }
            previousTo = previousTo + bytes.capacity();
        }


        ByteBuffer idBytes = Serializers.VAR_INTEGER.write(id);
        ByteBuffer lengthBytes = Serializers.VAR_INTEGER.write(allBytesToSend.length + idBytes.capacity());

        byte[] returnBytes = new byte[lengthBytes.capacity() + idBytes.capacity() + allBytesToSend.length];
        for (int index = 0; index < lengthBytes.capacity(); index++) {
            returnBytes[index] = lengthBytes.get(index);
        }
        for (int index = 0; index < idBytes.capacity(); index++) {
            returnBytes[lengthBytes.capacity() + index] = idBytes.get(index);
        }
        for (int index = 0; index < allBytesToSend.length; index++) {
            returnBytes[lengthBytes.capacity() + idBytes.capacity() + index] = allBytesToSend[index];
        }

        return ByteBuffer.wrap(returnBytes);
    }
}
