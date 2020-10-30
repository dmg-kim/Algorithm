package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int score[] = new int[N];
		double avg[] = new double[N];
		int max = Integer.MIN_VALUE;
		double answer = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			
			if(max < score[i]) {
				max = score[i];
			}
		}
		
		double sum = 0;
		
		for (int i = 0; i < score.length; i++) {
			avg[i] = ((double)score[i]/(double)max)*100;
			
			sum += avg[i];
		}
		
		answer = sum / N;
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}
