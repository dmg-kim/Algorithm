package skills;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 객체배열정렬 {
	public static void main(String[] args) {
		People[] peoples = { new People("상현", 20), new People("철수", 14), new People("경완", 31), new People("대호", 40),
				new People("지운", 24) };

		Arrays.sort(peoples); // 오름차순 정렬

		for (People i : peoples) { // 오름차순 출력
			System.out.print("[" + i.name + "]");
		}
		System.out.println();

		Arrays.sort(peoples, Collections.reverseOrder()); // 내림차순 정렬
		

		for (People i : peoples) { // 내림차순 출력
			System.out.print("[" + i.name + "]");
		}
		System.out.println();
		
		Arrays.sort(peoples);
		
		Animal[] animals = { new Animal("토끼", 14, 10), new Animal("염소", 31, 25), new Animal("강아지", 20, 15), new Animal("코끼리", 40, 200),
				new Animal("사자", 24, 100) };
		
		Arrays.sort(animals, 0, 5, new Comparator<Animal>() {
			public int compare(Animal a1, Animal a2) {
				return a1.age - a2.age;
			}
		});
		
		for (Animal i : animals) { // 오름차순 출력
			System.out.print("[" + i.name + "]");
		}
		System.out.println();

		
		Arrays.sort(animals, 0, 5, new Comparator<Animal>() {
			public int compare(Animal a1, Animal a2) {
				return a2.weight - a1.weight;
			}
		});
		
		for (Animal i : animals) { // 오름차순 출력
			System.out.print("[" + i.name + "]");
		}

	}

	static public class People implements Comparable<People> {

		String name;
		int age;

		 People(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(People p) {
			return this.age - p.age;
		}
	}
	
	static public class Animal {
		String name;
		int age;
		int weight;
		
		Animal(String name, int age, int weight) {
			this.name = name;
			this.age = age;
			this.weight = weight;
		}
	}

}
