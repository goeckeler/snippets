package com.goeckeler.lang;

public final class Trilean implements java.io.Serializable, Comparable<Trilean> {
	private static final long serialVersionUID = -7034530309911889656L;

	public static final Trilean TRUE = new Trilean(true);
	public static final Trilean FALSE = new Trilean(false);
	public static final Trilean UNDEFINED = new Trilean((Boolean) null);

	private final Boolean value;

	private Trilean(final Boolean booleanValue) {
		this.value = booleanValue;
	}

	public final static Trilean valueOf(final Boolean bool) {
		return (bool == null ? UNDEFINED : (bool ? TRUE : FALSE));
	}

	public final static Trilean valueOf(final String string) {
		if ("true".equalsIgnoreCase(string)) {
			return TRUE;
		}
		if ("false".equalsIgnoreCase(string)) {
			return FALSE;
		}
		return UNDEFINED;
	}

	public final Boolean booleanValue() {
		return value;
	}

	public final boolean isTrue() {
		return value != null && value.booleanValue();
	}

	public final boolean isFalse() {
		return value != null && !value.booleanValue();
	}

	public final boolean isUndefined() {
		return value == null;
	}

	public final boolean isTrueOrUndefined() {
		return value == null || isTrue();
	}

	public final boolean isFalseOrUndefined() {
		return value == null || isFalse();
	}

	@Override
	public final int hashCode() {
		return value == null ? 1229 : value.hashCode();
	}

	@Override
	public final boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other == null || !this.getClass().isAssignableFrom(other.getClass())) {
			return false;
		}

		return this.toString().equals(other.toString());
	}

	@Override
	public final int compareTo(final Trilean that) {
		if (that == null) {
			return 1;
		}
		if (this == that) {
			return 0;
		}
		return this.toString().compareTo(that.toString());
	}

	@Override
	public final String toString() {
		if (value == null) {
			return "undefined";
		}

		return value.toString();
	}
}
