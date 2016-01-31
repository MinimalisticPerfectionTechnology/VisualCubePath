package se.MPT.Logics;

public class UI {

	// public static long time;

	public Move[] algorithmProcess(PieceColor[] shuffeled) throws InterruptedException {
		return new MoveProcessor(shuffeled, true).getAnswer();
		// time = System.currentTimeMillis();
	}
}