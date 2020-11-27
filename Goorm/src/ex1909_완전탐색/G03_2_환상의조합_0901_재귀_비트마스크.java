package ex1909_완전탐색;

import java.util.*;

/*
 * [19년 09월 1주차 - 환상의조합]
 *  - N명의 팀원 능력치(<=20)
 *  - 주어진 토탈 능력치 S를 만족하는 팀구성 경우의 수 구하기 
 *  - 홍현이는 반드시 팀에 포함되어야함.(홍현이는 첫번재)
 *  
 *  <문제풀이>
 *  - DFS로 경우의 수 구해서
 *  - 합의 S를 만족하는 경우 구하기
 */  
public class G03_2_환상의조합_0901_재귀_비트마스크 {
	static int N, S;
	static int a[];
	static int chk[];
	static int Ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		a = new int[N+1];
		chk = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			a[i] = sc.nextInt();
		}
		
		Ans = 0;
		chk[1] = 1;
		DFS(1, a[1]);
		System.out.println(Ans);
	}

	public static void DFS(int n, int sum) {		

		if(n == N) {
			if(sum == S) {
				Ans++;
				
//				for (int i = 1; i <= N; i++) {
//					System.out.print(chk[i] + " ");
//				}
//				System.out.println();
			} 
			
			
			
			return;
		}
		chk[n+1] = 0;
		DFS(n+1, sum);			// n+1번 팀원 선택 안하는 경우
		chk[n+1]=1;
		DFS(n+1, sum+a[n+1]);		// n+1번 팀원 선택 하는 경우
		
	}
}
