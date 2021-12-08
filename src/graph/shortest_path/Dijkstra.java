package graph.shortest_path;



public class Dijkstra {
	static int[] distance = new int[100];
	static boolean[] found = new boolean[100];
	static int INF = 10000;
	static int step = 1;
	
	static class GraphType {
		int n;
		int[][] weight;
		
		public GraphType(int n, int[][] weight) {
			this.n = n;
			this.weight = weight;
		}
	}
	
	static int choose(int[] distance, int n, boolean[] found) {
		int i, min, minpos;
		min = Integer.MAX_VALUE;
		minpos = -1;
		
		for(i = 0; i < n; i++) {
			if(distance[i] < min && !found[i]) {
				min = distance[i];
				minpos = i;
			}	
		}
		
		return minpos;
	}
	
	static void print_status(GraphType g) {
		System.out.println("STEP : " + step);
		step++;
		String str = "distance: ";
		String str2 = "found: ";
		for(int i = 0; i < g.n; i++) {
			if(distance[i] == INF)
				str += " * " +" ";
			else
				str += distance[i] +" ";
		}
		System.out.println(str);
		for(int i = 0; i < g.n; i++)
			str2 += found[i]+" ";
		System.out.println(str2);
	}
	
	static void shortest_path(GraphType g, int start) {
		int i, u, w;
		for(i = 0; i < g.n; i++) {
			distance[i] = g.weight[start][i];
			found[i] = false;
		}
		
		found[start] = true;
		distance[start] = 0;
		
		for(i = 0; i < g.n-1; i++) {
			print_status(g);
			u = choose(distance, g.n, found);
			found[u] = true;
			for(w = 0; w < g.n; w++) {
				if(!found[w])
					if(distance[u] + g.weight[u][w] < distance[w])
						distance[w] = distance[u] + g.weight[u][w];
			}
		}
	}
	public static void main(String[] args) {
		int[][] array = {{0, 7, INF,INF, 3, 10, INF}, {7, 0, 4, 10, 2, 6, INF}, {INF, 4, 0, 2, INF,INF,INF}, {INF, 10, 2, 0, 11, 9, 4}, {3, 2, INF, 11, 0, INF, 5}, {10, 6, INF, 9, INF, 0, INF}, {INF,INF,INF, 4, 5, INF, 0}};
		GraphType g = new GraphType(7, array);
		shortest_path(g, 0);
	}

}
