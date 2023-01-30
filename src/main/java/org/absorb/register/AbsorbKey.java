package org.absorb.register;

public record AbsorbKey(String host, String value) {

	public String asFormatted() {
		return this.host + ":" + this.value;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof AbsorbKey key)) {
			return false;
		}
		return this.asFormatted().equals(key.asFormatted());
	}

	@Override
	public int hashCode() {
		return this.asFormatted().hashCode();
	}

	public static AbsorbKey resolve(String value) {
		String[] split = value.split(":", 2);
		return new AbsorbKey(split[0], split[1]);
	}
}
