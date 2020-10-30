package mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1197_최소스패닝트리 {
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
		
		int a, b, c;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(a, b, c));
		}
		
		eList.sort(new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e1.c - e2.c;
			}
		});
		
		int connect = 0;
		Answer = 0L;
		
		for (Edge now: eList) {
			if(find(now.a) != find(now.b)) {
				union(now.a, now.b);
				connect++;
				Answer += now.c;
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

	static public class Edge {
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
