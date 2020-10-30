package b5_4_기법_투포인터;

import java.io.*;
import java.util.*;

public class B03_BOJ2096_내려가기_DP_슬라이딩윈도우 {
	/*
	 * https://www.acmicpc.net/problem/2096
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int min_a=0, min_b=0, min_c=0;
		int max_a=0, max_b=0, max_c=0;
		
		int min = 0, max = 0;
		int a, b, c;
		int tmp_a = 0, tmp_b = 0, tmp_c = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				min_a = max_a = a; min_b = max_b = b; min_c = max_c = c;
				continue;
			}
			tmp_a = min_a; tmp_b = min_b; tmp_c = min_c;
			min_a = Math.min(tmp_a, tmp_b) + a;
			min_b = Math.min(Math.min(tmp_a, tmp_b), tmp_c) + b;
			min_c = Math.min(tmp_b, tmp_c) + c;
			
			tmp_a = max_a; tmp_b = max_b; tmp_c = max_c;
			max_a = Math.max(tmp_a, tmp_b) + a;
			max_b = Math.max(Math.max(tmp_a, tmp_b), tmp_c) + b; 
			max_c = Math.max(tmp_b, tmp_c) + c;
			
		}
		
		min = Math.min(min_a,Math.min(min_b, min_c));
		max = Math.max(max_a,Math.max(max_b, max_c));
		
		
		bw.append(max + " " + min + "\n");
		bw.flush();
		bw.close();
	}

}
