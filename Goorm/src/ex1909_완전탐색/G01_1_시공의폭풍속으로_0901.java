package ex1909_����Ž��;

import java.util.*;

/*
 * [19�� 09�� 1���� - �ð��� ��ǳ������]
 *  - 87���� ����
 *  - ������ 5�� ������ ��� ����
 *  - �츮�� 4���� ������ ������ ���� �����Ҽ� �ִ� 5���� ������ �־����� �� ������ �� �ִ� ������ �� ���ϱ�
 */
public class G01_1_�ð�����ǳ������_0901 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Heros[] = new int[88];
		
		for (int i = 0; i < 4; i++) {
			int n = sc.nextInt();
			Heros[n] = 1;
		}
		
		int Ans = 0;
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if(Heros[n] != 1) Ans++;
		}
		
		System.out.println(Ans);
	}
}
