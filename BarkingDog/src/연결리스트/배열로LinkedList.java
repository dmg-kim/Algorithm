package 연결리스트;

import java.util.Arrays;

public class 배열로LinkedList {
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
		// 1. unused에 새로운 값 생성
		dat[unused] = num;
		// 2. 새 원소의 pre에 현재 삽입한 위치 저장
		pre[unused] = idx;
		// 3. 새 원소의 nxt에 기존 값의 nxt값 저장
		nxt[unused] = nxt[idx];
		// 4. 삽입할 위치의 nxt 값과 다음 위치의 pre값에 새 원소의 위치 저장
		if(nxt[idx] != -1) {
			pre[nxt[idx]] = unused;
		}
		nxt[idx] = unused;
		
		// 5. unused값 1증가
		unused++;
	
	}
	
	private static void erase(int idx) {
//		if(nxt[idx] == -1) {
//			nxt[pre[idx]] = -1;
//		}
//		else {
//			// 1. 이전 위치의 nxt값을 삭제하는 현재 값의 nxt값으로 변경
//			nxt[pre[idx]] = nxt[idx];
//			// 2. 다음 위치의 pre값을 삭제하는 현재 값의 pre값으로 변경
//			pre[nxt[idx]] = pre[idx];
//		}
		
		// 1. 이전 위치의 nxt값을 삭제하는 현재 값의 nxt값으로 변경
		nxt[pre[idx]] = nxt[idx];
		// 2. 다음 위치의 pre값을 삭제하는 현재 값의 pre값으로 변경
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
