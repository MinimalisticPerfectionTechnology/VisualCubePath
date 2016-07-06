package se.MPT.Logics;

public class Info {
	private String path;

	public String getPath() {
		return path;
	}

	public String getClock() {
		return clock;
	}

	private String clock;

	public Info(String path, String clock) {
		this.path = path;
		this.clock = clock;
	}

	@Override
	public String toString() {
		return "Info [path=" + path + ", clock=" + clock + "]";
	}

}
