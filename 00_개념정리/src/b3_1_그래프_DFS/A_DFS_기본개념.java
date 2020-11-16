package b3_1_그래프_DFS;

import java.util.*;

public class A_DFS_기본개념 {
	/*
	 * [깊이우선탐색(DFS: Depth First Search)]
	 *  - 그래프를 방문하거나 탐색하는 방법 중 하나
	 *  - 완전탐색이나 백트래킹과 같이 탐색의 횟수(그래프의 최대 경로)가 정해져 있거나 예측 가능한 경우에 사용
	 *  - 절차
	 *   1. 선택한 정점에서 해야할 작업 진행
	 *   2. 선택한 정점과 연결된 정점 중 아직 방문하지 않은 정점 방문
	 *   3. 만약 더 방문할 정점이 없는 경우 이전 정점으로 되돌아 감
	 *   4. 1~3 반복
	 */
	
	static ArrayList<Edge> eList[] = new ArrayList[10];
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
		eList[5].add(new Edge(5, 6));
		eList[4].add(new Edge(4, 6));
		eList[6].add(new Edge(6, 7));
		
		DFS(1);
	}
	
	private static void DFS(int n) {	
		int cur = n;		
		
		if(visited[cur]) return;		
		visited[cur] = true;
		
		System.out.print(cur + "->");		
		
		int next;
		for (Edge e : eList[cur]) {
			next = e.next;
			if(!visited[next]) {
				DFS(next);
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
