package se.MPT.Logics;




public class Generator {
	public static PieceColor[] solvedColors() {
		return new PieceColor[]{
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.ORANGE,
				PieceColor.ORANGE,
				PieceColor.ORANGE,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.YELLOW,
				PieceColor.YELLOW,
				PieceColor.YELLOW,
				PieceColor.BLUE,
				PieceColor.BLUE,
				PieceColor.BLUE
			};
			
	}
	
	public static Permutation solved() {
		PieceColor[] perm = new PieceColor[]{
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.WHITE,
				PieceColor.ORANGE,
				PieceColor.ORANGE,
				PieceColor.ORANGE,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.GREEN,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.RED,
				PieceColor.YELLOW,
				PieceColor.YELLOW,
				PieceColor.YELLOW,
				PieceColor.BLUE,
				PieceColor.BLUE,
				PieceColor.BLUE
			};
			return new Permutation(perm, new Move[0]);
			
	}
}
