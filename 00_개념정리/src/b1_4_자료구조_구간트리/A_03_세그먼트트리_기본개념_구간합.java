package b1_4_자료구조_구간트리;

import java.util.*;

public class A_03_세그먼트트리_기본개념_구간합 {
	/*
	 * [세그먼트 트리(Segment Tree)]
	 *  1) 특정 숫자를 바꿔라 => O(logN)
	 *    : 이진트리의 높이만큼
	 *  2) i번째 숫자부터 j번째 숫자까지의 합을 구하라 => O(logN)
	 *  
	 *  - 이진트리 => 배열형태
	 *   . 루트가 1
	 *  - 트리의 각 노드에 "구간"의 정보를 저장
	 *  
	 *  - 절차
	 *   1. buildTree: 트리의 값 채우기
	 *    : 재귀(왼쪽 자식 + 오른쪽 자식)
	 *   2. 쿼리
	 *    1) get: Top Down으로 트리를 순회하면서 해당 노드의 범위에 구하고자 하는 범위가 포함되는지 확인
	 *    2) update:
	 *    3) getIdx:
	 *    
	 *    
	 *  <예제> 구간의 합 구하기
	 *  1: 구간의합,  2: 값을 변경
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
		// 재귀함수(Top Down)
		// tree[1]: 1~N
		// tree[2]: 1~N/2, tree[3]: N/2+1~N
		// tree[4]: 1~N/4, tree[5]: N/4+1 ~ N/2, tree[6]: N/2+1~3N/4, tree[7]:3N/4+1~N
		// tree[pos]의 값 채우기,이 때 구간은 (start ~ end)
		// start ~ end 합 리턴
		
		// tree의 단말 노드인 경우
		if(start >= end) {
			addr[start] = pos;	// 데이터 포지션 별 단말노드의 인덱스(위치)를 저장
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
		// 구하고자하는 구간(qStart~qEnd)가 주어진 구간(start~end)에 겹치지 않는 경우
		if(end < qStart || qEnd < start) {
			return 0;
		}
		
		// 완전히 포함하는 경우
		if(qStart <= start && end <= qEnd) {
			return tree[pos];
		}
		
		// 쪼개야 하는 경우
		int mid = (start + end) / 2;
		long leftSum = getSegSumInternal(pos * 2, start , mid, qStart, qEnd);
		long rightSum = getSegSumInternal(pos * 2 + 1, mid + 1 , end, qStart, qEnd);
		
		return leftSum + rightSum;
	}
	
	public static void update(int pos, int val) {
		// 해당 포지션의 leaf 노드 구하기
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
//		// 단말 노드인 경우
//		if(start >= end) {
//			if(start == dataIdx) return pos;
//			// 못찾은 경우
//			else return -1;	
//		}
//		// 단말 노드가 아닌 경우
//		else {
//			int mid = (start + end) / 2;
//			int leftIdx = getLeafIdx(pos * 2, start, mid, dataIdx);
//			if(leftIdx == -1) {	//왼쪽에서 못찾음
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
