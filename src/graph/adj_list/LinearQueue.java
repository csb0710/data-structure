package graph.adj_list;

public class LinearQueue {
	int front = -1;
	int rear = -1;
	private Object[] queue = new Object[100];
	
	public boolean is_empty() {
		return (front == rear);
	}
	
	public void enqueue(Object element) {
		rear++;
		queue[rear] = element;
	}
	
	public Object dequeue() {
		if(is_empty())
			System.out.println("이미 공백인 큐입니다");
		front++;
		Object temp = queue[front];
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
