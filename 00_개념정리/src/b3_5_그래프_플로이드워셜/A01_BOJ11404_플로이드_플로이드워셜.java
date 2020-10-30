package b3_5_그래프_플로이드워셜;

import java.io.*;
import java.util.*;

public class A01_BOJ11404_플로이드_플로이드워셜 {
	/*
	 * https://www.acmicpc.net/problem/11404
	 * 
	 * N(~100)개의 도시, M(~100,000)개의 버스
	 * 모든 도시의 쌍 (A->B)의 최소 비용 구하기
	 * 비용(~100,000)
	 */
	static int N, M;
	static int dist[][];
	static final int INF = 12341234;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		
		dist = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], INF);
		}
				
		int a, b, c;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			// 동일 노선에 여러개의 버스 존재시 최소값 저장
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		for (int by = 1; by <= N; by++) {
			for (int from = 1; from <= N; from++) {
				for (int to = 1; to <= N; to++) {
					if(from != to && dist[from][by] != INF && dist[by][to] != INF) {
						dist[from][to] = Math.min(dist[from][to], dist[from][by] + dist[by][to]);
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(dist[i][j] == INF) bw.append(0 + " ");
				else bw.append(dist[i][j] + " ");
			}
			bw.append("\n");
		}
		
		
		bw.flush();
		bw.close();
	}
	
	static class Edge {
		int from;
		int to;
		int dist;
		
		Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
	}
}
