package ex1909_����Ž��;

import java.io.*;
import java.util.*;

/*
 * [19�� 09�� 2���� - �ù�� ��ȫ��(3)]
 *  - �ù� ���� N X N(2~10)
 *  - aij: i���� j�� �ù� ���� ������ ����
 *  - ��� ��ġ�� ������� ���ƿ;���
 *    ������̵� ��� ����
 *    �湮���� ��湮 �Ұ�
 *    ������ ������ �̵�X
 *    ������� �� �湮 �ʿ� X
 *  <����Ǯ��>
 *  - DFS(����Ž��)
 */  
public class G06_3_�ù�վ�ȫ�� {
	static long N;
	static int K;
	static long box[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Long.parseLong(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		box = new long[K];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			box[i] = Long.parseLong(st.nextToken());
		}
		
		long Ans = 0L;
		int idx = K-1;
		while(N > 0) {
			Ans += N / box[idx];
			N %= box[idx];
			idx--;
		}
		
		System.out.println(Ans);
		

	}

}
