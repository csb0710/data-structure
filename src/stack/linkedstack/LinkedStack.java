package stack.linkedstack;

import java.util.EmptyStackException;

public class LinkedStack {
	private Node top = null;
	private int size = 0;
	
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
		return (top == null);
	}
	
	public void push(Object element) {
		Node newNode = new Node(element);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public Node pop() {
		Node temp = top;
		
		if(!is_empty()) {
			top = top.next;
			size--;
		}
		else
			System.out.println("이미 비어있는 스택입니다");
	
		return temp;
	}
	
	public Node peek() {
		if (top == null)
            throw new EmptyStackException();
		return top;
	}
	
	public int size() {
		return size;
	}
	
	public boolean search(Object element) {
		Node temp = top;
		while(temp != null) {
			if(temp.data.equals(element))
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void clear() {
		top = null;
	}
	
//	public String toString() {
//		String str = "[";
//		while(top != null) {
//			str += top.data;
//			if(top.next != null)
//				str += ", ";
//			top = top.next;
//		}
//		
//		return str + "]";
//	}
}
