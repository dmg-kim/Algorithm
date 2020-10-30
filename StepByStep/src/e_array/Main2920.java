package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean b_asc = true;
		boolean b_desc = true;
		
		int arr[] = new int[8];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(i > 0) {
				if(arr[i-1] > arr[i]) {
					b_asc = false;
				}
				else {
					b_desc = false;
				}
			}
		}
		if(b_asc && !b_desc) {
			bw.write("ascending" + "\n");
		} else if (!b_asc && b_desc) {
			bw.write("descending" + "\n");
		}
		else {
			bw.write("mixed" + "\n");
		}		
		
		bw.flush();
		bw.close();
	}
}
