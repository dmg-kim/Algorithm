package b3_9_�׷���_LCA;

import java.io.*;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/3176
 * 
 * <��������>
 *  - �� ���ø� �����ϴ� ��� �󿡼� ���� ª�� ������ ���̿� ���� �� ������ ���̸� ���ϴ� ���α׷�
 * <Point>
 *  - LCA Par ���� �� �ּ�, �ִ밪 ���ϱ�
 */
public class B04_BOJ3176_���γ�Ʈ��ũ {
	static int N, K;
	static ArrayList<Edge> eList[];
	static int d[];
	static int par[][];
	static int minpar[][];
	static int maxpar[][];
	static final int MAX_VAL = 1231234;
	static final int MIN_VAL = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		eList = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			eList[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			eList[a].add(new Edge(b, c));
			eList[b].add(new Edge(a, c));
		}
		
		d = new int[N+1];
		par = new int[N+1][18];
		minpar = new int[N+1][18];
		maxpar = new int[N+1][18];
		
		BFS();
		
		for (int j = 1; j <= 17; j++) {
			for (int i = 1; i <= N; i++) {
				par[i][j] = par[par[i][j-1]][j-1];
				minpar[i][j] = Math.min(minpar[par[i][j-1]][j-1], minpar[i][j-1]);
				maxpar[i][j] = Math.max(maxpar[par[i][j-1]][j-1], maxpar[i][j-1]);
			}
		}
		
		K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
//			Pair ret = LCA(d, e);
			int[] ret = LCA(d, e);
//			bw.write(ret.min + " " + ret.max + "\n");
			bw.write(ret[0] + " " + ret[1] + "\n");
//			bw.write(LCA(d, e) + "\n");
		}
		bw.flush();
		bw.close();

	}

	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		int visited[] = new int[N+1];
		q.add(1);
		d[1] = 0;
		par[1][0] = 0;
		minpar[1][0] = 0;
		maxpar[1][0] = 0;
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(visited[cur] == 1) continue;
			visited[cur] = 1;
			for (Edge n : eList[cur]) {
				if(visited[n.v] != 1) {
					d[n.v] = d[cur] + 1;
					par[n.v][0] = cur;
					minpar[n.v][0] = n.c;
					maxpar[n.v][0] = n.c;
					q.add(n.v);
					
				}
			}
		}
	}
	
	public static int[] LCA(int a, int b) {
		int ret_min = MAX_VAL;
		int ret_max = MIN_VAL;
		int ret[] = new int[2];
		if(d[a] > d[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int t = d[b] - d[a];
		
		for (int i = 17; i >= 0; i--) {
			if((t & (1 << i)) > 0) {
				ret_min = Math.min(ret_min, minpar[b][i]);
				ret_max = Math.max(ret_max, maxpar[b][i]);
				b = par[b][i];
			}
		}
		
		if(a == b) {
			ret[0] = ret_min;
			ret[1] = ret_max;
			return ret;
//			return new Pair(ret_min, ret_max);
//			return a;
		}
		
		for (int i = 17; i >= 0; i--) {
			if(par[a][i] != par[b][i]) {
				ret_min = Math.min(ret_min, minpar[a][i]);
				ret_min = Math.min(ret_min, minpar[b][i]);
				ret_max = Math.max(ret_max, maxpar[a][i]);
				ret_max = Math.max(ret_max, maxpar[b][i]);
				// �ִ밪, �ּҰ� ���� ���� �ϰ� a, b ����
				a = par[a][i];
				b = par[b][i];
			}
		}
		
		// �������� a, b�� �θ��� �ִ� �ּҷ� �� ����
		ret_min = Math.min(ret_min, minpar[a][0]);
		ret_min = Math.min(ret_min, minpar[b][0]);
		ret_max = Math.max(ret_max, maxpar[a][0]);
		ret_max = Math.max(ret_max, maxpar[b][0]);
//		return new Pair(ret_min, ret_max);
		ret[0] = ret_min;
		ret[1] = ret_max;
		return ret;
//		return par[a][0];
	}

	static class Edge {
		int v;
		int c;
		
		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
	static class Pair {
		int min;
		int max;
		Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

}
