package Day_3;

public class Arr_전치행렬 {//대각선 반전
	public static void main(String[] args) {
		int[][]arr = {{1,2,3} ,{4,5,6},{7,8,9}};
		
		for(int r = 0; r< arr.length ; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c]+" ");
				
			}
			System.out.println();
		}
		
		for(int r = 0 ; r < arr.length; r++) {
			for(int c = 0 ; c < arr[0].length ; c++) {
				if(r<c) {
					int rmp = arr[r][c];
					arr[r][c] = arr[c][r];
					arr[c][r] = t mp;
				}
			}
		}
		printArr(arr);
	}
	

}
