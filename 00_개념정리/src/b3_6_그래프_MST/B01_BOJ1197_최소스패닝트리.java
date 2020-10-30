package b3_6_그래프_MST;

import java.io.*;
import java.util.*;

public class B01_BOJ1197_최소스패닝트리 {
	/*
	 * https://www.acmicpc.net/problem/1197
	 * 
	 * 
	 * 
	 */
	
	static int V, E;
	static ArrayList<Edge> eList = new ArrayList<Edge>();
	static int[] Group = new int[10001];
	static long Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		eList.clear();

		for (int i = 1; i <= V; i++) {
			Group[i] = i;
		}
		
		int f, t, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(f, t, c));
		}
		
//		eList.sort(new Comparator<Edge>() {
//			public int compare(Edge e1, Edge e2) {
//				return e1.cost - e2.cost;
//			}
//		});
		
		Collections.sort(eList);
		
		int connect = 0;
		Answer = 0L;
		
		for (Edge e: eList) {
			if(find(e.from) != find(e.to)) {
				union(e.from, e.to);
				connect++;
				Answer += e.cost;
				if(connect == V-1) break;
			}	
		}
		
		bw.append(Answer + "\n");
		bw.close();

	}
	
	static public void union(int a, int b) {
		Group[find(b)] = find(a);
		
	}

	static public int find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = find(Group[n]);
	}

	static public class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.cost - e.cost;
		}
	}

}
