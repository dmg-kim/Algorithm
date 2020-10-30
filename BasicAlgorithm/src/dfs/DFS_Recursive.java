package dfs;

import java.util.ArrayList;

//DFS(깊이우선탐색) 재귀(Recursive) 이용 구현

public class DFS_Recursive {
	
	static int _M_size = 100;	// max number of vertices	
	// Adjacent List(인접리스트)
	static ArrayList<Integer> AdjList[] = new ArrayList[_M_size];	
	// check if the vertex is visited
	static boolean visited[] = new boolean[_M_size];
	
	public static void main(String[] args) {
		
		DFS(0);
		

	}

	public static void DFS(int curr_ver) {
		visited[curr_ver] = true;
			
		// find the next vertex and go.
		for (int i = 0; i < AdjList[curr_ver].size(); i++) {
			if(!visited[AdjList[curr_ver].get(i)]) {
				DFS(AdjList[curr_ver].get(i));
			}
		}
	}
}
