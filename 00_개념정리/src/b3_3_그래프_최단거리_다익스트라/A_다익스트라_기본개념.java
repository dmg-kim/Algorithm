package b3_3_�׷���_�ִܰŸ�_���ͽ�Ʈ��;

import java.util.*;

public class A_���ͽ�Ʈ��_�⺻���� {
	/*
	 * [���ͽ�Ʈ��(Dijkstra)]
	 *  - �ִ� ��θ� ã�� ���� ����ϴ� �˰���
	 *  - ��������κ��� ��� ���������� �ִܰŸ� ���
	 *  - �ð����⵵: O(ElogV) (V: ������ ��, E: ������ ��)
	 *  - ���� �Ǵ� ���� �׷���
	 *  - �Ÿ�(����ġ)�� ������ ���� ��� �Ұ� => ���� ����
	 *  - ����
	 *   1. �������� ����
	 *   2. ���������� ������ ��� ���������� �Ÿ��� ���Ѵ�� ����
	 *   3. ���� ��ġ���� �� �� �ִ� ��� ���� Ȯ��
	 *      ���� �ش� ������ ������� ����� �Ÿ����� �� ª�� ��η� �̵��� �� �ִٸ� �Ÿ� ����
	 *      �׷��� �ʴٸ� Skip
	   *      ��4. ���� �������� �ʾҴ� ������ �� ���� ª�� �Ÿ��� �ִ� ������ ���� �������� ����
	 *    => �켱���� ť(Priority Queue) ���
	 *   5. 3~4 �ݺ�
	 */
	static ArrayList<Edge> eList[] = new ArrayList[10];
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static boolean visited[] = new boolean[10];
	static int dist[] = new int[10];
	static final int INF = 999;
	static int ans;
	public static void main(String[] args) {
		for (int i = 0; i < eList.length; i++) {
			eList[i] = new ArrayList<Edge>();
		}
		
		eList[1].add(new Edge(2, 1));
		eList[1].add(new Edge(4, 5));
		eList[2].add(new Edge(3, 2));
		eList[3].add(new Edge(4, 1));
		eList[3].add(new Edge(5, 5));
		eList[3].add(new Edge(7, 3));
		eList[4].add(new Edge(6, 3));
		eList[4].add(new Edge(7, 3));
		eList[6].add(new Edge(7, 2));
		
		Arrays.fill(dist, INF);

		Dijkstra(1);
		
		for (int i = 1; i <= 7; i++) {
			ans += dist[i];
		}
		
		System.out.println("Total Cost: "  + ans);
	}
	
	private static void Dijkstra(int s) {
		pq.clear();
		
		pq.offer(new Edge(s, 0));
		dist[s] = 0;
		
		Edge cur;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			if(visited[cur.node]) continue;
			visited[cur.node] = true;
			
			int next;
			for (Edge e : eList[cur.node]) {
				next = e.node;
				if(dist[next] > dist[cur.node] + e.dist) {
					dist[next] = dist[cur.node] + e.dist;
					pq.offer(new Edge(next, dist[next]));
				}
			}	
		}
	}

	static class Edge implements Comparable<Edge>{
		int node;
		int dist;
		
		Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return this.dist - e.dist;
		}
	}

}
