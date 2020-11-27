package ex1909_����Ž��;

import java.io.*;
import java.util.*;

/*
 * 
 * [19�� 09�� 4���� - Ư����(2)]
 *  - N: ���Ƚ�� (1~10000)
 *  - ��� ��ǥ ���� x,y���� ǥ���� ����
 *  - ǥ����ǥ�� ������ ������ �׾����� �ٸ� ǥ���� �������� ������ ����
 *  
 *  <����Ǯ��>
 *  - ����
 *  - ����, ���μ�
 */  
public class G10_2_Ư���� {

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

