package se.MPT.Logics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Algorithm {
	private long startTime;

	public Info solve(String permutation) {
		Map<String, Move[]> peersScrumbled = new HashMap<>();
		Map<String, Move[]> peersSolved = new HashMap<>();

		peersScrumbled.put(permutation, new Move[0]);
		peersSolved.put(PermGenerator.solved(), new Move[0]);

		Map<String, Move[]> mapFromScrumbled = new HashMap<>();
		Map<String, Move[]> mapFromSolved = new HashMap<>();

		mapFromScrumbled.put(permutation, new Move[0]);
		mapFromSolved.put(PermGenerator.solved(), new Move[0]);

		startTime = System.currentTimeMillis();
		return solve(peersSolved, peersScrumbled, mapFromScrumbled, mapFromSolved);
	}

	private Info solve(Map<String, Move[]> peers1, Map<String, Move[]> peers2, Map<String, Move[]> mapOther,
			Map<String, Move[]> mapOwn) {
		Map<String, Move[]> newPeers = new HashMap<>();
		Iterator<Entry<String, Move[]>> it = peers1.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Move[]> pair = it.next();
			String currentPerm = pair.getKey().toString();
			Move[] currentMoves = pair.getValue();
			Move lastMove = null;
			if (currentMoves.length > 0) {
				lastMove = currentMoves[currentMoves.length - 1];
			}
			for (Move move : Move.values()) {
				if (currentMoves.length > 0) {
					int tryIndex = move.ordinal();
					int lastIndex = lastMove.ordinal();
					int tryChunk = (int) ((float) tryIndex / 3.0F);
					int lastChunk = (int) ((float) lastIndex / 3.0F);
					if (tryChunk == lastChunk) {
						continue;
					}
				}

				Move[] movesExtended = Arrays.copyOf(currentMoves, currentMoves.length + 1);
				movesExtended[currentMoves.length] = move;
				String newPerm = PermGenerator.generate(currentPerm, move);
				if (mapOther.containsKey(newPerm)) {
					return new Info(Arrays.toString(generateAnswer(mapOther.get(newPerm), movesExtended)),
							Long.toString(System.currentTimeMillis() - startTime));
				} else if (!mapOwn.containsKey(newPerm)) {
					mapOwn.put(newPerm, movesExtended);
					newPeers.put(newPerm, movesExtended);
				}
			}
		}
		return solve(peers2, newPeers, new HashMap<>(newPeers), new HashMap<>(peers1));
	}

	private Move[] generateAnswer(Move[] result, Move[] result2) {
		Move[] both = null;
		if ((result.length + result2.length) % 2 == 0) {
			both = Stream.concat(Arrays.stream(result2), Arrays.stream(Utils.reverseMoves(result)))
					.toArray(Move[]::new);
		} else {
			both = Stream.concat(Arrays.stream(result), Arrays.stream(Utils.reverseMoves(result2)))
					.toArray(Move[]::new);
		}
		return both;
	}

}
