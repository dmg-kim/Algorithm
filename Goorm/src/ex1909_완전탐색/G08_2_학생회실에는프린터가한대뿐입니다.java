package ex1909_����Ž��;

import java.io.*;
import java.util.*;

/*
 * [19�� 09�� 3���� - �л�ȸ�ǿ��� �����Ͱ� �� ����Դϴ�.(2)]
 *  - N: �л��� (5~100��)
 *  - wi: i��° �л� ���ð�
 *  - ai: i��° �л� ������ �ð�
 *  - ȿ��: SUM(wi + ai) �ּ�
 *  
 *  <����Ǯ��>
 *  - Ž��(Greedy)
 *  - ai �� ���� �Ͽ� ���
 */  
public class G08_2_�л�ȸ�ǿ��������Ͱ��Ѵ���Դϴ� {

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

