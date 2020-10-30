package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_구간합구하기_SegmentTree_NonRec_실패 {
	static int N, M, K;
	static int SIZE;
	static long Input[];
	static long Tree[];
	static int treeSize = 4000001 , MAXINPUT = 1000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		SIZE = N;
		
		Input = new long[MAXINPUT];
		Tree = new long[treeSize];
		
		for (int i = 1; i <= N; i++) {
			
			update(i, Long.parseLong(br.readLine()));
		}
		
//		for (int i = 0; i < 10; i++) {
//			System.out.print(Tree[i] + " ");
//		}
		
		
		
		int a, b;
		long c;
				
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(b, c);
			}
			else {				
				bw.append(get(b, (int)c) + "\n");
			}
			
		}
		bw.flush();
		bw.close();

	}

	// A[L] ~ A[R] 구간 합 구하기
	// 초기 호출: get(1, SIZE, 1, L, R)
	// Top-Down 방식: 위에서 부터 구간 체크
	public static long get(int L, int R) {
		L += SIZE - 1;
		R += SIZE - 1;
		int res = 0;
		
		for (; L <= R; L/=2, R/=2) {
			if(L%2 == 1) res += Tree[L++];
			if(R%2 == 1) res += Tree[R--];
		}
		return res;
	}

	// A[X] = V 갱신시
	private static void update(int X, long V) {
		X += SIZE - 1;
		
		Tree[X] = V;
		
		for (X /= 2; X >= 1; X /= 2) {
			Tree[X] = Tree[2*X] + Tree[2*X+1];
		}
	}

}
