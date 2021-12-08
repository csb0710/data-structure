package queue.linkedqueue;

public class Main {

	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		queue.queue_print();
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.queue_print();
	}

}
