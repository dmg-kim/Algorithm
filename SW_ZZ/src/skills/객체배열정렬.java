package skills;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ��ü�迭���� {
	public static void main(String[] args) {
		People[] peoples = { new People("����", 20), new People("ö��", 14), new People("���", 31), new People("��ȣ", 40),
				new People("����", 24) };

		Arrays.sort(peoples); // �������� ����

		for (People i : peoples) { // �������� ���
			System.out.print("[" + i.name + "]");
		}
		System.out.println();

		Arrays.sort(peoples, Collections.reverseOrder()); // �������� ����
		

		for (People i : peoples) { // �������� ���
			System.out.print("[" + i.name + "]");
		}
		System.out.println();
		
		Arrays.sort(peoples);
		
		Animal[] animals = { new Animal("�䳢", 14, 10), new Animal("����", 31, 25), new Animal("������", 20, 15), new Animal("�ڳ���", 40, 200),
				new Animal("����", 24, 100) };
		
		Arrays.sort(animals, 0, 5, new Comparator<Animal>() {
			public int compare(Animal a1, Animal a2) {
				return a1.age - a2.age;
			}
		});
		
		for (Animal i : animals) { // �������� ���
			System.out.print("[" + i.name + "]");
		}
		System.out.println();

		
		Arrays.sort(animals, 0, 5, new Comparator<Animal>() {
			public int compare(Animal a1, Animal a2) {
				return a2.weight - a1.weight;
			}
		});
		
		for (Animal i : animals) { // �������� ���
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
