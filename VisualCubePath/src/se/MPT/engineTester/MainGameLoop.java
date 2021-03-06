
package se.MPT.engineTester;

import org.lwjgl.opengl.Display;

import se.MPT.renderEngine.DisplayManager;
import se.MPT.renderEngine.Loader;
import se.MPT.renderEngine.RawModel;
import se.MPT.renderEngine.Renderer;
import se.MPT.shaders.StaticShader;

public class MainGameLoop {
	public static void main(String[] args) {
		DisplayManager.createDisplay();

		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();

		float[] vertices = { 
				-0.5f, 0.5f, 0, 	// V0
				-0.5f, -0.5f, 0, 	// V1
				0.5f, -0.5f, 0, 	// V2
				0.5f, 0.5f, 0 		// V3
		};

		int[] indices = { 
				0, 1, 3, 	// Top left triangle
				3, 1, 2		// Bottom right triangle
		};

		RawModel model = loader.loadToVAO(vertices, indices);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
