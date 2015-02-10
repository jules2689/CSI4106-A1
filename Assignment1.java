import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Assignment1 {

	public static void main(String[] args) {
		System.out.println("Assignment 1, CSI4106");
		System.out.println("Julian Nadeau, 6008161");
		System.out.println("=============================================================");
		
		AdjancencyMatrix matrix = setupMatrix();
        System.out.println("Here are your city choices: " + matrix.citiesString());
		String startCity = getChoice("What city are you in? ", matrix.getCities());
		String endCity = getChoice("What city do you want to go to? ", matrix.getCities());
		chooseAndPerformAlgorithm(matrix, startCity, endCity);
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
	
	private static void chooseAndPerformAlgorithm(AdjancencyMatrix matrix, String startCity, String endCity) {
		ArrayList<String> acceptableAlgs = new ArrayList<String>(Arrays.asList("b","d","u"));
		String algorithmChoice = getChoice("How do you want to go there? (b)readth first, (d)epth first, or (u)niform cost. ", acceptableAlgs);
		Algorithm algorithm = null;
		
		switch (algorithmChoice.charAt(0)) {
			case 'b':
				algorithm = new BreadthFirstSearch(matrix);
				break;
			case 'd':
				algorithm = new DepthFirstSearch(matrix);
				break;
			case 'u':
				algorithm = new UniformCostSearch(matrix);
				break;
		}
		
		algorithm.perform(startCity, endCity);
	}
	
	private static String getChoice(String message, ArrayList<String> acceptableChoices) {
		String choice = "N/A";
		
		try {
			while(acceptableChoices.contains(choice) == false) { choice = readLine(message); }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return choice;
	}
	
	private static String readLine(String format, Object... args) throws IOException {
	    if (System.console() != null) { return System.console().readLine(format, args); }
	    System.out.print(String.format(format, args));
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    return reader.readLine();
	}
	
}
