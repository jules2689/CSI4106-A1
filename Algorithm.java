import java.util.ArrayList;
import java.util.Stack;

public class Algorithm {
	protected int[][] adjancencyMatrix;
	protected int numberOfVertices;
	protected ArrayList<String> vertexNames;
	protected int numberOfVistedCities;
	protected int maxNumberOfCitiesInTheQueue;
	protected Stack<String> path = new Stack<String>();
	
	public Algorithm(AdjancencyMatrix matrix) {
		this.adjancencyMatrix = matrix.getMatrix();
		this.numberOfVertices = this.adjancencyMatrix.length;
		this.vertexNames = matrix.getCities();
		this.numberOfVistedCities = 0;
		this.maxNumberOfCitiesInTheQueue = 0;
	}

	public void perform(String startCity, String endCity) {
		throw new UnsupportedOperationException();
	}
	
	public void formStackPath(Node node) {
		this.path.push(node.name);
		
		while(node.fromNode != null) {
			this.path.push(node.fromNode.name);
			node = node.fromNode;
		}
	}
	
	public void outputAlgorithmStats() {
		System.out.println("");
		System.out.println("The total number of nodes generated (to represent time).\nIt is assumed that this means the number of 'visited' cities");
		System.out.println("~~ This algorithm visited " + this.numberOfVistedCities +  " cities during its run.");
		System.out.println("");
		System.out.println("The maximum number of nodes that existed in memory for any given run (to represent space)\nIt is assumed that this refers to the maximum number of cities in the queue or stack.");
		System.out.println("~~ This algorithm had a maximum of " + this.maxNumberOfCitiesInTheQueue +  " cities in its queue/stack at any given point in time.");
		System.out.println("");
		System.out.println("The path (from city to another) that will lead you from source to destination using the algorithm you decided to use.");
		System.out.println("~~ This is the path that was taken.");
		
		System.out.print(this.path.pop());
		while (!this.path.isEmpty()) {
			System.out.print(" -> " + this.path.pop());
		}
		
		System.out.println("");
	}
	
}
