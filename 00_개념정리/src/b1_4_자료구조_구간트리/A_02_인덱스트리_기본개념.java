package b1_4_자료구조_구간트리;

import java.util.*;

public class A_02_인덱스트리_기본개념 {
	/*
	 * [인덱스 트리(Indexed Tree)]
	 *  - 포화이진트리 모양의 자료구조
	 *  - 구간의 최대값, 최소값, 구간 합 등을 구할때 사용
	 *  - 인덱스 트리의 단말 노드와 그 외 노드들의 의미
	 *   . 단말 노드(Leaf Node): 실제 배열에 들어가 있는 값
	 *   . 그 외 노드: 두 단말 노드의 정보를 합친 값(ex: 두 값중 Max/Min/Sum 등)
	 *  - 인덱스 트리의 Leaf Node 수는 N보다 크거나 같아야 함.
	 *  
	 *  <예제> 구간의 최소값 구하기
	 *   . N(1~100,000) 개의 데이터
	 *   . Q(1~100,000) 개의 쿼리
	 *   . 쿼리는 3개의 정수 C, X, Y로 구성 (C:0 -> X~Y의 최소값, C:1 -> X번째 데이터 Y로 수정)
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
		
		// 값 입력
		for (int i = 1; i <= N; i++) {
			data[i] = sc.nextInt();
		}
		
		// leaf node Index 구하기
		leaf = 1;
		while(leaf < N) {
			leaf *= 2;
		}
		
		// leaf node에 데이터 셋팅
		for (int i = 1; i <= N; i++) {
			tree[leaf - 1 + i] = data[i];
		}
		
		// 트리 구성
		for (int i = leaf-1; i >= 1; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
		
		// 쿼리 입력 및 처리
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
			if(x % 2 == 1) {	// x가 오른쪽 노드인 경우
				min = Math.min(min, tree[x]);
			}
			if(y % 2 == 0) {	// y가 왼쪽 노드인 경우
				min = Math.min(min, tree[y]);
			}
			x = (x + 1) / 2;	// x가 오른쪽에 있는 경우는 오른쪽 옆칸의 상위 노드
			y = (y - 1) / 2;	// y가 왼쪽에 있는 경우는 왼쪽 옆칸의 상위 노드
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
