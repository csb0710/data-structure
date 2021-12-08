package queue.CircularQueue;

public class Main {

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.queue_print();
		System.out.println(queue.is_full());
		System.out.println(queue.dequeue());
		System.out.println(queue.is_full());
		queue.enqueue(10);
		queue.queue_print();
		System.out.println(queue.peek());
		System.out.println(queue.is_full());
	}

}
