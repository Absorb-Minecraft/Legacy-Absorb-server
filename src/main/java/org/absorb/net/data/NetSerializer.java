package org.absorb.net.data;

import java.nio.ByteBuffer;

public interface NetSerializer<D> {

    NetEntryData<D> read(int position, ByteBuffer bytes);

    ByteBuffer write(D value);
}
