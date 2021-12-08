package tree.binary_search_tree;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = null;
				
		root = tree.insert_node(root, 30);
		root = tree.insert_node(root, 20);
		root = tree.insert_node(root, 10);
		root = tree.insert_node(root, 40);
		root = tree.insert_node(root, 50);
		root = tree.insert_node(root, 60);
		
		tree.inorder(root);
		
		if(tree.search(root, 30) != null)
			System.out.println("success");
		else
			System.out.println("fail");
		

	}

}
