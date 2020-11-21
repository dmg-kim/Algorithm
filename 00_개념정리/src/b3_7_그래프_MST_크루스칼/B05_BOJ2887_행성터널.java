package b3_7_�׷���_MST_ũ�罺Į;

import java.io.*;
import java.util.*;

public class B05_BOJ2887_�༺�ͳ� {
	/*
	 * https://www.acmicpc.net/problem/2887
	 * 
	 * <��������>
	 *  - �༺�� ����: N ( <= 10��)
	 *  - �༺�� 3���� ��ǥ���� �� ��
	 *  - �� �༺ A(xA, yA, zA)�� B(xB, yB, zB)�� �ͳη� ������ �� ��� ����� min(|xA-xB|, |yA-yB|, |zA-zB|)
	 *  - �ͳ� �� N-1�� �Ǽ��Ͽ� ��� �༺ ����� �ּҺ�� 
	 * 
	 * <Point>
	 *  - �༺���� �Ÿ� ���ϱ� ���ؼ��� N*N = 100�� => �ð� �ʰ�
	 *  - �༺���� �Ÿ��� x, y, z ��� ��ǥ�� ���谡 �ƴ� x, y, z ��ǥ ������ ���̰��� �ּҰ�
	 *  - �� ��ǥ�� ���̰��� �Ÿ��� ����� ��� ���� ���� ���� �� ����
	 */
	
	static int N;
	static ArrayList<Loc> xList;
	static ArrayList<Loc> yList;
	static ArrayList<Loc> zList;
	static ArrayList<Edge> eList;
	static int g[];
	static long Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());

		xList = new ArrayList<Loc>();
		yList = new ArrayList<Loc>();
		zList = new ArrayList<Loc>();
		
		int x, y, z;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			xList.add(new Loc(i, x));
			yList.add(new Loc(i, y));
			zList.add(new Loc(i, z));
		}
		
		Collections.sort(xList);
		Collections.sort(yList);
		Collections.sort(zList);
		
		eList = new ArrayList<Edge>();
		g = new int[N+1];

		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i < N; i++) {
			eList.add(new Edge(xList.get(i-1).node, xList.get(i).node, Math.abs(xList.get(i-1).loc - xList.get(i).loc)));
			eList.add(new Edge(yList.get(i-1).node, yList.get(i).node, Math.abs(yList.get(i-1).loc - yList.get(i).loc)));
			eList.add(new Edge(zList.get(i-1).node, zList.get(i).node, Math.abs(zList.get(i-1).loc - zList.get(i).loc)));
		}
				
		Collections.sort(eList);
		
		int conn = 0;
		Answer = 0L;
		
		for (Edge e: eList) {
			if(Find(e.v1) != Find(e.v2)) {
				Union(e.v1, e.v2);
				conn++;
				Answer += e.w;
				if(conn == N-1) break;
			}	
		}
				
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
	
	static public class Loc implements Comparable<Loc>{
		int node;
		int loc;
		
		Loc(int node, int loc) {
			this.node = node;
			this.loc = loc;
		}

		@Override
		public int compareTo(Loc l) {
			// TODO Auto-generated method stub
			return this.loc - l.loc;
		}
	}

	static public class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int w;
		
		Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}
	}

}
