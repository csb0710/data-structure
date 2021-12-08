package graph.Kruskal;

import java.util.Arrays;

import com.sun.source.doctree.StartElementTree;

public class Graph {
	int n = 0;
	int[] parent = new int[100];
	Edge[] edges = new Edge[200];
	
	private class Edge implements Comparable{
		private int start;
		private int end;
		private int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Object p) {
			Edge people = (Edge)p;
	         if (this.weight < people.weight) {
	             return -1;
	         } else if (this.weight == people.weight) {
	             return 0;
	         } else {
	             return 1;
	         }
	     }
	}
	
	void set_init() {
		for(int i = 0; i < n; i++) {
			parent[i] = -1;
		}
	}
	
	int set_find(int curr) {
		if(parent[curr] == -1)
			return curr;
		while(parent[curr] != -1)
			curr = parent[curr];
		return curr;
	}
	
	void set_union(int a, int b) {
		int root1 = set_find(a);
		int root2 = set_find(b);
		if(root1 != root2)
			parent[root1] = root2;
	}
	void graph_init() {
		n = 0;
		for(int i = 0; i < 200; i++) {
			edges[i] = new Edge(0, 0, 0);
		}
	}
	
	void insert_edge(int start, int end, int w) {
		edges[n].start = start;
		edges[n].end = end;
		edges[n].weight = w;
		
		n++;
	}
	
	void kruskal() {
		int edge_accepted = 0;
		int uset, vset;
		Edge e;
		int i = 0;
		
		set_init();
		Arrays.sort(edges);
		
		while(edge_accepted < (n)) {
			e = edges[i];
			uset = set_find(e.start);
			vset = set_find(e.end);
			if(uset != vset) {
				System.out.println("간선 (" + e.start + ", " + e.end + ") " + e.weight + " 선택");
				set_union(e.start, e.end);
				edge_accepted++;
			}
			
			i++;
		}
	}
}
