package a00_�˰������;

import java.util.*;

public class A_01_�ڷᱸ��_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// Ư�� ��ġ�� �� �߰�
		list.add(2, 6);
		
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// Ư�� ��ġ �� ����
		list.remove(4);
		
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// Ư�� ���� �� ��ȯ(from ~ to+1)
		List<Integer> subList = list.subList(1, 3);
		
		for (int n : subList) {
			System.out.print(n + " ");
		}
		System.out.println();
		
	}

}
