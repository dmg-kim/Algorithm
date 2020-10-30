package floyd_warshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshall_11404 {
	static int N, M;
	static int dist[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 1. 거리 인접행렬 형태로 저장
		dist = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);	// 2. 거리 무한대로 초기화
			dist[i][i] = 0;								// 3. 동일 정점 0으로 초기화
		}		
		
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			// 4. 간선 정보 저장(최소값으로) 
			if(dist[a][b] > c)
				dist[a][b] = c;
		}
		
		// 5. 거리 계산
		for (int by = 1; by <= N; by++) {
			for (int from = 1; from <= N; from++) {
				for (int to = 1; to <= N; to++) {
					if(dist[from][by] != Integer.MAX_VALUE && dist[by][to] != Integer.MAX_VALUE) {	// 이동 가능한 거리만 계산
						dist[from][to] = Math.min(dist[from][to], dist[from][by] + dist[by][to]);
					}
				}
			}
		}
		
		for (int from = 1; from <= N; from++) {
			for (int to = 1; to <= N; to++) {
				if(dist[from][to] == Integer.MAX_VALUE) {
					dist[from][to] = 0;
				}
				bw.append(dist[from][to] + " ");
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();
	}
}
