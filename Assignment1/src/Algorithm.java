import java.util.ArrayList;

public class Algorithm {
	protected int[][] adjancencyMatrix;
	protected int numberOfVertices;
	protected ArrayList<String> vertexNames;
	
	public Algorithm(AdjancencyMatrix matrix) {
		this.adjancencyMatrix = matrix.getMatrix();
		this.numberOfVertices = this.adjancencyMatrix.length;
		this.vertexNames = matrix.getCities();
	}

	public void perform(String startCity, String endCity) {
		throw new UnsupportedOperationException();
	}
	
}
