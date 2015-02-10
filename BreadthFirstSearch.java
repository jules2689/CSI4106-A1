import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Algorithm {

	public BreadthFirstSearch(AdjancencyMatrix matrix) {
		super(matrix);
	}
	
	@Override
	public void perform(String startCity, String endCity) {
		System.out.println("=============================================================");
		System.out.println("Breadth First Search starting at " + startCity + " and looking for " + endCity);
		System.out.println("=============================================================");
		boolean reachedCity = false;
		Queue<Node> queue = new LinkedList<Node>();

		// Initialize Visited Cities to all 0
		int[] visitedCities = new int[this.numberOfVertices];
		for (int i = 0; i < visitedCities.length; i++) {
			visitedCities[i] = 0;
		}

		Node city = new Node(0, startCity, null);
		queue.add(city);
		visitedCities[this.vertexNames.indexOf(startCity)] = 1;

		whileLoop: while (!queue.isEmpty()) {
			city = (Node) queue.remove();
			int cityIndex = this.vertexNames.indexOf(city.name);
			this.numberOfVistedCities++;
			
			// If the current city is the end city, break out of the loop
			if (city.name.equals(endCity)) {
				System.out.println("Reached city " + city.name + ".");
				reachedCity = true;
				formStackPath(city);
				break whileLoop;
			} else {
				System.out.println("Examining city " + city.name + ".");
			}

			for (int i = 0; i < this.adjancencyMatrix[cityIndex].length; i++) {
				// If there is an edge (not zero) and we haven't visited, visit the city.
				if (this.adjancencyMatrix[cityIndex][i] != 0 && visitedCities[i] != 1) {
					String name = this.vertexNames.get(i);
					Node node = new Node(0, name, city);
					queue.add(node);
					if (queue.size() > this.maxNumberOfCitiesInTheQueue) {
						this.maxNumberOfCitiesInTheQueue = queue.size();
					}
					visitedCities[i] = 1;
				}
			}
		}

		if (!reachedCity) {
			System.out.println("Couldn't Reach City " + endCity);
		}

		outputAlgorithmStats();
	}

}
