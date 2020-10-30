package b5_4_기법_투포인터;

import java.io.*;
import java.util.*;

public class B02_BOJ2075_N번째큰수_PQ {
	/*
	 * https://www.acmicpc.net/problem/2075
	 * 
	 * N×N의 표에 수 N2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());

		// 오름차순 PQ 선언
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				n = Integer.parseInt(st.nextToken());
				// 입력 받은 수를 PQ에 추가
				pq.offer(n);	
				// PQ 사이즈가 N보다 크면 PQ에서 맨 앞(가장 작은수) 빼서 버림
				if(pq.size() == N+1) pq.poll();
			}
		}
		
		// 최종 PQ에는 가장 큰 N개의 수가 남아있고 PQ의 맨 앞의 수는 N번째로 큰 수가 됨
		int ans = pq.poll();
		bw.append(ans + "\n");
		bw.flush();
		bw.close();
		
	}

}
