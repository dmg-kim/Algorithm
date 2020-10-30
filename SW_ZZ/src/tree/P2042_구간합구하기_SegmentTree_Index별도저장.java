package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_구간합구하기_SegmentTree_Index별도저장 {
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

	// A[L] ~ A[R] 구간 합 구하기
	// 초기 호출: get(1, SIZE, 1, L, R)
	// Top-Down 방식: 위에서 부터 구간 체크
	public static long get(int S, int E, int node, int L, int R) {
		// 2) 현재 노드의 범위가 찾으려는 범위 밖인 경우
		if(L > E || R < S) {
			return 0;
		}
		// 3) 현재 노드의 범위가 찾으려는 범위 안인 경우
		if(L <= S && E <= R) {
			return Tree[node];
		}
		
		// 4) 그외 범위면 
		int mid = (S + E) / 2;
		return get(S, mid, node * 2, L, R) + get(mid + 1, E, node * 2 + 1, L, R);
	}

	// A[X] = V 갱신시
	// Tree[idx] = V 갱신후
	// 초기 호출: update(idx(X/2))
	private static void update(int node) {

		while(node >= 1) {
			Tree[node] = Tree[node*2] + Tree[node*2+1];
			node >>= 1;
		}		
	}
	
	// A[X] = V 갱신시
	// 초기 호출: update(1, SIZE, 1, X, diff)
	private static void update2(int S, int E, int node, int idx, long diff) {

		if(idx < S || idx > E) return;
		
		Tree[node] += diff;
		
		if(S == E) return;
		
		int mid = (S + E) / 2;
		
		update2(S, mid, node * 2, idx, diff);
		update2(mid + 1, E, node * 2 + 1, idx, diff);
		
	}

}
