package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_1753 {
	static int T;
	static int N, E;
	static int Start;
	static int Cost[];
	static boolean visited[];
	static ArrayList<Edge> AdjList[];	// 노드 인접리스트 배열 선언: Edge 타입의 ArrayList를 가지는 배열 선언
	static PriorityQueue<Edge> pq;	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());	// number of test case
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 노드의 수
			E = Integer.parseInt(st.nextToken());	// 간선의 수
			
			AdjList = new ArrayList[N+1];	// 노드 인접리스트 배열 초기화(사이즈)
			Cost = new int[N+1];		// 각 노드까지의 거리의 값 저장 배열
			visited = new boolean[N+1];	// 각 노드 방문 여부
			
			for (int i = 1; i <= N; i++) {
				AdjList[i] = new ArrayList<>();	// 노드별 간선 정보 인접리스트 초기화				
			}
			
			Start = Integer.parseInt(br.readLine());	// 시작 정점 입력 받음
			
			int u, v, w;
			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				
				AdjList[u].add(new Edge(v,w));		// 해당 노드별 간선 정보 인접리스트 형태로 저장
			}
			
			Arrays.fill(Cost, Integer.MAX_VALUE);	// 모든 정점까지의 거리 무한대로 초기화
			
			Cost[Start] = 0;	// 시작점은 0으로 설정
					
			pq = new PriorityQueue<Edge>();
			
			pq.add(new Edge(Start, Cost[Start]));	// 최초 시작 정점 정보 Priority Queue에 add
			
			Edge now, next;
			while(!pq.isEmpty()) {
				now = pq.poll();	// 현재 위치
				
				// 현재 정점 방문 여부 체크 및 방문 처리
				if(visited[now.node]) {
					continue;
				}
				
				visited[now.node] = true;
				
				// 현재 위치에서 갈 수 있는 모든 정점 확인
				for (int i = 0; i < AdjList[now.node].size(); i++) {
					next = AdjList[now.node].get(i);

					// 현재위치까지의 거리에서 다음 정점까지의 거리와 다음 정점 거리 값을 비교
					if(Cost[next.node] > Cost[now.node] + next.weight) {
						Cost[next.node] = Cost[now.node] + next.weight;	// 더 짧은 경로로 이동할 수 있는지 비교하여 가능하다면 거리 갱신
						pq.add(new Edge(next.node, Cost[next.node]));	// 다음 정점 정보 Priority Queue에 add
					}					
				}				
			}
			
			for (int i = 1; i <= N; i++) {
				if(Cost[i] == Integer.MAX_VALUE) {
					bw.write("INF" + "\n");
				}
				else {
					bw.write(Cost[i] + "\n");
				}
			}
			
			bw.flush();
			bw.close();			
		}
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
			return this.weight - e.weight;
		}
	}

}
