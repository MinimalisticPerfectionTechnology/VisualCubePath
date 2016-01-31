package se.MPT.Logics;

public class UI {

	// public static long time;

	public Move[] algorithmProcess(Side[] shuffeled) throws InterruptedException {
		return new MoveProcessor(shuffeled, true).getAnswere();
		// time = System.currentTimeMillis();
	}
}