package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B04_BOJ4386_별자리만들기 {
	/*
	 * https://www.acmicpc.net/problem/4386
	 * 
	 * <문제 설명>
	 * N개의 별
	 * 별자리
	 *  - 별자리를 이루는 선은 두개의 별을 일직선으로 연결
	 *  - 모든 별들은 별자리 위의 선을 통해 서로 직/간접적으로 연결
	 * 별자리를 만들수 있는 최소비용(소수점 2자리까지 출력)
	 * 
	 * <Point>
	 *  - 좌표를 이용해 거리를 구하고 구한 거리로 MST 수행
	 *  - 소수점 처리
	 */
	
	static int N, M;
	static double loc[][];
	static ArrayList<Edge> eList;
	static int g[];
	static double Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());

		loc = new double [N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			loc[i][0] = Double.parseDouble(st.nextToken());
			loc[i][1] = Double.parseDouble(st.nextToken());
		}
		
		eList = new ArrayList<Edge>();
		g = new int[N+1];

		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i <= N-1; i++) {
			for (int j = i+1; j <= N; j++) {
				double x = Math.pow(loc[i][0] - loc[j][0], 2);
				double y = Math.pow(loc[i][1] - loc[j][1], 2);
				double dist = Math.sqrt(x + y);
				
				eList.add(new Edge(i, j, dist));
				eList.add(new Edge(j, i, dist));
			}
		}
				
		Collections.sort(eList);
		
		int conn = 0;
		Answer = 0.0;
		
		for (Edge e: eList) {
			if(Find(e.v1) != Find(e.v2)) {
				Union(e.v1, e.v2);
				conn++;
				Answer += e.w;
				if(conn == N-1) break;
			}	
		}
		
		Answer = Math.round(Answer * 100);
		Answer /= 100;
		
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
		double w;
		
		Edge(int v1, int v2, double w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			if(this.w - e.w > 0) return 1;
			else if(this.w - e.w < 0) return -1;
			else return 0;
		}
	}

}
