package se.MPT.Logics;

import java.util.Arrays;

public class Utils {
	public static Side[] convertToInt(String inPerm){
		Side[] outPerm = new Side[21];
		for(int i = 0; i < 21; i++){
			switch (inPerm.charAt(i)){
			case 'W': outPerm[i] = Side.WHITE;
			break;

			case 'w': outPerm[i] = Side.WHITE;
			break;

			case 'O': outPerm[i] = Side.ORANGE;
			break;

			case 'o': outPerm[i] = Side.ORANGE;
			break;

			case 'G': outPerm[i] = Side.GREEN;
			break;

			case 'g': outPerm[i] = Side.GREEN;
			break;

			case 'R': outPerm[i] = Side.RED;
			break;

			case 'r': outPerm[i] = Side.RED;
			break;

			case 'Y': outPerm[i] = Side.YELLOW;
			break;

			case 'y': outPerm[i] = Side.YELLOW;
			break;

			case 'B': outPerm[i] = Side.BLUE;
			break;

			case 'b': outPerm[i] = Side.BLUE;
			break;

			case '0': outPerm[i] = Side.WHITE;
			break;

			case '1': outPerm[i] = Side.ORANGE;
			break;

			case '2': outPerm[i] = Side.GREEN;
			break;

			case '3': outPerm[i] = Side.RED;
			break;

			case '4': outPerm[i] = Side.YELLOW;
			break;

			case '5': outPerm[i] = Side.BLUE;
			break;
			default:
			break;
			}
		}
		return outPerm;
	}

	public static Move[] reverseMoves(Move[] moves) {
		
		for(int i = 0; i < moves.length / 2; i++)
		{
		    Move temp = moves[i];
		    moves[i] = moves[moves.length - i - 1];
		    moves[moves.length - i - 1] = temp;
		}
		
		return convertToReversed(moves);

	}

	private static Move[] convertToReversed(Move[] moves) {

		for(int i = 0; i < moves.length; i++) {
			moves[i] = reversedMove(moves[i]);
		}
		return moves;
	}

	public static Move reversedMove(Move move) {
		switch(move) {
		case F: return Move.FP;
		case F2: return Move.F2;
		case FP: return Move.F;
		case R: return Move.RP;
		case R2: return Move.R2;
		case RP: return Move.R;
		case U: return Move.UP;
		case U2: return Move.U2;
		case UP: return Move.U;
		}
		return null;
	}
}