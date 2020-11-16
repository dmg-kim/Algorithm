package b3_6_그래프_유니온파인드;

public class A_유니온파인드_기본개념 {
	/*
	 * [서로소 집합(Disjoint-set) / Union-Find]
	 *  - 유니온: 특정 두 노드를 하나의 그룹으로 합치는 유니온 연산
	 *  - 파인드: 어떤 노드가 어떤 그룹에 속해있는가를 확인하는 파인드 연산
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
