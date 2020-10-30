package g_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1316 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String Input[] = new String[N];
		
		for (int i = 0; i < Input.length; i++) {
			Input[i] = br.readLine();
		}
		
		int Answer = 0;
		boolean Judge;
		
		char before = ' ';
		int cnt[];
		
		for (int i = 0; i < Input.length; i++) {
			
			Judge = true;
			cnt = new int[26];
			
			before = Input[i].charAt(0);
			for (int j = 0; j < Input[i].length(); j++) {
				if(before == Input[i].charAt(j)) {
					cnt[Input[i].charAt(j)-'a']++;
					before = Input[i].charAt(j);
				}
				else {
					if(cnt[Input[i].charAt(j)-'a'] > 0) {
						Judge = false;
						break;
					}
					cnt[Input[i].charAt(j)-'a']++;
					before = Input[i].charAt(j);
				}
			}
			
			if(Judge) {
				Answer++;
			}
		}
		
		System.out.println(Answer);
	}
}
