package e_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main10818 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int iMax = Integer.MIN_VALUE;
		int iMin = Integer.MAX_VALUE;
		
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(iMax < arr[i])
				iMax = arr[i];
			if(iMin > arr[i])
				iMin = arr[i];
		}
		
//		Arrays.sort(arr);
		
//		bw.write(arr[0] + " " + arr[N-1]);
		bw.write(iMin + " " + iMax);
		
		
		bw.flush();
		bw.close();
	}
}
