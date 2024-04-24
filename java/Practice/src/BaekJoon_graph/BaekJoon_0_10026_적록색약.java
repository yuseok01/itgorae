package BaekJoon_graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_0_10026_적록색약 {
	static int n;
	static char map[][];
	static int[] result;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean[][] visited2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		result = new int[2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					noneBlindBfs(i, j);
					blindBfs(i, j);
				}
			}
		}System.out.println(result[0]+" "+result[1]);
	}

	private static void noneBlindBfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		if(!q.isEmpty()) {
			Point now = q.poll();	
			for(int k = 0 ; k < 4 ; k++) {
				int idx = now.x + dx[k];
				int idy = now.y + dy[k];
				if(0<=idx && idx < n && 0 <= idy && idy < n && !visited[idx][idy]) {
					if(map[now.x][now.y] == map[idx][idy]) {
						q.add(new Point(idx,idy));
						visited[idx][idy] = true;
						result[0]++;
					}
				}
			}
		}

	}

	private static void blindBfs(int x , int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		if(!q.isEmpty()) {
			Point now = q.poll();
			for(int k = 0 ; k < 4 ; k++) {
				int idx = now.x + dx[k];
				int idy = now.y + dy[k];
				if(0 <= idx && idx < n && 0 <= idy && idy < n && !visited2[idx][idy]) {
					if(map[now.x][now.y] == 'R' || map[now.x][now.y] =='G' ) {
						if(map[idx][idy] == 'R' || map[idx][idy] == 'G') {
							q.add(new Point(idx,idy));
							visited2[idx][idy] = true;
						}
						continue;
					}
					else {
						if(map[idx][idy] == map[now.x][now.y]) {
							q.add(new Point(idx,idy));
							visited2[idx][idy] = true;
							result[1]++;
						}
					}
				}
			}
		}
		
	}
}
