package graph.adj_mat;

public class Graph {
	private int n = 0;
	private int[][] adj_mat = new int[50][50];
	private boolean[] visited = new boolean[50];
	
	void init() {
		n = 0;
		for(int r = 0; r < 50; r++)
			for(int c = 0; c < 50; c++)
				adj_mat[r][c] = 0;
	}
	
	void insert_vertex(int v) {
		if(n+1 > 50) {
			System.out.println("�ִ� ������ ���� �ʰ�");
			return ; 
		}
		n++;
	}
	
	void insert_edge(int start, int end) {
		if(start >= n || end >= n) {
			System.out.println("���� ��ȣ ����");
			return ;
		}
		adj_mat[start][end] = 1;
	}
	
	void print_adj_mat() {
		for(int r = 0; r < n; r++) {
			String str = "";
			for(int c = 0; c < n; c++)
				str = str + adj_mat[r][c] + " ";
			System.out.println(str);
		}
	}
	
	void dfs_mat(int v) {
		visited[v] = true;
		System.out.println("���� " + v + " ->");
		for(int w = 0; w < n; w++)
			if(adj_mat[v][w] == 1 && !visited[w])
				dfs_mat(w);
	}
	
	void bfs_mat(int v) {
		int w;
		visited[v] = true;
		LinearQueue q = new LinearQueue();
		q.enqueue(v);
		System.out.println("���� " + v + " ->");
		while(!q.is_empty()) {
			v = q.dequeue();
			for(w = 0; w < n; w++) {
				if(adj_mat[v][w] == 1 && !visited[w]) {
					q.enqueue(w);
					System.out.println("���� " + w + " ->");
					visited[w] = true;
				}
			}
		}
	}
}
