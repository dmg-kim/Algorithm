package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_�����ձ��ϱ� {
	static int N, M, K;
	static int SIZE;	// leaf node ������
	static long num[];
	static long tree[];	// tree ������
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		SIZE = N+1;
		
		num = new long[SIZE];
		tree = new long[SIZE * 4];
		
		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(br.readLine());			
		}

		init(1, N, 1);
				
		int a, b;
		long c;
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(b, c, 1, 1, N);		
				
			}
			else {
				bw.append(get(b, (int)c, 1, 1, N) + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
	
	// A[L] ~ A[R] ���� �� ���ϱ�
	// �ʱ� ȣ��: get(L, R, 1, 1, SIZE)
	// Top-Down ���: ������ ���� ���� üũ
	private static long get(int L, int R, int node, int S, int E) {
		// ������ ��ġ�� �ʴ� ���
		if(R < S || E < L) return 0; 
		// �ش� ����� ������ ���ϰ��� �ϴ� ������ �� �����ϴ� ���
		if(L <= S && E <= R) return tree[node];
		
		int mid = (S + E) / 2;
		
		return get(L, R, node << 1, S, mid) + get(L, R, node << 1 + 1, mid + 1, E);
		
	}
	// A[X] = V ���Ž�
	// �ʱ� ȣ��: update(X, V, 1, 1, SIZE)
	private static long update(int X, long V, int node, int S, int E) {
		if(S == E) {
			return tree[node] = V;
		}
		
		int mid = (S + E) / 2;
		
		return tree[node] =  update(X, V, node<<1, S, mid) + update(X, V, node<<1 + 1, mid+1, E);
		
	}
	private static long init(int S, int E, int node) {
		if(S == E) {
			return tree[node] = num[S];
		}
		int mid = (S + E) / 2;
		
		return tree[node] = init(S, mid, node<<1) + init(mid+1, E, node<<1 + 1); 
	}

}
