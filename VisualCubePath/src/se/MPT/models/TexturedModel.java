package se.MPT.models;

import se.MPT.renderEngine.RawModel;
import se.MPT.textures.ModelTexture;

public class TexturedModel {
	private RawModel rawModel;
	private ModelTexture modelTexture;

	public TexturedModel(RawModel rawModel, ModelTexture modelTexture) {
		this.rawModel = rawModel;
		this.modelTexture = modelTexture;
	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getTexture() {
		return modelTexture;
	}
}
