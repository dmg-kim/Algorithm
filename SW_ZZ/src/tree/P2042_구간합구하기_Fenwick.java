package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_구간합구하기_Fenwick {
	static int N, M, K;
	static long Input[];
	static long Tree[];
	static int treeSize = 1000001 , maxSize = 1000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Input = new long[maxSize];
		Tree = new long[treeSize];
		
		for (int i = 1; i <= N; i++) {
			Input[i] =  Integer.parseInt(br.readLine());		
			update(i, Input[i]);
		}
		
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
				update(b, diff);
			}
			else {
				bw.append(get((int)c) - get(b-1) + "\n");
			}
			
		}
		bw.flush();
		bw.close();
	}


	// A[idx] 구간 합 구하기
	public static long get(int idx) {
		long ans = 0;
		
		while(idx > 0) {
			ans += Tree[idx];
			
			idx -= idx & -idx;
		}
		
		return ans;
	}

	// A[X] = V 갱신시
	private static void update(int idx, long diff) {

		while(idx <= N) {
			Tree[idx] += diff;
			
			idx += idx & -idx;
		}		
	}
	
}
