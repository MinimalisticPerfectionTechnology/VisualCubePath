package se.MPT.engineTester;

import org.lwjgl.opengl.Display;

import se.MPT.models.TexturedModel;
import se.MPT.renderEngine.DisplayManager;
import se.MPT.renderEngine.Loader;
import se.MPT.renderEngine.RawModel;
import se.MPT.renderEngine.Renderer;
import se.MPT.shaders.StaticShader;
import se.MPT.textures.ModelTexture;

public class MainGameLoop {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();

		float[] vertices = { -0.5f, 0.5f, 0, // V0
				-0.5f, -0.5f, 0, // V1
				0.5f, -0.5f, 0, // V2
				0.5f, 0.5f, 0 // V3
		};

		int[] indices = { 0, 1, 3, // Top left triangle
				3, 1, 2 // Bottom right triangle
		};

		float[] textureCoords = { 
				0,0,
				0,1,
				1,1,
				1,0};

		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("orange"));
		TexturedModel texturedModel = new TexturedModel(model, texture);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
