package ex1909_완전탐색;

import java.util.*;

/*
 * [19년 09월 1주차 - 시공의 폭풍속으로]
 *  - 87명의 영웅
 *  - 투임이 5명씩 영웅을 골라 게임
 *  - 우리팀 4명이 선택한 영웅과 내가 선택할수 있는 5명의 영웅이 주어졌을 때 선택할 수 있는 영웅의 수 구하기
 */
public class G01_1_시공의폭풍속으로_0901 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Heros[] = new int[88];
		
		for (int i = 0; i < 4; i++) {
			int n = sc.nextInt();
			Heros[n] = 1;
		}
		
		int Ans = 0;
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if(Heros[n] != 1) Ans++;
		}
		
		System.out.println(Ans);
	}
}
