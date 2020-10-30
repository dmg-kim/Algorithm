package mst_1647_도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int Group[];
	static ArrayList<Edge> eList;
	static int Answer;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		Group = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}
		
		eList = new ArrayList<Edge>();
		
		
		
		int a, b, c;
		
		for (int j = 1; j <= M; j++) {
			st= new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(a, b, c));					
		}
		
		Collections.sort(eList);
		
		int conn = 0;
		Answer = 0;
		
		for(Edge e: eList) {
			if(Find(e.start) != Find(e.end)) {
				Union(e.start, e.end);
				Answer += e.cost;
				conn++;
			}
			
			if(conn == N-2)
				break;
		}
		

		
		System.out.println(Answer);


	}

	public static void Union(int a, int b) {
		Group[Find(a)] = Find(b);
		
	}

	public static int Find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = Find(Group[n]);
	}
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
		
	}
	

}
