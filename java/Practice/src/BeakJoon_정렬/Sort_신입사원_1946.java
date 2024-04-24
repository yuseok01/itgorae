package BeakJoon_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort_신입사원_1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());

			int[] score = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				score[a-1]=b; 
				
			}
			int cnt=1;
			int rating = score[0];
			for(int i = 1; i< n ; i++) { //0은 이미소진 
				if(rating > score[i]) {
					cnt++;
					rating = score[i];
				}
			}
			System.out.print(cnt);
			System.out.println();
		}
	}
}
