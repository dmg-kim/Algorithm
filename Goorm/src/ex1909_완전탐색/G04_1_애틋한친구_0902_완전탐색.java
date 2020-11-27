package ex1909_완전탐색;

import java.util.*;

/*
 * [19년 09월 2주차 - 애틋한친구]
 *  - N명 친구 위치가 좌표평면 (N <= 1000)
 *  - 가장 먼 두 친구가 가장 애틋한 친구
 *  - 두친구 번호 출력(순서대로)
 *  
 *  <문제풀이>
 *  - 완전탐색?
 */  
public class G04_1_애틋한친구_0902_완전탐색 {
	static int N, S;
	static int f[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		f = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			f[i][0] = sc.nextInt();
			f[i][1] = sc.nextInt();
		}
		
		double max = 0.0;
		double res = 0.0;
		int f1 = 0, f2 = 0;
		for (int i = 1; i <= N-1; i++) {
			for (int j = i; j <= N; j++) {
				res = Calc(i, j);
				if(max < Calc(i, j)) {
					max = res;
					f1 = i;
					f2 = j;
				}
			}
		}


		System.out.println(f1 + " " + f2);
	}

	private static double Calc(int i, int j) {
		return Math.sqrt(Math.pow(f[i][0]-f[j][0], 2)+Math.pow(f[i][1]-f[j][1], 2));
		
	}
}
