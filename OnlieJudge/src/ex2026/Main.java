package ex2026;

// 문제유형: DFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int K, N, F;
	
	// 인접 행렬
	static int[][] F_Table = new int[901][901];
	
	// Check visited
	static boolean[] visited;
	
	// 소풍가는 친구 리스트
	static ArrayList<Integer> F_List = new ArrayList<Integer>(); 
	
	// 소풍가는 친구 인원
	static int isK = 0;
	
	// 모두 친구관계인지
	static boolean isAllF = false;
	
	static boolean findAnswer = false;
	
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		int x, y;
		
		// 친구관계 인접 행렬
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			F_Table[x][y] = 1;
			F_Table[y][x] = 1;
		}
		
		// 입력 확인
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(F_Table[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i <= N; i++) {
			F_List.clear();
			isK = 0;
			visited  = new boolean[N + 1];
			DFS(i);
			if(findAnswer) {
				return;
			}
		}
		
		if(!findAnswer) {
			System.out.println(-1);
		}
	}

	public static void DFS(int curr_ver) {
		visited[curr_ver] = true;
		F_List.add(curr_ver);
		isK++;

		
		// 모두 친구관계이고 소풍인원(K) 만족시 정답 출력
		if(isK == K) {
			for (int i = 0; i < F_List.size(); i++) {
				System.out.println(F_List.get(i));
			}
			findAnswer = true;
			return;
		}
		
		// 친구 관계인지 체크 and go.
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && F_Table[curr_ver][i] == 1) {
				// 새로 추가되는 친구가 소풍가는 친구들의 친구인지 체크
				isAllF = true;
				for (int j = 0; j < F_List.size(); j++) {
					if(F_Table[F_List.get(j)][i] == 1) {
						isAllF = true;
					}
					else {
						isAllF = false;
						break;
					}
				}
				
				// 새로 추가되는 친구가 소풍가는 모든 친구들의 친구인 경우 추가 
				if(isAllF) {
					DFS(i);
				}
			}
		}
	}
}
