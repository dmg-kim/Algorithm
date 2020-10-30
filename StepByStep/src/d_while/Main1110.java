package d_while;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main1110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = -1;
		int next = -2;
		int c = 0;
		
		n = Integer.parseInt(br.readLine());
		
		int a, b = 0;
		
		next = n;
		
		while (true) {
			if(next < 10) {
				a = 0;
				b = next;
			}
			
			a = next / 10;
			b = next % 10;
			
			next = b * 10 + ((a + b)%10); 
			
//			System.out.println(next);
			c++;
			
			if(next == n) {
				break;
			}
		}
		
		System.out.println(c);
		
	}
}
