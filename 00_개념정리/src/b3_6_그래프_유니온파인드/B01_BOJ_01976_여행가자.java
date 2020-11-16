package b3_6_그래프_유니온파인드;

import java.io.*;
import java.util.*;

/*
 * [BOJ_1976_여행가자]
 *  - https://www.acmicpc.net/problem/1976
 * 
 * 동혁이는 친구들과 함께 여행을 가려고 한다. 
 * 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다. 
 * 동혁이의 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자. 
 * 물론 중간에 다른 도시를 경유해서 여행을 할 수도 있다. 
 * 예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고, 동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.
 * 도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때(중복 가능) 가능한지 여부를 판별하는 프로그램을 작성하시오.
 * 
 * [문제풀이]
 *  1. 입력받은 간선을 union 시킴
 *  2. 여행가고자 하는 도시 기준 find하여 모두 일치하는지 체크
 */
public class B01_BOJ_01976_여행가자 {
	static int N, M;
	static int m[][];
	static int g[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		g = new int[N+1];
		m = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if(m[i][j] == 1) {
					Union(i, j);
				}
			}	
		}
		
		st = new StringTokenizer(br.readLine());
		boolean chk = true;
		
		int root = Find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			if(root != Find(Integer.parseInt(st.nextToken()))) {
				chk = false;
				break;
			}
		}
		
		if(!chk) bw.append("NO\n");
		else bw.append("YES\n");
		
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
