package tree;

import java.util.ArrayList;

public class Tree {

	public static void main(String[] args) {
		
		Node root = new Node(1, null, new ArrayList<>());
		root.child.add(new Node(2, root, new ArrayList<>()));
		root.child.add(new Node(3, root, new ArrayList<>()));
		
		Node now1 = root.child.get(0);
		now1.child.add(new Node(4, now1, new ArrayList<>()));
		now1.child.add(new Node(5, now1, new ArrayList<>()));
		
		Node now2 = root.child.get(1);
		now2.child.add(new Node(6, now2, new ArrayList<>()));
		now2.child.add(new Node(7, now2, new ArrayList<>()));
		
		// 자식 노드 탐색
		for(Node child: now2.child) {
			System.out.println(child.val);
		}
		
		// 부모 노드 탐색
		System.out.println(now2.parent.val);
		

	}
	
	static class Node {
		int val;
		Node parent;
		ArrayList<Node> child;
		
		public Node(int val, Node parent, ArrayList<Node> child) {
			this.val = val;
			this.parent = parent;
			this.child = child;
		}
	}
}
