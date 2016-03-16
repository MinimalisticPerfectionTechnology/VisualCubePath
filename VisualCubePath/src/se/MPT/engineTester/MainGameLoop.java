package se.MPT.engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import se.MPT.entities.Camera;
import se.MPT.entities.Entity;
import se.MPT.models.RawModel;
import se.MPT.models.TexturedModel;
import se.MPT.renderEngine.DisplayManager;
import se.MPT.renderEngine.Loader;
import se.MPT.renderEngine.Renderer;
import se.MPT.shaders.StaticShader;
import se.MPT.textures.ModelTexture;

public class MainGameLoop {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		float[] vertices = { -0.5f, 0.5f, 0, // V0
				-0.5f, -0.5f, 0, // V1
				0.5f, -0.5f, 0, // V2
				0.5f, 0.5f, 0 // V3
		};

		float[] textureCoords = { 0, 0, // V0
				0, 1, // V1
				1, 1, // V2
				1, 0 // V3
		};

		int[] indices = { 0, 1, 3, // Top left triangle
				3, 1, 2 // Bottom right triangle
		};

		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("orange")));
		Entity entity = new Entity(staticModel, new Vector3f(0, 0, -1), 0, 0, 0, 1);
		Camera camera = new Camera();

		while (!Display.isCloseRequested()) {
			entity.increaseRotation(1, 1, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
