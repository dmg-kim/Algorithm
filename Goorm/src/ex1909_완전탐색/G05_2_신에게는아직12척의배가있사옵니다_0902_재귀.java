package ex1909_완전탐색;

import java.io.*;
import java.util.*;

/*
 * [19년 09월 2주차 - 신에게는 아직 12척의 배가 있사옵니다]
 *  - 11 X 11 
 *  - aij 는 i번째 배가 j 위치에 있을때의 전투력
 *  - 첫째줄에는 아군 전투력 합
 *  - 둘재줄에는 아군의 진형 첫번재배부터
 *  
 *  <문제풀이>
 *  - 완전탐색?
 *  - DFS
 */  
public class G05_2_신에게는아직12척의배가있사옵니다_0902_재귀 {
	static final int N = 11;
	static int map[][];
	static int visited[];
	static int sel[];
	static int max;
	static int f_sel[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		map = new int[N+1][N+1];
		visited = new int[N+1];
		sel = new int[N+1];
		f_sel = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;
		
//		for (int i = 1; i <= N; i++) {
//			sel[1] = i;
//			Arrays.fill(visited, 0);
//			DFS(1, i, map[1][i]);
//		}
		
		DFS(0, 0, 0);
		
		System.out.println(max);
		for (int i = 1; i <= N; i++) {
			System.out.print(f_sel[i] + " ");
		}
		
	}
	public static void DFS(int no, int seq, int sum) {
		// 기저조건: 배 번호가 11번이면 sum과 max 비교하여 max 갱신
		if(no == N) {
			if(max < sum) {
				max = sum;
				for (int i = 1; i <= N; i++) {
					f_sel[i] = sel[i];
				}
			}
			return;
		}
		
		if(visited[seq] == 1) return;
		visited[seq] = 1;
		
		
		for (int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				sel[no+1] = i;
				DFS(no+1, i, sum+map[no+1][i]);
				visited[i] = 0;	// DFS 나오면 해당 위치(i) visited 초기화
			}
		}
	}
}
