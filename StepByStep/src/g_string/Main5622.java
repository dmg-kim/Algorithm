package g_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main5622 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String phoneNo = br.readLine();
		
		int newNo = 0;
		
		for (int i = 0; i < phoneNo.length(); i++) {
			if((phoneNo.charAt(i) >= 'P' && phoneNo.charAt(i) <= 'S')) {
				newNo += 8;
			}
			else if((phoneNo.charAt(i) >= 'W' && phoneNo.charAt(i) <= 'Z')) {
				newNo += 10;
			}
			else if((phoneNo.charAt(i) >= 'T' && phoneNo.charAt(i) <= 'V')) {
				newNo += 9;
			}
			else {
				newNo += (phoneNo.charAt(i)-'A')/3 + 3;
			}
		}
		System.out.println(newNo);
	}
}
