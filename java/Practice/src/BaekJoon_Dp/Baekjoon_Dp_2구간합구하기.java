package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Dp_2구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int [][] arr = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<=N; j++) {   
            	arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        for(int t = 1 ; t <= M ; t++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int sum=0;
        	for(int i = a ; i <= c; i++) {
        		sum = sum+ (arr[i][d] - arr[i][b-1]);
        	}
        	sb.append(sum+"\n");
        }
        System.out.print(sb);
    }

}