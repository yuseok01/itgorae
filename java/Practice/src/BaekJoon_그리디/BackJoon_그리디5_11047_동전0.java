package BaekJoon_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_그리디5_11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int coin [] = new int [n];
		for(int i = 0 ; i < n ; i++) {
			st=new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}int coinCnt =0;
		for(int i = n-1 ; i >= 0 ; i--) {
			if(m == 0) {
				break;
			}
			coinCnt += m / coin[i];
			m = m % coin[i];
			
		}
		System.out.println(coinCnt);
	}
}
