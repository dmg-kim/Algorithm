package b5_1_DP;

import java.util.Scanner;

public class SDS_연속부분최대합_DP {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		int N = sc.nextInt();
		
		int data[] = new int[N+1];
		
		int dp[] = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		
		dp[0] = data[0];
		
		int max = 0;
		
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i-1] + data[i], data[i]);
			if(max < dp[i]) max = dp[i];
		}
		
		System.out.println(max);

	}
}
