package search_algorithm;

public class AVL_Tree {
	static class AVLNode {
		private int key;
		private AVLNode left;
		private AVLNode right;
		
		public AVLNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
	
	static AVLNode rotate_right(AVLNode parent) {
		AVLNode child = parent.left;
		parent.left = child.right;
		child.right = parent;
		
		return child;
	}
	
	static AVLNode rotate_left(AVLNode parent) {
		AVLNode child = parent.right;
		parent.right = child.left;
		child.left = parent;
		
		return child;
	}
	
	static int get_height(AVLNode node) {
		int height = 0;
		
		if(node != null)
			height = 1 + Math.max(get_height(node.left), get_height(node.right));
		
		return height;
	}
	
	static int get_balance(AVLNode node) {
		if(node == null)
			return 0;
		return get_height(node.left) - get_height(node.right);
	}
	
	static AVLNode insert(AVLNode node, int key) {
		if(node == null) {
			AVLNode root = new AVLNode(key);
			return root;
		}
		
		if(key < node.key)
			node.left = insert(node.left, key);
		else if(key > node.key)
			node.right = insert(node.right, key);
		else
			return node;
		
		int balance = get_balance(node);
		
		if(balance > 1 && key < node.left.key)
			return rotate_right(node);
		if(balance < -1 && key > node.right.key)
			return rotate_left(node);
		if(balance > 1 && key > node.left.key) {
			node.left = rotate_left(node.left);
			return rotate_right(node);
		}
		if(balance < -1 && key < node.right.key) {
			node.right = rotate_right(node.right);
			return rotate_left(node);
		}
		
		return node;
	}
	
	static void preorder(AVLNode root) {
		if(root != null) {
			System.out.println(root.key);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		AVLNode root = null;
		
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 30);
		root = insert(root, 40);
		root = insert(root, 50);
		root = insert(root, 29);
		
		preorder(root);
	
	}

}
