package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_1916 {
	static int N, M;
	static ArrayList<Edge> AdjList[];
	static int Cost[];
	static PriorityQueue<Edge> pq;
	static int depart, arrive;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		AdjList = new ArrayList[N+1];
		
		for (int i = 0; i < AdjList.length; i++) {
			AdjList[i] = new ArrayList<Edge>();
		}
		
		int s, e, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			AdjList[s].add(new Edge(e, c));
		}
		
		Cost = new int[N+1];
		
		Arrays.fill(Cost, Integer.MAX_VALUE);
		
		pq = new PriorityQueue<Edge>();

		st = new StringTokenizer(br.readLine());
		
		depart = Integer.parseInt(st.nextToken());
		arrive = Integer.parseInt(st.nextToken());
		
		Cost[depart] = 0;
		pq.add(new Edge(depart, Cost[depart]));
		
		visited = new boolean[N+1];
		
		Edge now, next;
		while(!pq.isEmpty()) {
			now = pq.poll();
			
			if(now.node == arrive) {
				break;
			}
			
			if(visited[now.node]) {
				continue;
			}
			
			visited[now.node] = true;
			
			for (int i = 0; i < AdjList[now.node].size(); i++) {
				next = AdjList[now.node].get(i);
				if(Cost[next.node] > Cost[now.node] + next.weight) {
					Cost[next.node] = Cost[now.node] + next.weight;
					pq.add(new Edge(next.node, Cost[next.node]));
				}
			}
		}
		
		bw.write(Cost[arrive] + "\n");
		bw.flush();
		bw.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int node;
		int weight;
		
		Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.weight - e.weight;
		}
	}
	
}
