package bfs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


//BFS(너비우선탐색) 재귀(Recursive)로 구현이 안됨
//=> Queue 활용

public class BFS_Queue {

	static int _M_size = 100;	// max number of vertices
	// Adjacent List(인접리스트)
	static ArrayList<Integer> AdjList[] = new ArrayList[_M_size];
	// check if the vertex is visited
	static boolean visited[] = new boolean[_M_size];
	
	public static void main(String[] args) {

		BFS(1);
	}
	
	public static void BFS(int start_ver) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start_ver);
		visited[start_ver] = true;
		
		while(!Q.isEmpty()) {
			int curr_ver = Q.poll();
			
			// find the next vertex and go.
			for (int i = 0; i < AdjList[curr_ver].size(); i++) {
				if(!visited[AdjList[curr_ver].get(i)]) {
					visited[AdjList[curr_ver].get(i)] = true;
					Q.add(AdjList[curr_ver].get(i));
				}
			}		
		}
	}
}
