package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 과제2_contact2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [][] map = new int[101][101];
		boolean [] visited = new boolean[101];  
		int v = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<v/2;i++) {
			
			st= new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int max = 0 ;
		while(!q.isEmpty()) {
			System.out.println("큐사이즈는"+q.size());
			int cnt = q.size();
			max = 0; //?
			while(cnt>0) {
				cnt--;
				int tmp = q.poll();
				max = Math.max(max, tmp); //큐안에 있는 사이즈를 갱신 
				for(int i = 0 ; i <= 100; i++) {
					if(!visited[i] && map[tmp][i] ==1) {
						q.add(i);
						visited[i] = true;
					}
				}
				
			}
		}
		
	
	}

}
