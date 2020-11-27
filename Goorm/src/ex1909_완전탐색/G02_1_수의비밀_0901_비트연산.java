package ex1909_����Ž��;

import java.util.*;

/*
 * [19�� 09�� 1���� - ���Ǻ��]
 *  - ��н����� ���ڴ� ��� 2^k 
 *  - ����(10^18����)�� 2^k �̸� YES �ƴϸ� NO ���
 *  
 *  <����Ǯ��>
 *   1) 2�� ��������������� ��� ������ 1�� �Ǵ� �� 2^k
 *   2) 2������ ��Ÿ������ 1�� ��Ʈ�� �ϳ��� ��(2�� ���� -n: ������ 1�� ��Ʈ�� 1�� ����� �������� 0->1 ,1 ->0)
 *      => n�� n�� ���� & ����� 1�� ��Ʈ �ڱ��ڽ�
 */  
public class G02_1_���Ǻ��_0901_��Ʈ���� {

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
