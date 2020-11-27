package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * 
 * [19년 09월 4주차 - 특등사수(2)]
 *  - N: 사격횟수 (1~10000)
 *  - 모든 좌표 정수 x,y에는 표적이 있음
 *  - 표적좌표와 원점과 선분을 그었을때 다른 표적이 선분위에 없으면 명중
 *  
 *  <문제풀이>
 *  - 수학
 *  - 기울기, 서로소
 */  
public class G10_2_특등사수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long t[][] = new long[N][2];
		
		int Ans = 0;
		for (int i = 0; i < N; i++) {
			t[i][0] = sc.nextLong();
			t[i][1] = sc.nextLong();
			
			Ans += check(Math.abs(t[i][0]), Math.abs(t[i][1]));
		}
		
		System.out.println(Ans);
	}

	public static int check(long a, long b) {
		if(a < b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		if(gcd(a, b) != 1) return 0;
		else return 1;
	}

	public static long gcd(long a, long b) {
		if(b == 0) return a;
		else return gcd(b, a % b);
	}
}

