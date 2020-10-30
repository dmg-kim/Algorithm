package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_�����ձ��ϱ�_SegmentTree_Index�������� {
	static int N, M, K;
	static long Input[];
	static int idxArr[];
	static long Tree[];
	static int treeSize = 4000001 , maxSize = 1000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Input = new long[maxSize];
		idxArr = new int[maxSize];
		Tree = new long[treeSize];
		
		for (int i = 1; i <= N; i++) {
			Input[i] =  Integer.parseInt(br.readLine());			
		}
		
		init(1, N, 1);
				
		int a, b;
		long c;
		long diff;
				
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				diff = c - Input[b];
				Input[b] = c;
				Tree[idxArr[b]] = c;
				update(idxArr[b]/2);
//				update2(1, N, 1, b, diff);
			}
			else {
				
				bw.append(get(1, N, 1, b, (int)c) + "\n");
			}
			
		}
		bw.flush();
		bw.close();

	}

	public static long init(int S, int E, int node) {
		if(S == E) {
			idxArr[S] = node;
			return Tree[node] = Input[S];
		}
		
		int mid = (S + E) / 2;
		return Tree[node] = init(S, mid, node * 2) + init(mid + 1, E, node * 2 + 1);
		
	}

	// A[L] ~ A[R] ���� �� ���ϱ�
	// �ʱ� ȣ��: get(1, SIZE, 1, L, R)
	// Top-Down ���: ������ ���� ���� üũ
	public static long get(int S, int E, int node, int L, int R) {
		// 2) ���� ����� ������ ã������ ���� ���� ���
		if(L > E || R < S) {
			return 0;
		}
		// 3) ���� ����� ������ ã������ ���� ���� ���
		if(L <= S && E <= R) {
			return Tree[node];
		}
		
		// 4) �׿� ������ 
		int mid = (S + E) / 2;
		return get(S, mid, node * 2, L, R) + get(mid + 1, E, node * 2 + 1, L, R);
	}

	// A[X] = V ���Ž�
	// Tree[idx] = V ������
	// �ʱ� ȣ��: update(idx(X/2))
	private static void update(int node) {

		while(node >= 1) {
			Tree[node] = Tree[node*2] + Tree[node*2+1];
			node >>= 1;
		}		
	}
	
	// A[X] = V ���Ž�
	// �ʱ� ȣ��: update(1, SIZE, 1, X, diff)
	private static void update2(int S, int E, int node, int idx, long diff) {

		if(idx < S || idx > E) return;
		
		Tree[node] += diff;
		
		if(S == E) return;
		
		int mid = (S + E) / 2;
		
		update2(S, mid, node * 2, idx, diff);
		update2(mid + 1, E, node * 2 + 1, idx, diff);
		
	}

}
