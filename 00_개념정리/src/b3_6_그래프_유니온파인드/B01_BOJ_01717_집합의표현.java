package b3_6_그래프_유니온파인드;

import java.io.*;
import java.util.*;

public class B01_BOJ_01717_집합의표현 {
	static int N, M;
	static int g[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		g = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		int q, a, b;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			q = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(q == 0) {
				Union(a, b);
			}
			else {
				if(Find(a) == Find(b)) {
					bw.write("YES" + "\n");
				}
				else {
					bw.write("NO" + "\n");
				}
			}		
		}
		
		bw.flush();
		bw.close();
	}



	public static void Union(int a, int b) {
		g[Find(b)] = Find(a);
	}

	public static int Find(int n) {
		if(g[n] == n) return g[n];		
		return g[n] = Find(g[n]);
	}
	
	
}
