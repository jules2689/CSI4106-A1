
public class DepthFirstSearch extends Algorithm {
	private boolean[] seen;
	boolean reachedCity = false;
	
	public DepthFirstSearch(AdjancencyMatrix matrix) {
		super(matrix);
	}
	
	private void initializeVariables() {
		// Initialize search and seen list
		this.reachedCity = false;
		this.seen = new boolean[this.numberOfVertices];
		for (int i = 0; i < this.seen.length; i++) {
			seen[i] = false;
		}
	}
	
	@Override
	public void perform(String startCity, String endCity) {
		System.out.println("=============================================================");
		System.out.println("Depth First Search starting at " + startCity + " and looking for " + endCity);
		System.out.println("=============================================================");
		initializeVariables();

		// Perform Search
		depthFirstSearchRecursive(startCity, endCity, 0, new Node(0, startCity, null));
		if (!reachedCity) {
			System.out.println("Couldn't reach city " + endCity);
		}

		outputAlgorithmStats();
	}

	public void depthFirstSearchRecursive(String startCity, String endCity, int depth, Node fromNode) {
		this.numberOfVistedCities++;
		if (depth > this.maxNumberOfCitiesInTheQueue) {
			this.maxNumberOfCitiesInTheQueue = depth;
		}
		
		if (startCity.equals(endCity)) {
			System.out.println("Reached city " + startCity);
			reachedCity = true;
			formStackPath(fromNode);
		} else if (!reachedCity) {
			System.out.println("Examining city " + startCity + ".");
			int cityIndex = this.vertexNames.indexOf(startCity);
			this.seen[cityIndex] = true; // Mark the current city as seen

			for (int idx = 0; idx < this.numberOfVertices; idx++) {
				// If we haven't seen the city, and it has an edge to the city
				if (!this.seen[idx] && this.adjancencyMatrix[cityIndex][idx] != 0) {
					String name = this.vertexNames.get(idx);
					Node node = new Node(0, name, fromNode);
					depthFirstSearchRecursive(name, endCity, depth + 1, node);
				}
			}
		}
	}
	
}
