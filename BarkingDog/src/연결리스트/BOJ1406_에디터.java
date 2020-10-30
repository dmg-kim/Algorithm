package 연결리스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1406_에디터 {
	static int N, M;
	static char dat[] = new char[600001];
	static int pre[] = new int[600001];
	static int nxt[] = new int[600001];
	static int unused;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String input = br.readLine().trim();
		N = input.length();
		Arrays.fill(pre, -1);
		Arrays.fill(nxt, -1);
		
		unused = 1;
		for (int i = 0; i < N; i++) {
			dat[unused] = input.charAt(i);
			pre[unused] = i;
			if(i == N - 1) nxt[unused] = -1;
			else nxt[unused] = i+2;
			unused++;
		}
		pre[0] = -1;
		nxt[0] = 1;
		
//		for (int i = 0; i <= N + 1; i++) {
//			System.out.print(dat[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i <= N + 1; i++) {
//			System.out.print(pre[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i <= N + 1; i++) {
//			System.out.print(nxt[i] + " ");
//		}
//		System.out.println();
		
		M = Integer.parseInt(br.readLine().trim());
		String mode;
		char c = ' ';
		
		int loc = N;	// 커서 위치
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			mode = st.nextToken().trim();
			
			switch (mode) {
			case "L":
				if(loc != 0) loc = pre[loc];
				break;
			case "D":
				if(loc != N && nxt[loc] != -1) loc = nxt[loc];
				break;
			case "B":
				if(loc != 0) {
					erase(loc);
					loc = pre[loc];
				}
				break;
			case "P":
				c = st.nextToken().charAt(0);
				insert(loc, c);
				if(nxt[loc] != -1) loc = nxt[loc];
				else loc++;
				break;
			default:
				break;
			}
			
		}
		
//		for (int i = 0; i <= unused; i++) {
//			System.out.print(dat[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i <= unused; i++) {
//			System.out.print(pre[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i <= unused; i++) {
//			System.out.print(nxt[i] + " ");
//		}
//		System.out.println();
		
		
		bw.append(travers() +"\n");
		bw.flush();
		bw.close();
	}

	private static String travers() {
		String Answer = "";
		int cur = nxt[0];
		
		while(cur != -1) {
			Answer += dat[cur];
			cur = nxt[cur];
		}	
		return Answer;
	}

	private static void insert(int loc, char c) {
		dat[unused] = c;
		pre[unused] = loc;
		nxt[unused] = nxt[loc];
		if(nxt[loc] != -1) pre[nxt[loc]] = unused;
		nxt[loc] = unused;
		
		unused++;
		
		
		
	}

	private static void erase(int loc) {
		nxt[pre[loc]] = nxt[loc];
		if(nxt[loc] != -1) 	pre[nxt[loc]] = pre[loc];
		
	}

}
