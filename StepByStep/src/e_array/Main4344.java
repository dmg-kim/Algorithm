package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main4344 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		int N;
		int std[];
		double sum;
		double avg[] = new double[C];
		double answer[] = new double[C];
		double cnt;
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			std = new int[(int)N];
			sum = 0;
			
			for (int j = 0; j < N; j++) {
				std[j] = Integer.parseInt(st.nextToken());
				sum += std[j];
			}
			
			avg[i] = sum / N;
			
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if(avg[i] < std[j])
					cnt++;
			}
			answer[i] = Math.round((cnt / N)*100000);
//			System.out.println(String.format("%.3f", answer[i]/1000) + "%");
			bw.write(String.format("%.3f", answer[i]/1000) + "%\n");
		}
		
		bw.flush();
		bw.close();
	}
}
