package b3_1_�׷���_DFS;

import java.io.*;
import java.util.*;

/*
 *  https://www.acmicpc.net/problem/11266
 */
public class A_02_������_�⺻���� {
	static int V, E;
	static ArrayList<Integer> eList[];
	static int visited[];
	static int disc[];
	static boolean cut[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		disc = new int[V+1];
		eList = new ArrayList[V+1];
		visited = new int[V+1];
		cut = new boolean[V+1];
		
		for (int i = 1; i <= V; i++) {
			eList[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			eList[a].add(b);
			eList[b].add(a);
		}
		
		cnt = 0;
		for (int i = 1; i <= V; i++) {
			if(disc[i] == 0) {
				DFS(i, true);
			}
		}
		
		int Ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(cut[i]) {
				Ans++;
				sb.append(i + " ");
			}
		}
		System.out.println(Ans);
		System.out.println(sb);
	}
	
	private static int DFS(int n, boolean isRoot) {
		disc[n] = ++cnt;
		int ret = disc[n];
		int child = 0;
		
		for (int c : eList[n]) {
			// �ڽĳ�� �̹湮��
			if(disc[c] == 0) {
				child++;
				int min = DFS(c, false);
				ret = Math.min(min, ret);
				
				// ��Ʈ��尡 �ƴѰ��
				// �ڽĳ�尡 �����ִ� �ּ� �湮������ �������� �湮 �������� ũ�ٸ� ������� ������ 
				if(!isRoot && min >= disc[n]) {
					cut[n] = true;
				}
			}
			// �ڽĳ�� �̹� �湮��
			else {
				ret = Math.min(ret, disc[c]);
			}
		}
		
		// ��Ʈ����� ��� �ڽ��� 2�̻��̸� ������ ������
		if(isRoot && child > 1) {
			cut[n] = true;
		}
		return ret;
	}

}
