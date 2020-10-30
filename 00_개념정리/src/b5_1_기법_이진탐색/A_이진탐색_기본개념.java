package b5_1_���_����Ž��;

import java.util.Arrays;

public class A_����Ž��_�⺻���� {
	/*
	 * [����Ž��]
	 *  - �̹� ���ĵ� �迭���� Ư���� ���Ұ� ���ԵǾ� �ִ��� �ƴ��� ������ �Ǵ��� �� �ִ� ���
	 *  - �ð����⵵
	 *   . ���ĵ� ���: logN
	 *   . ���� �ʿ�   : NlogN
	 *  - ���� ���� ���ϱ�� �������� ���� ������ �� �ְ� �ش� ���� �´��� Ʋ���� Ȯ���ϴ� ����
	 */
	static int arr[] = {5, 2, 9, 4, 12, 10, 7, 6, 15, 24, 21, 27, 13};
	public static void main(String[] args) {
		
		Arrays.sort(arr);
		
		binarySearch(8);
		
		binarySearch(15);		
	}

	private static void binarySearch(int n) {
		int l = 0;
		int r = arr.length-1;
		int mid;
		int cnt = 0;
		while(l <= r) {
			mid = (l+r)/2;
			cnt++;
			
			if(n < arr[mid]) r = mid - 1;
			else if(n > arr[mid]) l = mid + 1;
			else {
				System.out.println(cnt + "ȸ���� ã��!!");
				return;
			}			
		}
		
		System.out.println("��ã��...");
		
	}
}
