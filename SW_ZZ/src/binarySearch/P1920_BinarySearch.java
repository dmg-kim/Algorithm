package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_BinarySearch {
	static int N, M;
	static int Nums[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		Nums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			
			Nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1. Á¤·Ä
		Arrays.sort(Nums);
		
		M = Integer.parseInt(br.readLine());
		int n = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			n = Integer.parseInt(st.nextToken());
			
			bw.append(BinarySearch(n) + "\n");
		}		
		bw.flush();
		bw.close();
	}
	private static int BinarySearch(int n) {
		int start = 1;
		int end = N;
		int mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(n == Nums[mid]) {
				return 1;
			}
			else if(n < Nums[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}		
		return 0;		
	}
}
