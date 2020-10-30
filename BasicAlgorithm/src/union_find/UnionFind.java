package union_find;

public class UnionFind {
	static int group[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int find(int n) {
		if(group[n] == n) return n;
		return group[n] = find(group[n]);
	}
	
	static void union (int a, int b) {
		group[find(b)] = find(a);
	}

}
