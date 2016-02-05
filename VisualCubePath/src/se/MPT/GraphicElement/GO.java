package se.MPT.GraphicElement;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class GO {
	protected float x;
	protected float y;
	protected float dx;
	protected float dy;
	protected Shape body;

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getDx() {
		return dx;
	}

	public float getDy() {
		return dy;
	}

	public abstract void update(GameContainer container);

	public Shape getShape() {
		return this.body;
	}

	public abstract void render(Graphics arg1);
}
