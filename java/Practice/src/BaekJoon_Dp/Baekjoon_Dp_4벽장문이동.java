package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Dp_4벽장문이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       arr[a] = 1;
       arr[b] =1; 
       int length = Integer.parseInt(br.readLine()); // 열어야할 벽장의 수 
       
       for(int i = 1 ; i <= length; i++) {
    	   int open = Integer.parseInt(br.readLine());
    	  
       }
        
        
        
    }

}