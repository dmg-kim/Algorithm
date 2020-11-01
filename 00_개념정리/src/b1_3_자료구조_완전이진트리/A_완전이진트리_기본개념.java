package b1_3_자료구조_완전이진트리;

import java.util.*;

public class A_완전이진트리_기본개념 {
	/*
	 * [완전이진트리(Complete Binary Tree)]
	 *  - 이진트리의 한 종류
	 *  - 마지막 레벨을 제외하고는 모든 노드가 꽉 채워져 있고,
	 *    마지막 레벨은 노드가 가장 왼쪽부터 빈칸 없이 채워져 있는 형태의 트리
	 *  - 이진 트리는 1차원 배열로 표현 가능
	 *   . Parent: x/2
	 *   . left_child: x*2
	 *   . right_child: x*2 +1 
	 *  - 트리 순회(Tree Traversal)
	 *   1. 전위 순회(pre-order): 루트 - 왼쪽 - 오른쪽 순
	 *   2. 중위 순회(in-order): 왼쪽 - 루트  - 오른쪽
	 *   3. 후위 순회(post-order): 왼쪽 - 오른쪽 - 루트
	 *   
	 *  <예제> N개의 트리 데이터가 입력되었을 때 트리를 중위순회하는 코드
	 *  (input)
	 *  9
	 *  1 2 3 4 5 6 7 8 9
	 *  (output)
	 *  4 2 5 1 6 3 
	 *       1
	 *    2      3
	 *  4   5  6   7
	 * 8 9 
	 */  
	static int n;
	static int tree[];
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tree = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			tree[i] = sc.nextInt();
		}

		System.out.println("1. 전위 순회");
		preOrder(1);
		System.out.println();
		
		System.out.println("2. 중위 순회");
		inOrder(1);
		System.out.println();

		System.out.println("3. 후위 순회");
		postOrder(1);
		System.out.println();
	}

	// 중위 순회
	static void inOrder(int node) {
		if(node > n) return;
		
		inOrder(node * 2);		
		System.out.print(tree[node] + " ");		
		inOrder(node * 2 + 1);
	}
	
	// 전위 순휘
	static void preOrder(int node) {
		if(node > n) return;
		
		System.out.print(tree[node] + " ");
		preOrder(node * 2);		
		preOrder(node * 2 + 1);
		
	}
	
	// 후위 순휘
	static void postOrder(int node) {
		if(node > n) return;
		
		postOrder(node * 2);
		postOrder(node * 2 + 1);
		
		System.out.print(tree[node] + " ");
	}

}
