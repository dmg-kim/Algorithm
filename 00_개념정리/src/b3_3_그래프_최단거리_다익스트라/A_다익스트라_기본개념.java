package b3_3_그래프_최단거리_다익스트라;

import java.util.*;

public class A_다익스트라_기본개념 {
	/*
	 * [다익스트라(Dijkstra)]
	 *  - 최단 경로를 찾기 위해 사용하는 알고리즘
	 *  - 출발점으로부터 모든 정점까지의 최단거리 계산
	 *  - 시간복잡도: O(ElogV) (V: 정점의 수, E: 간선의 수)
	 *  - 무향 또는 유향 그래프
	 *  - 거리(가중치)가 음수인 경우는 사용 불가 => 벨만 포드
	 *  - 절차
	 *   1. 시작정점 결정
	 *   2. 시작정점을 제외한 모든 정점까지의 거리를 무한대로 설정
	 *   3. 현재 위치에서 갈 수 있는 모든 정점 확인
	 *      만약 해당 정점이 현재까지 기록한 거리보다 더 짧은 경로로 이동할 수 있다면 거리 갱신
	 *      그렇지 않다면 Skip
	   *      ★4. 아직 선택하지 않았던 정점들 중 가장 짧은 거리에 있는 정점을 현재 정점으로 선택
	 *    => 우선순위 큐(Priority Queue) 사용
	 *   5. 3~4 반복
	 */
	static ArrayList<Edge> eList[] = new ArrayList[10];
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static boolean visited[] = new boolean[10];
	static int dist[] = new int[10];
	static final int INF = 999;
	static int ans;
	public static void main(String[] args) {
		for (int i = 0; i < eList.length; i++) {
			eList[i] = new ArrayList<Edge>();
		}
		
		eList[1].add(new Edge(2, 1));
		eList[1].add(new Edge(4, 5));
		eList[2].add(new Edge(3, 2));
		eList[3].add(new Edge(4, 1));
		eList[3].add(new Edge(5, 5));
		eList[3].add(new Edge(7, 3));
		eList[4].add(new Edge(6, 3));
		eList[4].add(new Edge(7, 3));
		eList[6].add(new Edge(7, 2));
		
		Arrays.fill(dist, INF);

		Dijkstra(1);
		
		for (int i = 1; i <= 7; i++) {
			ans += dist[i];
		}
		
		System.out.println("Total Cost: "  + ans);
	}
	
	private static void Dijkstra(int s) {
		pq.clear();
		
		pq.offer(new Edge(s, 0));
		dist[s] = 0;
		
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

	static class Edge implements Comparable<Edge>{
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
