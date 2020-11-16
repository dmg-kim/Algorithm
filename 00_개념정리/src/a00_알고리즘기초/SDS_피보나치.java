package a00_알고리즘기초;

import java.util.*;

public class SDS_피보나치 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mod = 1000000;
		int p = mod / 10 * 15;
		long n = sc.nextLong();
		
		int dp[] = new int[p+1];
		dp[0] = 0;
		dp[1] = 1;
		
		int ans = 0;
		for (int i = 2; i <= p; i++) {
			ans = (dp[i-1] + dp[i-2]) % mod;
			dp[i] = ans;
		}
		System.out.println(dp[(int)(n%p)]);

	}
}
