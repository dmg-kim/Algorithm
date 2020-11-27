package b3_1_그래프_DFS;

import java.io.*;
import java.util.*;

/*
 *  https://www.acmicpc.net/problem/11266
 */
public class A_02_단절점_기본개념 {
	static int V, E;
	static ArrayList<Integer> eList[];
	static int visited[];
	static int disc[];
	static boolean cut[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		disc = new int[V+1];
		eList = new ArrayList[V+1];
		visited = new int[V+1];
		cut = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			eList[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			eList[a].add(b);
			eList[b].add(a);
		}
		
		cnt = 0;
		for (int i = 1; i <= V; i++) {
			if(disc[i] == 0) {
				DFS(i, true);
			}
		}
		
		int Ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(cut[i]) {
				Ans++;
				sb.append(i + " ");
			}
		}
		System.out.println(Ans);
		System.out.println(sb);
	}
	
	private static int DFS(int n, boolean isRoot) {
		disc[n] = ++cnt;
		int ret = disc[n];
		int child = 0;
		
		for (int c : eList[n]) {
			// 자식노드 미방문시
			if(disc[c] == 0) {
				child++;
				int min = DFS(c, false);
				ret = Math.min(min, ret);
				
				// 루트노드가 아닌경우
				// 자식노드가 갈수있는 최소 방문순서가 현재노드의 방문 순서보다 크다면 현재노드는 단절점 
				if(!isRoot && min >= disc[n]) {
					cut[n] = true;
				}
			}
			// 자식노드 이미 방문시
			else {
				ret = Math.min(ret, disc[c]);
			}
		}
		
		// 루트노드인 경우 자식이 2이상이면 무조건 단절점
		if(isRoot && child > 1) {
			cut[n] = true;
		}
		return ret;
	}

}
