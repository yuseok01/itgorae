import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1_1_핀볼게임 {
	private static int[][] arr;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int t = 1 ; t <= tc ;t++ ) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for(int i = 0 ; i < n ; i++) {//입력
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < j ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
	}
}
