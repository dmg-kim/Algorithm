package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/15481
 * 
 * <문제설명>
 *  - 특정 간선을 포함하는 MST 구하기
 * 
 * <Point>
 *  - MST를 구성하는 트리로 LCA
 *  - Par배열 구할때 각 노드~조상까지의 간선 가중치가 가장 큰 값 저장
 *  - MST에서 특정 간선의 두 정점의 LCA를 구하고 LCA까지의 간선 중 가장 큰 가중치의 간선을 제외하고 특정 간선 가중치 추가
 *   : MST - maxE + 특정간선 가중치
 */
public class B09_BOJ15481_그래프와MST {
	static int N, M;
	static ArrayList<Edge> qList;
	static ArrayList<Edge> eList;
	static int g[];
	static long mst;
	static ArrayList<Edge> lcaList[];
	static int d[];
	static int par[][];
	static int maxC[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		qList = new ArrayList<Edge>();
		eList = new ArrayList<Edge>();
		lcaList = new ArrayList[N+1];
		g = new int[N+1];
		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			lcaList[i] = new ArrayList<Edge>();
		}

		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			qList.add(new Edge(a, b, c));
			eList.add(new Edge(a, b, c));
		}
		
		Collections.sort(eList);
		
		mst = 0L;
		int conn = 0;
		for (Edge e : eList) {
			if(Find(e.s) != Find(e.e)) {
				Union(e.s, e.e);
				mst += e.c;
				
				//	MST 경로만 lca를 구하기 위한 용도로 lcaList에 MST 간선 추가
				lcaList[e.s].add(new Edge(e.s, e.e, e.c));
				lcaList[e.e].add(new Edge(e.e, e.s, e.c));
				conn++;
			}
			if(conn == N-1) break;
		}
		
		d = new int[N+1];
		par = new int[N+1][19];		// log2(20만) < 18
		maxC = new int[N+1][19];
		
		bfs();
		
		for (int j = 1; j <= 18; j++) {
			for (int i = 1; i <= N; i++) {
				par[i][j] = par[par[i][j-1]][j-1];
				maxC[i][j] = Math.max(maxC[i][j-1], maxC[par[i][j-1]][j-1]);	// 각 노드 조상 최대간선값 저장
			}
		}
		
		for (Edge e : qList) {
			int x = e.s;
			int y = e.e;
			int lcaC = LCA(x ,y);	// x와 y 사이 가장 큰 간선 비용 구하기
			
			// 기존 MST값에 추가하는 간선의 비용 추가, 추가하는 노드 사이의 경로 중 가장 큰 간선 비용 제외
			bw.write(mst + e.c - lcaC + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		q.add(1);
		d[1] = 0;
		par[1][0] = 0;
		maxC[1][0] = 0;
		
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			for (Edge n : lcaList[cur]) {
				if(!visited[n.e]) {
					d[n.e] = d[cur]+1;
					par[n.e][0] = cur;
					maxC[n.e][0] = n.c;
					q.add(n.e);
				}
			}
		}
	}
	
	public static int LCA(int x, int y) {
		int ret = 0;
		if(d[x] > d[y]) {
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		int t = d[y] - d[x];
		
		for (int i = 18; i >= 0; i--) {
			if((t & (1 << i)) > 0) {
				ret = Math.max(ret, maxC[y][i]);
				y = par[y][i];
			}
		}
		
		if(x == y) return ret;
		
		for (int i = 18; i >= 0; i--) {
			if(par[x][i] != par[y][i]) {
				ret = Math.max(ret, maxC[x][i]);
				ret = Math.max(ret, maxC[y][i]);
				x = par[x][i];
				y = par[y][i];
			}
		}
		
		ret = Math.max(ret, maxC[x][0]);
		ret = Math.max(ret, maxC[y][0]);
		
		return ret ;
	}
	
	private static void Union(int a, int b) {
		g[Find(b)] = Find(a);		
	}

	public static int Find(int n) {
		if(g[n] == n) return g[n];
		return g[n] = Find(g[n]);	// 이거 걍 return Find(g[n]) 했다가 시간초과로 몇시간동안 개고생함 ㅠ
	}

	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int c;
		
		Edge(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.c - e.c;
		}
	}

}
