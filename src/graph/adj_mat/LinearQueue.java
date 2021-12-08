package graph.adj_mat;

public class LinearQueue {
	int front = -1;
	int rear = -1;
	private int[] queue = new int[100];
	
	public boolean is_empty() {
		return (front == rear);
	}
	
	public void enqueue(int element) {
		rear++;
		queue[rear] = element;
	}
	
	public int dequeue() {
		if(is_empty())
			System.out.println("이미 공백인 큐입니다");
		front++;
		int temp = queue[front];
		return temp;
	}
	
	public String toString() {
		String str = "[";
		for(int i = front+1; i <= rear; i++) {
			str += queue[i];
			if(i != rear) {
				str += ", ";
			}
		}
		
		return str + "]";
	}
}
