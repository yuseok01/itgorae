package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_3_17144_미세먼지안녕 {
	static int [][] map;
	static boolean [][] check;
	static int x;
	static int y;
	static int t;
	static int airC ;
	static int airC2;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static Queue<dust> q;
	static class dust{
		int x;
		int y;
		int w; 
		public dust(int x , int y , int w) {
			super();
			this.x = x;
			this.y = y;
			this.w =w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()); // x
		y = Integer.parseInt(st.nextToken()); // y
		t = Integer.parseInt(st.nextToken()); // t
		map = new int[x][y];
		check = new boolean[x][y];
		airC=-1;
		for(int i = 0 ; i< x ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0; j< y ; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(airC==-1 && map[i][j] == -1) {
					airC = i;
				}
			}
			
		}
		airC2 = airC+1;
		int nowT = 0;
		while(nowT != t) {
			checkDust();
			spreadVirus();
			operateAir();
			nowT++;
		}
		int result =0;
		for(int i = 0 ; i<x ; i++) {
			for(int j=0 ; j<y ; j++) {
				
				if(map[i][j]!=-1) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
		
		
	}
	static void checkDust() {
		q= new LinkedList<>();
		for(int i = 0; i< x ; i++) {
			for(int j = 0 ; j<y ; j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue;
				q.add(new dust(	i, j, map[i][j]));
				
			}
		}
		
	}
	static void spreadVirus() {
		while(!q.isEmpty()) {
			dust now = q.poll();
			if(now.w<5) continue;
			int adj = now.w/5;
			int cnt = 0;
			for(int k =0 ; k < 4 ; k++) {
				int idx = now.x + dx[k];
				int idy = now.y + dy[k];
				if(0<=idx && idx < x && 0<=idy && idy <y && map[idx][idy] != -1) {
					map[idx][idy] += adj;
					++cnt;
				}	
			}
			map[now.x][now.y] -= adj*cnt; // 다 퍼트리고 퍼트린 갯수를 뺀다
		}
	}

	static void operateAir() {
		int top = airC;
		int down = airC2;
		//위 
	    

        for (int i = top - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];

        for (int i = 0; i < y - 1; i++) 
            map[0][i] = map[0][i+1];

        for (int i = 0; i < top; i++) 
            map[i][y - 1] = map[i + 1][y - 1];
  
        for (int i = y - 1; i > 1; i--) 
            map[top][i] = map[top][i-1];
 
        map[top][1] = 0;
        

        //아래

        for (int i = down + 1; i < x - 1; i++) 
            map[i][0] = map[i + 1][0];

        for (int i = 0; i < y - 1; i++) 
            map[x - 1][i] = map[x - 1][i + 1]; 

        for (int i = x - 1; i > down; i--) 
            map[i][y - 1] = map[i - 1][y - 1];

        for (int i = y - 1; i > 1; i--) 
            map[down][i] = map[down][i - 1];
        map[down][1] = 0;
    }
    
}