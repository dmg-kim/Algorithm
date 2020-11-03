package b1_4_�ڷᱸ��_����Ʈ��;

import java.util.*;

public class A_03_���׸�ƮƮ��_�⺻����_������ {
	/*
	 * [���׸�Ʈ Ʈ��(Segment Tree)]
	 *  1) Ư�� ���ڸ� �ٲ�� => O(logN)
	 *    : ����Ʈ���� ���̸�ŭ
	 *  2) i��° ���ں��� j��° ���ڱ����� ���� ���϶� => O(logN)
	 *  
	 *  - ����Ʈ�� => �迭����
	 *   . ��Ʈ�� 1
	 *  - Ʈ���� �� ��忡 "����"�� ������ ����
	 *  
	 *  - ����
	 *   1. buildTree: Ʈ���� �� ä���
	 *    : ���(���� �ڽ� + ������ �ڽ�)
	 *   2. ����
	 *    1) get: Top Down���� Ʈ���� ��ȸ�ϸ鼭 �ش� ����� ������ ���ϰ��� �ϴ� ������ ���ԵǴ��� Ȯ��
	 *    2) update:
	 *    3) getIdx:
	 *    
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
15 9 6 4 5 2 4 3 1 0 
1 1 3
9
15 9 6 4 5 2 4 3 1 0 
0 2 6
20 14 6 9 5 2 4 3 6 0 
1 1 3
14
20 14 6 9 5 2 4 3 6 0 

 
	 */
	static int N, M;
	static final int MAX_N = 1000000;
	static final int MAX_TREE = 1048576*2;
	static int data[] = new int[MAX_N + 1];
	static int tree[] = new int[MAX_TREE];
	static int addr[] = new int[MAX_N + 1];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}
		
		buildTree();
		
		checkTree();
		
		int a, b, c;
		for (int i = 1; i <= M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a == 1) {
				System.out.println(getSegSum(b, c));
			}
			else {
				update(b, c);
				//checkTree();
			}
			checkTree();
		}
	}
	
	public static void buildTree() {
		buildTreeInternal(1, 1, N); // root, start, end (Top Down)
	}

	public static int buildTreeInternal(int pos, int start, int end) {
		// ����Լ�(Top Down)
		// tree[1]: 1~N
		// tree[2]: 1~N/2, tree[3]: N/2+1~N
		// tree[4]: 1~N/4, tree[5]: N/4+1 ~ N/2, tree[6]: N/2+1~3N/4, tree[7]:3N/4+1~N
		// tree[pos]�� �� ä���,�� �� ������ (start ~ end)
		// start ~ end �� ����
		
		// tree�� �ܸ� ����� ���
		if(start >= end) {
			addr[start] = pos;	// ������ ������ �� �ܸ������ �ε���(��ġ)�� ����
			return tree[pos] = data[start];
		}
		
		int mid = (start + end) / 2;
		int leftVal = buildTreeInternal(pos * 2, start, mid);
		int rightVal = buildTreeInternal(pos * 2 + 1, mid + 1, end);
		
		return tree[pos] = leftVal + rightVal;
	}
	
	public static long getSegSum(int start, int end) {
		return getSegSumInternal(1, 1, N, start, end);
	}
	
	public static long getSegSumInternal(int pos, int start, int end, int qStart, int qEnd) {
		// ���ϰ����ϴ� ����(qStart~qEnd)�� �־��� ����(start~end)�� ��ġ�� �ʴ� ���
		if(end < qStart || qEnd < start) {
			return 0;
		}
		
		// ������ �����ϴ� ���
		if(qStart <= start && end <= qEnd) {
			return tree[pos];
		}
		
		// �ɰ��� �ϴ� ���
		int mid = (start + end) / 2;
		long leftSum = getSegSumInternal(pos * 2, start , mid, qStart, qEnd);
		long rightSum = getSegSumInternal(pos * 2 + 1, mid + 1 , end, qStart, qEnd);
		
		return leftSum + rightSum;
	}
	
	public static void update(int pos, int val) {
		// �ش� �������� leaf ��� ���ϱ�
		//int index = getLeafIdx(1, 1, N, pos);
		int index = addr[pos];
		int diff = val - data[pos];
		data[pos] = val;
		
		while(index > 0) {
			tree[index] += diff;
			
			index >>= 1;
		}
	}
	
//	public static int getLeafIdx(int pos, int start, int end, int dataIdx) {
//		// �ܸ� ����� ���
//		if(start >= end) {
//			if(start == dataIdx) return pos;
//			// ��ã�� ���
//			else return -1;	
//		}
//		// �ܸ� ��尡 �ƴ� ���
//		else {
//			int mid = (start + end) / 2;
//			int leftIdx = getLeafIdx(pos * 2, start, mid, dataIdx);
//			if(leftIdx == -1) {	//���ʿ��� ��ã��
//				int rightIdx = getLeafIdx(pos * 2 + 1, mid + 1, end, dataIdx);
//				return rightIdx;
//			}
//			return leftIdx;
//		}
//	}
	

	public static void checkTree() {
		for (int i = 1; i <= 2 * N; i++) {
			System.out.print(tree[i] + " ");
		}
	}
}
