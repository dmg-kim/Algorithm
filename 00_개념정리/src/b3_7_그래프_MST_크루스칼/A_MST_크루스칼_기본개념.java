package b3_7_�׷���_MST_ũ�罺Į;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class A_MST_ũ�罺Į_�⺻���� {
	/*
	 * 	[�ּҽ���Ʈ��(MST: Minimum Spaning Tree)]
	 *  - ����ġ�� ���� �ּ��� �ּ� ���� �κ� �׷���
	 *   . �κ� �׷���: � �׷����� �����ϰ� �ִ� ������ ��� �Ϻΰ� ���ŵ� �׷���
	 *   . ���� �׷���: �׷����� �����ϴ� ��� �� ���� ���̿� ��ΰ� �����ϴ� �׷���
	 *   . �ּ� ���� �κ� �׷���: ������ ���� �ּҷ� �̿��Ͽ� ���� �� �ִ� ���� �׷���
	 *  - �ϳ��� �׷������� �������� Spanning Tree ������ �� ����
	 *  - �ִ� ��� ���ϱ�ʹ� �ٸ��� ��� �������� �����ϱ⸸ �ϸ��
	 *    �� �ִ� ��δ� ���� ������ ��� ���� ������ �ִܰŸ� ���ؾ���
	 *  - MST: ũ�罺Į(Kruskal), ����(Prim)
	 *  
	 * [ũ�罺Į(Kruskal)]
	 *  - �ð����⵵: O(ElogV) (V: ������ ��, E: ������ ��)
	 *  - ������ �����Ͽ� ����
	 *   : ����Ŭ Ȯ�� �ʿ� => ���Ͽ�-���ε�
	 *  - ����
	 *   1. �������� ����ġ ������ �������� ����
	 *   2. ���� ������ �������� �̾Ƴ� ���� ������ ������ ������Ʈ�� ����Ǿ� ���� ������(Group ��ǥ���� �ٸ���) �׷���
	 *   3. ���� V-1���� �������� �� ������� �������� �̷�� �׷����� MST
	 *   
	 *  - ����
	 *   1. ���� �� �������� �������� ����
	 *   2. ���� ������ ���� ����(����Ŭ �߻��� �̼���) �� �׷���
	 */
	static int V;
	static int E;
	static int group[];
	static ArrayList<Edge> eList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		group = new int[V+1];
		eList = new ArrayList<Edge>();
		int f, t, c;
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			eList.add(new Edge(f, t, c));
		}
		
		Collections.sort(eList);
		
		for (int i = 1; i <= V; i++) {
			group[i] = i;
		}
		
		long totalCost = 0L;
		int conn = 0;
		for (Edge e : eList) {
			if(Find(e.from) != Find(e.to)) {
				Union(e.from, e.to);
				totalCost += e.cost;
				conn++;
			}
			
			if(conn == V-1) break;
			
		}
		
		if(conn != V-1) {
			totalCost = -1;
		}

		System.out.println(totalCost);
		return;
		
		
	}

	private static void Union(int a, int b) {
		group[Find(b)] = Find(a);
		
	}

	private static int Find(int n) {
		if(group[n] == n) return n;
		else return group[n] = Find(group[n]);
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.cost - e.cost;
		}
		
	}

}
