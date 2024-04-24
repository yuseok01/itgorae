package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point{
	public int x, y;
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BeackJoon_미로탐색 {
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [][]arr;
	static boolean [][]check;
	static int n, m;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m =Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		for(int i =0; i<n ; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0 ;j<m ; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		bfs();	
		System.out.println(min);
	}
	private static void bfs() {
		min = 1;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[]{0,0,1});
		arr[0][0] =0;
		while (!q.isEmpty()) {
			int [] current = q.poll(); 
			int x = current[0]; 
			int y = current[1];
			int count = current[2];
		}
	}
}
