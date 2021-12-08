package tree.linkedtree;

public class tree {
	public void preorder(Node root) {
		if(root != null) {
			System.out.println(root);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root);
			inorder(root.right);
		}
	}
	
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root);
		}
	}
}
