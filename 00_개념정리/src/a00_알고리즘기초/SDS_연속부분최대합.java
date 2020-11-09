package a00_알고리즘기초;

import java.util.*;

public class SDS_연속부분최대합 {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num[] = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		int l = 0, r = 0;
		
		// l 고정, r을 이동하면서 구간합 구함
		// r 이동시 구간합이 0보다 작아지면 l, r 그다음위치로 모두 이동
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
