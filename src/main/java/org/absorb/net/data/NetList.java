package org.absorb.net.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class NetList<T> implements NetSerializer<List<T>> {

	private final NetSerializer<T> serializer;
	private final @Nullable Integer size;

	public NetList(@NotNull NetSerializer<T> serializer) {
		this(serializer, null);
	}

	public NetList(@NotNull NetSerializer<T> serializer, @Nullable Integer size) {
		this.serializer = serializer;
		this.size = size;
	}

	@Override
	public NetEntryData<List<T>> read(int position, ByteBuffer bytes) {
		int count = 0;
		int start = position;
		if (this.size == null) {
			NetEntryData<Integer> countEntry = NetSerializers.VAR_INTEGER.read(position, bytes);
			start = countEntry.endingPosition();
			count = countEntry.value();
		}else{
			count = this.size;
		}
		int previous = start;
		List<T> list = new ArrayList<>(count);
		for (int i = 0; i < count; i++) {
			NetEntryData<T> v = this.serializer.read(previous, bytes);
			previous = v.endingPosition();
			list.add(v.value());
		}
		return new NetEntryData<>(position, previous, list);
	}

	@Override
	public ByteBuffer write(List<T> value) {
		ByteBuffer ret = ByteBuffer.allocate(0);
		if (this.size == null) {
			ret = NetSerializers.VAR_INTEGER.write(value.size());
		}
		for (T entry : value) {
			ByteBuffer entryBuffer = this.serializer.write(entry);
			ByteBuffer temp = ByteBuffer.allocate(entryBuffer.limit() + ret.limit());
			temp.put(ret.array());
			temp.put(entryBuffer.array());
			ret = temp;
		}
		return ret;
	}
}
