package queue.double_ended_queue;

public class Deque {
	int front = 0;
	int rear = 0;
	int size = 6;
	private Object[] queue = new Object[size];
	
	public boolean is_empty() {
		return (front == rear);
	}
	
	public boolean is_full() {
		return (front == (rear + 1) % size);
	}
	
	public void add_rear(Object element) {
		if(is_full()) {
			System.out.println("�̹� ������ ����ť�Դϴ�");
		}
		rear = (rear + 1) % size;
		queue[rear] = element;
	}
	
	public Object delete_front() {
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		front = (front + 1) % size;
		return queue[front];
	}
	
	public Object get_front() {
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		
		return queue[(front + 1 + size) % size];
	}
	
	public void add_front(Object element) {
		if(is_full()) {
			System.out.println("�̹� ������ ����ť�Դϴ�");
		}
		queue[front] = element;
		front = (front - 1 + size) % size;
	}
	
	public Object delete_rear() {
		int qrev = rear;
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		rear = (rear - 1 + size) % size;
		return queue[qrev];
	}
	
	public Object get_rear() {
		if(is_empty())
			System.out.println("�̹� ������ ť�Դϴ�");
		
		return queue[rear];
	}
	
	public void queue_print() {
		if(!is_empty()) {
			String str = "| ";
			for(int i = (front + 1) % size; i != front ; i = (i + 1) % size) {
				str = str + queue[i] + " | ";
				if(i == rear)
					break;
			}
			System.out.println(str);
		}
	}
}
