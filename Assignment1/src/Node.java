public class Node {
	public int totalCost;
	public String name;
	public Node fromNode;
		
	public Node(int totalCost, String name, Node fromNode) {
		this.totalCost = totalCost;
		this.name = name;
		this.fromNode = fromNode;
	}	
}