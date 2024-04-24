package Day_3;

import java.util.Scanner;

public class Arr_2차원_델타 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][]arr = new int [5][5];
		
		int[]dr = {-1,0,1,0}; //상우하좌
		int[]dc	= {0,1,0,-1};
		
		int pr = 2; //현재위치
		int pc = 2; //현재위치 
		
		arr[pr][pc] = 1;
		
		while (true) {
			int d = sc.nextInt();
			
			arr[pr][pc] = 0;
			
			if(!(0 <= pr + dr[d] && pr +dr[d] < arr.length && 0<= pc + dc[d] && pc +dc[d] < arr[0].length)) {
				continue;
			}
			
			pr = pr + dr[d]; //인덱스 지
			pc = pc + dc[d];
			
			arr[pr][pc] = 1;
			
			System.out.println();
			for (int r = 0; r < arr.length ; r++) {
				for (int c = 0; c < arr[0].length; c++) {
					System.out.print(arr[r][c]+" ");
				}
				System.out.println();		
			}
			System.out.println();

		}
	}

}
