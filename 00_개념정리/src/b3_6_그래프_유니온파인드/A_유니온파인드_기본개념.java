package b3_6_�׷���_���Ͽ����ε�;

public class A_���Ͽ����ε�_�⺻���� {
	/*
	 * [���μ� ����(Disjoint-set) / Union-Find]
	 *  - ���Ͽ�: Ư�� �� ��带 �ϳ��� �׷����� ��ġ�� ���Ͽ� ����
	 *  - ���ε�: � ��尡 � �׷쿡 �����ִ°��� Ȯ���ϴ� ���ε� ����
	 */
	static int Group[];
	public static void main(String[] args) {
		int N = 10;
		Group = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}
		
		Union(1, 2);
		
		Find(1);	
	}

	private static int Find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = Find(Group[n]);
	}

	private static void Union(int a, int b) {
		Group[Find(b)] = Find(a);
	}

}
