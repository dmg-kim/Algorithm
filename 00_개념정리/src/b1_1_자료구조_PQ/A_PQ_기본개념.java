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
		
		System.out.println("[PQ1: int�� �������� ����]");
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
		
		System.out.println("[PQ2: int�� �������� ����] - Collections.reversOrder() ���");
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
		
		System.out.println("[PQ3: int�� �������� ����] - pq ����� Comparator ���");
		while(!pq3.isEmpty()) {
			System.out.print(pq3.poll() + " " );
		}
		System.out.println();
		
		PriorityQueue<Temp1> pq4 = new PriorityQueue<Temp1>(new Comparator<Temp1>() {
			@Override
			public int compare(Temp1 t1, Temp1 t2) {
				if(t1.x != t2.x) return t1.x-t2.x;
				else return t1.y - t2.y;
			}
			
		}); 
		
		pq4.offer(new Temp1(2, 1));
		pq4.offer(new Temp1(1, 4));
		pq4.offer(new Temp1(5, 6));
		pq4.offer(new Temp1(3, 8));
		pq4.offer(new Temp1(2, 5));
		pq4.offer(new Temp1(1, 2));
		
		System.out.println("[PQ4: ��ü(x,y) ����] - pq ����� Comparator ���");
		Temp1 tmp1;
		while(!pq4.isEmpty()) {
			tmp1 = pq4.poll();
			System.out.print("(" + tmp1.x + ", " + tmp1.y  + ") ");
		}
		System.out.println();
		
		PriorityQueue<Temp2> pq5 = new PriorityQueue<Temp2>();
		
		pq5.offer(new Temp2(2, 1));
		pq5.offer(new Temp2(1, 4));
		pq5.offer(new Temp2(5, 6));
		pq5.offer(new Temp2(3, 8));
		pq5.offer(new Temp2(2, 5));
		pq5.offer(new Temp2(1, 2));
		
		System.out.println("[PQ5: ��ü(x,y) ����] - ��ü Comparable implements");
		Temp2 tmp2;
		while(!pq5.isEmpty()) {
			tmp2 = pq5.poll();
			System.out.print("(" + tmp2.x + ", " + tmp2.y  + ") ");
		}
		System.out.println();
		
		ArrayList<Temp1> tList = new ArrayList<Temp1>();
		
		tList.add(new Temp1(2, 1));
		tList.add(new Temp1(1, 4));
		tList.add(new Temp1(5, 6));
		tList.add(new Temp1(3, 8));
		tList.add(new Temp1(2, 5));
		tList.add(new Temp1(1, 2));
		
		tList.sort(Comparator.comparingInt(t -> t.x));
		
		System.out.println("[ArrayList: ��ü(x,y) ����] - Array.sort(Comparator.comparingInt");
		for (Temp1 t : tList) {
			System.out.print("(" + t.x + ", " + t.y  + ") ");
		}
		System.out.println();
	}
	
	static class Temp1 {
		int x, y;
		
		Temp1(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Temp2 implements Comparable<Temp2> {
		int x;
		int y;
		
		Temp2(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Temp2 t) {
			if(this.x != t.x) return this.x - t.x;
			else return this.y - t.y;
		}
		
		
	}

}
