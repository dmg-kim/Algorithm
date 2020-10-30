package ex2661;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 문제유형: Recursive

public class Main {

	static int N; //(1~80)
	static String Answer;
	static boolean Stop;

	public static void main(String[] args) throws Exception {
	
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		N = Integer.parseInt(br.readLine().trim());
				
		GoodArray(1, "1");		

	}

	public static void GoodArray(int n, String s) {
		
		if(Stop) {
			return;
		}
		
		if(n == N) {
			Stop = true;
			System.out.println(s);
		}
		else {
			for (int i = 1; i <= 3; i++) {
				if(Check(s + i)) {
					GoodArray(n + 1, s + i);
				}			
			}			
		}		
	}

	public static boolean Check(String s) {
		int length = s.length();
		int checkNum = length / 2;
		int start = length - 1;
		int end = length;
		
		for (int i = 1; i <= checkNum; i++) {
			if(s.substring(start-i,  end - i).equals(s.substring(start, end))) {
				return false;
			}
			start -= 1;
		}
		
		return true;
	}
}