package b3_6_�׷���_���Ͽ����ε�;

import java.io.*;
import java.util.*;

/*
 * [BOJ_16562_ģ����]
 *  - https://www.acmicpc.net/problem/16562
 * 
 * 
 * 
 * [����Ǯ��]
 *  1. ģ�� �Է� �����鼭 ����� ���� ģ���� union
 *  2. ģ�� ��� sorting�ؼ� �ϳ��� �����ϸ鼭 üũ
 */
public class B01_BOJ_16562_ģ���� {
	static int N, M, K;
	static int cost[][];
	static int g[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		g = new int[N+1];
		cost = new int[N+1][3];
		
		
		for (int i = 0; i <= N; i++) {
			g[i] = i;
		}
		
		st = new StringTokenizer(br.readLine().trim());
		
		for (int i = 1; i <= N; i++) {
			cost[i][0] = i;
			cost[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int v = 0, w = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			if(cost[v][1] <= cost[w][1]) {
				Union(v, w);
				cost[v][2] = w;
				cost[w][2] = v;
			}
			else {
				Union(w, v);
				cost[v][2] = w;
				cost[w][2] = v;
			}
			
		}
		
		int tc = 0;	// �ܾ�
		Arrays.sort(cost, new Comparator<int[]>() {
			@Override
			public int compare(int[] c1, int[] c2) {
				// TODO Auto-generated method stub
				return c1[1] - c2[1];
			}
		});
				
		for (int i = 1; i <= N; i++) {
			if(tc + cost[i][1] <= K && Find(0) != Find(cost[i][0])) {
				Union(0, Find(cost[i][0]));
				Union(0, Find(cost[i][2]));
				tc += cost[i][1];
			}
		}
		
		boolean chk = false; 
		for (int i = 1; i <= N; i++) {
			if(Find(i) != 0) {
				chk = true;
				break;
			}
		}
		
		if(chk) bw.append("Oh no\n");
		else bw.append(tc + "\n");
		
		bw.flush();
		bw.close();
	}



	public static void Union(int a, int b) {
		g[Find(b)] = Find(a);
	}

	public static int Find(int n) {
		if(g[n] == n) return g[n];		
		return g[n] = Find(g[n]);
	}
	
	
}
