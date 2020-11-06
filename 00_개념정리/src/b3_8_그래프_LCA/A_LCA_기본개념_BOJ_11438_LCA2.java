package b3_8_�׷���_LCA;

import java.io.*;
import java.util.*;

public class A_LCA_�⺻����_BOJ_11438_LCA2 {
	/*
	 * [�ּҰ�������(LCA: Lowest Common Ancestor)]
	 *  - �� ������ ���� ��� �� ���̰� ���� ���� ��� (�ڱ� �ڽ��� �� ���� ����)
	 *  - Ʈ������ �� ����(u, v) ������ �Ÿ��� ������ ����ϰų� 
	 *    �� �������� �ּҰ�, �ִ밪, �հ� ���� ������ ���ϴ� ���
	 *  - �� �������� �ִ� ���: u - w(LCA) - v
	 *  
	 *  - ����
	 *   1. �־��� ���� �ΰ��� ����(depth)�� �����ϰ� �����.
	 *      �̶� �� ���� �� ���� 
	 *   2. �� ��忡�� 2�� ������ ��ŭ�� �θ� �ٸ� ��� �ݺ��Ͽ� �ö󰡸鼭 �������� ã�´�.
	 *  
	 *   - ���_1
	 *    . �� ���� �� ���̰� ���� �������� ��� �θ�� �̵�(���̰� ������ ������)
	 *    . �� ������ ���������� �� ������ ���ÿ� �θ�� �̵����� ������ ������ LCA
	 *    . �ð����⵵: O(N)
	 *   - ���_2
	 *    . ���_1�� ���������� �θ�� �̵���Ű�� ���� �� �� ����, ���� �ǳʶٵ���...
	 *    . parent[u][k]: ���� u�� 2^k��° �θ�
	 *    . 2^(k+1) = 2^k + 2^k
	 *      parent[u][k+1] = parent[parent[u][k]][k]
	 *    . k=i�϶��� ��������� �ִٸ� k=i+1�� ������ ä��� ����
	 *      bottom up ������� parent �迭 ä���
	 *      1) parent �迭 ä���
	 *      2) depth[u] > depth[v]�϶�, u�� parent[u]�� ��ü�ϴ� ���� �ݺ�
	 *       - ���� ���� ���� ���̰� 11�̶�� �������� 1011(2)
	 *         2^0��° �θ� -> 2^1��° �θ� -> 2^3��° �θ� ���� ���� ����ȭ
	 *       - �ð����⵵: O(N:��������) -> O(logN)
	 *      3) u != v �϶�, u�� parent[u]�� v�� parent[v]�� ���ÿ� ��ü�ϴ� ���� �ݺ�
	 *       - parent[u][k] != parent[v][k]�� ��Ȳ�̶�� 
	 *         u, v�� LCA�� ���̴� �ѷκ��� 2^k���� �ָ� ������ �ִ°� Ȯ����
	 *       - parent[u][k+1] == parent[v][k+1] �̶�� 2^k~2^(k+1) ���� ��򰡿� LCA ����
	 *       - k�� ū������ �õ��ϸ鼭 ��ȸ�Ͽ� parent[u][k] == parent[v][k] ã��
	 *      
	 */
	static int N, M;
	static int MAX_D;
	static ArrayList<Integer> eList[];
	static int depth[];
	static int parent[][];
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		eList = new ArrayList[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		int idx = 1;
		MAX_D = 0;
		while(idx <= N) {
			idx <<= 1;
			MAX_D++;
		}
		
		parent = new int[N+1][MAX_D];
		
		for (int i = 1; i <= N; i++) {
			eList[i] = new ArrayList<Integer>();
		}
		
		int u, v;
		for (int i = 1; i <= N-1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			eList[u].add(v);
			eList[v].add(u);
		}
		
		buildTree(1);
		
		init();
		
//		checkTree();
		
		M = Integer.parseInt(br.readLine().trim());
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			bw.append(LCA(u, v) + "\n");
		}
		
		bw.flush();
		bw.close();
	}

	public static void buildTree(int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(root);
		depth[root] = 0;		
		int cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(visited[cur]) continue;
			
			visited[cur] = true;
			
			for (int next : eList[cur]) {
				if(!visited[next]) {
					depth[next] = depth[cur]+1;
					parent[next][0] = cur;
					q.add(next);
				}
			}
		}
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

	public static int LCA(int u, int v) {
		int temp = 0;
		if(depth[u] < depth[v]) {
			temp = u;
			u = v;
			v = temp;
		}
		
		for (int j = MAX_D-1; j >= 0; j--) {
			if((1 << j) <= depth[u]-depth[v]) {
				u = parent[u][j];
			}
		}
		
		if(u == v) return u;
		
		for (int j = MAX_D - 1; j >= 0; j--) {
			if(parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}
		return parent[u][0];
	}
		
	public static void checkTree() {
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
		
}
