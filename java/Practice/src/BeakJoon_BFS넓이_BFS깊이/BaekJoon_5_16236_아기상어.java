package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class BaekJoon_5_16236_아기상어 {
	static int [][] map;
	static int [][] check;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int n ;
	static int 
	static Queue<Point> q ;
	static Point now;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n]; 
		check = new int[n][n];
		q = new LinkedList<>();
		for(int i = 0 ; i < n; i++) {
			st= new StringTokenizer(br.readLine()) ;
				for(int j = 0; j < n ;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==9) {
						q.add(new Point(i,j)); //시작점 큐에 저장 
						
				}
			}
		}
	}
}
