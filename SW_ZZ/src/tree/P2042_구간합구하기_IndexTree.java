package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_구간합구하기_IndexTree {
	static int N, M, K;
	static int leafSize = 1;	// leaf node 사이즈
	static long tree[];	// tree 사이즈
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. Leaf Node Size 구하기
		while(leafSize <= N) {
			leafSize <<= 1;
		}
		
		// 2. 인덱스 트리
		tree = new long[leafSize * 2];
		long num = 0;
		
		// 3. 초기값 인덱스 트리 셋팅
		for (int i = 0; i < N; i++) {
			num = Long.parseLong(br.readLine());
			update(leafSize + i, num);
		}
				
		int a, b;
		long c;
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(leafSize + b - 1, c - tree[leafSize + b - 1]);		
				
			}
			else {
				bw.append(get(leafSize + b - 1, leafSize + (int)c - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
	
	// A[L] ~ A[R] 구간 합 구하기
	// 초기 호출: get(L, R)
	// Bottom-Up 방식: 위에서 부터 구간 체크
	private static long get(int L, int R) {
		long ans = 0;
		// 왼쪽 노드가 오른쪽 노드와 작거나 같을때까지 반복
		while(L <= R) {
			// 1) 왼쪽 노드와 오른쪽 노드가 같은 경우 선택하고 종료
			if(L == R) {
				ans += tree[L];
				return ans;
			}			
			// 2) 왼쪽 노드가 홀수인 경우 값을 선택하고 오른쪽 노드로 이동
			if(L % 2 == 1) {
				ans += tree[L];
				L++;
			}			
			// 3) 오른쪽 노드가 짝수인 경우 값을 선택하고 왼쪽 노드로 이동
			if(R % 2 == 0) {
				ans+= tree[R];
				R--;
			}
			// 4) 왼쪽, 오른쪽 노드 각각 부모 노드로 이동
			L >>= 1;
			R >>= 1;
		}
		return ans;
	}
	// A[X] = V 갱신시
	// 초기 호출: update(X, V)
	private static void update(int node, long V) {
		while(node >= 1) {
			tree[node] += V;
			node >>= 1;
		}
		
	}
}
