package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

/*
 * https://www.acmicpc.net/problem/1944
 * 
 * <문제설명>
 *  - N X N 좌표 ( <= 50)
 *  - M개의 열쇠 (<= 250)
 *  - 열쇠를 찾으며 이동한 로봇의 이동거리 최소 합계 구하기
 * 
 * <Point>
 *  - 로봇, 열쇠 위치별 idx 채번
 *  - 각각 idx 별로 다른 열쇠 위치간의 거리 구하기(좌표 거리, 상-하-좌-우 이동가능)
 *   : BFS로 탐색
 */

public class B06_BOJ1944_복제로봇 {
	static int N, K;
	static char map[][];
	static int no[][];
	static int dx[] = {1, 0 , -1, 0};
	static int dy[] = {0 , 1, 0, -1};
	static final int DIV = 100;
	static ArrayList<Key> kList;
	static ArrayList<Edge> eList;
	static int g[];
	static int Ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N+2][N+2];
		no = new int[N+2][N+2];		// 키 번호 저장용
		for (int i = 0; i <= N+1; i++) {
			Arrays.fill(map[i], '1');
		}
		
		String tmp = "";
		kList = new ArrayList<Key>();
		int idx = 1;
		for (int i = 1; i <= N; i++) {
			tmp = br.readLine().trim();
			for (int j = 1; j <= N; j++) {
				map[i][j] = tmp.charAt(j-1);
				// 입력받으면서 S 또는 K인 경우 리스트 추가 및 번호 셋팅
				if(map[i][j] == 'S' || map[i][j] == 'K') {
					kList.add(new Key(idx, i*100 + j));
					no[i][j] = idx; 
					idx++;
				}
			}
		}
		
		eList = new ArrayList<Edge>();
		
		// 각 키 위치에서 다른 키까지의 거리 측정을 위해 BFS 수행 
		for (Key k : kList) {
			BFS(k.no, k.loc);
		}
		
		Collections.sort(eList);
		g = new int [K+2];
		
		for (int i = 1; i <= K+1; i++) {
			g[i] = i;
		}
		
		Ans = 0;
		int conn = 0;
		for (Edge n : eList) {
			if(Find(n.v1) != Find(n.v2)) {
				Union(n.v1, n.v2);
				Ans += n.w;
				conn++;
			}
		}
		
		if(conn == K) bw.write(Ans + " ");
		else bw.write(-1 + " ");
		bw.flush();
		bw.close();

	}

	public static void BFS(int cno, int loc) {
		Queue<Loc> q = new LinkedList<Loc>();
		boolean visited[][] = new boolean[N+2][N+2];
		q.add(new Loc(loc, 0));
		
		Loc cur;
		int cx, cy;
		int nx, ny;
		int dist = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			cx = cur.loc / DIV;
			cy = cur.loc % DIV;
			if(visited[cx][cy]) continue;
			visited[cx][cy] = true;
			for (int i = 0; i < 4; i++) {
				nx = cx + dx[i];
				ny = cy + dy[i];
				if(!visited[nx][ny] && map[nx][ny] != '1') {
					dist = cur.dist + 1;
					q.add(new Loc(nx*DIV+ny, dist));
					if(map[nx][ny] == 'K' || map[nx][ny] == 'S') {
						eList.add(new Edge(cno, no[nx][ny], dist));
						eList.add(new Edge(no[nx][ny], cno, dist));
					}
				}
			}
		}
	}
	
	public static void Union(int a, int b) {
		g[Find(b)] = Find(a);
	}
	
	public static int Find(int n) {
		if(g[n] == n) return g[n];
		return g[n] = Find(g[n]);
	}
	
	static class Key {
		int no;
		int loc;
		 Key(int no, int loc) {
			 this.no = no;
			 this.loc = loc;
		 }
	}
	static class Loc {
		int loc;
		int dist;
		Loc(int loc, int dist) {
			this.loc = loc;
			this.dist = dist;
		}
	}
	
	static class Edge implements Comparable<Edge> {
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
			// TODO Auto-generated method stub
			return this.w - e.w;
		}
	}
}
