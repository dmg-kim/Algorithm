package ex1909_����Ž��;

import java.util.*;

/*
 * [19�� 09�� 2���� - ��ƶ��ģ��]
 *  - N�� ģ�� ��ġ�� ��ǥ��� (N <= 1000)
 *  - ���� �� �� ģ���� ���� ��ƶ�� ģ��
 *  - ��ģ�� ��ȣ ���(�������)
 *  
 *  <����Ǯ��>
 *  - ����Ž��?
 */  
public class G04_1_��ƶ��ģ��_0902_����Ž�� {
	static int N, S;
	static int f[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		f = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			f[i][0] = sc.nextInt();
			f[i][1] = sc.nextInt();
		}
		
		double max = 0.0;
		double res = 0.0;
		int f1 = 0, f2 = 0;
		for (int i = 1; i <= N-1; i++) {
			for (int j = i; j <= N; j++) {
				res = Calc(i, j);
				if(max < Calc(i, j)) {
					max = res;
					f1 = i;
					f2 = j;
				}
			}
		}


		System.out.println(f1 + " " + f2);
	}

	private static double Calc(int i, int j) {
		return Math.sqrt(Math.pow(f[i][0]-f[j][0], 2)+Math.pow(f[i][1]-f[j][1], 2));
		
	}
}
