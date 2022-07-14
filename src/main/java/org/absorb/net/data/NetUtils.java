package org.absorb.net.data;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NetUtils {

    private static final int[] MAGIC = {-1,
                                        -1,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        0,
                                        1431655765,
                                        1431655765,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        1,
                                        858993459,
                                        858993459,
                                        0,
                                        715827882,
                                        715827882,
                                        0,
                                        613566756,
                                        613566756,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        2,
                                        477218588,
                                        477218588,
                                        0,
                                        429496729,
                                        429496729,
                                        0,
                                        390451572,
                                        390451572,
                                        0,
                                        357913941,
                                        357913941,
                                        0,
                                        330382099,
                                        330382099,
                                        0,
                                        306783378,
                                        306783378,
                                        0,
                                        286331153,
                                        286331153,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        3,
                                        252645135,
                                        252645135,
                                        0,
                                        238609294,
                                        238609294,
                                        0,
                                        226050910,
                                        226050910,
                                        0,
                                        214748364,
                                        214748364,
                                        0,
                                        204522252,
                                        204522252,
                                        0,
                                        195225786,
                                        195225786,
                                        0,
                                        186737708,
                                        186737708,
                                        0,
                                        178956970,
                                        178956970,
                                        0,
                                        171798691,
                                        171798691,
                                        0,
                                        165191049,
                                        165191049,
                                        0,
                                        159072862,
                                        159072862,
                                        0,
                                        153391689,
                                        153391689,
                                        0,
                                        148102320,
                                        148102320,
                                        0,
                                        143165576,
                                        143165576,
                                        0,
                                        138547332,
                                        138547332,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        4,
                                        130150524,
                                        130150524,
                                        0,
                                        126322567,
                                        126322567,
                                        0,
                                        122713351,
                                        122713351,
                                        0,
                                        119304647,
                                        119304647,
                                        0,
                                        116080197,
                                        116080197,
                                        0,
                                        113025455,
                                        113025455,
                                        0,
                                        110127366,
                                        110127366,
                                        0,
                                        107374182,
                                        107374182,
                                        0,
                                        104755299,
                                        104755299,
                                        0,
                                        102261126,
                                        102261126,
                                        0,
                                        99882960,
                                        99882960,
                                        0,
                                        97612893,
                                        97612893,
                                        0,
                                        95443717,
                                        95443717,
                                        0,
                                        93368854,
                                        93368854,
                                        0,
                                        91382282,
                                        91382282,
                                        0,
                                        89478485,
                                        89478485,
                                        0,
                                        87652393,
                                        87652393,
                                        0,
                                        85899345,
                                        85899345,
                                        0,
                                        84215045,
                                        84215045,
                                        0,
                                        82595524,
                                        82595524,
                                        0,
                                        81037118,
                                        81037118,
                                        0,
                                        79536431,
                                        79536431,
                                        0,
                                        78090314,
                                        78090314,
                                        0,
                                        76695844,
                                        76695844,
                                        0,
                                        75350303,
                                        75350303,
                                        0,
                                        74051160,
                                        74051160,
                                        0,
                                        72796055,
                                        72796055,
                                        0,
                                        71582788,
                                        71582788,
                                        0,
                                        70409299,
                                        70409299,
                                        0,
                                        69273666,
                                        69273666,
                                        0,
                                        68174084,
                                        68174084,
                                        0,
                                        Integer.MIN_VALUE,
                                        0,
                                        5};

    private NetUtils() {
        throw new RuntimeException("Should not be running");
    }

    public static Long[] encodeBlocks(int[] blocks, int bitsPerEntry) {

        //taken from https://github.com/Minestom/Minestom/blob/f2fec732022c1127c8edf702fe7da9e2afe9896e/src/main/java/net/minestom/server/utils/Utils.java#L135
        //only until i figure it out myself

        final long maxEntryValue = (1L << bitsPerEntry) - 1;
        final char valuesPerLong = (char) (64 / bitsPerEntry);
        final int magicIndex = 3 * (valuesPerLong - 1);
        final long divideMul = Integer.toUnsignedLong(MAGIC[magicIndex]);
        final long divideAdd = Integer.toUnsignedLong(MAGIC[magicIndex + 1]);
        final int divideShift = MAGIC[magicIndex + 2];
        final int size = (blocks.length + valuesPerLong - 1) / valuesPerLong;

        Long[] data = new Long[size];

        for (int i = 0; i < blocks.length; i++) {
            final long value = blocks[i];
            final int cellIndex = (int) (i * divideMul + divideAdd >> 32L >> divideShift);
            final int bitIndex = (i - cellIndex * valuesPerLong) * bitsPerEntry;
            Long previous = data[cellIndex];
            if (previous == null) {
                previous = 0L;
            }
            data[cellIndex] = previous & ~(maxEntryValue << bitIndex) | (value & maxEntryValue) << bitIndex;
        }

        return data;
    }

    public static ByteBuffer collect(Iterable<? extends ByteBuffer> collection) {
        ByteBuffer buffer = ByteBuffer.allocate(0);
        for (ByteBuffer value : collection) {
            ByteBuffer temp = ByteBuffer.allocate(buffer.limit() + value.limit());
            temp.put(buffer.array());
            temp.put(value.array());
            buffer = temp;
        }
        return buffer;
    }

    public static ByteBuffer collect(ByteBuffer... collection) {
        return collect(Arrays.asList(collection));
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


        ByteBuffer idBytes = NetSerializers.VAR_INTEGER.write(id);
        ByteBuffer lengthBytes = NetSerializers.VAR_INTEGER.write(allBytesToSend.length + idBytes.capacity());

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
