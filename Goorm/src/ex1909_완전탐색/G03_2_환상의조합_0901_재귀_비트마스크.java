package ex1909_����Ž��;

import java.util.*;

/*
 * [19�� 09�� 1���� - ȯ��������]
 *  - N���� ���� �ɷ�ġ(<=20)
 *  - �־��� ��Ż �ɷ�ġ S�� �����ϴ� ������ ����� �� ���ϱ� 
 *  - ȫ���̴� �ݵ�� ���� ���ԵǾ����.(ȫ���̴� ù����)
 *  
 *  <����Ǯ��>
 *  - DFS�� ����� �� ���ؼ�
 *  - ���� S�� �����ϴ� ��� ���ϱ�
 */  
public class G03_2_ȯ��������_0901_���_��Ʈ����ũ {
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
		DFS(n+1, sum);			// n+1�� ���� ���� ���ϴ� ���
		chk[n+1]=1;
		DFS(n+1, sum+a[n+1]);		// n+1�� ���� ���� �ϴ� ���
		
	}
}
