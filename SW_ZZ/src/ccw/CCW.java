package ccw;

import java.util.Random;

public class CCW {

	public static void main(String[] args) {
		Random random = new Random();
		
		int Ax = random.nextInt();
		int Ay = random.nextInt();
		
		int Bx = random.nextInt();
		int By = random.nextInt();
		
		int Cx = random.nextInt();
		int Cy = random.nextInt();
		
		System.out.println("CCW: " + ccw(Ax, Ay, Bx, By, Cx, Cy));
		System.out.println("CCW: " + ccw2(Ax, Ay, Bx, By, Cx, Cy));

	}

	private static int ccw(int ax, int ay, int bx, int by, int cx, int cy) {

		return (bx - ax) * (cy - ay) - (cx - ax) * (by - ay);
	}
	
	private static int ccw2(int ax, int ay, int bx, int by, int cx, int cy) {

		return ax * by + bx * cy + cx * ay - (bx * ay + cx * by + ax * cy);
	}

}
