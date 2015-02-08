import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Algorithm {

	public BreadthFirstSearch(AdjancencyMatrix matrix) {
		super(matrix);
	}
	
	@Override
	public void perform(String startCity, String endCity) {
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

}
