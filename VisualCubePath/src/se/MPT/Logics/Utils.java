package se.MPT.Logics;

public class Utils {
	public static Move[] reverseMoves(Move[] moves) {

		for (int i = 0; i < moves.length / 2; i++) {
			Move temp = moves[i];
			moves[i] = moves[moves.length - i - 1];
			moves[moves.length - i - 1] = temp;
		}

		return convertToReversed(moves);

	}

	private static Move[] convertToReversed(Move[] moves) {

		for (int i = 0; i < moves.length; i++) {
			moves[i] = reversedMove(moves[i]);
		}
		return moves;
	}

	public static Move reversedMove(Move move) {
		switch (move) {
		case F:
			return Move.FP;
		case F2:
			return Move.F2;
		case FP:
			return Move.F;
		case R:
			return Move.RP;
		case R2:
			return Move.R2;
		case RP:
			return Move.R;
		case U:
			return Move.UP;
		case U2:
			return Move.U2;
		case UP:
			return Move.U;
		}
		return null;
	}
}
