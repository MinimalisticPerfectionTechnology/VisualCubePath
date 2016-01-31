package se.MPT.Logics;


import java.util.Arrays;

public class Permutation {
	
	PieceColor[] pieceColor;
	Move[] moves;


	public Permutation(PieceColor[] pieceColor, Move[] moves) {
		this.pieceColor = pieceColor;
		this.moves = moves;
	}
	
	public Move[] getMoves() {
		return moves;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(pieceColor);
		return result;
	}


	public PieceColor[] getPieceColor() {
		return pieceColor;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permutation other = (Permutation) obj;
		if (!Arrays.equals(pieceColor, other.pieceColor))
			return false;
		return true;
	}
}
