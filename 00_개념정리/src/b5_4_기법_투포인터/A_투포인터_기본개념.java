package b5_4_기법_투포인터;

public class A_투포인터_기본개념 {
	/*
	 * [투포인터]
	 *  - 정렬된 배열에서 두 개의 포인터 를 이용하여 해당 값들과 원하는 값을 비교한 뒤 포인터를 조작하여
	 *    원하는 결과를 얻어내는 기법
	 *  - 문제
	 *   . 배열 내 합이 S가 되는 순서쌍 찾기
	 *   . 1) 완전 탐색: N^2
	 *   . 2) 투포인터: 정렬(N), 정렬X(NlogN)
	 */
	public static void main(String[] args) {
		int arr[] = new int[50000];
		
		for (int i = 0; i < arr.length; i++) {
			double dVal = Math.random();
			arr[i] = (int) (dVal * 1000);
		}
		
		long start = System.currentTimeMillis();
		
		// 1) 완전 탐색
		int S = 500;
		int cnt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == S)
					cnt++;
			}
		}
		System.out.println("순서쌍 갯수: " + cnt);
		
		long end = System.currentTimeMillis();
		
		System.out.println("1) 완전탐색 소요시간: " + (end - start)/1000 + "." + (end - start)%1000);
		
		
		start = System.currentTimeMillis();
		// 2) 투포인터
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
		
		System.out.println("순서쌍 갯수: " + cnt);
		
		end = System.currentTimeMillis();
		
		System.out.println("2) 투포인터 소요시간: " + (end - start)/1000 + "." + (end - start)%1000);

	}

}
