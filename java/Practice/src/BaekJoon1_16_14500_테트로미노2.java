import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_16_14500_테트로미노2 {
<<<<<<< HEAD
	/*
	 * -- * 2
	 * ㅁ *1
	 * ㄱ *4 *2좌우 대칭
	 * ㄹ *4
	 * ㅗ *4
	 */
	static int[][] dr = {{0,0,0,0},{0,0,1,1},{0,1,2,2},{0,1,1,2},{0,0,0,1},
			{0,1,2,3},{0,1,2,2},{0,0,1,2},{0,0,1,2},{0,1,1,2},
			{0,0,1,1},{0,0,1,1},{0,1,1,2},{0,1,1,1},{0,1,1,2},
			{0,0,0,1},{0,1,1,1},{0,0,0,1},{0,1,1,1}};
	static int[][] dc = {{0,1,2,3},{0,1,0,1},{0,0,0,1},{0,0,1,1},{0,1,2,1},
			{0,0,0,0},{1,1,0,1},{0,1,0,0},{0,1,1,1},{1,0,1,0},
			{1,2,0,1},{0,1,1,2},{1,0,1,1},{1,0,1,2},{0,0,1,0},
			{0,1,2,0},{0,0,1,2},{0,1,2,2},{2,0,1,2}};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		for(int i = 0 ;i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxSum = -1;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				outer : for(int tetNum = 0; tetNum<dr.length; tetNum++) { //도형갯수만큼
					int[] nowXs = dr[tetNum]; //도형 4방향 좌표넣기
					int[] nowYs = dc[tetNum];//도형 4방향 좌표넣기
					int sum = 0;
					for(int k = 0; k<4; k++) {
						int curX = i+nowXs[k];
						int curY = j+nowYs[k];
						if(curX < 0 || curY <0 || curX >= n || curY >=m) {
							
							continue outer;
						}
						
						sum+= map[curX][curY];
					}
					maxSum = Math.max(maxSum, sum);
				}	
			}
		}
		System.out.println(maxSum);
	}
}
=======
    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solution(i, j, arr[i][j], 1);
                visited[i][j] = false;
                checkExtraShapes(i, j);
            }
        }

        System.out.println(maxSum);
    }

    private static void solution(int x, int y, int sum, int depth) {
        if (depth == 4) {
            maxSum = Math.max(sum, maxSum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                solution(nx, ny, sum + arr[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    private static void checkExtraShapes(int x, int y) {
        // "ㅗ", "ㅜ", "ㅏ", "ㅓ" 모양을 확인
        if (x >= 0 && x < n - 1 && y >= 1 && y < m - 1) {
            int sum = arr[x][y] + arr[x][y - 1] + arr[x][y + 1] + arr[x + 1][y];
            maxSum = Math.max(maxSum, sum);
        }import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

        public class Main {
        	static int[][] dr = {{0,0,0,0},{0,0,1,1},{0,1,2,2},{0,1,1,2},{0,0,0,1},
        			{0,1,2,3},{0,1,2,2},{0,0,1,2},{0,0,1,2},{0,1,1,2},
        			{0,0,1,1},{0,0,1,1},{0,1,1,2},{0,1,1,1},{0,1,1,2},
        			{0,0,0,1},{0,1,1,1},{0,0,0,1},{0,1,1,1}};
        	static int[][] dc = {{0,1,2,3},{0,1,0,1},{0,0,0,1},{0,0,1,1},{0,1,2,1},
        			{0,0,0,0},{1,1,0,1},{0,1,0,0},{0,1,1,1},{1,0,1,0},
        			{1,2,0,1},{0,1,1,2},{1,0,1,1},{1,0,1,2},{0,0,1,0},
        			{0,1,2,0},{0,0,1,2},{0,1,2,2},{2,0,1,2}};
        	public static void main(String[] args) throws IOException {
        		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        		StringTokenizer st = new StringTokenizer(in.readLine());
        		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        		
        		int[][] map = new int[N][M];
        		for(int i = 0 ;i<N; i++) {
        			st = new StringTokenizer(in.readLine());
        			for(int j = 0; j<M; j++) {
        				map[i][j] = Integer.parseInt(st.nextToken());
        			}
        		}
        		
        		int maxSum = -1;
        		for(int i = 0; i<N; i++) {
        			for(int j = 0; j<M; j++) {
        				outer : for(int tetNum = 0; tetNum<dr.length; tetNum++) {
        					int[] curXs = dr[tetNum];
        					int[] curYs = dc[tetNum];
        					int sum = 0;
        					for(int k = 0; k<4; k++) {
        						int curX = i+curXs[k];
        						int curY = j+curYs[k];
        						if(curX < 0 || curY <0 || curX >= N || curY >=M)
        							continue outer;
        						
        						sum+= map[curX][curY];
        					}
        					maxSum = Math.max(maxSum, sum);
        				}	
        			}
        		}
        		System.out.println(maxSum);
        	}
        }
        if (x >= 1 && x < n && y >= 1 && y < m - 1) {
            int sum = arr[x][y] + arr[x][y - 1] + arr[x][y + 1] + arr[x - 1][y];
            maxSum = Math.max(maxSum, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 0 && y < m - 1) {
            int sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
            maxSum = Math.max(maxSum, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 1 && y < m) {
            int sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
            maxSum = Math.max(maxSum, sum);
        }
    }
}
>>>>>>> f01f57c881f59b9eb64a480fdce04b3119e40180
