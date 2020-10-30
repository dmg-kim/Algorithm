package dfs;

import java.util.ArrayList;

//DFS(���̿켱Ž��) ���(Recursive) �̿� ����

public class DFS_Recursive {
	
	static int _M_size = 100;	// max number of vertices	
	// Adjacent List(��������Ʈ)
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
