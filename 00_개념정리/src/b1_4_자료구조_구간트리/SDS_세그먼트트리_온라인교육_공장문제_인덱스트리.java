package b1_4_자료구조_구간트리;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/7578
 */
public class SDS_세그먼트트리_온라인교육_공장문제_인덱스트리 {
	static int N; // 1~500000
	static final int MAX_N = 500000;
	static final int MAX_VAL = 1000000;
	static final int MAX_TREE = 524288*2;
//	static int A_Arr[] = new int[MAX_N+1];
//	static int B_Idx[] = new int[MAX_VAL+1];
//	static long tree[] = new long[MAX_TREE+1];
	static int A_Arr[];
	static int B_Idx[];
	static long tree[];
	static int leaf;
	static long Ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		A_Arr = new int[N+1];
		B_Idx = new int[MAX_VAL+1];
		
		// 0. 입력
		//  1) A열 설비 입력
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			A_Arr[i] = Integer.parseInt(st.nextToken());
		}

		//  2) B열 설비 정보 입력		
		st = new StringTokenizer(br.readLine().trim());
		int eqpNo = 0;
		for (int i = 1; i <= N; i++) {
			eqpNo = Integer.parseInt(st.nextToken());
			B_Idx[eqpNo] = i;
		}
		
		// 1. 트리 구성(초기화)
		leaf = 1;
		while(leaf <= N) leaf <<= 1;
		tree = new long[leaf*2+1];
		Arrays.fill(tree, 0);
		
//		buildTree();
		
//		checkTree();
		
		Ans = 0L;
		// 2. 상단 설비부터 체크
		//  - 상단 설비와 매핑된 하단 설비 위치보다 오른쪽에 매핑된 설비가 있는지
		//   . Ans += get(하단 설비 idx ~ N)
		//   . update(하단 설비 idx)
		for (int i = 1; i <= N; i++) {
			Ans += get(B_Idx[A_Arr[i]], N);
			
			update(B_Idx[A_Arr[i]], 1);
//			checkTree();
		}
		
		// 3. Ans 출력
		bw.append(Ans + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void checkTree() {
		for (int i = 1; i <= leaf*2; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

	public static void buildTree() {
//		int idx = leaf - 1;
//		for (int i = 1; i <= N; i++) {
//			tree[idx+1] = 0;
//		}
//		
//		for (int i = leaf-1; i >= 1; i--) {
//			tree[i] = tree[i * 2] + tree[(i * 2) + 1];
//		}
		Arrays.fill(tree, 0);
	}
	
	public static void update(int idx, int val) {
		idx += leaf - 1;
		while(idx > 0) {
			tree[idx] += val;
			idx >>= 1;
		}	
	}
	
	public static long get(int start, int end) {
		long sum = 0L;
		start += leaf - 1;
		end += leaf - 1;
		
		while(start <= end) {
			if(start % 2 == 1) sum += tree[start++]; 
			if(end % 2 == 0) sum += tree[end--];
			
			start >>= 1;
			end >>= 1;
		}
		return sum;
	}
}
