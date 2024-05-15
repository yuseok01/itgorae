package BaeckJoon_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_4_1613_역사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int [][] historyTable = new int[v+1][v+1]; 
		//0인 사건은 없음 
		
		for (int i = 0; i < e ; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			historyTable[from][to] =1;
		}
		for(int k = 1; k <= v ; k++) {
			for(int i = 1; i <=v ;i++) {
				for(int j = 1; j<=v ;j++) {
					if(historyTable[i][k] == 1 && historyTable[k][j] ==1) {
						historyTable[i][j] = 1;
					}
				}
			}
		}
//		for(int i = 1 ; i <= v ; i++) {
//			for(int j = 1; j <=v ; j++) {
//				System.out.print(historyTable[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(historyTable[a][b] ==1 ) {
				System.out.println(-1);
			}else if(historyTable[b][a]== 1) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		
	}
}

