package g_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2942 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int now = 0;
		int answer = 0;
		
		while (now < input.length()) {
			if(input.charAt(now) == 'c') {
				
				if(now+1 < input.length() && input.charAt(now+1) == '=') {
					now++;
				}
				else if (now+1 < input.length() && input.charAt(now+1) == '-') {
					now++;
				}
				
			}
			else if (input.charAt(now) == 'd') {
				
				if(now+1 < input.length() && input.charAt(now+1) == 'z') {					
					if(now+2 < input.length() && input.charAt(now+2) == '=') {
						now++;
						now++;
					}
				}
				else if (now+1 < input.length() && input.charAt(now+1) == '-') {
					now++;
				}

			}
			else if (input.charAt(now) == 'l') {
				if(now+1 < input.length() && input.charAt(now+1) == 'j') {
					now++;
				}
			}
			else if (input.charAt(now) == 'n') {
				if(now+1 < input.length() && input.charAt(now+1) == 'j') {
					now++;
				}
			}
			else if (input.charAt(now) == 's') {
				if(now+1 < input.length() && input.charAt(now+1) == '=') {
					now++;
				}
			}
			else if (input.charAt(now) == 'z') {
				if(now+1 < input.length() && input.charAt(now+1) == '=') {
					now++;
				}
			}
			
			now++;
			answer++;
		}
		
		System.out.println(answer);
	}
}
