package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2869_Snail {
	static int A, B, V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 1. 계산으로,,,
//		int day = 0;
//		double start = 0;
//		double move = 0;
//		if(A < V) {
//			start = A;
//			move = A - B;
//			day = (int)Math.ceil((V - start) / move) + 1;
//		}
//		else {
//			day = 1;
//		}
//		
//		bw.append(day + "\n");
		
		// 2. 이분탐색으로,,,
		//  - 날짜를 기준으로 이분탐색
		int start = 0;
		int end = V;
		int day = 0;
		int answer = Integer.MAX_VALUE;
		
		while(start <= end) {
			day = (start+end)/2;
			
			if(V <= day*(A-B) + A) {
				answer = Math.min(answer, day+1);
				end = day - 1;
			}
			else {
				start = day + 1;
			}
		}
		
		
		
		bw.append(answer + "\n");
		
		bw.flush();
		bw.close();
	}
}
