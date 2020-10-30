package mst_1944_복제로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Edge> eList;
	static String Miro[][];
	static int Pos[][];
	static Queue<Edge> q;
	static ArrayList<Edge> bfsList;
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static boolean visited[][];
	static int Group[];
	static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Miro = new String[N+1][N+1];
		Pos = new int[N+1][N+1];
		
		
		String sTemp;
		char cTemp;
		int key = 2;	// 보물은 2번부터...
		
		eList = new ArrayList<Edge>();
		bfsList = new ArrayList<Edge>();

		Group = new int[M+2];
		
		for (int i = 1; i <= M+1 ; i++) {
			Group[i] = i;
		}
		
		int idx = 1;
		
		for (int i = 1; i <= N; i++) {
			sTemp = br.readLine();
			for (int j = 1; j <= N; j++) {
				Miro[i][j] = sTemp.substring(j-1, j);
				if(Miro[i][j].equals("S") || Miro[i][j].equals("K")) {
					Miro[i][j] = "K";
					bfsList.add( new Edge(i, j, 0));
					Pos[i][j] = idx++;
				}
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(Miro[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println(bfsList.size());

		for (int i = 0; i < bfsList.size(); i++) {
			BFS(i);
		}
		
		Collections.sort(eList);
		
//		for (Edge e: eList) {
//			System.out.println(e.start + "->" + e.end + ": " + e.cost);
//		}
		
		Answer = 0;
		int conn = 0;
		
		for (Edge e: eList) {
			if(Find(e.start) != Find(e.end)) {
				Answer += e.cost;
				Union(e.start, e.end);
				conn++;
				
				if (conn == M)
					break;
			}
		}
		
		if (conn < M)
			System.out.println("-1");
		else
			System.out.println(Answer);
		
	}
	
	public static void Union(int a, int b) {
		Group[Find(b)] = Find(a);
		
	}

	public static int Find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = Find(Group[n]);
	}

	public static void BFS(int idx) {
		q = new LinkedList<Edge>();
		
		q.offer(bfsList.get(idx));
		int curX, curY, curIdx;
		int nxtX, nxtY;
		
		Edge now;
		
		visited = new boolean[N+1][N+1];
		
		int dist = 0;
		
		while(!q.isEmpty()) {
			
			now = q.poll();
						
			curX = now.start;
			curY = now.end;
			dist = now.cost;
			curIdx = idx + 1;
			
			visited[curX][curY] = true;
			
			for (int i = 0; i < 4; i++) {
				nxtX = curX + dx[i];
				nxtY = curY + dy[i];
				
				if(nxtX < 1 || nxtX > N || nxtY < 1 || nxtY > N) {
					continue;
				}
				
				if(visited[nxtX][nxtY] || Miro[nxtX][nxtY].equals("1")) {
					continue;
				}
				
				visited[nxtX][nxtY] = true;
				q.offer(new Edge(nxtX, nxtY, dist + 1));
				
				
				if(Miro[nxtX][nxtY].equals("K") && curIdx < Pos[nxtX][nxtY]) {
					eList.add(new Edge(curIdx, Pos[nxtX][nxtY], dist + 1));
				}
			}
		}
	}


	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;
		
		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			
			return this.cost - e.cost;
		}
	}
}
