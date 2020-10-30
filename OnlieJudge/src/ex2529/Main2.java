package ex2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2{
	
	static boolean[] visited = new boolean[10];
	static ArrayList<String> list = new ArrayList<String>();
	static String[] input;
	static int k;
	
	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader sc = new BufferedReader(isr);
		
	    k = Integer.parseInt(sc.readLine());
	    input = sc.readLine().split(" ");
	 
	    for (int i = 0; i <= 9; i++) {
	        visited[i] = true;
	        dfs(i, 0, i + "");
	    }
	    System.out.println(list.get(list.size() - 1));
	    System.out.println(list.get(0));
	}
 
	public static void dfs(int v, int cnt, String str) {
	    if (cnt == k) {
	        // success
	        list.add(str);
	    } else {
	        for (int i = 0; i <= 9; i++) {
	            if (!visited[i]) {
	                if (input[cnt].equals("<")) {
	                    if (v >= i) {
	                        continue;
	                    }
	                } else {
	                    if (v <= i) {
	                        continue;
	                    }
	                }
	                visited[i] = true;
	                dfs(i, cnt + 1, str + i);
	            }
	        }
	    }
	    // backtracking
	    visited[v] = false;
	}

}