package b3_7_그래프_MST_크루스칼;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class A_MST_크루스칼_기본개념 {
	/*
	 * 	[최소신장트리(MST: Minimum Spaning Tree)]
	 *  - 가중치의 합이 최소인 최소 연결 부분 그래프
	 *   . 부분 그래프: 어떤 그래프를 구성하고 있는 간선들 가운데 일부가 제거된 그래프
	 *   . 연결 그래프: 그래프를 구성하는 모든 두 정점 사이에 경로가 존재하는 그래프
	 *   . 최소 연결 부분 그래프: 간선의 수를 최소로 이용하여 만들 수 있는 연결 그래프
	 *  - 하나의 그래프에는 여러개의 Spanning Tree 존재할 수 있음
	 *  - 최단 경로 구하기와는 다르게 모든 정점들을 연결하기만 하면됨
	 *    ※ 최단 경로는 시작 정점과 모든 정점 사이의 최단거리 구해야함
	 *  - MST: 크루스칼(Kruskal), 프림(Prim)
	 *  
	 * [크루스칼(Kruskal)]
	 *  - 시간복잡도: O(ElogV) (V: 정점의 수, E: 간선의 수)
	 *  - 간선을 선택하여 구성
	 *   : 사이클 확인 필요 => 유니온-파인드
	 *  - 절차
	 *   1. 간선들을 가중치 순으로 오름차순 정렬
	 *   2. 정렬 순으로 간선들을 뽑아내 양쪽 정점을 포함한 컴포넌트가 연결되어 있지 않으면(Group 대표값이 다르면) 그룹핑
	 *   3. 간선 V-1개가 뽑혔을때 그 간선들과 정점들이 이루는 그래프가 MST
	 *   
	 *  - 절차
	 *   1. 간선 값 기준으로 오름차순 정렬
	 *   2. 정렬 순으로 간선 선택(사이클 발새시 미선택) 후 그룹핑
	 */
	static int V;
	static int E;
	static int group[];
	static ArrayList<Edge> eList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		group = new int[V+1];
		eList = new ArrayList<Edge>();
		int f, t, c;
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(f, t, c));
		}
		
		Collections.sort(eList);
		
		for (int i = 1; i <= V; i++) {
			group[i] = i;
		}
		
		long totalCost = 0L;
		int conn = 0;
		for (Edge e : eList) {
			if(Find(e.from) != Find(e.to)) {
				Union(e.from, e.to);
				totalCost += e.cost;
				conn++;
			}
			
			if(conn == V-1) break;
			
		}
		
		if(conn != V-1) {
			totalCost = -1;
		}

		System.out.println(totalCost);
		return;
		
		
	}

	private static void Union(int a, int b) {
		group[Find(b)] = Find(a);
		
	}

	private static int Find(int n) {
		if(group[n] == n) return n;
		else return group[n] = Find(group[n]);
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.cost - e.cost;
		}
		
	}

}
