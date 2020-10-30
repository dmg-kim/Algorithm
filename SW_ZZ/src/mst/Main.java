package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static int N, M;
	static int result;
	static int[] par;
	static String[][] arr;
	static int[][] visit;
	static int[][] position;
	static ArrayList<Edge> list;
	static ArrayList<Edge> bfslist;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static class Edge implements Comparable<Edge> {
		int here;
		int next;
		int weight;

		public Edge(int here, int next, int weight) {
			this.here = here;
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.weight - o.weight < 0)
				return -1;
			else if (this.weight - o.weight > 0)
				return 1;
			else
				return 0;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new String[N + 1][N + 1];
		position = new int[N + 1][N + 1];

		par = new int[M + 2];
		list = new ArrayList<>();
		bfslist = new ArrayList<>();
		result = 0;

		int cnt = 1;
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				String temp = str.substring(j - 1, j);
				arr[i][j] = temp;
				if (temp.equals("S") || temp.equals("K")) {
					arr[i][j] = "K";
					position[i][j] = cnt++;
					bfslist.add(new Edge(i, j, 0));
				}
			}
		}

		for (int i = 0; i < M; i++) {
			visit = new int[N + 1][N + 1];
			bfs(i);
		}

		Collections.sort(list);
		
//		for (Edge e: list) {
//			System.out.println(e.here + "->" + e.next + ": " + e.weight);
//		}
		
		
		for (int i = 1; i <= M + 1; i++) {
			par[i] = i;
		}

		int rCnt = 0;
		for (Edge e : list) {
			int a = find(e.here);
			int b = find(e.next);

			if (a == b)
				continue;
			rCnt++;
			par[b] = a;
			result += e.weight;
		}
		if (rCnt == M)
			System.out.println(result);
		else
			System.out.println("-1");

	}

	public static void bfs(int now) {
		// TODO Auto-generated method stub
		Edge n = bfslist.get(now);
		Queue<Edge> q = new LinkedList<Edge>();

		q.offer(n);
		while (!q.isEmpty()) {
			Edge e = q.poll();
			visit[e.here][e.next] = -1;
			int val = e.weight;
			// System.out.println("===================");
			for (int i = 0; i < 4; i++) {
				int nx = e.here + dx[i];
				int ny = e.next + dy[i];
				if (ny < 1 || ny > N || nx < 1 || nx > N)
					continue;
				if (visit[nx][ny] == -1 || arr[nx][ny].equals("1")) {
					continue;
				}
				visit[nx][ny] = -1;
				q.offer(new Edge(nx, ny, val + 1));
				// System.out.println(e.here + " " + e.next + "("+dx[i] + " , " + dy[i]+")" +
				// arr[nx][ny] + " " + visit[nx][ny] + " " + val);
				// System.out.println(" == " + arr[nx][ny]);
				if (arr[nx][ny].equals("K")) {
					list.add(new Edge(now + 1, position[nx][ny], val + 1));
				}
			}
		}
	}

	public static int find(int n) {
		if (par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
}
