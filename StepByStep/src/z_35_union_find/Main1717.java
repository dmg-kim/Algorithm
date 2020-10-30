package z_35_union_find;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1717 {
	
	static int N, M;
	static int Group[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Group = new int[N+1];
		
		for (int i = 1; i < N; i++) {
			Group[i] = i;
		}
		
		int q, a, b;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			q = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			switch (q) {
			case 0:
				Union(a, b);
				break;

			case 1:
				if(Find(a) != Find(b)) {
					bw.write("NO" + "\n");
				}
				else {
					bw.write("YES" + "\n");
				}
				
				break;
			default:
				break;
			}			
		}
		
		bw.flush();
		bw.close();
	}

	public static int Find(int n) {
		if(Group[n] == n) return n;
		else
		return Group[n] = Find(Group[n]);
	}

	public static void Union(int a, int b) {

		Group[Find(b)] = Find(a);
	}
}
