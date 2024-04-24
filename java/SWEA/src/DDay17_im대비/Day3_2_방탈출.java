package DDay17_im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_2_방탈출 {
	
	public static void main(String[] args) throws IOException {
		
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] bulb = new int[n + 2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			bulb[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			if(bulb[i] == 1) {
				result++;
				bulb[i + 1] = bulb[i + 1] == 1 ? 0 : 1;
				bulb[i + 2] = bulb[i + 2] == 1 ? 0 : 1;
			}
		}	
		
		System.out.println(result);
	}

}