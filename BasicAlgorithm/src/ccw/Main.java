package ccw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
				
		int p1x, p1y;
		int p2x, p2y;
		int p3x, p3y;
		
		st = new StringTokenizer(br.readLine());
		p1x = Integer.parseInt(st.nextToken());
		p1y = Integer.parseInt(st.nextToken());
		
		Pair P1 = new Pair(p1x, p1y);
		
		st = new StringTokenizer(br.readLine());
		p2x = Integer.parseInt(st.nextToken());
		p2y = Integer.parseInt(st.nextToken());
		
		Pair P2 = new Pair(p2x, p2y);
		
		st = new StringTokenizer(br.readLine());
		p3x = Integer.parseInt(st.nextToken());
		p3y = Integer.parseInt(st.nextToken());
		
		Pair P3 = new Pair(p3x, p3y);
		
		int Answer = CCW(P1, P2, P3);
		
		if(Answer > 0) {
			System.out.println(1);
		}
		else if (Answer < 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(Answer);
		}
				}
	
	public static int CCW(Pair p1, Pair p2, Pair p3) {
		
		return (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.y*p2.x + p2.y*p3.x + p3.y*p1.x); 
	}

	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	


}
