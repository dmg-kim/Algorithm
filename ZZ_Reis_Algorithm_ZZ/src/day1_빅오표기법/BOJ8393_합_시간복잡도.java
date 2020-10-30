package day1_���ǥ���;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ8393_��_�ð����⵵ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		int ans = 0;
		
		// O(n)
//		for (int i = 1; i <= n; i++) {
//			ans += i;
//		}
		
		// O(1)
		ans = (n + 1) * n / 2;
		
		bw.append(ans + "\n");
		bw.flush();
		bw.close();

	}

}
