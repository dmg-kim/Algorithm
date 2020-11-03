package b1_4_�ڷᱸ��_����Ʈ��;

import java.util.*;

public class A_02_�ε���Ʈ��_�⺻����_������ {
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
	 *    
	 *  <����> ������ �� ���ϱ�
	 *  1: ��������,  2: ���� ����
	 *  (input)
	 *  8 5
	 *  1 3 8 4 8 3 8 9
	 *  1 2 4
	 *  2 2 5
	 *  1 2 4
	 *  2 3 -10
	 *  1 1 8
	 *  (output)
	 *  15
	 *  17
	 *  28
 	 *  (input)
5 3
3 1 5 2 4
1 1 3
0 2 6
1 1 3
	 *  (output)
9
14

5 3
3 1 5 2 4
15 11 4 4 7 4 0 3 1 5 2 4 0 0 0 0 
1 1 3
9
15 11 4 4 7 4 0 3 1 5 2 4 0 0 0 0 
0 2 6
20 16 4 9 7 4 0 3 6 5 2 4 0 0 0 0 
1 1 3
14
20 16 4 9 7 4 0 3 6 5 2 4 0 0 0 0 
	 */
	static int N, M;
	static final int MAX_N = 1000000;
	static final int MAX_TREE = 1048576*2;
	static int data[] = new int[MAX_N + 1];
	static int tree[] = new int[MAX_TREE];
	static int leaf;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}
		
		leaf = 1;
		while(leaf < N) {
			leaf <<= 1;
		}
		
		buildTree();
		
		checkTree();
		
		int a, b, c;
		for (int i = 1; i <= M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a == 1) {
				System.out.println(getSum(b, c));
			}
			else {
				update(b, c);
				//checkTree();
			}
			checkTree();
		}
	}
	
	private static long getSum(int start, int end) {
		long sum = 0L;
		
		start = leaf - 1 + start;
		end = leaf - 1 + end;
		
		while(start <= end) {
			if(start % 2 == 1) {
				sum += tree[start++];
			}
			if(end  % 2 == 0) {
				sum += tree[end--];
			}
			
			start >>= 1;
			end >>= 1;
		}
		return sum;
	}
	
	public static void checkTree() {
		for (int i = 1; i <= 2 * leaf; i++) {
			System.out.print(tree[i] + " ");
		}
	}
	
	public static void update(int pos, int val) {
		int index = leaf - 1 + pos;
		int diff = val - data[pos];
		data[pos] = val;
		
		while(index > 0) {
			tree[index] += diff;
			
			index >>= 1;
		}
		
	}
	
	public static void buildTree() {
		int index = leaf - 1;
		for (int i = 1; i <= N; i++) {
			tree[index + i] = data[i];
		}
		
		for (int i = index; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[(i * 2) + 1];
		}
	}
}
