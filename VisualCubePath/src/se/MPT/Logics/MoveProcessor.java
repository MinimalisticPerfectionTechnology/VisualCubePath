package se.MPT.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class MoveProcessor {

	private Set<Permutation> set1;
	private Set<Permutation> set2;
	private Permutation result = null;
	private Permutation result2 = null;
	private Move[] answere = null;

	public MoveProcessor(PieceColor[] startPerrm, boolean shuffledProcessor) {
		answere = new Move[0];
		this.set1 = new HashSet<Permutation>();
		this.set2 = new HashSet<Permutation>();
		Permutation p = new Permutation(startPerrm, new Move[0]);
		Permutation p2 = new Permutation(Generator.solvedColors(), new Move[0]);
		temporaryList2.add(p2);
		temporaryList.add(p);
		set1.add(p);
		set2.add(p2);
		if (!p.equals(p2)) {
			runAlgorithm();
		} else {
			// ui.setFinalAnswere("[Solved]");
		}
	}

	ArrayList<Permutation> temporaryList = new ArrayList<Permutation>();
	ArrayList<Permutation> temporaryList2 = new ArrayList<Permutation>();

	private void runAlgorithm() {
		ArrayList<Permutation> newList = new ArrayList<Permutation>();
		for (Permutation p : temporaryList) {
			for (Move m : Move.values()) {
				Move[] moves = Arrays.copyOf(p.getMoves(), p.getMoves().length + 1);
				moves[p.getMoves().length] = m;
				Permutation p2 = new Permutation(PermGenerator.generate(p.getPieceColor(), m), moves);
				if (set2.contains(p2)) {
					result = p2;
					Iterator<Permutation> i;
					i = set2.iterator();
					while (i.hasNext()) {

						Permutation pTemp = i.next();
						if (pTemp.equals(result)) {
							result2 = pTemp;
							break;
						}
					}
					answere = generateAnswere();
					return;
				} else if (set1.add(p2)) {
					newList.add(p2);
				}
			}

		}
		temporaryList = newList;
		runAlgorithm2();
	}

	private void runAlgorithm2() {
		ArrayList<Permutation> newList = new ArrayList<Permutation>();
		for (Permutation p : temporaryList2) {
			for (Move m : Move.values()) {
				Move[] moves = Arrays.copyOf(p.getMoves(), p.getMoves().length + 1);
				moves[p.getMoves().length] = m;
				Permutation p2 = new Permutation(PermGenerator.generate(p.getPieceColor(), m), moves);
				if (set1.contains(p2)) {
					result2 = p2;
					Iterator<Permutation> i;
					i = set1.iterator();
					while (i.hasNext()) {

						Permutation pTemp = i.next();
						if (pTemp.equals(result2)) {
							result = pTemp;
							break;
						}
					}
					answere = generateAnswere();
					return;
				} else if (set2.add(p2)) {
					newList.add(p2);
				}
			}
		}
		temporaryList2 = newList;
		runAlgorithm();
	}

	private Move[] generateAnswere() {
		Move[] both = Stream.concat(Arrays.stream(result.getMoves()), Arrays.stream(Utils.reverseMoves(result2.getMoves()))).toArray(Move[]::new);
		return both;
	}

	public Move[] getAnswere() {
		return answere;
	}
}
