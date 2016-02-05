package se.MPT.renderEngine;

public class RawModel {
	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	private int vaoID;
	private int vertexCount;

	public RawModel(int vaoID, int vertexCount) {
		super();
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
	}

}
