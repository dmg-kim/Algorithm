package b3_9_그래프_LCA;

import java.io.*;
import java.util.*;

/*
 * [LCA와 쿼리]
 * 
 * https://www.acmicpc.net/problem/15480
 * 
 * <문제설명>
 *  - 쿼리  r u v: 루트가 r일때 LCA(u, v) 구하기
 *  
 * <Point>
 *  - 쿼리별 루트 기준으로 트리 구성 및 LCA 구하기 => 시간 초과
 *  - 1을 루트로 하는 트리에서 LCA(r, u), LCA(r, v), LCA(u, v) 중 깊이가 가장 깊은 LCA가  정답
 */

public class B05_BOJ15480_LCA와쿼리 {
	static int N, M;
	static ArrayList<Integer> eList[];
	static int d[];
	static int par[][];
	static int Ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		eList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			eList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			eList[u].add(v);
			eList[v].add(u);
		}
		
		d = new int[N+1];
		par = new int[N+1][18];
		
		BFS(1);
		
		for (int j = 1; j <= 17; j++) {
			for (int i = 1; i <= N; i++) {
				par[i][j] = par[par[i][j-1]][j-1];
			}
		}
		
		M = Integer.parseInt(br.readLine().trim());
		
		Ans = 0;
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// LCA(r, u), LCA(r, v), LCA(u, v) 중 깊이가 가장 깊은 LCA가  정답
			int lca1 = LCA(r, u);
			int lca2 = LCA(r, v);
			int lca3 = LCA(u, v);
			
			if(d[lca1] < d[lca2]) lca1 = lca2;
			if(d[lca1] < d[lca3]) lca1 = lca3;
			
			bw.write(lca1 + "\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	public static int LCA(int a, int b) {
		if(d[a] > d[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int t = d[b] - d[a];
		
		for (int i = 17; i >= 0; i--) {
			if((t & (1 << i)) > 0) {
				b = par[b][i];
			}
		}
		
		if(a == b) return a;
		
		for (int i = 17; i >= 0; i--) {
			if(par[a][i] != par[b][i]) {
				a = par[a][i];
				b = par[b][i];
			}
		}		
		return par[a][0];
	}

	public static void BFS(int r) {
		Queue<Integer> q = new LinkedList<Integer>();
		int visited[] = new int[N+1];
		q.add(r);
		d[r] = 0;
		par[r][0] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(visited[cur] == 1) continue;
			visited[cur] = 1;
			for (int n : eList[cur]) {
				if(visited[n] == 0) {
					d[n] = d[cur] + 1;
					par[n][0] = cur;
					q.add(n);
				}
			}
		}		
	}
}
