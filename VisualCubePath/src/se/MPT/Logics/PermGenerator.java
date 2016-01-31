package se.MPT.Logics;

public class PermGenerator {
	public static PieceColor[] generate(PieceColor[] permutation, Move move) {
		// PieceColor[] p = new PieceColor[permutation.length];
		// System.arraycopy(permutation, 0, p, 0, permutation.length);
		switch (move) {
		case R:

			return PermGenerator.r(permutation);
		// break;

		case R2:

			return PermGenerator.r2(permutation);
		// break;

		case RP:
			return PermGenerator.rI(permutation);
		// break;

		case U:
			return PermGenerator.u(permutation);
		// break;

		case U2:
			return PermGenerator.u2(permutation);
		// break;
		case UP:
			return PermGenerator.uI(permutation);
		// break;
		case F:
			return PermGenerator.f(permutation);

		// break;
		case F2:
			return PermGenerator.f2(permutation);
		// break;
		case FP:
			return PermGenerator.fI(permutation);
		// break;

		}
		return permutation;
	}

	public static PieceColor[] r(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[1] = permutation[8];
		p[3] = permutation[10];
		p[8] = permutation[16];
		p[10] = permutation[17];
		p[11] = permutation[13];
		p[12] = permutation[11];
		p[13] = permutation[14];
		p[14] = permutation[12];
		p[16] = permutation[18];
		p[17] = permutation[20];
		p[18] = permutation[1];
		p[20] = permutation[3];

		return p;
	}

	public static PieceColor[] r2(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[1] = permutation[16];
		p[3] = permutation[17];
		p[8] = permutation[18];
		p[10] = permutation[20];
		p[11] = permutation[14];
		p[12] = permutation[13];
		p[13] = permutation[12];
		p[14] = permutation[11];
		p[16] = permutation[1];
		p[17] = permutation[3];
		p[18] = permutation[8];
		p[20] = permutation[10];

		return p;
	}

	public static PieceColor[] rI(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[1] = permutation[18];
		p[3] = permutation[20];
		p[8] = permutation[1];
		p[10] = permutation[3];
		p[11] = permutation[12];
		p[12] = permutation[14];
		p[13] = permutation[11];
		p[14] = permutation[13];
		p[16] = permutation[8];
		p[17] = permutation[10];
		p[18] = permutation[16];
		p[20] = permutation[17];

		return p;
	}

	public static PieceColor[] u(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[0] = permutation[2];
		p[1] = permutation[0];
		p[2] = permutation[3];
		p[3] = permutation[1];
		p[4] = permutation[7];
		p[5] = permutation[8];
		p[7] = permutation[11];
		p[8] = permutation[12];
		p[11] = permutation[20];
		p[12] = permutation[19];
		p[20] = permutation[4];
		p[19] = permutation[5];

		return p;
	}

	public static PieceColor[] u2(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[0] = permutation[3];
		p[1] = permutation[2];
		p[2] = permutation[1];
		p[3] = permutation[0];
		p[4] = permutation[11];
		p[5] = permutation[12];
		p[7] = permutation[20];
		p[8] = permutation[19];
		p[11] = permutation[4];
		p[12] = permutation[5];
		p[20] = permutation[7];
		p[19] = permutation[8];

		return p;
	}

	public static PieceColor[] uI(PieceColor[] permutation) {
		PieceColor[] permutationAfterTurn = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, permutationAfterTurn, 0, permutation.length);

		permutationAfterTurn[0] = permutation[1];
		permutationAfterTurn[1] = permutation[3];
		permutationAfterTurn[2] = permutation[0];
		permutationAfterTurn[3] = permutation[2];
		permutationAfterTurn[4] = permutation[20];
		permutationAfterTurn[5] = permutation[19];
		permutationAfterTurn[7] = permutation[4];
		permutationAfterTurn[8] = permutation[5];
		permutationAfterTurn[11] = permutation[7];
		permutationAfterTurn[12] = permutation[8];
		permutationAfterTurn[20] = permutation[11];
		permutationAfterTurn[19] = permutation[12];

		return permutationAfterTurn;
	}

	public static PieceColor[] f(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[2] = permutation[6];
		p[3] = permutation[5];
		p[5] = permutation[15];
		p[6] = permutation[16];
		p[7] = permutation[9];
		p[8] = permutation[7];
		p[9] = permutation[10];
		p[10] = permutation[8];
		p[11] = permutation[2];
		p[13] = permutation[3];
		p[15] = permutation[13];
		p[16] = permutation[11];

		return p;
	}

	public static PieceColor[] f2(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[2] = permutation[16];
		p[3] = permutation[15];
		p[5] = permutation[13];
		p[6] = permutation[11];
		p[7] = permutation[10];
		p[8] = permutation[9];
		p[9] = permutation[8];
		p[10] = permutation[7];
		p[11] = permutation[6];
		p[13] = permutation[5];
		p[15] = permutation[3];
		p[16] = permutation[2];

		return p;
	}

	public static PieceColor[] fI(PieceColor[] permutation) {
		PieceColor[] p = new PieceColor[permutation.length];
		System.arraycopy(permutation, 0, p, 0, permutation.length);

		p[2] = permutation[11];
		p[3] = permutation[13];
		p[5] = permutation[3];
		p[6] = permutation[2];
		p[7] = permutation[8];
		p[8] = permutation[10];
		p[9] = permutation[7];
		p[10] = permutation[9];
		p[11] = permutation[16];
		p[13] = permutation[15];
		p[15] = permutation[5];
		p[16] = permutation[6];

		return p;
	}
}