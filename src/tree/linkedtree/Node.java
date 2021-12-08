package tree.linkedtree;

public class Node {
	public Object data;
	public Node left;
	public Node right;
	
	public Node(Object input) {
		this.data = input;
		this.left = null;
		this.right = null;    	
	}
	
	public void addleft(Node left) {
		this.left = left;
	}
	
	public void addright(Node right) {
		this.right = right;
	}
	
	public String toString() {
		return String.valueOf(this.data);
	}
}
