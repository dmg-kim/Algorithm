package b3_7_�׷���_MST_ũ�罺Į;

import java.io.*;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/15481
 * 
 * <��������>
 *  - Ư�� ������ �����ϴ� MST ���ϱ�
 * 
 * <Point>
 *  - MST�� �����ϴ� Ʈ���� LCA
 *  - Par�迭 ���Ҷ� �� ���~��������� ���� ����ġ�� ���� ū �� ����
 *  - MST���� Ư�� ������ �� ������ LCA�� ���ϰ� LCA������ ���� �� ���� ū ����ġ�� ������ �����ϰ� Ư�� ���� ����ġ �߰�
 *   : MST - maxE + Ư������ ����ġ
 */
public class B09_BOJ15481_�׷�����MST {
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
				
				//	MST ��θ� lca�� ���ϱ� ���� �뵵�� lcaList�� MST ���� �߰�
				lcaList[e.s].add(new Edge(e.s, e.e, e.c));
				lcaList[e.e].add(new Edge(e.e, e.s, e.c));
				conn++;
			}
			if(conn == N-1) break;
		}
		
		d = new int[N+1];
		par = new int[N+1][19];		// log2(20��) < 18
		maxC = new int[N+1][19];
		
		bfs();
		
		for (int j = 1; j <= 18; j++) {
			for (int i = 1; i <= N; i++) {
				par[i][j] = par[par[i][j-1]][j-1];
				maxC[i][j] = Math.max(maxC[i][j-1], maxC[par[i][j-1]][j-1]);	// �� ��� ���� �ִ밣���� ����
			}
		}
		
		for (Edge e : qList) {
			int x = e.s;
			int y = e.e;
			int lcaC = LCA(x ,y);	// x�� y ���� ���� ū ���� ��� ���ϱ�
			
			// ���� MST���� �߰��ϴ� ������ ��� �߰�, �߰��ϴ� ��� ������ ��� �� ���� ū ���� ��� ����
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
		return g[n] = Find(g[n]);	// �̰� �� return Find(g[n]) �ߴٰ� �ð��ʰ��� ��ð����� ������� ��
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
