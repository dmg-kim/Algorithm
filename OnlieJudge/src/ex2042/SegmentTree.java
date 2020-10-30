package ex2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SegmentTree {
	static int N, M, K;
	static long Input[];
	static long Tree[];
	static int MAXTREE = 2000001 , MAXINPUT = 1000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Input = new long[MAXINPUT];
		Tree = new long[MAXTREE];
		
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
				update(1, N, 1, b, diff);
			}
			else {
				
				bw.append(sum(1, N, 1, b, (int)c) + "\n");
			}
			
		}
		bw.flush();
		bw.close();

	}

	public static long init(int start, int end, int node) {
		if(start == end) {
			return Tree[node] = Input[start];
		}
		
		int mid = (start + end) / 2;
		return Tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		
	}

	// A[L] ~ A[R] 구간 합 구하기
	// 초기 호출: get(1, SIZE, 1, L, R)
	// Top-Down 방식: 위에서 부터 구간 체크
	public static long sum(int start, int end, int node, int left, int right) {
		
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && right >= end) {
			return Tree[node];
		}
		
		int mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}

	// A[X] = V 갱신시
	// 초기 호출: update(1, SIZE, 1, X, diff)
	private static void update(int start, int end, int node, int index, long diff) {

		if(index < start || index > end) {
			return;
		}
		
		Tree[node] += diff;
		
		if(start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		update(start, mid, node * 2, index, diff);
		update(mid + 1, end, node * 2 + 1, index, diff);
		
	}

}
