package 배열;

import java.util.Arrays;

public class 합이100원소찾기 {
	/*주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다은 위치의 두 원소가 존재하면 1을,
	 *존재하지 않으면 0을 반화하는 함수 func2(int arr[], int N)을 작성하라.
	 * arr의 각 수는 0이상 100 이하이고 N은 1000이하이다.
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
		/* O(N^2)이 아닌 O(N) 으로 찾기
		 * 현재 값과 더해서 100이 되는 숫자가 이전에 존재했는지 체크
		 * 없다면 현재 값 마킹하고 다음으로 넘어감
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
