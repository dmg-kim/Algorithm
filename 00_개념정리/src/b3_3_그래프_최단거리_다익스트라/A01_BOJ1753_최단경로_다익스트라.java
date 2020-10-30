package b3_3_그래프_최단거리_다익스트라;

import java.io.*;
import java.util.*;

public class A01_BOJ1753_최단경로_다익스트라 {
	/*
	 * https://www.acmicpc.net/problem/1753
	 * 
	 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램
	 * 
	 */
	static int V, E, S;
	static ArrayList<Edge> eList[];
	static int dist[];
	static boolean visited[];
	static final int INF = 3000001;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		S = Integer.parseInt(br.readLine().trim());
		
		eList = new ArrayList[V+1];
		dist = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(dist, INF);
		pq = new PriorityQueue<Edge>();
		
		for (int i = 1; i <= V; i++) {
			eList[i] = new ArrayList<Edge>();
		}
		
		int u, v, w;
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			eList[u].add(new Edge(v, w));
		}
		
		Dijkstra(S);
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF) bw.append("INF\n");
			else bw.append(dist[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	private static void Dijkstra(int s) {
		dist[s] = 0;
		
		pq.offer(new Edge(s, 0));
		
		Edge cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			if(visited[cur.node]) continue;
			
			visited[cur.node] = true;
			
			int next;
			for (Edge e : eList[cur.node]) {
				next = e.node;
				if(dist[next] > dist[cur.node] + e.dist) {
					dist[next] = dist[cur.node] + e.dist;
					pq.offer(new Edge(next, dist[next]));
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int node;
		int dist;
		
		Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.dist - e.dist;
		}
	}
}
