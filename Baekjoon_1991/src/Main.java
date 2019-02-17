import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		
		for (int i = 0; i < N; i++) {
			char[] data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.add(data[0], data[1], data[2]);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
		br.close();
	}
}

class Tree {
	Node root;
	
	public void add(char data, char leftData, char rightData) {
		if (root == null) {
			root = new Node(data);
			
			if (leftData != '.')
				root.left = new Node(leftData);
			
			if (rightData != '.')
				root.right = new Node(rightData);
		}
		else
			search(root, data, leftData, rightData);
	}
	
	private void search(Node root, char data, char leftData, char rightData) {
		if (root == null) return;
		else if (root.data == data) {
			if (leftData != '.')
				root.left = new Node(leftData);
			if (rightData != '.')
				root.right = new Node(rightData);
		} else {
			search(root.left, data, leftData, rightData);
			search(root.right, data, leftData, rightData);
		}
	}
	
	public void preorder(Node root) {
		System.out.print(root.data);
		if (root.left != null) preorder(root.left);
		if (root.right != null) preorder(root.right);
	}
	
	public void inorder(Node root) {
		if (root.left != null) inorder(root.left);
		System.out.print(root.data);
		if (root.right != null) inorder(root.right);
	}
	
	public void postorder(Node root) {
		if (root.left != null) postorder(root.left);
		if (root.right != null) postorder(root.right);
		System.out.print(root.data);
	}
}
class Node {
	char data;
	Node left, right;
	public Node(char data) {
		this.data = data;
	}
}