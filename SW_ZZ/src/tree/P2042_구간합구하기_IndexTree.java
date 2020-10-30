package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2042_�����ձ��ϱ�_IndexTree {
	static int N, M, K;
	static int leafSize = 1;	// leaf node ������
	static long tree[];	// tree ������
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. Leaf Node Size ���ϱ�
		while(leafSize <= N) {
			leafSize <<= 1;
		}
		
		// 2. �ε��� Ʈ��
		tree = new long[leafSize * 2];
		long num = 0;
		
		// 3. �ʱⰪ �ε��� Ʈ�� ����
		for (int i = 0; i < N; i++) {
			num = Long.parseLong(br.readLine());
			update(leafSize + i, num);
		}
				
		int a, b;
		long c;
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(leafSize + b - 1, c - tree[leafSize + b - 1]);		
				
			}
			else {
				bw.append(get(leafSize + b - 1, leafSize + (int)c - 1) + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
	
	// A[L] ~ A[R] ���� �� ���ϱ�
	// �ʱ� ȣ��: get(L, R)
	// Bottom-Up ���: ������ ���� ���� üũ
	private static long get(int L, int R) {
		long ans = 0;
		// ���� ��尡 ������ ���� �۰ų� ���������� �ݺ�
		while(L <= R) {
			// 1) ���� ���� ������ ��尡 ���� ��� �����ϰ� ����
			if(L == R) {
				ans += tree[L];
				return ans;
			}			
			// 2) ���� ��尡 Ȧ���� ��� ���� �����ϰ� ������ ���� �̵�
			if(L % 2 == 1) {
				ans += tree[L];
				L++;
			}			
			// 3) ������ ��尡 ¦���� ��� ���� �����ϰ� ���� ���� �̵�
			if(R % 2 == 0) {
				ans+= tree[R];
				R--;
			}
			// 4) ����, ������ ��� ���� �θ� ���� �̵�
			L >>= 1;
			R >>= 1;
		}
		return ans;
	}
	// A[X] = V ���Ž�
	// �ʱ� ȣ��: update(X, V)
	private static void update(int node, long V) {
		while(node >= 1) {
			tree[node] += V;
			node >>= 1;
		}
		
	}
}
