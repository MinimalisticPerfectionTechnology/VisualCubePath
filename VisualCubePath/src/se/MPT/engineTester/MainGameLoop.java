package se.MPT.engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import se.MPT.entities.Camera;
import se.MPT.entities.Entity;
import se.MPT.entities.Light;
import se.MPT.models.RawModel;
import se.MPT.models.TexturedModel;
import se.MPT.renderEngine.DisplayManager;
import se.MPT.renderEngine.Loader;
import se.MPT.renderEngine.OBJLoader;
import se.MPT.renderEngine.Renderer;
import se.MPT.shaders.StaticShader;
import se.MPT.textures.ModelTexture;

public class MainGameLoop {
	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		RawModel model = OBJLoader.loadObjModel("stall", loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("orange")));
		ModelTexture texture = staticModel.getTexture();
		texture.setShineDamper(10);
		texture.setReflectivity(1);
		Entity entity = new Entity(staticModel, new Vector3f(0, -4, -20), 0, 0, 0, 1);
		Light light = new Light(new Vector3f(0, 0, 1), new Vector3f(1, 1, 1));
		Camera camera = new Camera();

		while (!Display.isCloseRequested()) {
			entity.increaseRotation(0, 1, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
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
