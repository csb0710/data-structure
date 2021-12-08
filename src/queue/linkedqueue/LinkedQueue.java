package queue.linkedqueue;

public class LinkedQueue {
	private Node front = null;
	private Node rear = null;
	
	private class Node {
    	private Object data;
    	private Node next;
    	
    	public Node(Object input) {
    		this.data = input;
    		this.next = null;
    	}
    	
    	public String toString() {
    		return String.valueOf(this.data);
    	}
    }
	
	public boolean is_empty() {
		return (front == null);
	}
	
	public void enqueue(Object element) {
		Node newNode = new Node(element);
		if(is_empty()) {
			front = newNode;
			rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public Object dequeue() {
		Node temp = front;
		if(is_empty()) {
			return null;
		}
		front = front.next;
		return temp;
	}
	
	public Object peek() {
		if(front == null) {
			System.out.println("비어있는 스택입니다");
		}
		return front;
	}
	
	public void queue_print() {
		if(!is_empty()) {
			String str = "| ";
			for(Node temp = front; temp != null; temp = temp.next) {
				str += temp.data + " | ";
			}
			System.out.println(str);
		}
	}
}
