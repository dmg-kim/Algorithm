package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3502 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input[] = new int[42];
		int remain = 0;
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			
			remain = Integer.parseInt(br.readLine()) % 42;
			
			input[remain]++;
			if(input[remain] == 1) {
				answer++;
			}
		}
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
