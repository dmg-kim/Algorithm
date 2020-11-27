package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * [19년 09월 3주차 - 구슬수집가(2)]
 *  - 구슬 정리를 위한 상자: 크기가 배수관계 
 *  - 최소개수의 상자를 이용하여 구슬 정리
 *  - N: 구슬의 개수 (10~10^16)
 *  - K: 상자 종류개수(2~30)
 *  <문제풀이>
 *  - 탐욕(Greedy) 알고리즘
 *  - 거스름돈 거슬러주기 문제
 */  
public class G07_2_구슬수집가 {
	static long N;
	static int K;
	static long box[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		box = new long[K];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			box[i] = Long.parseLong(st.nextToken());
		}
		
		long Ans = 0L;
		int idx = K-1;
		while(N > 0) {
			Ans += N / box[idx];
			N %= box[idx];
			idx--;
		}
		
		System.out.println(Ans);
		

	}

}
