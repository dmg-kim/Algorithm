package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * [19년 09월 3주차 - 학생회실에는 프린터가 한 대뿐입니다.(2)]
 *  - N: 학생수 (5~100만)
 *  - wi: i번째 학생 대기시간
 *  - ai: i번째 학생 프린터 시간
 *  - 효율: SUM(wi + ai) 최소
 *  
 *  <문제풀이>
 *  - 탐욕(Greedy)
 *  - ai 순 정렬 하여 계산
 */  
public class G08_2_학생회실에는프린터가한대뿐입니다 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long a[] = new long[N];
		long e[] = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		long Ans = 0L;
		e[0] = a[0];
		Ans += e[0];
		for (int i = 1; i < N; i++) {
			e[i] = e[i-1] + a[i];
			Ans += e[i];
		}
		System.out.println(Ans);
	}

}

