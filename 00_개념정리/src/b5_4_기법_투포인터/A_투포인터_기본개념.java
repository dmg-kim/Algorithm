package b5_4_���_��������;

public class A_��������_�⺻���� {
	/*
	 * [��������]
	 *  - ���ĵ� �迭���� �� ���� ������ �� �̿��Ͽ� �ش� ����� ���ϴ� ���� ���� �� �����͸� �����Ͽ�
	 *    ���ϴ� ����� ���� ���
	 *  - ����
	 *   . �迭 �� ���� S�� �Ǵ� ������ ã��
	 *   . 1) ���� Ž��: N^2
	 *   . 2) ��������: ����(N), ����X(NlogN)
	 */
	public static void main(String[] args) {
		int arr[] = new int[50000];
		
		for (int i = 0; i < arr.length; i++) {
			double dVal = Math.random();
			arr[i] = (int) (dVal * 1000);
		}
		
		long start = System.currentTimeMillis();
		
		// 1) ���� Ž��
		int S = 500;
		int cnt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == S)
					cnt++;
			}
		}
		System.out.println("������ ����: " + cnt);
		
		long end = System.currentTimeMillis();
		
		System.out.println("1) ����Ž�� �ҿ�ð�: " + (end - start)/1000 + "." + (end - start)%1000);
		
		
		start = System.currentTimeMillis();
		// 2) ��������
		int l = 0;
		int r = arr.length - 1;
		
		int sum = 0;
		while(l < r) {
			sum = arr[l] + arr[r];
			
			if(sum < S) {
				l++;
			}
			else if (sum > S) {
				r--;
			}
			else {
				cnt++;
				l++;
				r--;
			}
		}
		
		System.out.println("������ ����: " + cnt);
		
		end = System.currentTimeMillis();
		
		System.out.println("2) �������� �ҿ�ð�: " + (end - start)/1000 + "." + (end - start)%1000);

	}

}
