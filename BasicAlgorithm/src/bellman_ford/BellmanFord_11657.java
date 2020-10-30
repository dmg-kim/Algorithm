package bellman_ford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BellmanFord_11657 {
	static int N, M;
	static ArrayList<Edge> AdjList;
	static int dist[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		AdjList = new ArrayList<Edge>();		
		
		int a, b, c;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			// 1. ���� ���� ����
			AdjList.add(new Edge(a, b, c));			
		}
		
		dist = new int[N+1];
		
		// 2. ���� ������ ������ ��� ���������� �Ÿ��� ���Ѵ�� ����
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1] = 0;	// 3. ���� ������ �Ÿ� 0 ����
		
		
		boolean updateFlag = false;;
		
		for (int i = 0; i < N; i++) {
			updateFlag = false;	// ���� ����Ŭ ������
			
			for(Edge e : AdjList) {
				// 4.����������� �Ÿ��� ���Ѵ밡 �ƴϰ� , ��������� ������������ �Ÿ��� �̹� ����� �Ÿ����� ª�� ��� �Ÿ� ����
				if(dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.dist) {
					dist[e.end] = dist[e.start] + e.dist;
					updateFlag = true;	// N��° ����� �Ÿ� ������ �Ǹ� ���� ����Ŭ ���� 
//					if(i == N-1) {
//						���� ����Ŭ
//					}
				}
			}
		}
		
		if(updateFlag) {
			bw.write("-1\n");
		}
		else {
			for (int i = 2; i <= N; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					bw.write("-1\n");
				}
				else {
					bw.write(dist[i] + "\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		

	}
	
	static class Edge {
		int start;
		int end;
		int dist;
		
		Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
	}

}
