package mst_6497_Àü·Â³­;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_pq {
	static int N, M;
	static PriorityQueue<Edge> PQ;
	static int Group[];
	static int Answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while((st = new StringTokenizer(br.readLine())) != null) {
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0)
				return;
			
			PQ = new PriorityQueue<Edge>();
			Group = new int[N+1];
			
			for (int i = 1; i < N; i++) {
				Group[i] = i;
			}
			
			int x, y, z;
			int totalCost = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());
				
				totalCost += z;
				
				PQ.add(new Edge(x,y,z));
			}
			
			int connCnt = 0;
			
			Answer = 0;
			
			
			Edge now;
			
			while(!PQ.isEmpty()) {
				now = PQ.poll();
				if(Find(now.start) != Find(now.end)) {
					Union(now.start, now.end);
					connCnt++;
					Answer += now.dist;
					
					if(connCnt == N-1)
						break;
				}
			}
			
			System.out.println(totalCost - Answer);
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
	
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int dist;
		
		Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			if(e.dist > this.dist)
				return -1;
			else if(e.dist == this.dist)
				return 0;
			else
				return 1;
		}
		
	}

}
