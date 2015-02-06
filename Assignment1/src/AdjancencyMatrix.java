import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

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

	public ArrayList<String> getCities() {
		return this.vertexNames;
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
			addVertex(vertex);
		}
	}

	public void addVertex(String vertex) {
		this.vertexNames.add(vertex);
	}

	public void breadthFirstSearch(String startCity, String endCity) {
		System.out.println("Breadth First Search starting at " + startCity + " and looking for " + endCity);
		boolean reachedCity = false;
		Queue<String> queue = new LinkedList<String>();

		// Initialize Visited Cities to all 0
		int[] visitedCities = new int[this.numberOfVertices];
		for (int i = 0; i < visitedCities.length; i++) {
			visitedCities[i] = 0;
		}

		String city = startCity;
		queue.add(city);
		visitedCities[this.vertexNames.indexOf(startCity)] = 1;

		whileLoop: while (!queue.isEmpty()) {
			city = (String) queue.remove();
			int cityIndex = this.vertexNames.indexOf(city);

			// If the current city is the end city, break out of the loop
			if (city.equals(endCity)) {
				System.out.println("Reached city " + city + ".");
				reachedCity = true;
				break whileLoop;
			} else {
				System.out.println("Examining city " + city + ".");
			}

			for (int i = 0; i < this.adjancencyMatrix[cityIndex].length; i++) {
				// If there is an edge (not zero) and we haven't visited, visit the city.
				if (this.adjancencyMatrix[cityIndex][i] != 0 && visitedCities[i] != 1) {
					String name = this.vertexNames.get(i);
					queue.add(name);
					visitedCities[i] = 1;
				}
			}
		}

		if (!reachedCity) {
			System.out.println("Couldn't Reach City " + endCity);
		}

		System.out.println("");
	}

	private boolean[] seen;
	boolean reachedCity = false;

	public void depthFirstSearch(String startCity, String endCity) {
		System.out.println("Depth First Search starting at " + startCity + " and looking for " + endCity);

		// Initialize search and seen list
		this.seen = new boolean[this.numberOfVertices];
		reachedCity = false;
		for (int i = 0; i < this.seen.length; i++) {
			seen[i] = false;
		}

		// Perform Search
		depthFirstSearchRecursive(startCity, endCity);
		if (!reachedCity) {
			System.out.println("Couldn't reach city " + endCity);
		}

		System.out.println("");
	}

	public void depthFirstSearchRecursive(String startCity, String endCity) {
		if (startCity.equals(endCity)) {
			System.out.println("Reached city " + startCity);
			reachedCity = true;
		} else if (!reachedCity) {
			System.out.println("Examining city " + startCity + ".");
			int cityIndex = this.vertexNames.indexOf(startCity);
			this.seen[cityIndex] = true; // Mark the current city as seen

			for (int idx = 0; idx < this.numberOfVertices; idx++) {
				// If we haven't seen the city, and it has an edge to the city
				if (!this.seen[idx] && this.adjancencyMatrix[cityIndex][idx] != 0) {
					String name = this.vertexNames.get(idx);
					depthFirstSearchRecursive(name, endCity);
				}
			}
		}
	}
	
	public void uniformCostSearch(String startCity, String endCity) {
		System.out.println("Uniform Cost Search starting at " + startCity + " and looking for " + endCity);
		// TODO: Dijkstra
		System.out.println("TODO Dijkstra");
	}
}
