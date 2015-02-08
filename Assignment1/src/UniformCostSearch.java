import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch extends Algorithm {
	
	public UniformCostSearch(AdjancencyMatrix matrix) {
		super(matrix);
	}
	
	@Override
	public void perform(String startCity, String endCity) {
		System.out.println("Uniform Cost Search starting at " + startCity + " and looking for " + endCity);
		
		// Initialize Variables
	    boolean reachedCity = false;
	    boolean[] visitedCities = new boolean[this.numberOfVertices];
		for (int i = 0; i < visitedCities.length; i++) {
			visitedCities[i] = false;
		}
		
	    int cityIndex = this.vertexNames.indexOf(startCity);
		PriorityQueue<Node> queue = new PriorityQueue<Node>(this.numberOfVertices, getNodeComparator());
		Node node = new Node(0, startCity, null);
		queue.add(node);
		
		
		uniformWhileLoop: while(queue.isEmpty() == false) {
			node = queue.poll();
			cityIndex = this.vertexNames.indexOf(node.name);
			visitedCities[cityIndex] = true;
			this.numberOfVistedCities++;
			
			if (cityDidReachEnd(node, endCity)) {
				reachedCity = true;
				break uniformWhileLoop;
			}
			
			for (int i = 0; i < this.adjancencyMatrix[cityIndex].length; i++) {
				int cost = this.adjancencyMatrix[cityIndex][i];
				String name = this.vertexNames.get(i);
				if (cost != 0 && !visitedCities[i]) {
					int totalCost = cost + node.totalCost;
					Node currentNode = new Node(totalCost, name, node);
					queue.add(currentNode);
					if (queue.size() > this.maxNumberOfCitiesInTheQueue) {
						this.maxNumberOfCitiesInTheQueue = queue.size();
					}
				}
			}
		}
		
		outputFinalInformation(reachedCity, node);
	}
	
	private boolean cityDidReachEnd(Node node, String endCity) {
		if (node.name.equals(endCity)) {
			System.out.println("Reached city " + node.name + " from " + node.fromNode.name + " with total cost " + node.totalCost + ".");
			return true;
		} else if (node.fromNode != null) {
			System.out.println("Examining city " + node.name + " from " + node.fromNode.name + " with total cost " + node.totalCost + ".");
		} else {
			System.out.println("Starting at city " + node.name);
		}
		return false;
	}
	
	private void outputFinalInformation(boolean reachedCity, Node node) {
		if (!reachedCity) {
			System.out.println("Couldn't Reach City");
		} else {
			while(node.fromNode != null) {
				System.out.println("Visited " + node.fromNode.name);
				node = node.fromNode;
			}
		}
		outputAlgorithmStats();
	}
	
	private Comparator<Node> getNodeComparator() {
		Comparator<Node> nodeComparator = new Comparator<Node>() {
	        @Override
	        public int compare(Node e1, Node e2) {
	            return e1.totalCost - e2.totalCost;
	        }
	    };
	    return nodeComparator;
	}
	
	private class Node {
		public int totalCost;
		public String name;
		public Node fromNode;
		
		private Node(int totalCost, String name, Node fromNode) {
			this.totalCost = totalCost;
			this.name = name;
			this.fromNode = fromNode;
		}
	}
}
