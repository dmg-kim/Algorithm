package g_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1157 {
	static int iSum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		str = str.toUpperCase();
		
		int cnt[] = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i)-'A']++;
		}
		
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		
		boolean dup = false;
	
		for (int i = 0; i < cnt.length; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				maxIdx = i;
				dup = false;
			}
			else if (max == cnt[i]) {
				dup = true;
			}	
		}
		
		if(dup) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(maxIdx + 'A'));
		}

	}
}
