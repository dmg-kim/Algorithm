package b3_7_�׷���_MST_ũ�罺Į;

import java.io.*;
import java.util.*;

public class B04_BOJ4386_���ڸ������ {
	/*
	 * https://www.acmicpc.net/problem/4386
	 * 
	 * <���� ����>
	 * N���� ��
	 * ���ڸ�
	 *  - ���ڸ��� �̷�� ���� �ΰ��� ���� ���������� ����
	 *  - ��� ������ ���ڸ� ���� ���� ���� ���� ��/���������� ����
	 * ���ڸ��� ����� �ִ� �ּҺ��(�Ҽ��� 2�ڸ����� ���)
	 * 
	 * <Point>
	 *  - ��ǥ�� �̿��� �Ÿ��� ���ϰ� ���� �Ÿ��� MST ����
	 *  - �Ҽ��� ó��
	 */
	
	static int N, M;
	static double loc[][];
	static ArrayList<Edge> eList;
	static int g[];
	static double Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());

		loc = new double [N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			loc[i][0] = Double.parseDouble(st.nextToken());
			loc[i][1] = Double.parseDouble(st.nextToken());
		}
		
		eList = new ArrayList<Edge>();
		g = new int[N+1];

		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i <= N-1; i++) {
			for (int j = i+1; j <= N; j++) {
				double x = Math.pow(loc[i][0] - loc[j][0], 2);
				double y = Math.pow(loc[i][1] - loc[j][1], 2);
				double dist = Math.sqrt(x + y);
				
				eList.add(new Edge(i, j, dist));
				eList.add(new Edge(j, i, dist));
			}
		}
				
		Collections.sort(eList);
		
		int conn = 0;
		Answer = 0.0;
		
		for (Edge e: eList) {
			if(Find(e.v1) != Find(e.v2)) {
				Union(e.v1, e.v2);
				conn++;
				Answer += e.w;
				if(conn == N-1) break;
			}	
		}
		
		Answer = Math.round(Answer * 100);
		Answer /= 100;
		
		bw.write(Answer + "\n");
		bw.flush();
		bw.close();

	}
	
	static public void Union(int a, int b) {
		g[Find(b)] = Find(a);
		
	}

	static public int Find(int n) {
		if(g[n] == n) return n;
		return g[n] = Find(g[n]);
	}

	static public class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		double w;
		
		Edge(int v1, int v2, double w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			if(this.w - e.w > 0) return 1;
			else if(this.w - e.w < 0) return -1;
			else return 0;
		}
	}

}
