package 배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10808_알파벳개수 {
	static int Alphabet[] = new int[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String input = br.readLine();
		
		Arrays.fill(Alphabet, 0);
		
		for (int i = 0; i < input.length(); i++) {			
			Alphabet[input.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < Alphabet.length; i++) {
			bw.append(Alphabet[i] + " ");
		}
		
		bw.flush();
		bw.close();
	}
}
