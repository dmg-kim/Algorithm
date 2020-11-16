package b3_1_�׷���_DFS;

import java.util.*;

public class A_DFS_�⺻���� {
	/*
	 * [���̿켱Ž��(DFS: Depth First Search)]
	 *  - �׷����� �湮�ϰų� Ž���ϴ� ��� �� �ϳ�
	 *  - ����Ž���̳� ��Ʈ��ŷ�� ���� Ž���� Ƚ��(�׷����� �ִ� ���)�� ������ �ְų� ���� ������ ��쿡 ���
	 *  - ����
	 *   1. ������ �������� �ؾ��� �۾� ����
	 *   2. ������ ������ ����� ���� �� ���� �湮���� ���� ���� �湮
	 *   3. ���� �� �湮�� ������ ���� ��� ���� �������� �ǵ��� ��
	 *   4. 1~3 �ݺ�
	 */
	
	static ArrayList<Edge> eList[] = new ArrayList[10];
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
		eList[5].add(new Edge(5, 6));
		eList[4].add(new Edge(4, 6));
		eList[6].add(new Edge(6, 7));
		
		DFS(1);
	}
	
	private static void DFS(int n) {	
		int cur = n;		
		
		if(visited[cur]) return;		
		visited[cur] = true;
		
		System.out.print(cur + "->");		
		
		int next;
		for (Edge e : eList[cur]) {
			next = e.next;
			if(!visited[next]) {
				DFS(next);
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
