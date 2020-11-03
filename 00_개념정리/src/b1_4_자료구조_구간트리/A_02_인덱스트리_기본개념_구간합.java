package b1_4_자료구조_구간트리;

import java.util.*;

public class A_02_인덱스트리_기본개념_구간합 {
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
