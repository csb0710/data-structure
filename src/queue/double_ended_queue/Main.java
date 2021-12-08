package queue.double_ended_queue;

public class Main {

	public static void main(String[] args) {
		Deque queue = new Deque();

		queue.add_rear(10);
		queue.add_front(20);
		queue.add_front(30);
		queue.add_front(40);
		queue.add_rear(50);
		
		queue.queue_print();
		System.out.println(queue.is_full());
		System.out.println(queue.delete_rear());
		System.out.println(queue.delete_front());
		System.out.println(queue.delete_rear());
		System.out.println(queue.front);
		System.out.println(queue.rear);
		queue.queue_print();
		queue.add_rear(10);
		queue.queue_print();
	}

}
