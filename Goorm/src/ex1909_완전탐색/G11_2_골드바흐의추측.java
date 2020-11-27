package ex1909_����Ž��;

import java.io.*;
import java.util.*;

/*
 * [19�� 09�� 4���� - �������� ����(2)]
 *  - 2���� ū ��� ¦���� �ΰ��� �Ҽ��� ������ ǥ�� ����
 *  - N: ���� ����(1~1000)
 *  - ai: ¦��(4~100��)
 *  
 *  <����Ǯ��>
 *  - �Ҽ�: �����佺�׳׽��� ü
 *  - 100������ �Ҽ����ϱ�
 */ 
public class G11_2_������������ {
	static final int MAX = 1000000;	
	static int p[] = new int[1000001];
	static long N;
	static ArrayList<Integer> pList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		getPrime();
		
		pList = new ArrayList<Integer>();
		for (int i = 1; i <= MAX ; i++) {
			if(p[i] == 0) pList.add(i);
		}
		
		int gno = 0;
		for (int i = 0; i < N; i++) {
			gno = sc.nextInt();
			int s = 0;
			int e = pList.size()-1;
			int Ans1 = 0, Ans2 = 0;
			while(s <= e) {
				if(gno < pList.get(s) + pList.get(e)) {
					e--;
				}
				else if(gno > pList.get(s) + pList.get(e)) {
					s++;
				}
				else {
					Ans1 = pList.get(s);
					Ans2 = pList.get(e);
					
					s++;
					e--;
				}
			}
			System.out.println(Ans1 + " " + Ans2);
		}
	}

	public static void getPrime() {
		p[0] = 1;
		p[1] = 1;
		for (int i = 2; i*i <= MAX; i++) {
			for (int j = i*i; j <= MAX; j+=i) {
				p[j] = 1;
			}
		}		
	}	
}

