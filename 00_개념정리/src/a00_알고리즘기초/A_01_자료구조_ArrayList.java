package a00_알고리즘기초;

import java.util.*;

public class A_01_자료구조_ArrayList {

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
		
		// 특정 위치에 값 추가
		list.add(2, 6);
		
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// 특정 위치 값 삭제
		list.remove(4);
		
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// 특정 범위 값 반환(from ~ to+1)
		List<Integer> subList = list.subList(1, 3);
		
		for (int n : subList) {
			System.out.print(n + " ");
		}
		System.out.println();
		
	}

}
