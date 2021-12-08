package list.doublylinkedlist.implementation.copy;


public class DoublyLinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;
    
    private class Node {
    	private Object data;
    	private Node next;
    	private Node prev;
    	
    	public Node(Object input) {
    		this.data = input;
    		this.next = null;
    		this.prev = null;
    	}
    	
    	public String toString() {
    		return String.valueOf(this.data);
    	}
    	
    	
    }
    
    public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		if(head != null) {
			head.prev = newNode;
		}
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
    		newNode.prev = tail;
    		tail = newNode;
    		size++;
    	}
    	
    }
    
   	private Node node(int index) {
    	Node x = head;
    	if(index < size/2) {
    		for(int i = 0; i<index; i++) {
        		x = x.next;
        	}
    	}
    	else {
    		for(int i = size-1; i > index ; i--) {
    			x = x.prev;
    		}
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
   			Node temp1 = node(index-1);
   			Node temp2 = temp1.next;
   			newNode.next = temp2;
   			temp1.next = newNode;
   			temp2.prev = newNode;
   			newNode.prev = temp1;
   			size++;
   		}
   	}
   	
   	public Object removeFirst() {
   		Node temp = head;
   		head = head.next;
   		Object returnData = temp.data;
   		temp = null;
   		if(head != null) {
   			head.prev = null;
   		}
   		size--;
   		
   		return returnData;
   	}
   	
   	public Object remove(int index) {
   		if(index == 0) {
   			return removeFirst();
   		}
   		Node temp = node(index-1);
   		Node todoDeleted = temp.next;
   		Node temp2 = todoDeleted.next;
   		temp.next = temp2;
   		Object returnData = todoDeleted.data;
   		temp2.prev = temp;
   		if(todoDeleted == tail) {
   			tail = temp;
   		}
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
   		
   		public Object previous() {
   			if(next == null) {
   				LastReturned = next = tail;
   			}
   			else {
   				LastReturned = next = next.prev;
   			}
   			nextIndex--;
   			return LastReturned.data;
   		}
   		
   		public boolean hasPrevious() {
   			return nextIndex > 0;
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
   				next.prev = newNode;
   			}
   			else {
   				LastReturned.next = newNode;
   				newNode.prev = LastReturned;
   				if(next != null) {
   					newNode.next = next;
   					next.prev = newNode;
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
   			if(LastReturned == null) {
   				throw new IllegalStateException();
   			}
   			Node p = LastReturned.prev;
   			Node n = LastReturned.next;
   			
   			if(p == null) {
   				head = n;
   				head.prev = null;
   				LastReturned = null;
   				size--;
   				nextIndex--;
   			}
   			else {
   				p.next = n;
   				LastReturned.prev = null;
   			}
   			if(n == null) {
   				tail = p;
   				tail.next = null;
   			}
   			else {
   				n.prev = p;
   			}
   			if(next == null) {
   				LastReturned = tail;
   			}
   			else {
   				LastReturned = next.prev;
   			}
   			size--;
   			nextIndex--;
   		}
   	}
   	
}