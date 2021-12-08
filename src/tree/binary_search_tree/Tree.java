package tree.binary_search_tree;

public class Tree {
	Node search(Node node, int key) {
		if(node == null) return null;
		if(key == node.data) return node;
		else if(key < node.data)
			return search(node.left, key);
		else
			return search(node.right, key);
	}
	
	Node insert_node(Node node, int key) {
		if(node == null) {
			Node new_node = new Node(key);
			return new_node;
		}  // node�� �ʱ� null �����̸� data ���� �������� �ʾ� �ٸ� ������ �� ����� ������ �Ͼ�� ������ �� if���� �� �տ� �ξ���Ѵ�.
		if(key < node.data)
			node.left = insert_node(node.left, key);
		else if(key > node.data)
			node.right = insert_node(node.right, key);
		
		return node;
	}
	
	Node min_value_node(Node node) {
		Node current = node;
		
		while(current.left != null)
			current = current.left;
		
		return current;
	}
	
	Node delete_node(Node root, int key) {
		if(root == null) return root;
		if(key < root.data)
			root.left = delete_node(root.left, key);
		else if(key > root.data)
			root.right = delete_node(root.right, key);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node temp = min_value_node(root.right);
				root.data = temp.data;
				root.right = delete_node(root.right, temp.data);
			}
		}
		
		return root;
	}
	
	void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
}
