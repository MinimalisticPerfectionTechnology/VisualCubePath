package se.MPT.Logics;

import java.util.ArrayList;
import java.util.List;

public class Info {
	private List<Move> godsAlgorithm;

	public String getPathString() {
		return this.godsAlgorithm.toString();
	}

	public String getClock() {
		return clock;
	}

	private String clock;

	public Info(Move[] pathArray, String clock) {
		godsAlgorithm = new ArrayList<>(pathArray.length);
		append(pathArray);
		this.clock = clock;
	}

	private void append(Move[] path) {
		for (Move move : path) {
			this.godsAlgorithm.add(move);
		}
	}

	public Info() {
		this.godsAlgorithm = new ArrayList<>();
		this.clock = "";
	}

	public boolean isSolved() {
		return godsAlgorithm.isEmpty();
	}

	public Move getFirst() {
		return godsAlgorithm.get(0);
	}

	public void prune() {
		if (!godsAlgorithm.isEmpty()) {
			godsAlgorithm.remove(0);
		}
	}
}
