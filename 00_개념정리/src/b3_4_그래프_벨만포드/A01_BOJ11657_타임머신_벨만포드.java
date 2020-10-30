package b3_4_�׷���_��������;

import java.io.*;
import java.util.*;

public class A01_BOJ11657_Ÿ�Ӹӽ�_�������� {
	/*
	 * https://www.acmicpc.net/problem/11657
	 * 
	 * N���� ����, M���� ����
	 * ���� �̵��ð��� ������ ��쵵 ����(������ ���� Ÿ�Ӹӽ�)
	 * 1�� ���ÿ��� ����Ͽ� ������ ���÷� ���� ���� ���� �ð��� ���ϴ� ���α׷�
	 *  
	 */
	static int N, M, S;
	static ArrayList<Edge> eList;
	static long dist[];
	static final int INF = 60000001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		eList = new ArrayList<Edge>();
		dist = new long[N+1];
		
		int a, b, c;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(a, b, c));
		}
		
		Arrays.fill(dist, INF);
		dist[1] = 0L;
		boolean nCycle = false;
		
		for (int i = 1; i <= N; i++) {
			for (Edge e : eList) {
				if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.dist) {
					dist[e.to] = dist[e.from] + e.dist;
					if(i == N) {
						nCycle = true;
						break;
					}
				}
			}
		}
		
		if(nCycle) {
			bw.append(-1 + "\n");
		}
		else {
			for (int i = 2; i <= N; i++) {
				if(dist[i] == INF) bw.append(-1 + "\n"); 
				else bw.append(dist[i] + "\n");
			}
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
