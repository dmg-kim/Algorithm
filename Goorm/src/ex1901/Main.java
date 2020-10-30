package ex1901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
static int Team[] = new int[4];
static int Mine[] = new int[5];
static int Answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < Team.length; i++) {
			Team[i] = Integer.parseInt(st.nextToken());			
		}
		
		st = new StringTokenizer(br.readLine());
		
		Answer = 0;
		
		for (int i = 0; i < Mine.length; i++) {
			Mine[i] = Integer.parseInt(st.nextToken());
			
			boolean chk = true;
			
			for (int j = 0; j < Team.length; j++) {
				if(Mine[i] == Team[j]) {
					chk = false;
					break;
				}
			}
			
			if(chk) {
				Answer++;
			}
		}
		
		bw.write(Answer + "\n");
		bw.flush();
		bw.close();
		
		
		

	}

}
