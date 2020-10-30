package b5_1_기법_이진탐색;

import java.util.Arrays;

public class A_이진탐색_기본개념 {
	/*
	 * [이진탐색]
	 *  - 이미 정렬된 배열에서 특정한 원소가 포함되어 있는지 아닌지 빠르게 판단할 수 있는 기법
	 *  - 시간복잡도
	 *   . 정렬된 경우: logN
	 *   . 정렬 필요   : NlogN
	 *  - 답을 직접 구하기는 힘들지만 답을 가정할 수 있고 해당 답이 맞는지 틀린지 확인하는 문제
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
				System.out.println(cnt + "회만에 찾음!!");
				return;
			}			
		}
		
		System.out.println("못찾음...");
		
	}
}
