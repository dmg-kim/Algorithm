package tree;

public class Tree_Binary {

	public static void main(String[] args) {
		
		Node tree[] = new Node[8];
		tree[0] = null;
		tree[1] = new Node(1);
		tree[2] = new Node(2);
		tree[3] = new Node(2);
		tree[4] = new Node(3);
		tree[5] = new Node(3);
		tree[6] = new Node(3);
		tree[7] = new Node(3);
		
		int index = 3;
		
		// 자식 노드 탐색
		System.out.println(index*2 + ": " + tree[index*2].val);
		System.out.println(index*2+1 + ": " + tree[index*2+1].val);
		
		// 부모 노드 탐색
		System.out.println(index/2 + ": " + tree[index/2].val);
		
	}
	
	static class Node {
		int val;
		
		public Node(int val) {
			this.val = val;
		}
	}
}


