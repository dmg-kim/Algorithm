package t;

import java.util.Scanner;
public class °ÅµìÁ¦°ö±¸ÇÏ±â{
	  static final long mod = 10007;
	    public static void main(String[] args){

	       Scanner sc = new Scanner(System.in);
	       
	       int n = sc.nextInt();
	       long m = sc.nextLong();
	       long res = getAnswer(n, m);
	       
	       System.out.println(res);
	      
	    }
	    
	    public static long getAnswer(int n, long m) {
	      if(m == 1) return n;
	      
	      long res = 1;
	      if(m % 2 == 1) {
	        res = getAnswer(n, m/2);
	        res *= res;
	        res *= n;	        
	      }
	      else {
	        res = getAnswer(n, m/2);
	        res *= res;
	      }
	      
	      res %= mod;
	      
	      return res;
	    }
	}