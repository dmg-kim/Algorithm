package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int n1 = b/100;
		int n2 = (b-(n1*100))/10;
		int n3 = (b-(n1*100) - (n2*10));
		
		System.out.println(a * n3);
		System.out.println(a * n2);
		System.out.println(a * n1);
		System.out.println(a * b);
		
	}

}
