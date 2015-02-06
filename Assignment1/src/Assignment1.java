
public class Assignment1 {

	public static void main(String[] args) {
		AdjancencyMatrix matrix = setupMatrix();
        matrix.printMatrix();
        matrix.breadthFirstSearch("Oradea", "Neamt");
        matrix.depthFirstSearch("Oradea", "Neamt");
    }
	
	public static AdjancencyMatrix setupMatrix() {
		AdjancencyMatrix matrix = new AdjancencyMatrix(20);
		
        String[] names = {	"Oradea", "Zerind", "Arad", "Timisoara", "Lugoj", "Mehadia", 
        					"Drobeta", "Sibiu", "Rimnicu Vilcea", "Craiova", "Fagaras", 
        					"Pitesti", "Bucharest", "Giurgiu", "Urziceni", "Neamt", "Iasi", 
        					"Vaslui", "Hirsova", "Eforie" };
        matrix.addVertices(names);
        
        matrix.addEdge("Oradea", "Zerind", 71);
        matrix.addEdge("Zerind", "Arad", 75);
        matrix.addEdge("Arad", "Timisoara", 118);
        matrix.addEdge("Timisoara", "Lugoj", 111);
        matrix.addEdge("Lugoj", "Mehadia", 70);
        matrix.addEdge("Mehadia", "Drobeta", 75);
        
        matrix.addEdge("Drobeta", "Craiova", 120);
        matrix.addEdge("Oradea", "Sibiu", 151);
        matrix.addEdge("Arad", "Sibiu", 140);
        
        matrix.addEdge("Sibiu", "Rimnicu Vilcea", 80);
        matrix.addEdge("Rimnicu Vilcea", "Craiova", 146);
        
        matrix.addEdge("Sibiu", "Fagaras", 99);
        matrix.addEdge("Rimnicu Vilcea", "Pitesti", 97);
        matrix.addEdge("Craiova", "Pitesti", 138);
        
        matrix.addEdge("Fagaras", "Bucharest", 211);
        matrix.addEdge("Pitesti", "Bucharest", 101);
        
        matrix.addEdge("Bucharest", "Giurgiu", 90);
        
        matrix.addEdge("Bucharest", "Urziceni", 85);
        matrix.addEdge("Urziceni", "Hirsova", 98);
        matrix.addEdge("Hirsova", "Eforie", 86);
        
        matrix.addEdge("Urziceni", "Vaslui", 142);
        matrix.addEdge("Vaslui", "Iasi", 92);
        matrix.addEdge("Iasi", "Neamt", 87);
        
        return matrix;
	}
	
	
	
}
