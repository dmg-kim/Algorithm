package b5_4_���_��������;

import java.io.*;
import java.util.StringTokenizer;

public class B01_BOJ2003_��������2_�������� {
	/*
	 * https://www.acmicpc.net/problem/2003
	 * 
	 * N���� ���� �� ���� A[1], A[2], ��, A[N] 
	 * �� ������ i��° ������ j��° �������� �� A[i] + A[i+1] + �� + A[j-1] + A[j]�� M�� �Ǵ� ����� �� ���ϱ�
	 * N(1 �� N �� 10,000)
	 * M(1 �� M �� 300,000,000)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		/* �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		 * N�� �ִ� 10000�ε� �迭 10002 ������ ������ (1���� �ؼ� 10001)
		 * r++ ������ �迭���� �ϳ��� �Ѿ� �� �� �־ ������+1 ����.
		 * �̰Ŷ��� ��ð���...�Ф�
		 * �ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		 */
		int arr[] = new int[10002];
		
		st = new StringTokenizer(br.readLine().trim());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ���� Ǭ��
//		int ans = 0;
//		int l = 0;
//		int r = 0;
//		int sum = 0;
//		int l_sum = 0;
//		int r_sum = 0;
//		
//		while(true) {
//			if(r > N) break;	// r�� �迭 ������ �Ѿ�� stop
//			
//			sum = r_sum - l_sum;	// 0~r������ sum - 0~l������ sum = l+1~r ������ ��
//			
//			if(sum == M) {		// sum�� M�� ������ 
//				ans++;			// ī��Ʈ + 1
//				r++;			// r ��ĭ �̵� �� r_sum �� ������
//				r_sum += arr[r];
//			}
//			else if(sum < M) {	// sum�� M���� ������
//				r++;			// r ��ĭ ���� ����(r_sum �� ����) ���� �� ����
//				r_sum += arr[r];
//			}
//			else if(sum > M) {	// sum�� M���� ũ��
//				l++;			// l ��ĭ ���� ����(l_sum �� ����) ���� �� ����
//				l_sum += arr[l];
//			}
//		}
		
		// �� ���� �ڵ�...
		int ans = 0;
		int l = 1, r = 1;
		int sum = 0;
		while(r <= N+1) {
			
			if(sum < M) {
				sum +=arr[r];
				r++;
			}
			else {
				sum -= arr[l];
				l++;
			}
			
			// ���� �� üũ�� if�� ���� üũ...(�̻����� �� ������;;��)
			if(sum == M) ans++;
		}
		
		bw.append(ans + "\n");
		bw.flush();
		bw.close();
	}

}
