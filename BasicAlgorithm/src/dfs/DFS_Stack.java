package dfs;

import java.util.ArrayList;
import java.util.LinkedList;

//DFS(깊이우선탐색) Stack 이용 구현

public class DFS_Stack {

	static int _M_size = 100;	// max number of vertices

	// Adjacent List(인접리스트)
	static ArrayList<Integer> AdjList[] = new ArrayList[_M_size];
	
	// check if the vertex is visited
	static boolean visited[] = new boolean[_M_size];
	
	// using LinkedList instead Stack(performanc issue)
	static LinkedList<int[]> S = new LinkedList<>();
		
	public static void main(String[] args) {

		DFS(1);

	}

	public static void DFS(int start_ver) {
		int order = -1;
		int i;
		
		// initialize visited
		for (i = 0; i < _M_size; i++) {
			visited[i] = false;
		}
		
		visited[start_ver] = true;
		S.addLast(new int[] {start_ver, -1});
		
		// find the next vertex and go
		while(!S.isEmpty()) {
			int curr_ver = S.getLast()[0];
			
			for (i = order + 1; i < AdjList[curr_ver].size(); i++) {
				int next_ver = AdjList[curr_ver].get(i);
				
				if(!visited[next_ver]) {
					visited[next_ver] = true;
					S.addLast(new int[] {next_ver, i});
					order = -1;
					break;
				}
			}
		}
		
	}

}
