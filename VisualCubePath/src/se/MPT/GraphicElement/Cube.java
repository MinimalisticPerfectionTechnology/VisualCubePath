package se.MPT.GraphicElement;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import se.MPT.Logics.PermGenerator;
import se.MPT.engineTester.VisualCubePath;

public class Cube extends Element {

	ArrayList<Shape> faces = null;

	private int[] PERSPECTIVE_1 = null;

	private static int NR_VERT = 8;
	private static int NR_HORIZ = 6;

	float[] posisionsOfFaces = null;
	int LIMIT;
	int width;
	int height;
	String permuation = "";
	Color[] colors = null;

	public Cube() {
		init(2, VisualCubePath.CANVAS_HEIGHT - VisualCubePath.CANVAS_HEIGHT / 3, VisualCubePath.CANVAS_HEIGHT);
	}

	private void initPerspectiveArrays() {
		PERSPECTIVE_1 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };
	}

	private void init(int NR_PER_SIDE, int width, int height) {
		initPerspectiveArrays();
		LIMIT = NR_PER_SIDE * NR_PER_SIDE * 6;
		permuation = PermGenerator.solved();
		faces = new ArrayList<>();
		colors = new Color[LIMIT];

		posisionsOfFaces = new float[LIMIT * 2]; // times two since it's both x
													// and y.
		setPermutations(permuation);
		this.width = width;
		this.height = height;

		resetPosisions(PERSPECTIVE_1);
		for (int i = 0; i < LIMIT; i++) {
			// int shapeX = this.x;
			// int shapeY;
			float xPos = posisionsOfFaces[i * 2];
			float yPos = posisionsOfFaces[(i * 2) + 1];
			Shape face = new Rectangle(xPos, yPos, this.width / NR_HORIZ - 2, this.height / NR_VERT - 2);
			faces.add(face);
		}
	}

	private void resetPosisions(int[] PERSPECTIVE) {

		float[] xPosisions = new float[NR_HORIZ];
		float[] yPosisions = new float[NR_VERT];
		int lenght = yPosisions.length;
		for (int i = 0; i < lenght; i++) {
			if (i < xPosisions.length) {
				int relPosX = ((this.width / xPosisions.length) * i); // 6 =
																		// number
																		// of
																		// faces
																		// x-wise
				xPosisions[i] = this.x + relPosX;
			}
			// }
			int relPosY = ((this.height / lenght) * i); // 8 = number of faces
														// y-wise.
			yPosisions[i] = this.y + relPosY;
		}

		for (int i = 0; i < posisionsOfFaces.length / 2; i++) {
			// int index =i/2;
			int index = PERSPECTIVE[i] * 2;
			switch (i) {
			case 0:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[0];
				break;
			case 1:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[0];
				break;
			case 2:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[1];
				break;
			case 3:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[1];
				break;
			case 4:
				posisionsOfFaces[index] = xPosisions[0];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 5:
				posisionsOfFaces[index] = xPosisions[1];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 6:
				posisionsOfFaces[index] = xPosisions[0];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 7:
				posisionsOfFaces[index] = xPosisions[1];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 8:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 9:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 10:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 11:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 12:
				posisionsOfFaces[index] = xPosisions[4];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 13:
				posisionsOfFaces[index] = xPosisions[5];
				posisionsOfFaces[index + 1] = yPosisions[2];
				break;
			case 14:
				posisionsOfFaces[index] = xPosisions[4];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 15:
				posisionsOfFaces[index] = xPosisions[5];
				posisionsOfFaces[index + 1] = yPosisions[3];
				break;
			case 16:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[4];
				break;
			case 17:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[4];
				break;
			case 18:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[5];

				break;
			case 19:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[5];
				break;
			case 22:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[6];
				break;
			case 20:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[6];
				break;
			case 21:
				posisionsOfFaces[index] = xPosisions[2];
				posisionsOfFaces[index + 1] = yPosisions[7];
				break;
			case 23:
				posisionsOfFaces[index] = xPosisions[3];
				posisionsOfFaces[index + 1] = yPosisions[7];
				break;
			}
		}

	}

	public void setPermutations(String p) {
		char[] pieces = p.toCharArray();
		int i = 0;

		char[] newPieceColors = new char[pieces.length + 3];
		// 6, 18, 20
		int k = 0;
		for (int j = 0; j < pieces.length; j++) {
			if (j == 6 || j == 18 || j == 20) {
				k++;
			}
			newPieceColors[j + k] = pieces[j];
		}
		newPieceColors[6] = 'O';
		newPieceColors[19] = 'Y';
		newPieceColors[22] = 'B';
		for (char s : newPieceColors) {
			switch (s) {
			case 'W':
				colors[i] = Color.white;
				break;
			case 'O':
				colors[i] = Color.orange;
				break;
			case 'G':
				colors[i] = Color.green;
				break;
			case 'R':
				colors[i] = Color.red;
				break;
			case 'Y':
				colors[i] = Color.yellow;
				break;
			case 'B':
				colors[i] = Color.blue;
				break;
			}
			i++;
		}
	}

	@Override
	public void update(GameContainer container) {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics arg1) {

		int i = 0;
		for (Shape s : faces) {
			arg1.setColor(colors[i]);
			arg1.fill(s);
			i++;
		}
	}
}
