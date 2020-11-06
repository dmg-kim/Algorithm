package b3_8_�׷���_LCA;

import java.io.*;
import java.util.*;

public class B01_BOJ1761_�������ǰŸ� {
	/*  
	 * https://www.acmicpc.net/problem/1761
	 *      
	 */
	static int N, M;
	static int MAX_D;
	static ArrayList<Node> node[];
	static int parent[][];
	static boolean visited[];
	static int dist[];
	static int depth[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		node = new ArrayList[N+1];		
		visited = new boolean[N+1];
		dist = new int[N+1];
		depth = new int[N+1];
		
		// MAX_D ���
		int idx = 1;
		MAX_D = 0;
		while(idx <= N) {
			idx <<= 1;
			MAX_D++;
		}
		
		parent = new int[N+1][MAX_D];
		
		for (int i = 1; i <= N; i++) {
			node[i] = new ArrayList<Node>();
		}
		
		int u, v, d;
		int tmp[] = new int[2];
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			node[u].add(new Node(v, d, 0));
			node[v].add(new Node(u, d, 0));
			
		}
		
		// Depth �� parent ���� �ʱ�ȭ
		buildTree(1);
		
		// parent ���� ä���
		init();
		
//		checkTree();
		
		M = Integer.parseInt(br.readLine().trim());
		
		int lca = 0;
		int ans = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			lca = LCA(u, v);
			ans = dist[u] + dist[v] - (dist[lca]*2);
			bw.append(ans + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	// BFS�� depth �� �ʱ� parent ���� ����
	public static void buildTree(int root) {
		Queue<Integer> q = new LinkedList<Integer>();		
		q.add(root);		
		dist[root] = 0;
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(visited[cur]) continue;			
			visited[cur] = true;			
			for (Node next : node[cur]) {
				if(!visited[next.child]) {
					depth[next.child] = depth[cur] + 1;					
					dist[next.child] = dist[cur] + next.dist;
					parent[next.child][0] = cur;
					q.add(next.child);
				}
			}
		}
	}

	public static int LCA(int u, int v) {
		
		// u�� ���̰� v�� ���̺��� ���� �ɷ� ó��
		//  - v�� ���̰� u�� ���̺��� ���� ��� swap ó��
		int temp = 0;
		if(depth[u] < depth[v]) {
			temp = u;
			u = v;
			v = temp;
		}
		
		// u�� ���̸� v�� ���̿� �����ϰ� ������
		for (int j = MAX_D-1; j >= 0; j--) {
			if((1 << j) <= depth[u] - depth[v]) {
				u = parent[u][j];
			}
		}
		
		// ���� ����ȭ �� u�� v�� ������ ��� �״�� LCA ���� 
		if(u == v) return u;
		
		// ���̸� ���߸鼭 LCA ã��
		for (int j = MAX_D - 1; j >= 0; j--) {
			if(parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}
		return parent[u][0];
	}

	public static void init() {
		for (int j = 1; j < MAX_D; j++) {
			for (int i = 1; i <= N; i++) {
				if(parent[i][j-1] != 0) {
					parent[i][j] = parent[parent[i][j-1]][j-1];
				}
			}
		}
	}
		
	public static void checkTree() {
		for (int i = 1; i <= N; i++) {
			System.out.print(dist[i] + " " );
		}
		System.out.println();
		
		for (int i = 1; i <= N; i++) {
			System.out.print(depth[i] + " " );
		}
		System.out.println();
		
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < MAX_D; j++) {
				System.out.print(parent[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	static class Node {
		int child;
		int dist;
		int depth;
		
		Node(int child, int dist, int depth) {
			this.child = child;
			this.dist = dist;
			this.depth = depth;
		}
	}
}
