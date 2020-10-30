package g_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2908 {
	static int iSum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		String a1 = "";
		String b1 = "";
		
//		for (int i = 1; i <= 3; i++) {
//			a1 += a.charAt(a.length()-i);
//			b1 += b.charAt(b.length()-i);
//		}
		
		a1 = new StringBuffer(a).reverse().toString();
		b1 = new StringBuffer(b).reverse().toString();
		
		if(Integer.parseInt(a1) > Integer.parseInt(b1))
			System.out.println(a1);
		else
			System.out.println(b1);
	}
}
