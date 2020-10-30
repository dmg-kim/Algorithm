package b5_4_���_��������;

import java.io.*;
import java.util.*;

public class B02_BOJ2075_N��°ū��_PQ {
	/*
	 * https://www.acmicpc.net/problem/2075
	 * 
	 * N��N�� ǥ�� �� N2�� ä���� �ִ�. ä���� ������ �� ���� Ư¡�� �ִµ�, ��� ���� �ڽ��� �� ĭ ���� �ִ� ������ ũ��
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());

		// �������� PQ ����
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				n = Integer.parseInt(st.nextToken());
				// �Է� ���� ���� PQ�� �߰�
				pq.offer(n);	
				// PQ ����� N���� ũ�� PQ���� �� ��(���� ������) ���� ����
				if(pq.size() == N+1) pq.poll();
			}
		}
		
		// ���� PQ���� ���� ū N���� ���� �����ְ� PQ�� �� ���� ���� N��°�� ū ���� ��
		int ans = pq.poll();
		bw.append(ans + "\n");
		bw.flush();
		bw.close();
		
	}

}
