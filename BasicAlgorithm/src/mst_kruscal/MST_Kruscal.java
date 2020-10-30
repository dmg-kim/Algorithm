package mst_kruscal;

import java.util.ArrayList;
import java.util.Comparator;

public class MST_Kruscal {
	static ArrayList<Edge> edgeList;
	static int group[];
	static int totalCost;
	
	class Edge {
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}	
	
	public static void main(String[] args) {
				
		// ���(Cost)�������� ����
		edgeList.sort(Comparator.comparingInt(e -> e.cost));
		
		// ���İ� �������� ���� ����
		for(Edge now: edgeList) {
			// ����Ŭ�� �ƴϸ�
			if(find(now.start) != find(now.end)) {
				union(now.start, now.end);
				totalCost += now.cost;
			}
		}

	}
	
	static int find(int n) {
		if(group[n] == n) return n;
		return group[n] = find(group[n]);
	}
	
	static void union (int a, int b) {
		group[find(b)] = find(a);
	}
}
