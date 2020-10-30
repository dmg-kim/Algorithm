package ex2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ÀÎµ¦½ºÆ®¸® {
	static int N, M, K;
	static int N_list[];
	static long iTree[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		N_list = new int[N+1];
		
		// Leaf NodeÀÇ °¹¼ö
		int idxOfLeaf = 1;
		while(N > idxOfLeaf) {
			idxOfLeaf *=2;
		}
		
		iTree = new long[2*idxOfLeaf];

		for (int i = 0; i < N; i++) {
			N_list[i] = Integer.parseInt(br.readLine());
			iTree[idxOfLeaf + i] = N_list[i];
			Update(iTree, (idxOfLeaf + i)/2 );
		}
		
		int a, b, c = 0;
		
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
					
			if(a == 1) {
				N_list[b - 1] = c;
				iTree[idxOfLeaf + b - 1] = c;
				Update(iTree, (idxOfLeaf + b - 1) / 2);
			}
			else {
				System.out.println(Get(iTree, idxOfLeaf + b - 1, idxOfLeaf + c - 1));
			}
		}
		
		

	}



	private static long Get(long[] iTree, int start, int end) {
		if(start > end) {
			return 0;
		}
		
		if(start == end) {
			return iTree[start];
		} 
		
		long rtn = 0;
		
		if(start % 2 == 1) {
			rtn += iTree[start];
			start++;
		}
		
		if(end % 2 == 0) {
			rtn += iTree[end];
			end--;
		}
		
		return rtn + Get(iTree, start / 2, end / 2);
		
		
	}



	private static void Update(long[] iTree, int i) {
		if(i < 1) {
			return;
		}
		
		iTree[i] = iTree[i*2] + iTree[i*2 +1];
		
		Update(iTree, i/2);
		
	}

}
