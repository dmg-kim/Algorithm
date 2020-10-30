package day1_빅오표기법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10871_X보다작은수_공간복잡도 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			if(X > n) bw.append(n + " ");
		}
		
		bw.append("\n");
		
		bw.flush();
		bw.close();

	}

}
