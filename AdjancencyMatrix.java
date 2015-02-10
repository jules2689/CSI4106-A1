import java.util.ArrayList;

public class AdjancencyMatrix {
	private int numberOfVertices;
	private int numberOfEdges;
	private int[][] adjancencyMatrix;
	private ArrayList<String> vertexNames;

	public AdjancencyMatrix(int numberOfVertices) {
		if (numberOfVertices < 0) {
			throw new RuntimeException("Number of vertices must be nonnegative");
		}
		this.setNumberOfVertices(numberOfVertices);
		this.setNumberOfEdges(0);
		initializeMatrix();
		this.vertexNames = new ArrayList<String>(this.numberOfVertices);
	}

	private void initializeMatrix() {
		this.adjancencyMatrix = new int[numberOfVertices][numberOfVertices];
		for (int i = 0; i < this.adjancencyMatrix.length; i++) {
			for (int j = 0; j < this.adjancencyMatrix[i].length; j++) {
				this.adjancencyMatrix[i][j] = 0;
			}
		}
	}
	
	public String citiesString() {
		String cities = "";
		for (String city : this.vertexNames) {
			cities += city + ", ";
		}
		return cities.substring(0, cities.length() - 2);
	}
	
	public ArrayList<String> getCities() {
		return this.vertexNames;
	}
	
	public int[][] getMatrix() {
		return this.adjancencyMatrix;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	private void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	private void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}
	
	public void addEdge(String vertexA, String vertexB, int edgeWeight) {
		int vertexAIndex = this.vertexNames.indexOf(vertexA);
		int vertexBIndex = this.vertexNames.indexOf(vertexB);

		if (adjancencyMatrix[vertexAIndex][vertexBIndex] == 0) {
			numberOfEdges++;
		}
		
		adjancencyMatrix[vertexAIndex][vertexBIndex] = edgeWeight;
		adjancencyMatrix[vertexBIndex][vertexAIndex] = edgeWeight;
	}

	public void addVertices(String[] vertices) {
		for (String vertex : vertices) {
			this.vertexNames.add(vertex);
		}
	}
}
