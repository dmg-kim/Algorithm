package b4_1_수학_순열_조합;

import java.io.*;

public class G_0901_수의비밀 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine().trim()); 

		// (-) 단항연산자: n의 2의 보수
		// n과 n의 2의보수를 & 연산하게 되면 n의 가장 마지막이 1인 수 => 펜윅트리에 사용
		// 2^k은 1인 비트가 한개, 즉 마지막 비트가 1인 수 == 자기자신
		if((n & -n) == n) System.out.println("Yes");
		else System.out.println("No");
	}

}
