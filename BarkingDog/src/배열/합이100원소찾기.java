package �迭;

import java.util.Arrays;

public class ����100����ã�� {
	/*�־��� ���� N�� int �迭 arr���� ���� 100�� ���� ���� ��ġ�� �� ���Ұ� �����ϸ� 1��,
	 *�������� ������ 0�� ��ȭ�ϴ� �Լ� func2(int arr[], int N)�� �ۼ��϶�.
	 * arr�� �� ���� 0�̻� 100 �����̰� N�� 1000�����̴�.
	 */
	static int arr[] = new int[1000];
	static int check[] = new int [101];
	public static void main(String[] args) {

		int arr[] = {1, 23, 53, 77, 60};		
		func2(arr, 5);
		int arr2[] = {1, 52, 48};
		func2(arr2, 3);
		int arr3[] = {50, 42};
		func2(arr3, 2);
		int arr4[] = {4, 13, 63, 87};
		func2(arr4, 4);
		
	}
	private static void func2(int[] arr, int n) {
		Arrays.fill(check, 0);
		/* O(N^2)�� �ƴ� O(N) ���� ã��
		 * ���� ���� ���ؼ� 100�� �Ǵ� ���ڰ� ������ �����ߴ��� üũ
		 * ���ٸ� ���� �� ��ŷ�ϰ� �������� �Ѿ
		 */
		for (int i = 0; i < arr.length; i++) {
			if(check[100 - arr[i]] == 1) {
				System.out.println(1);
				return;
			}
			else {
				check[arr[i]] = 1;
			}
		}
		System.out.println(0);
		
	}

}
