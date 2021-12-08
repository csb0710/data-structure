package graph.topological_sorting;

public class Graph {
	int n;
	Node[] adj_list = new Node[50];
	boolean[] visited = new boolean[50];

	void insert_vertex(int v) {
		if(n+1 > 50) {
			System.out.println("�ִ� ������ ���� �ʰ�");
			return ; 
		}
		n++;
	}
	
	void insert_edge(int u, int v) {
		if(u >= n || v >= n) {
			System.out.println("���� ��ȣ ����");
			return ;
		}
		Node node = new Node(v);
		node.link = adj_list[u];
		adj_list[u] = node;
	}
	
	void print_adj_list() {
		for(int i = 0; i < n; i++) {
			Node node = adj_list[i];
			String str = "���� " + i + "�� ���� ����Ʈ";
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
		System.out.println("���� " + v + " ->");
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
		System.out.println("���� " + v + " ->");
		while(!q.is_empty()) {
			v = q.dequeue();
			for(node = adj_list[v]; node != null; node = node.link) {
				if(!visited[node.vertex]) {
					q.enqueue(node.vertex);
					System.out.println("���� " + node.vertex + " ->");
					visited[node.vertex] = true;
				}
			}
		}
	}
}
