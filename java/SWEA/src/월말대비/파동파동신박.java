package 월말대비;

import java.io.IOException;
import java.util.Scanner;

public class 파동파동신박 {
	static int n;
	static int startNum;
	static int a;
	static int b;
	static int d;
	static int [][]arr;
	static boolean [][] check;
	static int [] dx = {-1,-1,0,1,1,1,0,-1};
	static int [] dy  =  {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1 ; t<=tc ;t++) {
			n = sc.nextInt(); // 열 갯수
            startNum = sc.nextInt(); // 시작 숫자
            a = sc.nextInt(); // j값
            b = sc.nextInt(); // j값
            d = sc.nextInt(); // 증감
			arr = new int[n][n];
			check = new boolean[n][n];
			dfs(startNum, a, b);
			System.out.print("#"+t+" ");
			for(int i = 0; i< n ; i++) {
				int sum=0;
				for(int j =0; j<n ; j++) {
					sum+=arr[i][j];
				}System.out.print(sum+" ");
			}System.out.println();
		}
	}
	static void dfs(int depth, int idxI, int idxY) {
		arr[idxI][idxY] = depth;
		check[idxI][idxY]=true;
		for(int k = 0; k<8;k++) {
			int idx= idxI+dx[k];
			int idy = idxY + dy[k];			
			if(0<=idx && idx<n && 0<=idy && idy < n && !check[idx][idy]) {
				dfs(depth+d,idx,idy);
			}
		}
		
	}

}
