package mst_15481_그래프와MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Edge> eList;
	static int Group[];
	static boolean Checked[];
	static long Answer; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		eList = new ArrayList<Edge>();
		
		Group = new int[N+1];
		
		Checked = new boolean[M+1];
		
		int a, b, c;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(i, a, b, c));
		}
		
		Collections.sort(eList);
		
//		for (Edge e: eList) {
//			System.out.println(e.no + "   " + e.start + "->" + e.end + ":" + e.cost);
//		}
		
		int now;
		int connCnt;
		
		for (int i = 1; i <= M; i++) {
			
			now = i;
			Answer = 0L;
			connCnt = 0;
			
			for (int j = 1; j <= N; j++) {
				Group[j] = j;
			}
			
			for (int j = 1; j <= M; j++) {
				Checked[j] = false;
			}
			
			for (Edge f: eList) {
				if(now == f.no) {
					Union(f.from, f.to);
					Answer += f.cost;
					connCnt++;
					Checked[f.no] = true;
					
					break;
				}
			}
			
			for (Edge e: eList) {
				
				if(!Checked[e.no]) {
				
					if(Find(e.from) != Find(e.to)) {
						Union(e.from, e.to);
						Answer += e.cost;
						connCnt++;
						if(connCnt == N -1) {
							break;
						}
					}
				}
			}
			
			System.out.println(Answer);
		}	
	}
	
	public static void Union(int start, int end) {
		Group[Find(end)] = Find(start);
	}

	public static int Find(int n) {
		if(Group[n] == n)
			return n;
		else 
			return Group[n] = Find(Group[n]); 
	}
	
	static class Edge implements Comparable<Edge>  {
		int no;
		int from;
		int to;
		int cost;
		
		Edge(int no, int from, int to, int cost) {
			this.no = no;
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
}
