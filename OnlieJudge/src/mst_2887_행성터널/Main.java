package mst_2887_행성터널;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Edge> eList;
	static int Group[];
//	static ArrayList<Integer> Group;
	static ArrayList<Node> xList;
	static ArrayList<Node> yList;
	static ArrayList<Node> zList;
	static int Answer;
	static ArrayList<Pair> LocList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		eList = new ArrayList<Edge>();
		
		Group = new int[N+1];
//		Group = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			Group[i] = i;
		}
		
//		for (int i = 0; i < N; i++) {
//			Group.add(i);
//		}
		
		
		int x, y, z;
		LocList = new ArrayList<Pair>();
		xList = new ArrayList<Node>();
		yList = new ArrayList<Node>();
		zList = new ArrayList<Node>();
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			xList.add(new Node(i, x));
			yList.add(new Node(i, y));
			zList.add(new Node(i, z));
		}
		
		Collections.sort(xList);
		Collections.sort(yList);
		Collections.sort(zList);
		
		for (int i = 1; i < xList.size(); i++) {
			eList.add(new Edge(xList.get(i-1).no, xList.get(i).no, Math.abs(xList.get(i-1).val-xList.get(i).val)));
			eList.add(new Edge(yList.get(i-1).no, yList.get(i).no, Math.abs(yList.get(i-1).val-yList.get(i).val)));
			eList.add(new Edge(zList.get(i-1).no, zList.get(i).no, Math.abs(zList.get(i-1).val-zList.get(i).val)));
		}
		
		int cost = 0;
		
//		for (int start = 0; start < LocList.size() - 1; start++) {
//			
//			for (int end = start+1; end < LocList.size(); end++) {
//				
//				cost = Math.min(Math.min(Math.abs(LocList.get(start).x-LocList.get(end).x), Math.abs(LocList.get(start).y-LocList.get(end).y)), Math.abs(LocList.get(start).z-LocList.get(end).z));
//				
//				eList.add(new Edge(start, end, cost));
//			}
//		}
		
		Collections.sort(eList);
		
		Answer = 0;
		int conn = 0;
		
		for (Edge e:eList) {
			if(Find(e.start) != Find(e.end)) {
				Answer += e.cost;
				Group[e.end] = e.start;
				
				conn++;
				
				if(conn == N - 1) 
					break;
			}
		}
		
		System.out.println(Answer);
		

	}
	
//	public static void Union(int a, int b) {
//		//Group.set(Find(a),Find(b));
//		Group[Find(a)] = Find(b);
//		
//	}

	public static int Find(int n) {
//		if(Group.get(n) == n) return n;
//		
//		return Group.set(n, Find(Group.get(n)));
		
		if(Group[n] == n) return n;
		
		return Group[n] = Find(Group[n]);
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;
		
		Edge (int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			if(this.cost > e.cost) 
				return 1;
			else if (this.cost == e.cost)
				return 0;
			else
				return -1;
		}
	}
	
	static class Pair {
		int x;
		int y;
		int z;
		
		Pair (int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Node implements Comparable<Node> {
		int no;
		int val;
		
		Node(int no, int val) {
			this.no = no;
			this.val = val;
		}

		@Override
		public int compareTo(Node n) {
			if(this.val > n.val) return 1;
			else if (this.val == n.val) return 0;
			else return -1;
		}
	}

}
