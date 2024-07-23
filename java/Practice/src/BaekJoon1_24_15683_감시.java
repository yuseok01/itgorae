import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_24_15683_감시 {
	static class cam{
		int what;
		int x;
		int y;
		public cam(int what, int x, int y) {
			super();
			this.what = what;
			this.x = x;
			this.y = y;
		}
		
	}
	private static int[][] map;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	
    	int empty = 0 ; 
    	 map = new int[x][y];
    	/**
    	 * 빈공간의 총 갯수를 세고 
    	 * 1,2,3,4,5 카메라의 각각 감시가능한 최대값을 뺀다
    	 * 출력한다
    	 */
    	Queue<cam> q = new ArrayDeque<>();
    	for(int i = 0 ; i < x ; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0 ; j <y ; j ++	) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 0) {
    				empty++;
    			}
    			if(map[i][j] != 0 && map[i][j] != 6 ) {
    				q.add(new cam(map[i][j],i, j));
    			}
    		}
    	}
    	while(!q.isEmpty()) {
    		cam now = q.poll();
    		dfs(now.x,now.y,now.what);
    	}
    	
    	
    	
    }
	private static void dfs(int x, int y, int cam) {
		
		
	}
}