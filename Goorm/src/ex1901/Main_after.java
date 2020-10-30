package ex1901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_after {
static int Heros[] = new int[88];
static int Answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			Heros[Integer.parseInt(st.nextToken())] = 1;			
		}
		
		st = new StringTokenizer(br.readLine());
		
		Answer = 0;
		
		for (int i = 0; i < 5; i++) {
			
			if(Heros[Integer.parseInt(st.nextToken())] == 0) {
				Answer++;
			}
		}
		
		bw.write(Answer + "\n");
		bw.flush();
		bw.close();

	}

}
