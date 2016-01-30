package se.MPT.Logics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class UI {
	
//	public static long time;

	public Move[] algorithmProcess(Side[] shuffeled) throws InterruptedException {
		return new MoveProcessor(shuffeled, true).getAnswere();
//		time = System.currentTimeMillis();	
	}
}