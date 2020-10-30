package ex2026;

// ��������: DFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int K, N, F;
	
	// ���� ���
	static int[][] F_Table = new int[901][901];
	
	// Check visited
	static boolean[] visited;
	
	// ��ǳ���� ģ�� ����Ʈ
	static ArrayList<Integer> F_List = new ArrayList<Integer>(); 
	
	// ��ǳ���� ģ�� �ο�
	static int isK = 0;
	
	// ��� ģ����������
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
		
		// ģ������ ���� ���
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			F_Table[x][y] = 1;
			F_Table[y][x] = 1;
		}
		
		// �Է� Ȯ��
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

		
		// ��� ģ�������̰� ��ǳ�ο�(K) ������ ���� ���
		if(isK == K) {
			for (int i = 0; i < F_List.size(); i++) {
				System.out.println(F_List.get(i));
			}
			findAnswer = true;
			return;
		}
		
		// ģ�� �������� üũ and go.
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && F_Table[curr_ver][i] == 1) {
				// ���� �߰��Ǵ� ģ���� ��ǳ���� ģ������ ģ������ üũ
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
				
				// ���� �߰��Ǵ� ģ���� ��ǳ���� ��� ģ������ ģ���� ��� �߰� 
				if(isAllF) {
					DFS(i);
				}
			}
		}
	}
}
