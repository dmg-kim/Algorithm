package b5_4_기법_투포인터;

import java.io.*;
import java.util.*;

public class B02_BOJ2075_N번째큰수_투포인터 {
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
		
		int ans = 0;
		
		bw.append(ans + "\n");
		bw.flush();
		bw.close();
	}

}
