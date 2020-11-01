package b1_1_자료구조_PQ;

import java.util.*;

public class A_PQ_기본개념 {
	/*
	 * [우선순위 큐(Priority Queue)]
	 *  - Heap 구조를 가지는 자료구조
	 *  - 큐에서 삭제 연산시 가장 우선순위가 높은 값부터 삭제
	 *  - 시간복잡도: O(logN) (데이터 추가 및 삭제시)
	 *  - 기본 자료형(int, float, double 등)의 Comparator 구현없이 Default 유형으로 사용 가능
	 *  - 가능 연산: offer, peek, poll, isEmpty, size
	 */
	public static void main(String[] args) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		pq1.offer(2);
		pq1.offer(7);
		pq1.offer(3);
		pq1.offer(4);
		pq1.offer(9);
		pq1.offer(1);
		pq1.offer(6);
		
		while(!pq1.isEmpty()) {
			System.out.print(pq1.poll() + " " );
		}
		System.out.println();
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq2.offer(2);
		pq2.offer(7);
		pq2.offer(3);
		pq2.offer(4);
		pq2.offer(9);
		pq2.offer(1);
		pq2.offer(6);
		
		while(!pq2.isEmpty()) {
			System.out.print(pq2.poll() + " " );
		}
		System.out.println();
		
		PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				// TODO Auto-generated method stub
				return i2 - i1;
			}
			
		});
		pq3.offer(2);
		pq3.offer(7);
		pq3.offer(3);
		pq3.offer(4);
		pq3.offer(9);
		pq3.offer(1);
		pq3.offer(6);
		
		while(!pq3.isEmpty()) {
			System.out.print(pq3.poll() + " " );
		}
		
	}

}
