package stack.linkedstack;

public class Main {

	public static void main(String[] args) {
		LinkedStack linkedstack = new LinkedStack();
		
		linkedstack.push(10);
		linkedstack.push(20);
		linkedstack.push(30);
		
		System.out.println(linkedstack.search(20));
		System.out.println(linkedstack.search(40));
		System.out.println(linkedstack.size());
		System.out.println(linkedstack.pop());
		System.out.println(linkedstack.pop());
		System.out.println(linkedstack.peek());
		System.out.println(linkedstack.size());
		
	}

}
