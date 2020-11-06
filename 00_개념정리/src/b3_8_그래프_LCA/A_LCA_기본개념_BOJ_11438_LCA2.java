package b3_8_그래프_LCA;

import java.io.*;
import java.util.*;

public class A_LCA_기본개념_BOJ_11438_LCA2 {
	/*
	 * [최소공통조상(LCA: Lowest Common Ancestor)]
	 *  - 두 정점의 조상 노드 중 깊이가 가장 깊은 노드 (자기 자신이 될 수도 있음)
	 *  - 트리에서 두 정점(u, v) 사이의 거리를 빠르게 계산하거나 
	 *    두 정점간의 최소값, 최대값, 합계 등을 빠르게 구하는 방법
	 *  - 두 정점간의 최단 경로: u - w(LCA) - v
	 *  
	 *  - 절차
	 *   1. 주어진 정점 두개의 깊이(depth)를 동일하게 맞춘다.
	 *      이때 두 점중 더 깊은 
	 *   2. 두 노드에서 2의 지수승 만큼의 부모가 다른 경우 반복하여 올라가면서 공통조상 찾는다.
	 *  
	 *   - 방법_1
	 *    . 두 정점 중 깊이가 깊은 정점에서 계속 부모로 이동(깊이가 같아질 때까지)
	 *    . 두 정점이 만날때까지 두 정점을 동시에 부모로 이동시켜 만나는 정점이 LCA
	 *    . 시간복잡도: O(N)
	 *   - 방법_2
	 *    . 방법_1과 동일하지만 부모로 이동시키는 것을 좀 더 빨리, 많이 건너뛰도록...
	 *    . parent[u][k]: 정점 u의 2^k번째 부모
	 *    . 2^(k+1) = 2^k + 2^k
	 *      parent[u][k+1] = parent[parent[u][k]][k]
	 *    . k=i일때의 정보가모두 있다면 k=i+1의 정보를 채울수 있음
	 *      bottom up 방식으로 parent 배열 채우기
	 *      1) parent 배열 채우기
	 *      2) depth[u] > depth[v]일때, u를 parent[u]로 대체하는 것을 반복
	 *       - 만약 둘의 깊이 차이가 11이라면 이진수로 1011(2)
	 *         2^0번째 부모 -> 2^1번째 부모 -> 2^3번째 부모를 통해 깊이 동기화
	 *       - 시간복잡도: O(N:깊이차이) -> O(logN)
	 *      3) u != v 일때, u를 parent[u]로 v를 parent[v]로 동시에 대체하는 것을 반복
	 *       - parent[u][k] != parent[v][k]인 상황이라면 
	 *         u, v의 LCA의 깊이는 둘로부터 2^k보다 멀리 떨어져 있는게 확실함
	 *       - parent[u][k+1] == parent[v][k+1] 이라면 2^k~2^(k+1) 사이 어딘가에 LCA 존재
	 *       - k를 큰값부터 시도하면서 순회하여 parent[u][k] == parent[v][k] 찾기
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
