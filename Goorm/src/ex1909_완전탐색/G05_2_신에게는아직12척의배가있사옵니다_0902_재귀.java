package ex1909_����Ž��;

import java.io.*;
import java.util.*;

/*
 * [19�� 09�� 2���� - �ſ��Դ� ���� 12ô�� �谡 �ֻ�ɴϴ�]
 *  - 11 X 11 
 *  - aij �� i��° �谡 j ��ġ�� �������� ������
 *  - ù°�ٿ��� �Ʊ� ������ ��
 *  - �����ٿ��� �Ʊ��� ���� ù��������
 *  
 *  <����Ǯ��>
 *  - ����Ž��?
 *  - DFS
 */  
public class G05_2_�ſ��Դ¾���12ô�ǹ谡�ֻ�ɴϴ�_0902_��� {
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
		// ��������: �� ��ȣ�� 11���̸� sum�� max ���Ͽ� max ����
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
				visited[i] = 0;	// DFS ������ �ش� ��ġ(i) visited �ʱ�ȭ
			}
		}
	}
}
