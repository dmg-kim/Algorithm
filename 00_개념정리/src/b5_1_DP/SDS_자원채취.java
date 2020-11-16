package b5_1_DP;

import java.io.*;
import java.util.*;

public class SDS_자원채취 {
	static int N, M;
	static int res[][];
	static int dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = new int[N+2][M+2];
		dp = new int[N+2][M+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= M; j++) {
				res[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = res[1][1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + res[i][j];
			}
		}
		
		bw.append(dp[N][M] + "\n");
		bw.flush();
		bw.close();
	}
}
