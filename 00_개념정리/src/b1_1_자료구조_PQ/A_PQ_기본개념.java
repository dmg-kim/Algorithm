package b1_1_�ڷᱸ��_PQ;

import java.util.*;

public class A_PQ_�⺻���� {
	/*
	 * [�켱���� ť(Priority Queue)]
	 *  - Heap ������ ������ �ڷᱸ��
	 *  - ť���� ���� ����� ���� �켱������ ���� ������ ����
	 *  - �ð����⵵: O(logN) (������ �߰� �� ������)
	 *  - �⺻ �ڷ���(int, float, double ��)�� Comparator �������� Default �������� ��� ����
	 *  - ���� ����: offer, peek, poll, isEmpty, size
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
