package dfs;

import java.util.ArrayList;
import java.util.LinkedList;

//DFS(깊이우선탐색) Stack 이용 구현

public class DFS_Stack_Array {

	static int N = 100;	// max number of vertices

	// Adjacent List(인접리스트)
	static ArrayList<Integer> AdjList[] = new ArrayList[N];
	
	// check if the vertex is visited
	static boolean visited[] = new boolean[N];
	
	public static void main(String[] args) {

		DFS(1);

	}

	public static void DFS(int start_ver) {
		int stack[] = new int[N];
		int stkIdx = 0;
		int cur = start_ver;
		int next = 0;
		
		stack[0] = cur;
		
		// find the next vertex and go
		while(stkIdx >= 0) {
			cur = stack[stkIdx--];
			
			for (int i = 0; i < AdjList[cur].size(); i++) {
				next = AdjList[cur].get(i);
				
				if(!visited[next]) {
					visited[next] = true;
					stack[++stkIdx] = next;
				}
			}
		}
	}
}
