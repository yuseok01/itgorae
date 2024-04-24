package A형대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {
	static int [] arr;
	static boolean [] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t =1 ; t <= tc ; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for(int i =0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dp(0);
			
			
		}
	}
	static void dp(int n) {
		if() return;
		
		
		
		check[n] = true;
		check
	}

}
