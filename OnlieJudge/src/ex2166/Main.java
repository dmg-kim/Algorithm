package ex2166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] Area;
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		int N;
		
		N = Integer.parseInt(br.readLine());
		
		Pair[] List = new Pair[N];
		
		long x, y;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());
			List[i] = new Pair(x, y);
		}
		
//		Arrays.sort(List);
		
//		for (int i = 0; i < List.length; i++) {
//			System.out.println(i + ":" +List[i].x + "," + List[i].y);
//		}
		
		Area = new long[N];
		
		for (int i = 0; i < N-1; i++) {	
			CCW(i, List[i], List[i+1]);
		}
		
		long Answer = 0;
		
		for (int i = 0; i < Area.length; i++) {
			Answer += Area[i];
		}
		
		Answer /= 2;
		
		if(Answer% 2==0) {
			System.out.println(Answer + ".0");
		}
		else {
			System.out.println(Answer + ".5");
		}
		

	}
	
	public static void CCW(int i, Pair p1, Pair p2) {
		long val = (p1.x*p2.y - p1.y*p2.x);
		
		if (val < 0) {
			val *= -1;
		}
				
		Area[i] = val;
	}

	static class Pair {
//	static class Pair implements Comparable<Pair> {
		long x, y;
		Pair(long x, long y) {
			this.x = x;
			this.y = y;					
		}
		

//		@Override
//		public int compareTo(Pair p) {
//			if(this.x > p.x) {
//				return 1;
//			}
//			else if(this.x < p.x) {
//				return -1;
//			}
//			else {
//				if(this.y > p.y) {
//					return 1;
//				}
//				else if(this.y > p.y) {
//					return -1;
//				}
//				else {
//					return 0;
//				}
//			}
//		}
	}

}
