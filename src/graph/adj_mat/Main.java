package graph.adj_mat;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph();
		for(int i = 0; i < 6; i++) 
			g.insert_vertex(i);
		g.insert_edge(0, 2);
		g.insert_edge(2, 1);
		g.insert_edge(2, 3);
		g.insert_edge(0, 4);
		g.insert_edge(4, 5);
		g.insert_edge(1, 5);
		
		//g.dfs_mat(0);
		g.print_adj_mat();
		g.bfs_mat(0);
	}

}
