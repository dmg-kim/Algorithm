package b1_4_�ڷᱸ��_����Ʈ��;

import java.io.*;
import java.util.*;
/*
 * https://www.acmicpc.net/problem/7578
 */
public class SDS_���׸�ƮƮ��_�¶��α���_���幮��_���׸�ƮƮ�� {
	static int N; // 1~500000
	static final int MAX_N = 500000;
	static final int MAX_VAL = 1000000;
	static final int MAX_TREE = 524288*2;
	static int A_Arr[] = new int[MAX_N+1];
	static int B_Idx[] = new int[MAX_VAL+1];
	static long tree[] = new long[MAX_TREE+1];
	static int addr[] = new int[MAX_N+1];
	static int leaf;
	static long Ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		
		// 0. �Է�
		//  1) A�� ���� �Է�
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 1; i <= N; i++) {
			A_Arr[i] = Integer.parseInt(st.nextToken());
		}

		//  2) B�� ���� ���� �Է�		
		st = new StringTokenizer(br.readLine().trim());
		int eqpNo = 0;
		for (int i = 1; i <= N; i++) {
			eqpNo = Integer.parseInt(st.nextToken());
			B_Idx[eqpNo] = i;
		}
		
		// 1. Ʈ�� ����(�ʱ�ȭ)
		Arrays.fill(tree, 0);
		
		buildTree(1, 1, N);
		
//		checkTree();
		
		Ans = 0L;
		// 2. ��� ������� üũ
		//  - ��� ����� ���ε� �ϴ� ���� ��ġ���� �����ʿ� ���ε� ���� �ִ���
		//   . Ans += get(�ϴ� ���� idx ~ N)
		//   . update(�ϴ� ���� idx)
		for (int i = 1; i <= N; i++) {
			Ans += getSegSum(1, 1, N, B_Idx[A_Arr[i]], N);
			
			update(B_Idx[A_Arr[i]], 1);
//			checkTree();
		}
		
		// 3. Ans ���
		bw.append(Ans + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void checkTree() {
		for (int i = 1; i <= N*2; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

	public static void buildTree(int pos, int start, int end) {
		
		if(start >= end) {
			addr[start] = pos;
			return;
		}
		
		int mid = (start + end) / 2;
		buildTree(pos*2, start, mid);
		buildTree(pos*2 + 1, mid+1, end);
		
		return;
	}
	
	public static void update(int idx, int val) {
		int treeIdx = addr[idx];
		while(treeIdx > 0) {
			tree[treeIdx] += val;
			treeIdx >>= 1;
		}	
	}
	
	public static long getSegSum(int pos, int start, int end, int qStart, int qEnd) {
		
		// 1. ��ġ�� �ʴ� ���
		if(start > qEnd || end < qStart) return 0;
		
		// 2. ������ ��ġ�� ���
		if(qStart <= start && end <= qEnd) return tree[pos];
		
		// 3. �ɰ��� �ϴ� ���
		int mid = (start + end) / 2;
		
		long leftSum = getSegSum(pos*2, start, mid, qStart, qEnd);
		long rightSum = getSegSum(pos * 2 + 1, mid + 1, end, qStart, qEnd);
		
		return leftSum + rightSum;
	}
}
