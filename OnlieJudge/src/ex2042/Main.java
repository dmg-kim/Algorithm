package ex2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static long num[];
	
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		num = new long[N +1];
		
		for (int i = 1; i <= N; i++) {
			update(i, Integer.parseInt(br.readLine()));
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
				diff = c - getSum(b,b);
				update(b, diff);
			}
			else {
				
				System.out.println(getSum(b, (int)c));
			}
			
		}

	}

	public static long getSum(int start, int end) {
		
		return sum(end) - sum(start-1);
	}

	public static long sum(int i) {
		long res = 0;
		
		while(i > 0) {
			res += num[i];
			i -= (i & -i);
		}
		return res;
	}

	private static void update(int i, long diff) {
		while(i < N+1) {
			num[i] += diff;
			i += (i & -i);
		}
		
	}

}
