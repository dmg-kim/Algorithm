package b5_4_기법_투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class B01_BOJ2003_수들의합2_투포인터 {
	/*
	 * https://www.acmicpc.net/problem/2003
	 * 
	 * N개의 수로 된 수열 A[1], A[2], …, A[N] 
	 * 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수 구하기
	 * N(1 ≤ N ≤ 10,000)
	 * M(1 ≤ M ≤ 300,000,000)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		/* ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		 * N이 최대 10000인데 배열 10002 선언한 이유는 (1부터 해서 10001)
		 * r++ 했을때 배열범위 하나를 넘어 갈 수 있어서 사이즈+1 해줌.
		 * 이거때매 몇시간을...ㅠㅠ
		 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		 */
		int arr[] = new int[10002];
		
		st = new StringTokenizer(br.readLine().trim());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 내가 푼거
//		int ans = 0;
//		int l = 0;
//		int r = 0;
//		int sum = 0;
//		int l_sum = 0;
//		int r_sum = 0;
//		
//		while(true) {
//			if(r > N) break;	// r이 배열 범위를 넘어가면 stop
//			
//			sum = r_sum - l_sum;	// 0~r까지의 sum - 0~l까지의 sum = l+1~r 구간의 합
//			
//			if(sum == M) {		// sum이 M과 같으면 
//				ans++;			// 카운트 + 1
//				r++;			// r 한칸 이동 및 r_sum 값 더해줌
//				r_sum += arr[r];
//			}
//			else if(sum < M) {	// sum이 M보다 작으면
//				r++;			// r 한칸 증가 시켜(r_sum 값 증가) 구간 합 증가
//				r_sum += arr[r];
//			}
//			else if(sum > M) {	// sum이 M보다 크면
//				l++;			// l 한칸 증가 시켜(l_sum 값 증가) 구간 합 감소
//				l_sum += arr[l];
//			}
//		}
		
		// 개 간단 코드...
		int ans = 0;
		int l = 1, r = 1;
		int sum = 0;
		while(r <= N+1) {
			
			if(sum < M) {
				sum +=arr[r];
				r++;
			}
			else {
				sum -= arr[l];
				l++;
			}
			
			// 같은 거 체크를 if문 따로 체크...(이생각을 왜 못했지;;ㅠ)
			if(sum == M) ans++;
		}
		
		bw.append(ans + "\n");
		bw.flush();
		bw.close();
	}

}
