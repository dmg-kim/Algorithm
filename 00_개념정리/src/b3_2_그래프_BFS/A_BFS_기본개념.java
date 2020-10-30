package b3_2_�׷���_BFS;

import java.util.*;

public class A_BFS_�⺻���� {
	/*
	 * [�ʺ�켱Ž��(BFS: Breadth First Search)]
	 *  - �׷����� �湮�ϰų� Ž���ϴ� ��� �� �ϳ�
	 *  - �ִܰŸ�, �ּҺ��� ���� �ּҰ� ���� ����
	 *  - �׷����� ����ġ�� 1�� ���
	 *  - ����
	 *   1. ����� ���� �� ù ��° ������ �����Ͽ� ����� �������� ����
	 *   2. ������ �������� �ؾ��� �۾� ����
	 *   3. ������ ������ ����� ���� �� �湮���� ���� ��� ���� ����
	 *   4. ����� ������ ��� ��尡 ���ŵ� ������ 1~3 �ݺ�
	 *  - ������ �����ϰ� ����� ���� �� ���� ���� ����� ������ �����ϸ� �ش� ������ ���� �۾�
	 *   => Queue(FIFO) ���: ���� ���� ���� �����͸� ���� ó���ϴ� ����
	 */
	static ArrayList<Edge> eList[] = new ArrayList[10];
	static Queue<Integer> q = new LinkedList<Integer>();
	static boolean visited[] = new boolean[10];
	public static void main(String[] args) {
		
		for (int i = 0; i < eList.length; i++) {
			eList[i] = new ArrayList<Edge>();
		}
		
		eList[1].add(new Edge(1, 2));
		eList[1].add(new Edge(1, 3));
		eList[1].add(new Edge(1, 4));
		eList[2].add(new Edge(2, 5));
		eList[3].add(new Edge(3, 5));
		eList[3].add(new Edge(5, 6));
		eList[4].add(new Edge(4, 6));
		eList[6].add(new Edge(6, 7));
		
		BFS(1);

	}
	
	private static void BFS(int n) {
		q.add(n);
		
		int cur;		
		while(!q.isEmpty()) {
			cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			System.out.print(cur + "->");
			int next = 0;
			for (Edge e : eList[cur]) {
				next = e.next;
				if(!visited[next]) q.offer(next);
			}
		}
	}

	static class Edge {
		int node;
		int next;
		
		Edge(int node, int next) {
			this.node = node;
			this.next = next;
		}
	}
}
