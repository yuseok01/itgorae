package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.awt.Point;

public class BeakJoon_2_1987_알파벳BFS {
	static boolean [][] visited;
	static char[][] arr;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int R;
	private static int C;
	static Set<Character> s = new HashSet<>(); // 중복안됨 , 안에 있는지 확인 가능 
	static int cnt;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i < R ;i++) {
			String input = br.readLine();
			for(int j = 0 ;j <C ; j++) {
				arr[i][j] = input.charAt(j);
			}
		}cnt = 0;
		bfs(0,0);
		System.out.println(cnt);
	}
	static void bfs(int x, int y) {
		if(!s.contains(arr[x][y])) {
			s.add(arr[x][y]);
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(x,y));
			visited[x][y] = true;
			cnt++;
			while(!q.isEmpty()) {
				Point now = q.poll();
				for(int k = 0 ; k < 4 ; k++) {
					int idx = now.x + dx[k];
					int idy = now.y + dy[k];
					if(0<=idx && idx < R && 0<= idy && idy <C && !s.contains(arr[idx][idy]) && !visited[idx][idy] ) {
						cnt++;
						q.add(new Point(idx,idy));
						visited[idx][idy] = true;
						s.add(arr[idx][idy]);
					}
				}
			}
		}
		
	}
}
/*
 * ArrayList<Integer>[] list = new ArrayList[1]; 
		for(int i = 0; i<5; i++) {
			list[i]= new ArrayList<>();
		}
*/
