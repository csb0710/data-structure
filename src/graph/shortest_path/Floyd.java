package graph.shortest_path;

import graph.shortest_path.Dijkstra.GraphType;

public class Floyd {
	static int[][] A = new int[1000][1000];
	static int INF = 10000;
	
	static class GraphType {
		int n;
		int[][] weight;
		
		public GraphType(int n, int[][] weight) {
			this.n = n;
			this.weight = weight;
		}
	}
	
	static void printA(GraphType g) {
		int i, j;
		for(i = 0; i < g.n; i++) {
			String str = "";
			for(j = 0; j < g.n; j++) {
				if(A[i][j] == INF)
					str += "* ";
				else
					str += A[i][j] + " ";
			}
			System.out.println(str);
		}
		System.out.println("================================");
	}
	
	static void floyd(GraphType g) {
		int i, j, k;
		
		for(i = 0; i < g.n; i++)
			for(j = 0; j < g.n; j++) {
				A[i][j] = g.weight[i][j];
			}
		printA(g);
		
		for(k = 0; k < g.n; k++) {
			for(i = 0; i < g.n; i++)
				for(j = 0; j < g.n; j++)
					if(A[i][k] + A[k][j] < A[i][j])
						A[i][j] = A[i][k] + A[k][j];
			printA(g);
		}
		
	}
	
	public static void main(String[] args) {
		int[][] array = {{0, 7, INF,INF, 3, 10, INF}, {7, 0, 4, 10, 2, 6, INF}, {INF, 4, 0, 2, INF,INF,INF}, {INF, 10, 2, 0, 11, 9, 4}, {3, 2, INF, 11, 0, INF, 5}, {10, 6, INF, 9, INF, 0, INF}, {INF,INF,INF, 4, 5, INF, 0}};
		GraphType g = new GraphType(7, array);
		floyd(g);

	}

}
