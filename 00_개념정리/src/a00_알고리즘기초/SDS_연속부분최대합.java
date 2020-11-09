package a00_�˰������;

import java.util.*;

public class SDS_���Ӻκ��ִ��� {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num[] = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int l = 0, r = 0;
		
		// l ����, r�� �̵��ϸ鼭 ������ ����
		// r �̵��� �������� 0���� �۾����� l, r �״�����ġ�� ��� �̵�
		long max = Long.MIN_VALUE;
		long sum = 0;
		
		while(r < N) {
			sum += num[r];
			max = Math.max(max, sum);
			if(sum < 0) {
				sum = 0;
				l = r++;
			}
			else {
				r++;
			}
		}
		
		System.out.println(max);

	}
}
