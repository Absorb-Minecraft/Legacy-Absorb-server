package org.absorb.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MarkedByteArrayInputStream extends ByteArrayInputStream {

    private long counter;

    public MarkedByteArrayInputStream(ByteBuffer buffer) {
        this(buffer.array());
    }

    public MarkedByteArrayInputStream(byte[] buf) {
        super(buf);
    }

    public long getCounter() {
        return this.counter;
    }

    @Override
    public synchronized int read() {
        int b = super.read();
        if (b >= 0) {
            this.counter++;
        }
        return b;
    }

    @Override
    public synchronized int read(byte[] b, int off, int len) {
        int ret = super.read(b, off, len);
        if (ret >= 0) {
            this.counter += ret;
        }
        return ret;
    }

    @Override
    public int read(byte... b) throws IOException {
        int ret = super.read(b);
        if (ret >= 0) {
            this.counter++;
        }
        return ret;
    }

    @Override
    public synchronized long skip(long skip) {
        long n = super.skip(skip);
        if (n > 0)
            this.counter += n;
        return n;
    }

    @Override
    public synchronized void reset() {
        super.reset();
        this.counter = 0;
    }
}
