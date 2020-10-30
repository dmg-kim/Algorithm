package b3_6_그래프_MST;

import java.io.*;
import java.util.*;

public class B09_BOJ15481_그래프와MST_프림_LCA {
	/*
	 * https://www.acmicpc.net/problem/15481
	 * 
	 * 
	 * 
	 */
	static int N, M;
	static ArrayList<Edge> eList;
	static int Group[] = new int[200001];
	static long Answer; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
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
