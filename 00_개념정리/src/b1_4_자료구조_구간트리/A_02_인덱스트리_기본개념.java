package b1_4_�ڷᱸ��_����Ʈ��;

import java.util.*;

public class A_02_�ε���Ʈ��_�⺻���� {
	/*
	 * [�ε��� Ʈ��(Indexed Tree)]
	 *  - ��ȭ����Ʈ�� ����� �ڷᱸ��
	 *  - ������ �ִ밪, �ּҰ�, ���� �� ���� ���Ҷ� ���
	 *  - �ε��� Ʈ���� �ܸ� ���� �� �� ������ �ǹ�
	 *   . �ܸ� ���(Leaf Node): ���� �迭�� �� �ִ� ��
	 *   . �� �� ���: �� �ܸ� ����� ������ ��ģ ��(ex: �� ���� Max/Min/Sum ��)
	 *  - �ε��� Ʈ���� Leaf Node ���� N���� ũ�ų� ���ƾ� ��.
	 *  
	 *  <����> ������ �ּҰ� ���ϱ�
	 *   . N(1~100,000) ���� ������
	 *   . Q(1~100,000) ���� ����
	 *   . ������ 3���� ���� C, X, Y�� ���� (C:0 -> X~Y�� �ּҰ�, C:1 -> X��° ������ Y�� ����)
	 *  (input)
10 4
1 2 3 4 5 6 7 8 9 10
0 3 7 
1 5 2
0 4 9 
0 1 4
	 *  (output)
	 *  3
	 *  2
	 *  1
	 */
	static final int MAX_TREE = 262144; //leaf node: 131072  tree size: leaf node x 2
	static final int MAX_N = 100000;
	static int N, Q;
	static int tree[] = new int[MAX_TREE];
	static int data[] = new int[MAX_N+1];
	static int leaf;
	static final int INF = Integer.MAX_VALUE; 
	public static void main(String[] args) {
//		int leafIdx = 1;
//		while(leafIdx < MAX_N) {
//			leafIdx *= 2;
//		}
//		System.out.println(leafIdx);
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();
		
		// �� �Է�
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}
		
		// leaf node Index ���ϱ�
		leaf = 1;
		while(leaf < N) {
			leaf *= 2;
		}
		
		// leaf node�� ������ ����
		for (int i = 1; i <= N; i++) {
			tree[leaf - 1 + i] = data[i];
		}
		
		// Ʈ�� ����
		for (int i = leaf-1; i >= 1; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
		
		// ���� �Է� �� ó��
		int c, x, y;
		for (int i = 1; i <= Q; i++) {
			c = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			// update
			if(c == 1) {
				update(x, y);
			}
			// get
			else {
				get(x, y);
			}
		}
	}

	public static void get(int x, int y) {
		int min = INF;		
		x = leaf - 1 + x;
		y = leaf - 1 + y;
		
		while(x <= y) {
			if(x % 2 == 1) {	// x�� ������ ����� ���
				min = Math.min(min, tree[x]);
			}
			if(y % 2 == 0) {	// y�� ���� ����� ���
				min = Math.min(min, tree[y]);
			}
			x = (x + 1) / 2;	// x�� �����ʿ� �ִ� ���� ������ ��ĭ�� ���� ���
			y = (y - 1) / 2;	// y�� ���ʿ� �ִ� ���� ���� ��ĭ�� ���� ���
		}
		
		System.out.println(min);
	}

	public static void update(int x, int y) {
		tree[leaf - 1 + x] = y;
		x = (leaf - 1 + x) / 2;
		while(x > 0) {
			tree[x] = Math.min(tree[x * 2], tree[x * 2 + 1]);
			x /= 2;
		}
	}
}
