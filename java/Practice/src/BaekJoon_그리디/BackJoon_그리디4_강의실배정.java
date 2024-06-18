package BaekJoon_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
3
1 3
2 4
3 5
*/
public class BackJoon_그리디4_강의실배정{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st ;
        LinkedList<String> list = new LinkedList<>();
        int tc = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String [] input = br.readLine().split("");
        for(int i = 0 ; i < n; i++) {
        	list.offer(input[i]);
        }
        for(int i =1; i<=n;i++) {
        	String A = list.peek();
        	list.offer(list.poll());
        	if(i)
        }
        int M = n/4;
        list.offer(list.poll)
        
    }
}