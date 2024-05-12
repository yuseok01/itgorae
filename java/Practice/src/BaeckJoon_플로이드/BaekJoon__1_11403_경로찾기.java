package BaeckJoon_플로이드;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon__1_11403_경로찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		for (int k = 0 ; k < n ; k++) { 
			for (int i = 0 ; i< n ; i++) {
				for(int j = 0 ; j <n ; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) { //i부터 k k부터 j까지 연결되어있으면 
						arr[i][j]= 1;
					}
				}
			}
		}
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n ; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
