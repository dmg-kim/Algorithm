package day2_¿ÏÀüÅ½»ö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2309_ÀÏ°ö³­ÀïÀÌ_¿ÏÀüÅ½»ö {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int arr[] = new int[9];
		
		int totalHeight = 0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			totalHeight += arr[i];
		}
		
		int diff = totalHeight - 100;
		
		Arrays.sort(arr);
		
		int s = 0, e = 8;
	    boolean isFind = false;
		while(s < e) {
			if(arr[s] + arr[e]  == diff) {
				isFind = true; 
				break;
			}
			else if (arr[s] + arr[e]  > diff) e--;
			else s++;
		}
		
		if(isFind) {
			for (int i = 0; i < 9; i++) {
				if(i != s && i != e)
					bw.append(arr[i] + "\n");
			}
		}
		
		
		bw.flush();
		bw.close();

	}

}
