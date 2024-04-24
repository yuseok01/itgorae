package 월말대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
	static  int [] dx = {-1,-1,0,1,1,1,0,-1};
	static  int [] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t <=tc ;t++) {
			int [][] arr = new int [6][7];
			for(int i = 0 ; i < 6 ; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 7; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			int result = 0;
			start : for(int i = 6 ; i >= 0 ; i--) {
				for(int j = 5 ; j>=0; j--) {
					if(arr[j][i]==0) {						
						for(int k = 0 ; k< 8; k++) {
							cnt=0;
							for(int l =1 ; l <=3 ;l++) {
								int idx = j + l* dy[k];
								int idy = i + l * dx[k];
								if(  0 <= idx && idx < 6 && 0<=idy && idy < 7 && arr[idx][idy]==1) {
									cnt++;
									if(cnt ==3) {
										
										result = i;
										break start;
									}
								}
							}
							
						}
					}
				}
			}
			if(result != 0 ) {
				System.out.print("#"+t+" "+ result);
				
				
			}
			else {
				System.out.print("#"+t+" "+ -1);
			
			}	
			System.out.println();
		}
		
	}

}
