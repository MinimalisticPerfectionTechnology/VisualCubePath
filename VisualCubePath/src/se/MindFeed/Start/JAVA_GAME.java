package se.MindFeed.Start;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import se.MPT.GraphicElement.Cube;
import se.MPT.Logics.Generator;
import se.MPT.Logics.Move;
import se.MPT.Logics.PermGenerator;
import se.MPT.Logics.PieceColor;
import se.MPT.Logics.UI;
import se.MPT.Logics.Utils;
import se.MindFeed.GameObjects.GO;

public class JAVA_GAME extends BasicGame {

	Font font;
	Font font2;
	TrueTypeFont trueTypeFont;
	TrueTypeFont trueTypeFontSmall;

	public static int CANVAS_HEIGHT = 800;
	public static int CANVAS_WIDTH = 1100;

	public JAVA_GAME(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public static final float GRAVITY = 0.01f;
	public static String gameName = "rockSlider";

	public static ArrayList<GO> gameObjects = null;

	private Cube cube = null;
	private UI ui = null;
	private PieceColor[] perm = null;
	private ArrayList<Move> godsAlgorithm;
	private ArrayList<Move> latest;

	private String godsAlgorithmString = "[Solved]";

	@Override
	public void init(GameContainer arg0) throws SlickException {
		gameObjects = new ArrayList<>();
		cube = new Cube();
		gameObjects.add(cube);
		ui = new UI();
		perm = Generator.solvedColors();
		// font = new Font("Verdana", Font.BOLD, 24);
		font = new Font("monospaced", Font.BOLD, 24);
		trueTypeFont = new TrueTypeFont(font, true);
		// font2 = new Font("Verdana", Font.ITALIC, 23);
		font2 = new Font("monospaced", Font.ITALIC, 24);
		trueTypeFontSmall = new TrueTypeFont(font2, true);
		godsAlgorithm = new ArrayList<Move>();
		latest = new ArrayList<>();
	}

	public static void main(String[] s) throws SlickException {
		AppGameContainer appGameContainer = new AppGameContainer(new JAVA_GAME(gameName));
		int maxFPS = 60;
		appGameContainer.setTargetFrameRate(maxFPS);
		appGameContainer.setDisplayMode(CANVAS_WIDTH, CANVAS_HEIGHT, false);
		appGameContainer.setAlwaysRender(true);
		appGameContainer.start();

	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// for(GO go : gameObjects) {
		// go.render(arg1);
		// }
		cube.render(arg1);
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, 0, "Keys 1-9 correspond to the following moves:");
		trueTypeFont.drawString(CANVAS_WIDTH / 2, 30, "F   F2   F'   R   R2   R'   U   U2   U'");
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, 60, "Undo: [<]");
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 1.5F, 60, "Solve: [>]");
		// trueTypeFont.drawString(CANVAS_WIDTH/2, 30, "1 2 3 4 5 6 7 8 9");

		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, godsAlgorithmString, Color.pink);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {

		Input input = arg0.getInput();
		if (input.isKeyPressed(Input.KEY_1)) {
			Move m = Move.F;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);

		} else if (input.isKeyPressed(Input.KEY_2)) {
			Move m = Move.F2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_3)) {
			Move m = Move.FP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_4)) {
			Move m = Move.R;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_5)) {
			Move m = Move.R2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_6)) {
			Move m = Move.RP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_7)) {
			Move m = Move.U;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_8)) {
			Move m = Move.U2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_9)) {
			Move m = Move.UP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			if (!godsAlgorithm.isEmpty()) {
				if (m == godsAlgorithm.get(0)) {
					updatePermutation(true);
				}
			}
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_LEFT) && !latest.isEmpty()) {
			perm = PermGenerator.generate(perm, Utils.reversedMove(latest.get(latest.size() - 1)));
			latest.remove(latest.size() - 1);
			updatePermutation(false);
		} else if (input.isKeyPressed(Input.KEY_RIGHT) && !godsAlgorithm.isEmpty()) {
			Move m = godsAlgorithm.get(0);
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(true);
		}

		// for(GO go : gameObjects) {
		// go.update(arg0);
		// }

	}

	private void updatePermutation(boolean rightMove) {
		cube.setPermutations(perm);
		try {
			if (rightMove) {
				godsAlgorithm.remove(0);
				godsAlgorithmString = godsAlgorithm.isEmpty() ? "[Solved]" : Utils.moveToString(godsAlgorithm.toArray(new Move[godsAlgorithm.size()]));
			} else {
				Move[] moves = new Move[0];
				moves = ui.algorithmProcess(perm);
				godsAlgorithm = new ArrayList<Move>(Arrays.asList(moves));
				godsAlgorithmString = godsAlgorithm.isEmpty() ? "[Solved]" : Utils.moveToString(moves);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(answer);
		// ui = new UI();
	}
}
