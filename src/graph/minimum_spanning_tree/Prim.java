package graph.minimum_spanning_tree;

class GraphType {
	int n;
	int[][] weight;
	
	public GraphType(int n, int[][] weight) {
		this.n = n;
		this.weight = weight;
	}
}

public class Prim {
	static int[] distance = new int[100];
	static boolean[] selected = new boolean[100];
	static int INF = 10000;
	
	static int get_min_vertex(int n) {
		int v = n, i;
		for(i = 0; i < n; i++)
			if(!selected[i]) {
				v = i;
				break;
			}
		for(i = 0; i < n; i++) 
			if(!selected[i] && (distance[i] < distance[v]))
				v = i;
		return v;
	}
	
	static void prim(GraphType g, int s) {
		int i, u, v;
		
		for(u = 0; u < g.n; u++) {
			distance[u] = INF;
			selected[u] = false;
		}
		distance[s] = 0;
		for(i = 0; i < g.n; i++) {
			u = get_min_vertex(g.n);
			selected[u] = true;
			if(distance[u] == INF) return;
			System.out.println("정점 " + u + " 추가");
			for(v = 0; v < g.n; v++) {
				if(g.weight[u][v] != INF) 
					if(!selected[v] && g.weight[u][v] < distance[v])
						distance[v] = g.weight[u][v];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] array = {{0, 29, INF, INF, INF, 10, INF}, {29, 0, 16, INF,INF,INF, 15}, {INF, 16, 0, 12, INF,INF,INF}, {INF,INF, 12, 0, 22, INF, 18}, {INF,INF,INF, 22, 0, 27, 25}, {10, INF,INF,INF, 27, 0, INF}, {INF, 15, INF, 18, 25, INF, 0}
		};
		GraphType g = new GraphType(7, array);
		prim(g, 0);
	}

}
