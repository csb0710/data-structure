package tree.linkedtree;

public class Main {

	public static void main(String[] args) {
		tree tree = new tree();
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		
		n1.addleft(n2);
		n1.addright(n3);
		n2.addleft(n4);
		n2.addright(n5);
		n3.addright(n6);
		
		tree.inorder(n1);
		System.out.println("-");
		tree.preorder(n1);
		System.out.println("-");
		tree.postorder(n1);
		System.out.println("-");
		tree.inorder(n2);
		
	}

}
