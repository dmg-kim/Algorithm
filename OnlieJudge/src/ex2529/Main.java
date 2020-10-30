package ex2529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main{
	static int N;
	static ArrayList<Integer> MaxArr[];
	static ArrayList<Integer> MinArr[];
	static String[] Sign;
	static boolean Visited[];
	static int MaxAnswer[];
	static int MinAnswer[];
	
    public static void main(String[] args) throws Exception {
    	InputStreamReader isr = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(isr);
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	
    	Sign = new String[N];
    	
    	st = new StringTokenizer(br.readLine());
    	
    	MaxArr = new ArrayList[N+1];
    	MinArr = new ArrayList[N+1];

    	for (int i = 0; i < N+1; i++) {
			MaxArr[i] = new ArrayList<Integer>();
			MinArr[i] = new ArrayList<Integer>();
		}
    	
    	for (int i = 0; i < N; i++) {
			Sign[i] = st.nextToken();
//			System.out.println(Sign[i]);
			if(Sign[i].equals("<") ) {
				MaxArr[i].add(i+1);
				MinArr[i+1].add(i);
			}
			else {
				MaxArr[i+1].add(i);
				MinArr[i].add(i+1);
			}
		}
    	
//    	for (int i = 0; i < N+1; i++) {
//    		System.out.print("MaxArr[" + i + "]: ");
//			for (int j = 0; j < MaxArr[i].size(); j++) {
//				System.out.print(MaxArr[i].get(j) + " ");
//			}
//			System.out.println();
//		}
//    	
//    	for (int i = 0; i < N+1; i++) {
//    		System.out.print("MinArr[" + i + "]: ");
//			for (int j = 0; j < MinArr[i].size(); j++) {
//				System.out.print(MinArr[i].get(j) + " ");
//			}
//			System.out.println();
//		}
    	
    	
    	Visited = new boolean[N];
    	MaxAnswer = new int [N+1];
    	MinAnswer = new int [N+1];
    	
    	DFS(0);
    	
    	for (int i = 0; i < MaxAnswer.length; i++) {
			System.out.print(MaxAnswer[i] + " ");
		}

    }

	private static void DFS(int n) {
		
		if(MaxArr[n].size() == 0) {
			
			return;
		}
		
		for (int i = 0; i < N + 1; i++) {
			if(Visited[i]) {
				continue;
			}
			else {
				Visited[i] = true;
				for (int j = 0; j < MaxArr[i].size(); j++) {
					DFS(MaxArr[i].get(j));
					
					MaxAnswer[n] = N--;
					
				}
				
			}
		}
		
		
		
	}
    
 
}
