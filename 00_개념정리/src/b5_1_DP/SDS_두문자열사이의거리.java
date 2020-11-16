package b5_1_DP;

import java.util.*;

public class SDS_두문자열사이의거리 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.nextLine();
		String B = sc.nextLine();
		
		
		
		int dp[][] = new int[1001][1001];
		
		for (int i = 0; i <= A.length(); i++) {
			dp[i][0] = i;
			dp[0][i] = i;
		}
		
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if(A.charAt(i-1) != B.charAt(j-1)) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
				}
				else {
					dp[i][j] = dp[i-1][j-1];
				}
			}
		}
		
		for (int i = 0; i <= A.length(); i++) {
			for (int j = 0; j <= B.length(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(dp[A.length()][B.length()]);
	}
}
