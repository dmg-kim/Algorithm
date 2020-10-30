package b4_2_����_��Ŭ����ȣ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_������_03_��Ŭ����ȣ����_�⺻���� {
	/*
	 * [��Ŭ���� ȣ����]
	 * ���� A, B (A > B)
	 * r = A�� B�� ���� ������
	 * GCD(A, B) = GCD(B, r) ==> ��� �̿�
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		System.out.println("=== �ִ����� ���ϱ� === \n �� ���� �Է��ϼ���.");
		
		st = new StringTokenizer(br.readLine().trim());
		
		int a, b, temp = 0;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		if(a < b) {
			temp = a;	
			a = b; 
			b = temp;
		}
		
		long start, end;
		
		start = System.currentTimeMillis();
		System.out.println(GCD_rec(a, b));
		end = System.currentTimeMillis();
		System.out.println("1) GCD_rec �ҿ�ð�: " + (end - start)/1000 + "." + (end - start)%1000);
		
		start = System.currentTimeMillis();
		System.out.println(GCD_while(a, b));
		end = System.currentTimeMillis();
		System.out.println("2) GCD_while �ҿ�ð�: " + (end - start)/1000 + "." + (end - start)%1000);
	}

	private static int GCD_rec(int a, int b) {
		if(b == 0) return a;	// a��  b�� ������ ������ ���
		else return GCD_rec(b, a % b);
	}
	
	private static int GCD_while(int a, int b) {
		int n = 0;
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}
}
