package se.MPT.engineTester;

import java.awt.Font;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import se.MPT.GraphicElement.Cube;
import se.MPT.GraphicElement.Element;
import se.MPT.Logics.Algorithm;
import se.MPT.Logics.Info;
import se.MPT.Logics.Move;
import se.MPT.Logics.PermGenerator;
import se.MPT.Logics.Utils;

public class VisualCubePath extends BasicGame {

	private static final String SOLVED = "[Solved]";
	Font font;
	Font font2;
	TrueTypeFont trueTypeFont;
	TrueTypeFont trueTypeFontSmall;

	public static int CANVAS_HEIGHT = 800;
	public static int CANVAS_WIDTH = 1300;

	public VisualCubePath(String title) {
		super(title);
	}

	public static final float GRAVITY = 0.01f;
	public static String gameName = "2x2x2";

	public static ArrayList<Element> gameObjects = null;

	private Cube cube = null;
	private Algorithm ui = null;
	private String perm;
	private ArrayList<Move> latest;

	private String godsAlgorithmString = SOLVED;
	private String godsAlgorithmStringClock = "";
	private Info result;

	@Override
	public void init(GameContainer arg0) throws SlickException {
		CANVAS_HEIGHT = arg0.getHeight();
		CANVAS_WIDTH = arg0.getWidth();
		gameObjects = new ArrayList<>();
		cube = new Cube();
		gameObjects.add(cube);
		ui = new Algorithm();
		perm = PermGenerator.solved();
		// font = new Font("Verdana", Font.BOLD, 24);
		font = new Font("monospaced", Font.BOLD, 24);
		trueTypeFont = new TrueTypeFont(font, true);
		// font2 = new Font("Verdana", Font.ITALIC, 23);
		font2 = new Font("monospaced", Font.ITALIC, 24);
		trueTypeFontSmall = new TrueTypeFont(font2, true);
		latest = new ArrayList<>();
		result = new Info();

	}

	public static void main(String[] s) throws SlickException {
		AppGameContainer appGameContainer = new AppGameContainer(new VisualCubePath(gameName));
		int maxFPS = 60;
		appGameContainer.setTargetFrameRate(maxFPS);
		appGameContainer.setDisplayMode(appGameContainer.getScreenWidth(), appGameContainer.getScreenHeight(), true);
		appGameContainer.setAlwaysRender(true);
		appGameContainer.start();

	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		cube.render(arg1);
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, 0, "Keys 1-9 correspond to the following moves:");
		trueTypeFont.drawString(CANVAS_WIDTH / 2, 30, "F   F2   F'   R   R2   R'   U   U2   U'");
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, 60, "Undo: [<]");
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 1.5F, 60, "Solve: [>]");

		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2, godsAlgorithmString, Color.pink);
		trueTypeFontSmall.drawString(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2 + 30, "ms: " + godsAlgorithmStringClock, Color.pink);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		Input input = arg0.getInput();
		if (input.isKeyPressed(Input.KEY_1)) {
			Move m = Move.F;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_2)) {
			Move m = Move.F2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_3)) {
			Move m = Move.FP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_4)) {
			Move m = Move.R;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_5)) {
			Move m = Move.R2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_6)) {
			Move m = Move.RP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_7)) {
			Move m = Move.U;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_8)) {
			Move m = Move.U2;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);
		} else if (input.isKeyPressed(Input.KEY_9)) {
			Move m = Move.UP;
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			updatePermutation(m);

		} else if (input.isKeyPressed(Input.KEY_LEFT) && !latest.isEmpty()) {
			perm = PermGenerator.generate(perm, Utils.reversedMove(latest.get(latest.size() - 1)));
			latest.remove(latest.size() - 1);
			updatePermutation2();
			if (latest.isEmpty()) {
				godsAlgorithmString = SOLVED;
			}
		} else if (input.isKeyPressed(Input.KEY_RIGHT) && !result.isSolved()) {
			Move m = result.getFirst();
			latest.add(m);
			perm = PermGenerator.generate(perm, m);
			makeRightMove();
		}
	}

	private void makeRightMove() {
		result.prune();
		godsAlgorithmString = result.isSolved() ? SOLVED : result.getPathString();
		cube.setPermutations(perm);
	}

	private void updatePermutation(Move m) {
		boolean isCorrectMove = false;
		if (!result.isSolved()) {
			if (m == result.getFirst()) {
				isCorrectMove = true;
				makeRightMove();
			}
		}
		if (!isCorrectMove) {
			updatePermutation2();
		}
	}

	private void updatePermutation2() {
		cube.setPermutations(perm);
		result = ui.solve(perm);

		String moves = result.getPathString();
		godsAlgorithmString = result.isSolved() ? SOLVED : moves;
		godsAlgorithmStringClock = result.getClock();
	}
}
