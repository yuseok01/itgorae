package Day_3;

public class Arr_2차원 {
	public static void main(String[] args) {
		//행 우선 순회
		int [][] arr = new int[3][3];
		int num = 1;
		for(int r = 0 ; r <arr.length; r++) {
			for(int c = 0 ; c < arr[0].length ; c++) {
				arr[r][c]=num++;
				System.out.print(arr[r][c]+ " ");
			}
			System.out.println();
		}
		System.out.println("열");
		for(int c = 0 ; c < arr[0].length; c++ ) {
			for(int r = 0 ; r < arr.length; r++) { 
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
		
		System.out.println("지그재그");
		for (int r = 0 ; r < arr.length; r++ ) {
				if(r%2 == 0) {
					for(int c = 0; c<arr[0].length; c++) {
						System.out.print(arr[r][c]+" ");
					}System.out.println();
					
				}else {
					
					for(int c = arr[0].length -1 ; c >= 0; c--) {
						System.out.print(arr[r][c] + " ");
					}
				}
		}
		
	
	}

}
