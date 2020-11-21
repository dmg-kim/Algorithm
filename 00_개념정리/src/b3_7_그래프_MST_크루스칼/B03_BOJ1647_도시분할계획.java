package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B03_BOJ1647_도시분할계획 {
	/*
	 * https://www.acmicpc.net/problem/1647
	 * 
	 * <문제설명>
	 *  - 마을 이장은 하나의 마을을 두개의 마을로 분리
	 *  - 분리된 마을은 각 집마다 하나의 길로 연결되어야 함
	 *  
	 * <Point>
	 *  - 마을을 분리하기 위해 MST 수행 연결개수: N-2
	 */
	
	static int N, M;
	static ArrayList<Edge> eList;
	static int g[];
	static long Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		eList = new ArrayList<Edge>();
		g = new int[N+1];

		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		int u, v, w;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(u, v, w));
		}
		
		
		Collections.sort(eList);
		
		int conn = 0;
		Answer = 0L;
		
		for (Edge e: eList) {
			if(Find(e.v1) != Find(e.v2)) {
				Union(e.v1, e.v2);
				conn++;
				Answer += e.w;
				if(conn == N-2) break;
			}	
		}
		
		bw.write(Answer + "\n");
		bw.flush();
		bw.close();

	}
	
	static public void Union(int a, int b) {
		g[Find(b)] = Find(a);
		
	}

	static public int Find(int n) {
		if(g[n] == n) return n;
		return g[n] = Find(g[n]);
	}

	static public class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int w;
		
		Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.w - e.w;
		}
	}

}
