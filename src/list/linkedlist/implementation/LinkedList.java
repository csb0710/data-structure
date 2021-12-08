package list.linkedlist.implementation;

public class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
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
    
    public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
    
    public void addLast(Object input) {
    	Node newNode = new Node(input);
    	if(size == 0) {
    		addFirst(input);
    	}
    	else {
    		tail.next = newNode;
    		tail = newNode;
    		size++;
    	}
    	
    }
    
   	private Node node(int index) {
    	Node x = head;
    	for(int i = 0; i<index; i++) {
    		x = x.next;
    	}
    	return x;
    }
   	
   	public void add(int index, Object input) {
   		Node newNode = new Node(input);
   		
   		if(index == 0) {
   			addFirst(input);
   		}
   		else if(index == size) {
   			addLast(input);
   		}
   		else {
   			Node current = node(index-1);
   			newNode.next = current.next;
   			current.next = newNode;
   			size++;
   		}
   	}
   	
   	public Object removeFirst() {
   		Node temp = head;
   		head = head.next;
   		Object returnData = temp.data;
   		temp = null;
   		size--;
   		
   		return returnData;
   	}
   	
   	public Object remove(int index) {
   		if(index == 0) {
   			return removeFirst();
   		}
   		else if (index == size-1) {
   			return removeLast();
   		}
   		Node temp = node(index-1);
   		Node todoDeleted = temp.next;
   		temp.next = todoDeleted.next;
   		Object returnData = todoDeleted.data;
   		if(todoDeleted == tail) {
   			tail = temp;
   		}
   		System.out.println(node(1));
   		System.out.println(todoDeleted.data);
   		todoDeleted = null;
   		size--;
   		return returnData;
   		
   	}
   	
   	public Object removeLast() {
   		return remove(size-1);
   		
   	}
   	
   	public int size() {
   		return size;
   	}
   	
   	public Object get(int index) {
   		Node temp = node(index);
   		return temp.data;
   	}
   	
   	public int indexOf(Object data) {
   		Node temp = head;
   		int index = 0;
   		while(temp.data != data) {
   			temp = temp.next;
   			index++;
   			if(temp == null) {
   				return -1;
   			}
   		}
   		return index;
   	}
   	
   	public String toString() {
   		if(head == null) {
   			return "[]";
   		}
   		Node temp = head;
   		String str = "[";
   		
   		while(temp.next != null) {
   			str += temp.data + ", ";
   			temp = temp.next;
   		}
   		str += temp.data;
   		
   		return str + "]";
   	}
   	
   	public ListIterator listIterator() {
   		return new ListIterator();
   	}
   	
   	public class ListIterator {
   		private Node next;
   		private Node LastReturned;
   		private int nextIndex = 0;
   		public ListIterator() {
   			next = head;
   		}
   		
   		public Object next() {
   			LastReturned = next;
   			next = next.next;
   			nextIndex++;
   			return LastReturned.data;
   		}
   		
   		public boolean hasNext() {
   			return next != null;
   		}
   		
   		public void add(Object input) {
   			Node newNode = new Node(input);
   			if(LastReturned == null) {
   				head = newNode;
   				newNode.next = next;
   			}
   			else {
   				LastReturned.next = newNode;
   				if(next != null) {
   					newNode.next = next;
   				}
   				else { 
   					tail = newNode;
   				}
   			}
			LastReturned = newNode;
			nextIndex++;
			size++;
   		}
   		
   		public void remove() {
   			Node removedNode = LastReturned;
   			if(nextIndex == 0) {
   				throw new IllegalStateException();
   			}
   			LinkedList.this.remove(nextIndex-1);
   			nextIndex--;
   		}
   	}
   	
}