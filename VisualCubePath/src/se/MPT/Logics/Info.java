package se.MPT.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Info {
	private List<Move> godsAlgorithm;
	private String godsAlgorithmString;

	public String getPathString() {
		return godsAlgorithmString;
	}

	public String getClock() {
		return clock;
	}

	private String clock;

	public Info(Move[] pathArray, String clock) {
		godsAlgorithm = new ArrayList<>(pathArray.length);
		append(pathArray);
		this.clock = clock;
		this.godsAlgorithmString = Arrays.toString(pathArray);
		godsAlgorithmString = godsAlgorithm.toString();
	}

	private void append(Move[] path) {
		for (Move move : path) {
			this.godsAlgorithm.add(move);
		}
	}

	public Info() {
		this.godsAlgorithm = new ArrayList<>();
		this.clock = "";
		godsAlgorithmString = "";
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

	@Override
	public String toString() {
		return "Info [path=" + godsAlgorithm + ", clock=" + clock + "]";
	}

}
