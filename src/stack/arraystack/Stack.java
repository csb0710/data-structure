package stack.arraystack;

public class Stack {
	int top = -1;
	private Object[] stack = new Object[100];
	
	public boolean is_empty() {
		return (top == -1);
	}
	
	public void push(Object element) {
		top = top + 1;
		stack[top] = element;
	}
	
	public Object pop() {
		if(is_empty()) {
			System.out.println("비어있는 스택입니다");
			return null;
		}
		
		Object value = stack[top];
		top = top - 1;
		
		return value;
	}
	
	public Object peek() {
		if(is_empty()) {
			System.out.println("비어있는 스택입니다");
			return null;
		}
		
		return stack[top];
	}
	
	public int size() {
		return top+1;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i <= top; i++) {
			str += stack[i];
			if(i != top) {
				str += ", ";
			}
		}
		
		return str + "]";
	}
	
	public void clear() {
		top = -1;
	}
	
	public boolean search(Object element) {
		for(int i = 0; i <= top; i++) {
			if(stack[i] == element)
				return true;
		}
		return false;
	}
}
