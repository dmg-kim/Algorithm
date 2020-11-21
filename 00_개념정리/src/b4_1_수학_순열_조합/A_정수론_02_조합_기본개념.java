package b4_1_수학_순열_조합;

import java.util.Scanner;

public class A_정수론_02_조합_기본개념 {
	/*
	 * 파스칼 삼각형(이항계수)
	 * 조합: nCr = n-1Cr-1 + n-1Cr
	 */
	public static void main(String[] args) throws Exception {
		int N = 10;
		long combi[][] = new long[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || i == j) combi[i][j] = 1;
				else combi[i][j] = combi[i-1][j-1] + combi[i-1][j];
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		System.out.println(n + "C" + r +" = " + combi[n][r]);
		System.out.println((n-1) + "C" + (r-1) +" + " + (n-1) + "C" + r + " = " + combi[n-1][r-1] + " + " + combi[n-1][r]);
	}
}
