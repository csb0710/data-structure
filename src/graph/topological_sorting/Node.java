package graph.topological_sorting;

public class Node {
	public int vertex;
	public Node link;
	
	public Node(int input) {
		this.vertex = input;
		this.link = null;   	
	}
	
	public String toString() {
		return String.valueOf(this.vertex);
	}
}
