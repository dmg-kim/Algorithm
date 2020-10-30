package mst_9373_º¹µµ¶Õ±â;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int W, N;
	static int leftW, rightW;
	
	static ArrayList<Edge> eList;
	static int Group[];
	static ArrayList<Sensor> sList;
	
	static double Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			W = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			
			leftW = N + 1;
			rightW = N + 2;
			
			eList = new ArrayList<Edge>();
			sList = new ArrayList<Sensor>();
			
			Group = new int[N+3];
			
			for (int i = 1; i <= N+2; i++) {
				Group[i] = i;
			}
			
			int a, b, c;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				sList.add(new Sensor(i, a, b, c));
			}
			
			eList.add(new Edge(leftW, rightW, W));
			for (int i = 1; i <= sList.size(); i++) {
				Sensor now = sList.get(i - 1);
				eList.add(new Edge(now.no, leftW, Math.max(0, now.x - now.r)));
				eList.add(new Edge(now.no, rightW, Math.max(0, W - now.x - now.r)));
				
				for (int j = 1; j < i; j++) {
					Sensor comp = sList.get(j - 1);
					
					int x = now.x - comp.x;
					int y = now.y - comp.y;
					int r = now.r + comp.r;
					
					double dist = Math.sqrt(x*x + y*y);
					eList.add(new Edge(comp.no, now.no, dist - r));	
				
				}	
			}
			
//			for (Edge e: eList) {
//				System.out.println(e.start + "->" + e.end + ": " + e.cost);
//			}
			
			Collections.sort(eList);
			
//			for (Edge e: eList) {
//				System.out.println(e.start + "->" + e.end + ": " + e.cost);
//			}
			
			Answer = 0;
			
			for (Edge e: eList) {
				if(Find(e.start) == Find(e.end)) {
					continue;
				}
				
				Union(e.start, e.end);
				
				if(Find(leftW) == Find(rightW)) {
					Answer = e.cost;
					break;
				}
			}
			
			if(Answer == 0)
				System.out.println("0");
			else
				System.out.printf("%f\n",Answer/2.0);
			
			
		}
	}
	
	public static void Union(int a, int b) {
		Group[Find(b)] = Find(a);
		
	}

	public static int Find(int n) {
		if(Group[n] == n) return n;
		return Group[n] = Find(Group[n]);
	}

	static class Edge implements Comparable<Edge> {
		int no;
		int start;
		int end;
		double cost;
		
		Edge(int start, int end, double cost) {			
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			if(this.cost > e.cost)
				return 1;
			else if(this.cost < e.cost)
				return -1;
			else
				return 0;
		}
	}
	
	static class Sensor {
		int no;
		int x;
		int y;
		int r;
		
		Sensor(int no, int x, int y, int r) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

}
