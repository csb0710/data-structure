package queue.LinearQueue;

public class Main {

	public static void main(String[] args) {
		LinearQueue queue = new LinearQueue();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println(queue);
		System.out.println(queue.dequeue());
		
	}

}
