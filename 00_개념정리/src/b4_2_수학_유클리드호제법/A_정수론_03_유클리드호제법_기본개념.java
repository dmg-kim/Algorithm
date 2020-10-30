package b4_2_수학_유클리드호제법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_정수론_03_유클리드호제법_기본개념 {
	/*
	 * [유클리드 호제법]
	 * 정수 A, B (A > B)
	 * r = A를 B로 나눈 나머지
	 * GCD(A, B) = GCD(B, r) ==> 재귀 이용
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		System.out.println("=== 최대공약수 구하기 === \n 두 수를 입력하세요.");
		
		st = new StringTokenizer(br.readLine().trim());
		
		int a, b, temp = 0;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if(a < b) {
			temp = a;	
			a = b; 
			b = temp;
		}
		
		long start, end;
		
		start = System.currentTimeMillis();
		System.out.println(GCD_rec(a, b));
		end = System.currentTimeMillis();
		System.out.println("1) GCD_rec 소요시간: " + (end - start)/1000 + "." + (end - start)%1000);
		
		start = System.currentTimeMillis();
		System.out.println(GCD_while(a, b));
		end = System.currentTimeMillis();
		System.out.println("2) GCD_while 소요시간: " + (end - start)/1000 + "." + (end - start)%1000);
	}

	private static int GCD_rec(int a, int b) {
		if(b == 0) return a;	// a가  b로 나누어 떨어진 경우
		else return GCD_rec(b, a % b);
	}
	
	private static int GCD_while(int a, int b) {
		int n = 0;
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}
}
