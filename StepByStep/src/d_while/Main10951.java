package d_while;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10951 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = 10;
		int b = 10;
		int sum;
		
		String str = "";
		String temp[] = new String[2];
		
		while ((str = br.readLine()) != null) {
			
			if(str.length() == 0)
				break;
			
			temp = str.split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			
			sum = a + b;
			
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}
}
