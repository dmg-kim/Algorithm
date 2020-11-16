package b3_6_그래프_유니온파인드;

import java.io.*;
import java.util.*;

public class B09_BOJ_06227_단지번호붙이기 {
	static int N;
	static int m[][];
	static int c[][];
	static boolean visited[][];
	static int di[] = {1, 0, -1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int cntC;
	static final int DIV = 100;
	static int g[];
	static ArrayList<Integer> cntH;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine().trim());
		
		m = new int[N+2][N+2];
		c = new int[N+2][N+2];
		cntH = new ArrayList<Integer>();
		visited = new boolean[N+2][N+2];
		g = new int[2600];
		
		String tmp = "";
		for (int i = 1; i <= N; i++) {
			tmp = br.readLine().trim();
			for (int j = 1; j <= N; j++) {
				m[i][j] = tmp.charAt(j-1) - '0';
				g[i*DIV+j] = i*DIV+j;
			}
		}
		
//		check(m);
		
		cntC = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(m[i][j] != 0 && !visited[i][j]) {
					cntH.add(DFS(i, j));
					cntC++;
				}
			}
		}
		
//		check(c);
		
		bw.append(cntC+"\n");
		
		Collections.sort(cntH);
		
		for (int n : cntH) {
			bw.append(n + "\n");
		}
		
		bw.flush();
		bw.close();
	}

	public static int DFS(int i, int j) {
		int cur = m[i][j];
		visited[i][j] = true;
		c[i][j] = m[i][j];
		int ni = 0, nj = 0;
		for (int k = 0; k < 4; k++) {
			ni = i + di[k];
			nj = j + dj[k];
			
			if(!visited[ni][nj] && m[ni][nj] != 0 && m[i][j] == m[ni][nj]) {
//				Union(i*DIV+j, ni*DIV+nj);
				c[i][j] += DFS(ni, nj);
			}
		}
		return c[i][j];
	}

	public static void Union(int a, int b) {
		g[Find(b)] = Find(a);
	}

	public static int Find(int n) {
		if(g[n] == n) return g[n];		
		return g[n] = Find(g[n]);
	}
	
	public static void check(int[][] m) {
		for (int i = 0; i <= N+1; i++) {
			for (int j = 0; j <= N+1; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
