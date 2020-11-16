package b3_6_�׷���_���Ͽ����ε�;

import java.io.*;
import java.util.*;

/*
 * [BOJ_1976_���డ��]
 *  - https://www.acmicpc.net/problem/1976
 * 
 * �����̴� ģ����� �Բ� ������ ������ �Ѵ�. 
 * �ѱ����� ���ð� N�� �ְ� ������ �� ���� ���̿� ���� ���� ����, ���� ���� �ִ�. 
 * �������� ���� ������ �־����� ��, �� ���� ��ΰ� ������ ������ �˾ƺ���. 
 * ���� �߰��� �ٸ� ���ø� �����ؼ� ������ �� ���� �ִ�. 
 * ���� ��� ���ð� 5�� �ְ�, A-B, B-C, A-D, B-D, E-A�� ���� �ְ�, �������� ���� ��ȹ�� E C B C D ��� E-A-B-C-B-C-B-D��� �����θ� ���� ������ �޼��� �� �ִ�.
 * ���õ��� ������ ���õ� ���� ���� ���ΰ� �־��� �ְ�, �������� ���� ��ȹ�� ���� ���õ��� ������� �־����� ��(�ߺ� ����) �������� ���θ� �Ǻ��ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [����Ǯ��]
 *  1. �Է¹��� ������ union ��Ŵ
 *  2. ���డ���� �ϴ� ���� ���� find�Ͽ� ��� ��ġ�ϴ��� üũ
 */
public class B01_BOJ_01976_���డ�� {
	static int N, M;
	static int m[][];
	static int g[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		
		g = new int[N+1];
		m = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			g[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if(m[i][j] == 1) {
					Union(i, j);
				}
			}	
		}
		
		st = new StringTokenizer(br.readLine());
		boolean chk = true;
		
		int root = Find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			if(root != Find(Integer.parseInt(st.nextToken()))) {
				chk = false;
				break;
			}
		}
		
		if(!chk) bw.append("NO\n");
		else bw.append("YES\n");
		
		bw.flush();
		bw.close();
	}



	public static void Union(int a, int b) {
		g[Find(b)] = Find(a);
	}

	public static int Find(int n) {
		if(g[n] == n) return g[n];		
		return g[n] = Find(g[n]);
	}
	
	
}
