package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_1753 {
	static int T;
	static int N, E;
	static int Start;
	static int Cost[];
	static boolean visited[];
	static ArrayList<Edge> AdjList[];	// ��� ��������Ʈ �迭 ����: Edge Ÿ���� ArrayList�� ������ �迭 ����
	static PriorityQueue<Edge> pq;	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());	// number of test case
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// ����� ��
			E = Integer.parseInt(st.nextToken());	// ������ ��
			
			AdjList = new ArrayList[N+1];	// ��� ��������Ʈ �迭 �ʱ�ȭ(������)
			Cost = new int[N+1];		// �� �������� �Ÿ��� �� ���� �迭
			visited = new boolean[N+1];	// �� ��� �湮 ����
			
			for (int i = 1; i <= N; i++) {
				AdjList[i] = new ArrayList<>();	// ��庰 ���� ���� ��������Ʈ �ʱ�ȭ				
			}
			
			Start = Integer.parseInt(br.readLine());	// ���� ���� �Է� ����
			
			int u, v, w;
			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				
				AdjList[u].add(new Edge(v,w));		// �ش� ��庰 ���� ���� ��������Ʈ ���·� ����
			}
			
			Arrays.fill(Cost, Integer.MAX_VALUE);	// ��� ���������� �Ÿ� ���Ѵ�� �ʱ�ȭ
			
			Cost[Start] = 0;	// �������� 0���� ����
					
			pq = new PriorityQueue<Edge>();
			
			pq.add(new Edge(Start, Cost[Start]));	// ���� ���� ���� ���� Priority Queue�� add
			
			Edge now, next;
			while(!pq.isEmpty()) {
				now = pq.poll();	// ���� ��ġ
				
				// ���� ���� �湮 ���� üũ �� �湮 ó��
				if(visited[now.node]) {
					continue;
				}
				
				visited[now.node] = true;
				
				// ���� ��ġ���� �� �� �ִ� ��� ���� Ȯ��
				for (int i = 0; i < AdjList[now.node].size(); i++) {
					next = AdjList[now.node].get(i);

					// ������ġ������ �Ÿ����� ���� ���������� �Ÿ��� ���� ���� �Ÿ� ���� ��
					if(Cost[next.node] > Cost[now.node] + next.weight) {
						Cost[next.node] = Cost[now.node] + next.weight;	// �� ª�� ��η� �̵��� �� �ִ��� ���Ͽ� �����ϴٸ� �Ÿ� ����
						pq.add(new Edge(next.node, Cost[next.node]));	// ���� ���� ���� Priority Queue�� add
					}					
				}				
			}
			
			for (int i = 1; i <= N; i++) {
				if(Cost[i] == Integer.MAX_VALUE) {
					bw.write("INF" + "\n");
				}
				else {
					bw.write(Cost[i] + "\n");
				}
			}
			
			bw.flush();
			bw.close();			
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int node;
		int weight;
		
		Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

}
