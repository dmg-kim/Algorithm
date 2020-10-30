package ccw_ex2166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static double[] Area;
	static int[][] Pos; 
	static int Answer; 
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Pos = new int [10002][4];
		Area = new double[10002];
		
		Answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Pos[i][0] = i;
			Pos[i][1] = Integer.parseInt(st.nextToken());
			Pos[i][2] = Integer.parseInt(st.nextToken()); 
		}
		
		Pos[N][1] = Pos[0][1];
		Pos[N][2] = Pos[0][2];
		
		for (int i = 1; i < N-1; i++) {

			Area[i] = CCW(Pos[0][1], Pos[0][2], Pos[i][1], Pos[i][2], Pos[i+1][1], Pos[i+1][2]);
			
		}
		
		for (int i = 0; i < N; i++) {
			Answer += Area[i];
		}
		
		if(Answer % 2 == 0) {
			System.out.print(Answer/2 + "." + "0");
		}
		else {
			System.out.print(Answer/2 + "." + "5");
		}
		
		
		
		

	}
	public static double CCW(int x1, int y1, int x2, int y2, int x3, int y3) {
		double val = (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
		
		if(val < 0) {
			val = val * -1;
		}
		return val;
	}

}
