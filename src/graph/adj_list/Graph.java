package graph.adj_list;

import graph.adj_mat.LinearQueue;

public class Graph {
	private int n;
	private Node[] adj_list = new Node[50];
	private boolean[] visited = new boolean[50];
	
	private class Node {
    	private int vertex;
    	private Node link;
    	
    	public Node(int input) {
    		this.vertex = input;
    		this.link = null;
    	}
    	
    	public String toString() {
    		return String.valueOf(this.vertex);
    	}
    }
	
	void insert_vertex(int v) {
		if(n+1 > 50) {
			System.out.println("최대 정점의 개수 초과");
			return ; 
		}
		n++;
	}
	
	void insert_edge(int u, int v) {
		if(u >= n || v >= n) {
			System.out.println("정점 번호 오류");
			return ;
		}
		Node node = new Node(v);
		node.link = adj_list[u];
		adj_list[u] = node;
	}
	
	void print_adj_list() {
		for(int i = 0; i < n; i++) {
			Node node = adj_list[i];
			String str = "정점 " + i + "의 인접 리스트";
			while(node != null) {
				str = str + " -> " + node;
				node = node.link;
			}
			System.out.println(str);
		}
	}
	
	void dfs_list(int v) {
		Node node = adj_list[v];
		visited[v] = true;
		System.out.println("정점 " + v + " ->");
		for(; node != null; node = node.link) {
			if(!visited[node.vertex]) 
				dfs_list(node.vertex);
		}
	}
	
	void bfs_list(int v) {
		visited[v] = true;
		Node node;
		LinearQueue q = new LinearQueue();
		q.enqueue(v);
		System.out.println("정점 " + v + " ->");
		while(!q.is_empty()) {
			v = q.dequeue();
			for(node = adj_list[v]; node != null; node = node.link) {
				if(!visited[node.vertex]) {
					q.enqueue(node.vertex);
					System.out.println("정점 " + node.vertex + " ->");
					visited[node.vertex] = true;
				}
			}
		}
	}
}
