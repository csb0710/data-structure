package queue.CircularQueue;

public class CircularQueue {
	int front = 0;
	int rear = 0;
	int size = 6;
	private Object[] queue = new Object[size];
	
	public boolean is_empty() {
		return (front == rear);
	}
	
	public boolean is_full() {
		return (front == (rear+1)%size);
	}
	
	public void enqueue(Object element) {
		if(is_full()) {
			System.out.println("이미 가득찬 원형큐입니다");
		}
		rear = (rear + 1) % size;
		queue[rear] = element;
	}
	
	public Object dequeue() {
		if(is_empty())
			System.out.println("이미 공백인 큐입니다");
		front = (front + 1) % size;
		return queue[front];
	}
	
	public Object peek() {
		if(is_empty())
			System.out.println("이미 공백인 큐입니다");
		
		return queue[(front + 1) % size];
	}
	
	public void queue_print() {
		if(!is_empty()) {
			String str = "| ";
			for(int i = (front + 1) % size; i != front ; i = (i + 1) % size) {
				str = str + queue[i] + " | ";
			}
			System.out.println(str);
		}
	}
}
