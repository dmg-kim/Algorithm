package b3_7_그래프_MST_크루스칼;

import java.io.*;
import java.util.*;

public class B09_BOJ15481_그래프와MST_프림_LCA_민바 {
	/*
	 * https://www.acmicpc.net/problem/15481
	 * 
	 * https://salepark.tistory.com/53
	 * 
	 */
	static int N,M;

    static long result;
    static int parent[];

    static PriorityQueue<Edge> que;
    static ArrayList<Edge> originList;

    static ArrayList<Edge>[] lcaList;
    private static int[][] par;
    private static long[][] maxArr;
    private static int visit[];
    private static int[] dep;
    private static final int MAX_D = 19;

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        long weight;

        Edge(int v1,int v2,long weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            if(this.weight - o.weight < 0)
            	return -1;
            else if(this.weight - o.weight > 0)
            	return 1;
            else
            	return 0;
            		
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        que = new PriorityQueue();
        originList = new ArrayList<>();

        lcaList = new ArrayList[N+1];
        par = new int[N + 1][MAX_D];
        maxArr = new long[N + 1][MAX_D];

        dep = new int[N + 1];
        visit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lcaList[i] = new ArrayList<Edge>();
        }
        parent = new int[N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            que.add(new Edge(u,v,w));
            originList.add(new Edge(u,v,w));
        }


        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        
        while(!que.isEmpty()) {
        	Edge e = que.poll();
            int a = find(e.v1);
            int b = find(e.v2);

            if(a == b)
                continue;

            parent[b] = a;
            lcaList[e.v1].add(new Edge(e.v1,e.v2,e.weight));
            lcaList[e.v2].add(new Edge(e.v2,e.v1,e.weight));
            result += e.weight;
        }

        Queue<Edge> que = new LinkedList<>();
        que.add(new Edge(1,1,0));

        while (!que.isEmpty()) {
            Edge q = que.poll();
            visit[q.v1] = 1;
            for (Edge e : lcaList[q.v2]) {
                if (visit[e.v2] == 0) {
                    dep[e.v2] = dep[e.v1] + 1;
                    que.add(new Edge(e.v1, e.v2, e.weight));

                    par[e.v2][0] = e.v1;
                    maxArr[e.v2][0] = e.weight;

                    for (int i = 1; i <= MAX_D-1; i++) {
                        if (par[e.v2][i - 1] == 0) break;
                        par[e.v2][i] = par[par[e.v2][i - 1]][i - 1];
                        maxArr[e.v2][i] = Math.max(maxArr[e.v2][i - 1], maxArr[par[e.v2][i - 1]][i - 1]);
                        //System.out.println(i-1 + " , " + e.next + " minArr[i - 1][e.next] : " + minArr[i - 1][e.next] + " minArr[i - 1][par[i - 1][e.next]] : " + minArr[i - 1][par[i - 1][e.next]]);
                        //System.out.println("maxArr[i - 1][e.next] : " + maxArr[i - 1][e.next] + " maxArr[i - 1][par[i - 1][e.next]] : " + maxArr[i - 1][par[i - 1][e.next]]);

                    }
                }
            }
        }
        
        checkTree();
/*        for (int v = 1; v <= N; v++) {
        	for (int h = MAX_D-1; h >0; h--) {
                maxArr[v][h] = Math.max(maxArr[v][h - 1], maxArr[par[v][h - 1]][h - 1]);
                //par[v][h] = par[h - 1][par[v][h - 1]];
            }
        }*/


        for (int i = 0; i < M; i++) {
            long temp = result;
            Edge e = originList.get(i);
            temp += e.weight;
            temp -= lca(e.v1, e.v2);
            System.out.println(temp);
        }
    }
    
	public static void checkTree() {
		for (int i = 1; i <= N; i++) {
			System.out.print(dep[i] + " ");
		}
		System.out.println();
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < MAX_D; j++) {
				System.out.print(par[i][j] + " ");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < MAX_D; j++) {
				System.out.print(maxArr[i][j] + " ");
			}
			System.out.println();
		}
	}

    private static long lca(int a, int b) {
        long maxResult = Long.MIN_VALUE;
        if (dep[a] > dep[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 깊은 위치에 있는 b를 올리면서 a와 같은 높이를 맞춘다

        for (int i = MAX_D-1; i >= 0; i--) {

            if (((1 << i) & (dep[b] - dep[a])) != 0) {
                //if (dep[b] - dep[a] >= (1 << i)){
                maxResult = Math.max(maxArr[b][i], maxResult);
                //System.out.println(minResult + " " + maxResult);
                b = par[b][i];

            }
        }
        if (a == b) {
            return maxResult;
        }

        // 공통 조상을 찾는다.
        for (int i = MAX_D-1; i >= 0; i--) {
            //System.out.println(" a : " + a + " b : " + b + " i ; " + i);
            if (par[a][i] != par[b][i]) {
                maxResult = Math.max(Math.max(maxArr[a][i],maxArr[b][i]), maxResult);
                a = par[a][i];
                b = par[b][i];
            }

        }
        maxResult = Math.max(Math.max(maxArr[a][0],maxArr[b][0]), maxResult);
        //System.out.println("11111111" + " a : " + a + " b : " + b);
        //System.out.println("#1 minResult : " + minResult + " maxResult : " + maxResult);

        return maxResult;


    }

    static int find(int n){
        if(parent[n] == n)
            return n;
        return parent[n] = find(parent[n]);
    }


}