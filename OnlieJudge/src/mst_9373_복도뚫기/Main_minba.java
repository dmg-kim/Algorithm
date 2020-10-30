package mst_9373_º¹µµ¶Õ±â;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_minba {
	static int T;
	static int W, N;
	static int par[];
	static double result;
	static ArrayList<Edge> list;
	static ArrayList<Comp> comp;

	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		double weight;

		Edge(int v1, int v2, double weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			
			if(this.weight > o.weight){
                return 1;
            }
			else if (this.weight == o.weight) {
				return 0;
			}
			else
				return -1;
		}
	}

	static class Comp {
		int v1;
		int v2;
		double weight;

		Comp(int v1, int v2, double weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			W = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());

			par = new int[N + 3];
			list = new ArrayList<>();
			comp = new ArrayList<>();

			for (int j = 1; j <= N; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				comp.add(new Comp(a, b, c));
			}

			for (int j = 1; j <= N + 2; j++) {
				par[j] = j;
			}

			list.add(new Edge(N + 1, N + 2, W));
			for (int j = 1; j <= comp.size(); j++) {
				Comp c = comp.get(j - 1);
				double leftW = Math.max(0, c.v1 - c.weight);
				double rightW = Math.max(0, W - (c.v1 + c.weight));
				list.add(new Edge(j, N + 1, leftW));
				list.add(new Edge(j, N + 2, rightW));
				// System.out.println(" j : " + j );
				// System.out.println("left : " + leftW + " right : " + rightW );
				for (int k = 1; k < j; k++) {
					Comp m = comp.get(k - 1);
					// System.out.println("("+maxX+","+minX+") , " + " ("+maxY+","+minY+")");
					double weight = Math.sqrt(Math.pow(c.v1 - m.v1, 2) + Math.pow(c.v2 - m.v2, 2));
					weight = weight - c.weight - m.weight;
					// System.out.println("weight : " + weight);
					// System.out.println(" k : " + k + " j : " + j + " weight : " + weight);
					list.add(new Edge(k, j, weight));
				}
			}

			Collections.sort(list);
			for (Edge e : list) {
				int a = find(e.v1);
				int b = find(e.v2);

				// System.out.println("here : " + e.v1 + " next : " + e.v2 + " weight : " +
				// e.weight + " a : " + a + " b : " + b);

				if (a == b)
					continue;
				par[b] = a;
				// System.out.println(find(N+1) + " : " + find(N+2));
				if (find(N + 1) == find(N + 2)) {
					result = e.weight;

					break;
				}

			}
			// System.out.println(result);
			if (result == 0)
				System.out.println("0");
			else
				System.out.printf("%f\n", result / 2.0);
			// System.out.printf("%.6f\n",result/2.0);
		}
	}

	static int find(int n) {
		if (par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}

}