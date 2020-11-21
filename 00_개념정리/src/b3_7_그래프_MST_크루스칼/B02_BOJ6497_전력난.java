package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B02_BOJ6497_전력난 {
	/*
	 * https://www.acmicpc.net/problem/6497
	 * 
	 * <문제설명>
	 * 
	 * <Point>
	 *  - 간선을 입력 받으며 전체 비용 구하기
	 *  - 구한 전체 비용에서 MST 비용을 빼서 연결하지 않아도 될 비용 절감
	 *   : MST비용 최소 연결 비용
	 *   : 전체비용 - MST 비용 = 최대절약비용
	 * 
	 */
	
	static int N, M;
	static ArrayList<Edge> eList;
	static int g[];
	static int totalCost;
	static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 이거 입력형태가 ㅈ같음!!!!
		while((st = new StringTokenizer(br.readLine())) != null) {
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				return;
			
			eList = new ArrayList<Edge>();
			g = new int[N+1];
	
			for (int i = 1; i <= N; i++) {
				g[i] = i;
			}
			
			int u, v, w;
			totalCost = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				
				eList.add(new Edge(u, v, w));
				totalCost += w;
			}
			
			
			Collections.sort(eList);
			
			int conn = 0;
			Answer = 0;
			
			for (Edge e: eList) {
				if(Find(e.v1) != Find(e.v2)) {
					Union(e.v1, e.v2);
					conn++;
					Answer += e.w;
					if(conn == N-1) break;
				}	
			}
			
			System.out.println(totalCost - Answer);
		}
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
