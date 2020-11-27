package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * [19년 09월 4주차 - 골드바흐의 추측(2)]
 *  - 2보다 큰 모든 짝수는 두개의 소수의 합으료 표시 가능
 *  - N: 수의 개수(1~1000)
 *  - ai: 짝수(4~100만)
 *  
 *  <문제풀이>
 *  - 소수: 에라토스테네스의 체
 *  - 100만까지 소수구하기
 */ 
public class G11_2_골드바흐의추측 {
	static final int MAX = 1000000;	
	static int p[] = new int[1000001];
	static long N;
	static ArrayList<Integer> pList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		getPrime();
		
		pList = new ArrayList<Integer>();
		for (int i = 1; i <= MAX ; i++) {
			if(p[i] == 0) pList.add(i);
		}
		
		int gno = 0;
		for (int i = 0; i < N; i++) {
			gno = sc.nextInt();
			int s = 0;
			int e = pList.size()-1;
			int Ans1 = 0, Ans2 = 0;
			while(s <= e) {
				if(gno < pList.get(s) + pList.get(e)) {
					e--;
				}
				else if(gno > pList.get(s) + pList.get(e)) {
					s++;
				}
				else {
					Ans1 = pList.get(s);
					Ans2 = pList.get(e);
					
					s++;
					e--;
				}
			}
			System.out.println(Ans1 + " " + Ans2);
		}
	}

	public static void getPrime() {
		p[0] = 1;
		p[1] = 1;
		for (int i = 2; i*i <= MAX; i++) {
			for (int j = i*i; j <= MAX; j+=i) {
				p[j] = 1;
			}
		}		
	}	
}

