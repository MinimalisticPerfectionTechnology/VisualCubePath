package se.MPT.Logics;


import java.util.Arrays;

public class Permutation {
	
	Side[] side;
	Move[] moves;


	public Permutation(Side[] side, Move[] moves) {
		this.side = side;
		this.moves = moves;
	}
	
	public Move[] getMoves() {
		return moves;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(side);
		return result;
	}


	public Side[] getSide() {
		return side;
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
		if (!Arrays.equals(side, other.side))
			return false;
		return true;
	}
}
