package �����ڵ��ۼ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10871_X����������_�ڵ��׽�Ʈ�Ͱ������ٸ��� {
	static int N, X;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int input = 0;
		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(st.nextToken());
			if(X > input) bw.append(input + " ");
		}
		
//		bw.append("\n");
		bw.flush();
		bw.close();
	}
}
