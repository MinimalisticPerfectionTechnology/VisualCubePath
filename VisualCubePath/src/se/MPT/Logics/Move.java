package se.MPT.Logics;

public enum Move {

	R("R"), RP("R'"), R2("R2"), U("U"), UP("U'"), U2("U2"), F("F"), FP("F'"), F2("F2");

	private final String m;

	private Move(final String text) {
		this.m = text;
	}

	@Override
	public String toString() {
		return m;
	}
}
