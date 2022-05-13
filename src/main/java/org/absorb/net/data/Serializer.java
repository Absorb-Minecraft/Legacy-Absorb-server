package org.absorb.net.data;

import java.nio.ByteBuffer;

public interface Serializer<D> {

    NetEntryData<D> read(int position, ByteBuffer bytes);

    ByteBuffer write(D value);
}
