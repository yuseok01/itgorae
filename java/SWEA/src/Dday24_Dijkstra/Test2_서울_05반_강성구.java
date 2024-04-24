import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2_서울_05반_강성구2 {
	static int[][] map, map1;				
	static int n, m, homeCnt;
	static int[] homes, homeCost1;
	static int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			map = new int[n][n];									//입력 저장용 배열
			map1 = new int[n][n];									//dp용 배열
			for(int i=0; i<n; i++) {
				str = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(str[j]);			//입력 저장
				}
			}
			System.out.println("in");
			homes = new int[m];										//고양이 쉼터 정보 저장
			homeCost1 = new int[m];
			homeCnt = 0;
			for(int i=0; i<m; i++) {
				str = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				homes[homeCnt++] = 10000*a+b;						//
			}
			for(int i=0; i<n; i++) {
				Arrays.fill(map1[i], -1);
			}
			map1[n-1][n-1] = map[n-1][n-1];
			System.out.println("dp1");
			dp(n-1, n-1);
			for(int i=0; i<m; i++) {
				int home = homes[i];
				int a = home/10000;
				int b = home%10000;
				homeCost1[i] = map1[a][b];
			}
			for(int i=0; i<n; i++) {
				Arrays.fill(map1[i], -1);
			}
			map1[0][0] = map[0][0];
			System.out.println("dp2");
			dp2(0, 0);
			int ans = Integer.MAX_VALUE;
			for(int i=0; i<m; i++) {
				int home = homes[i];
				int a = home/10000;
				int b = home%10000;
//				homeCost2[i] = map1[a][b]-map[a][b];
				int total = map1[a][b]-map[a][b]+homeCost1[i];
				ans = Math.min(ans, total);
			}
			System.out.printf("#%d %d", tc, ans);
		}
	}
	
	static void dp(int i, int j) {
		int ni = i-1;
		int nj = j-1;
		if(ni>=0) {
			if(map1[ni][j]==-1) {
				map1[ni][j] = map1[i][j]+map[ni][j];
			}else {
				map1[ni][j] = Math.min(map1[ni][j] , map1[i][j]+map[ni][j]);
			}
			dp(ni,j);
		}
		if(nj>=0) {
			if(map1[i][nj]==-1) {
				map1[i][nj] = map1[i][j]+map[i][nj];
			}else {
				map1[i][nj] = Math.min(map1[i][nj] , map1[i][j]+map[i][nj]);
			}
			dp(i, nj);
		}
	}
	
	static void dp2(int i, int j) {
		int ni = i+1;
		int nj = j+1;
		if(ni<n) {
			if(map1[ni][j]==-1) {
				map1[ni][j] = map1[i][j]+map[ni][j];
			}else {
				map1[ni][j] = Math.min(map1[ni][j] , map1[i][j]+map[ni][j]);
			}
			dp2(ni,j);
		}
		if(nj<n) {
			if(map1[i][nj]==-1) {
				map1[i][nj] = map1[i][j]+map[i][nj];
			}else {
				map1[i][nj] = Math.min(map1[i][nj] , map1[i][j]+map[i][nj]);
			}
			dp2(i, nj);
		}

	}
}
