package se.MPT.Logics;




public class Generator {
	public static Side[] solvedSide() {
		return new Side[]{
				Side.WHITE,
				Side.WHITE,
				Side.WHITE,
				Side.WHITE,
				Side.ORANGE,
				Side.ORANGE,
				Side.ORANGE,
				Side.GREEN,
				Side.GREEN,
				Side.GREEN,
				Side.GREEN,
				Side.RED,
				Side.RED,
				Side.RED,
				Side.RED,
				Side.YELLOW,
				Side.YELLOW,
				Side.YELLOW,
				Side.BLUE,
				Side.BLUE,
				Side.BLUE
			};
			
	}
	
	public static Permutation solved() {
		Side[] perm = new Side[]{
				Side.WHITE,
				Side.WHITE,
				Side.WHITE,
				Side.WHITE,
				Side.ORANGE,
				Side.ORANGE,
				Side.ORANGE,
				Side.GREEN,
				Side.GREEN,
				Side.GREEN,
				Side.GREEN,
				Side.RED,
				Side.RED,
				Side.RED,
				Side.RED,
				Side.YELLOW,
				Side.YELLOW,
				Side.YELLOW,
				Side.BLUE,
				Side.BLUE,
				Side.BLUE
			};
			return new Permutation(perm, new Move[0]);
			
	}
}
