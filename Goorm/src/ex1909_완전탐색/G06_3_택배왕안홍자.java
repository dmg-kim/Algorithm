package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * [19년 09월 2주차 - 택배왕 안홍자(3)]
 *  - 택배 보수 N X N(2~10)
 *  - aij: i에서 j로 택배 서비스 제공시 보수
 *  - 배달 마치면 출발지로 돌아와야함
 *    어떤지역이든 출발 가능
 *    방문지역 재방문 불가
 *    보수가 없으면 이동X
 *    모든지역 다 방문 필요 X
 *  <문제풀이>
 *  - DFS(완전탐색)
 */  
public class G06_3_택배왕안홍자 {
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
