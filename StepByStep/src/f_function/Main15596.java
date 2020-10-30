package f_function;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15596 {
	static int iSum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		System.out.println(sum(arr));

	}

	public static long sum(int[] a) {
		iSum = 0;
		
		for (int i = 0; i < a.length; i++) {
			iSum += a[i];
		}
		
		return iSum;
		
	}
}
