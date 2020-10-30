package day2_완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1912_연속합_완전탐색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		int dp[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// DP
		dp[0] = arr[0];
		int ans = dp[0];
		
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			
			ans = Math.max(ans, dp[i]);
		}
		
		// 투 포인터(못품ㅠ)
//		ans = Integer.MIN_VALUE;
//		
//		int s = 0, e = 1;
//		int sum = arr[s];
//		while(true) {
//		    if (sum > arr[e]) {
//		    	ans = sum;
//		    	e++;
//		    }
//			else if(sum + arr[e] > arr[e]) sum += arr[e++];
//			else if(sum + arr[e] <= arr[e]) 
//			{
//				sum = arr[e++];
//				s = e;
//			}
//			
//			ans = Math.max(ans, sum);
//			
//			if(e == n-1) break;
//		}
		
		bw.append(ans + "\n");
		
		
		bw.flush();
		bw.close();

	}

}
