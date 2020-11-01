package b1_3_�ڷᱸ��_��������Ʈ��;

import java.util.*;

public class A_��������Ʈ��_�⺻���� {
	/*
	 * [��������Ʈ��(Complete Binary Tree)]
	 *  - ����Ʈ���� �� ����
	 *  - ������ ������ �����ϰ�� ��� ��尡 �� ä���� �ְ�,
	 *    ������ ������ ��尡 ���� ���ʺ��� ��ĭ ���� ä���� �ִ� ������ Ʈ��
	 *  - ���� Ʈ���� 1���� �迭�� ǥ�� ����
	 *   . Parent: x/2
	 *   . left_child: x*2
	 *   . right_child: x*2 +1 
	 *  - Ʈ�� ��ȸ(Tree Traversal)
	 *   1. ���� ��ȸ(pre-order): ��Ʈ - ���� - ������ ��
	 *   2. ���� ��ȸ(in-order): ���� - ��Ʈ  - ������
	 *   3. ���� ��ȸ(post-order): ���� - ������ - ��Ʈ
	 *   
	 *  <����> N���� Ʈ�� �����Ͱ� �ԷµǾ��� �� Ʈ���� ������ȸ�ϴ� �ڵ�
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

		System.out.println("1. ���� ��ȸ");
		preOrder(1);
		System.out.println();
		
		System.out.println("2. ���� ��ȸ");
		inOrder(1);
		System.out.println();

		System.out.println("3. ���� ��ȸ");
		postOrder(1);
		System.out.println();
	}

	// ���� ��ȸ
	static void inOrder(int node) {
		if(node > n) return;
		
		inOrder(node * 2);		
		System.out.print(tree[node] + " ");		
		inOrder(node * 2 + 1);
	}
	
	// ���� ����
	static void preOrder(int node) {
		if(node > n) return;
		
		System.out.print(tree[node] + " ");
		preOrder(node * 2);		
		preOrder(node * 2 + 1);
		
	}
	
	// ���� ����
	static void postOrder(int node) {
		if(node > n) return;
		
		postOrder(node * 2);
		postOrder(node * 2 + 1);
		
		System.out.print(tree[node] + " ");
	}

}
