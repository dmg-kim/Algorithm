package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int iMax = Integer.MIN_VALUE;
		int idxMax = -1;
		
		int arr[] = new int[9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(iMax < arr[i]) {
				iMax = arr[i];
				idxMax = i+1;
			}
		}
		
		bw.write(iMax + "\n");
		bw.write(idxMax + "\n");
		
		
		bw.flush();
		bw.close();
	}
}
