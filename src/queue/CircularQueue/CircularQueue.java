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
			System.out.println("�̹� ������ ����ť�Դϴ�");
		}
		rear = (rear + 1) % size;
		queue[rear] = element;
	}
	
	public Object dequeue() {
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		front = (front + 1) % size;
		return queue[front];
	}
	
	public Object peek() {
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		
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
