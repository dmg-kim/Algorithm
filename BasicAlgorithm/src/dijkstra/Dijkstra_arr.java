package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_arr {
	static int dist[];
	static int adj[][];	// �������(2�� �迭) ����
	static PriorityQueue<Integer> pq;
	static int N, E;
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());	// number of test case
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// ����� ��
			E = Integer.parseInt(st.nextToken());	// ������ ��
			
			adj = new int[N+1][N+1];	// ������� ����
			
			int u, v, w;
			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());	// start
				v = Integer.parseInt(st.nextToken());	// end
				w = Integer.parseInt(st.nextToken());	// distance
				
				adj[u][v] = w;	// ������� 
			}
			
			for (int i = 1; i <= N; i++) {				
				for (int j = 1; j < N; j++) {
					bw.write(adj[i][j] + " ");
				}
				bw.write("\n");
			}
			
			bw.flush();
			bw.close();			
		}
	}
}
