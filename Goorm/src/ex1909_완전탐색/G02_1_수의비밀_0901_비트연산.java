package ex1909_완전탐색;

import java.util.*;

/*
 * [19년 09월 1주차 - 수의비밀]
 *  - 비밀스러운 숫자는 모두 2^k 
 *  - 숫자(10^18이하)가 2^k 이면 YES 아니면 NO 출력
 *  
 *  <문제풀이>
 *   1) 2로 나누어떨어질때까지 계속 나누면 1이 되는 수 2^k
 *   2) 2진수로 나타냈을때 1인 비트가 하나인 수(2의 보수 -n: 마지막 1인 비트만 1로 남기고 나머지는 0->1 ,1 ->0)
 *      => n과 n의 보수 & 연산시 1인 비트 자기자신
 */  
public class G02_1_수의비밀_0901_비트연산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
//		while(n % 2 == 0) {
//			n >>= 1;
//		}
//		
//		if(n == 1) System.out.println("Yes");
//		else System.out.println("No");
		if(n == (n & -n)) {
			System.out.println("Yes");
		}
		else System.out.println("No");
	}
}
