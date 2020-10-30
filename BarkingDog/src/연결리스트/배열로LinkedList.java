package ���Ḯ��Ʈ;

import java.util.Arrays;

public class �迭��LinkedList {
	static int MX = 6;
	static int dat[] = new int[MX];
	static int pre[] = new int[MX];
	static int nxt[] = new int[MX];
	static int unused = 1;
	public static void main(String[] args) {
		Arrays.fill(pre, -1);
		Arrays.fill(nxt, -1);
		
		insert_test();
		erase_test();

	}


	private static void insert_test() {
		System.out.println("****** insert_test *****\n");
		insert(0, 10); // 10(address=1)
		traverse();
		insert(0, 30); // 30(address=2) 10
		traverse();
		insert(2, 40); // 30 40(address=3) 10
		traverse();
		insert(1, 20); // 30 40 10 20(address=4)
		traverse();
		insert(4, 70); // 30 40 10 20 70(address=5)
		traverse();
		
//		for (int i = 0; i < dat.length; i++) {
//			System.out.print(dat[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < dat.length; i++) {
//			System.out.print(pre[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < dat.length; i++) {
//			System.out.print(nxt[i] + " ");
//		}
//		System.out.println();
	}
	
	private static void erase_test() {
		System.out.println("****** erase_test *****\n");
		erase(1); // 30 40 20 70
		traverse();
		erase(2); // 40 20 70
		traverse();
		erase(4); // 40 70
		traverse();
		erase(5); // 40
		traverse();
		
	}
	
	private static void insert(int idx, int num) {
		// 1. unused�� ���ο� �� ����
		dat[unused] = num;
		// 2. �� ������ pre�� ���� ������ ��ġ ����
		pre[unused] = idx;
		// 3. �� ������ nxt�� ���� ���� nxt�� ����
		nxt[unused] = nxt[idx];
		// 4. ������ ��ġ�� nxt ���� ���� ��ġ�� pre���� �� ������ ��ġ ����
		if(nxt[idx] != -1) {
			pre[nxt[idx]] = unused;
		}
		nxt[idx] = unused;
		
		// 5. unused�� 1����
		unused++;
	
	}
	
	private static void erase(int idx) {
//		if(nxt[idx] == -1) {
//			nxt[pre[idx]] = -1;
//		}
//		else {
//			// 1. ���� ��ġ�� nxt���� �����ϴ� ���� ���� nxt������ ����
//			nxt[pre[idx]] = nxt[idx];
//			// 2. ���� ��ġ�� pre���� �����ϴ� ���� ���� pre������ ����
//			pre[nxt[idx]] = pre[idx];
//		}
		
		// 1. ���� ��ġ�� nxt���� �����ϴ� ���� ���� nxt������ ����
		nxt[pre[idx]] = nxt[idx];
		// 2. ���� ��ġ�� pre���� �����ϴ� ���� ���� pre������ ����
		if(nxt[idx] != -1) {
			pre[nxt[idx]] = pre[idx];
		}
		
	}
	
	private static void traverse() {
		int cur = nxt[0];
		while(cur != -1) {
			System.out.print(dat[cur] + " ");
			cur = nxt[cur];
		}
		System.out.print("\n\n");
		
	}

}
