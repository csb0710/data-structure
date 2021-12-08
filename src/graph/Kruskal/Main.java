package graph.Kruskal;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.graph_init();
		
		g.insert_edge(0, 1, 29);
		g.insert_edge(1, 2, 16);
		g.insert_edge(2, 3, 12);
		g.insert_edge(3, 4, 22);
		g.insert_edge(4, 5, 27);
		g.insert_edge(5, 0, 10);
		g.insert_edge(6, 1, 15);
		g.insert_edge(6, 3, 18);
		g.insert_edge(6, 4, 25);
		
		g.kruskal();
	}

}
