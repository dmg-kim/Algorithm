package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B09_BOJ15481_그래프와MST_프림_LCA {
	/*
	 * https://www.acmicpc.net/problem/15481
	 * 
	 * https://salepark.tistory.com/53
	 * 
	 */
	static int N, M;
	static ArrayList<Edge> eList;
	static ArrayList<Edge> eList_temp;
	static ArrayList<Edge> lcaList[];
	static int Group[];
	static boolean visited[];
	static int depth[];
	static int parent[][];
	static long maxArr[][];
	static int MAX_D;
	static long Answer; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		eList = new ArrayList<Edge>();
		eList_temp = new ArrayList<Edge>();
		
		lcaList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			lcaList[i] = new ArrayList<Edge>();
		}
		
		int idx = 1;
		MAX_D = 0;
		while(idx <= N) {
			idx <<= 1;
			MAX_D++;
		}
		
		Group = new int[N+1];
		visited = new boolean[N+1];
		depth = new int[N+1];
		parent = new int[N+1][MAX_D];
		maxArr = new long[N+1][MAX_D];
		
		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}
		
		int u, v, w;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			eList.add(new Edge(u, v, w));
			eList_temp.add(new Edge(u, v, w));
		}
		
		
		Collections.sort(eList);
		
		int con = 0;
		int totalCost = 0;
		ArrayList<Edge> mst = new ArrayList<Edge>();
		for (Edge e : eList) {
			if(find(e.from) != find(e.to)) {
				union(e.from, e.to);
				con++;
				totalCost += e.cost;
				lcaList[e.from].add(new Edge(e.from, e.to, e.cost));
				lcaList[e.to].add(new Edge(e.to, e.from, e.cost));
			}
			if(con == N-1) break;
		}
		
		buildTree();
		init();
		
		checkTree();
		
		long lca;
		int ans = 0;
		for (int i = 1; i <= M; i++) {
			u = eList_temp.get(i-1).from;
			v = eList_temp.get(i-1).to;
			w = eList_temp.get(i-1).cost;
			
			lca = LCA(u, v);
			
			ans = totalCost;
			ans += w;
			ans -= lca;
			bw.append(ans + "\n");
		}
		bw.flush();
		bw.close();

	}

	public static long LCA(int u, int v) {
		long maxVal = Long.MIN_VALUE; 
		int temp; 
		if(depth[u] < depth[v]) {
			temp = u;
			u = v;
			v = temp;
		}
		
		for (int j = MAX_D - 1; j >= 0; j--) {
			if((1 << j) <= (depth[u] - depth[v])) {
				maxVal = Math.max(maxVal, maxArr[u][j]);
				u = parent[u][j];				
			}
		}
		
		if(u == v) return maxVal;
		
		for (int j = MAX_D - 1; j >= 0; j--) {
			if(parent[u][j] != parent[v][j]) {
				maxVal = Math.max(maxVal, Math.max(maxArr[u][j], maxArr[v][j]));
				u = parent[u][j];
				v = parent[v][j];				
			}
		}
		return maxVal = Math.max(maxVal,Math.max(maxArr[u][0], maxArr[v][0]));
	}

	public static void buildTree() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		depth[1] = 0;
		
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for (Edge next : lcaList[cur]) {
				if(!visited[next.to]) {
					depth[next.to] = depth[cur] + 1;
					parent[next.to][0] = cur;
					maxArr[next.to][0] = next.cost;
					q.add(next.to);
				}
			}
		}
	}
	
	public static void init() {
		for (int j = 1; j < MAX_D - 1; j++) {
			for (int i = 1; i <= N; i++) {
				if(parent[i][j-1] > 0) {
					parent[i][j] = parent[parent[i][j-1]][j-1];
					maxArr[i][j] = Math.max(maxArr[i][j-1], maxArr[parent[i][j-1]][j]);
				}
			}
		}
	}

	public static void union(int a, int b) {
		Group[find(b)] = find(a);
		
	}

	public static int find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = find(Group[n]);
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
	
	static class Node {
		int next;
		int cost;
		
		Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}
	
	public static void checkTree() {
		for (int i = 1; i <= N; i++) {
			System.out.print(depth[i] + " ");
		}
		System.out.println();
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < MAX_D; j++) {
				System.out.print(parent[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < MAX_D; j++) {
				System.out.print(maxArr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
