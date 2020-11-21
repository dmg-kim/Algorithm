package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B05_BOJ2887_행성터널 {
	/*
	 * https://www.acmicpc.net/problem/2887
	 * 
	 * <문제설명>
	 *  - 행성의 개수: N ( <= 10만)
	 *  - 행성은 3차원 좌표위의 한 점
	 *  - 두 행성 A(xA, yA, zA)와 B(xB, yB, zB)를 터널로 연결할 때 드는 비용은 min(|xA-xB|, |yA-yB|, |zA-zB|)
	 *  - 터널 총 N-1개 건설하여 모든 행성 연결시 최소비용 
	 * 
	 * <Point>
	 *  - 행성간의 거리 구하기 위해서는 N*N = 100억 => 시간 초과
	 *  - 행성간의 거리는 x, y, z 모든 좌표의 관계가 아닌 x, y, z 좌표 각각의 차이값의 최소값
	 *  - 각 좌표의 차이값을 거리로 계산후 모든 간선 정보 저장 및 정렬
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
