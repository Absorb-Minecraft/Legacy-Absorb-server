package org.absorb.utils.compare;

import org.spongepowered.math.vector.Vector3i;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class Vector3Compare {

	public static Comparator<Vector3i> XYZ_I =
			(vector3i, t1) -> compareOn(vector3i, t1, Vector3i::x, Vector3i::y, Vector3i::z);

	private static <V> int compareOn(V vector1, V vector2, ToIntFunction<V> first,
			ToIntFunction<V> second, ToIntFunction<V> third) {
		int compare = first.applyAsInt(vector1) - first.applyAsInt(vector2);
		if (compare != 0) {
			return compare;
		}
		compare = second.applyAsInt(vector1) - second.applyAsInt(vector2);
		if (compare != 0) {
			return compare;
		}
		return third.applyAsInt(vector1) - third.applyAsInt(vector2);
	}

	;
}
