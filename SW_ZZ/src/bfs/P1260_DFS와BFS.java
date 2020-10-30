package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1260_DFS와BFS {
	
	static int N, M, V;
	static ArrayList<Integer>[] AdjList = new ArrayList[1001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			AdjList[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			AdjList[a].add(b);
			AdjList[b].add(a);
		}
		
		// 정점 번호가 작은것부터 방문하기 위해 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(AdjList[i]);
		}
		
		DFS(V);
		
		BFS(V);
		

	}

	// DFS - Stack 사용(배열)
	public static void DFS(int v) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int stack[] = new int[M];	// 간선의 크기 만큼
		int stkIdx = 0;
		int cur = v;
		int next = 0;
		boolean visited[] = new boolean[N+1];
		
		stack[0] = cur;

		while(stkIdx >= 0) {
			cur = stack[stkIdx--];
			
			if(!visited[cur]) {
				visited[cur] = true;
				bw.append(cur + " ");
			}			
			
			for (int i = 0; i < AdjList[cur].size(); i++) {
				next = AdjList[cur].get(AdjList[cur].size()-1-i);
				
				if(!visited[next]) {
					stack[++stkIdx] = next;
				}
			}
		}
		bw.append("\n");
		bw.flush();
		
	}
	
	// DFS - Stack 사용(Stack 자료구조)
//	public static void DFS(int v) throws Exception {
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		Stack<Integer> s = new Stack<Integer>();
//		int cur = v;
//		int next = 0;
//		boolean visited[] = new boolean[N+1];
//
//		s.push(cur);
//
//		while(!s.isEmpty()) {
//			cur = s.pop();
//			
//			if(!visited[cur]) {
//				visited[cur] = true;
//				bw.append(cur + " ");
//			}			
//			
//			for (int i = 0; i < AdjList[cur].size(); i++) {
//				next = AdjList[cur].get(AdjList[cur].size()-1-i);
//				
//				if(!visited[next]) {
//					s.push(next);
//					
//				}
//			}
//		}
//		bw.append("\n");
//		bw.flush();
//		
//	}
	
	// BFS - Queue 사용
	public static void BFS(int v) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		int cur = v;
		int next = 0;
		boolean visited[] = new boolean[N+1];
		
		q.add(v);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			if(!visited[cur]) {
				visited[cur] = true;
				bw.append(cur + " ");
			}
			
			for (int i = 0; i < AdjList[cur].size(); i++) {
				next = AdjList[cur].get(i);
				
				if(!visited[next]) {
					q.add(next);
				}
			}
		}
		
		bw.flush();
		bw.close();
	}

}
