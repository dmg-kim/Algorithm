package b3_2_그래프_BFS;

import java.util.*;

public class A_BFS_기본개념 {
	/*
	 * [너비우선탐색(BFS: Breadth First Search)]
	 *  - 그래프를 방문하거나 탐색하는 방법 중 하나
	 *  - 최단거리, 최소비용과 같이 최소값 관련 문제
	 *  - 그래프의 가중치가 1인 경우
	 *  - 절차
	 *   1. 저장된 정점 중 첫 번째 정점을 선택하여 저장된 정점에서 제거
	 *   2. 제거한 정점에서 해야할 작업 진행
	 *   3. 제거한 정점과 연결된 정점 중 방문하지 않은 모든 정점 저장
	 *   4. 저장된 정점에 모든 노드가 제거될 때까지 1~3 반복
	 *  - 정점을 저장하고 저장된 정점 중 가장 먼저 저장된 정점을 선택하며 해당 정점에 대한 작업
	 *   => Queue(FIFO) 사용: 가장 먼저 들어온 데이터를 먼저 처리하는 구조
	 */
	static ArrayList<Edge> eList[] = new ArrayList[10];
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean visited[] = new boolean[10];
	public static void main(String[] args) {
		
		for (int i = 0; i < eList.length; i++) {
			eList[i] = new ArrayList<Edge>();
		}
		
		eList[1].add(new Edge(1, 2));
		eList[1].add(new Edge(1, 3));
		eList[1].add(new Edge(1, 4));
		eList[2].add(new Edge(2, 5));
		eList[3].add(new Edge(3, 5));
		eList[3].add(new Edge(5, 6));
		eList[4].add(new Edge(4, 6));
		eList[6].add(new Edge(6, 7));
		
		BFS(1);

	}
	
	private static void BFS(int n) {
		q.add(n);
		
		int cur;		
		while(!q.isEmpty()) {
			cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			System.out.print(cur + "->");
			int next = 0;
			for (Edge e : eList[cur]) {
				next = e.next;
				if(!visited[next]) q.offer(next);
			}
		}
	}

	static class Edge {
		int node;
		int next;
		
		Edge(int node, int next) {
			this.node = node;
			this.next = next;
		}
	}
}
