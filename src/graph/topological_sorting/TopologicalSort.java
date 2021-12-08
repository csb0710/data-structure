package graph.topological_sorting;

public class TopologicalSort {
	static int[] in_degree = new int[100];
	
	static boolean topo_sort(Graph g) {
		int i;
		LinearQueue q = new LinearQueue();
		Node node;
		
		for(i = 0; i < g.n; i++)
			in_degree[i] = 0;
		for(i = 0; i < g.n; i++) {
			node = g.adj_list[i];
			while(node != null) {
				in_degree[node.vertex]++;
				node = node.link;
			}
		}
		
		for(i = 0; i < g.n; i++)
			if(in_degree[i] == 0)
				q.enqueue(i);
		
		while(!q.is_empty()) {
			int w;
			w = q.dequeue();
			System.out.println("Á¤Á¡ " + w + " ->");
			node = g.adj_list[w];
			while(node != null) {
				int u = node.vertex;
				in_degree[u]--;
				if(in_degree[u] == 0) {
					q.enqueue(u);
				node = node.link;
				}
			}
		}
		
		return (i == g.n);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		for(int i = 0; i < 6; i++)
			g.insert_vertex(i);
		
		g.insert_edge(0, 2);
		g.insert_edge(0, 3);
		
		g.insert_edge(1, 3);
		g.insert_edge(1, 4);
		
		g.insert_edge(2, 3);
		g.insert_edge(2, 5);
		
		g.insert_edge(3, 5);
		
		g.insert_edge(4, 5);
		
		topo_sort(g);
	}

}
