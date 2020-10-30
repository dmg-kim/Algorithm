package mst_1922_네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Edge> eList;
	static int Group[];
	static int Answer;
	
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int a, b, c;
		
		eList = new ArrayList<Edge>();
		
		Group = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}
		
		Answer = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(a, b, c);
			
			eList.add(e);
		}
		
//		for(Edge e : eList) {
//			System.out.println(e.a + " " + e.b + " " + e.c);
//		}
		
		eList.sort(Comparator.comparingInt(e -> e.c));
		
//		for(Edge e : eList) {
//			System.out.println(e.a + " " + e.b + " " + e.c);
//		}
		
		int conn = 0;
		
		for(Edge now: eList) {
			if(Find(now.a) != Find(now.b)) {
				Union(now.a, now.b);
				Answer += now.c;
				conn++;
				
				if(conn == N-1) {
					break;
				}
			}
		}
		
		System.out.println(Answer);
		
	}
	
	public static void Union(int a, int b) {
		Group[Find(b)] = Find(a);
		
	}

	public static int Find(int n) {
		if(Group[n] == n) return n;
		
		return Group[n] = Find(Group[n]);
	}
	
	

	static class Edge {
		int a;
		int b;
		int c;
		
		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

}
