package com.choelinska.horrorlibz.util;

public enum Rating {
	THREE, SEVEN, THIRTEEN, SIXTEEN, EIGHTEEN, TWENTYONE;

	@Override public String toString() {
		switch (this.name()){
		case "THREE":
			return "3+";

		case "SEVEN":
			return "7+";

		case "THIRTEEN":
			return "13+";

		case "EIGHTEEN":
			return "18+";

		case "TWENTYONE":
			return "21+";

		default:
			return "UNKNOWN";
		}
	}
}
