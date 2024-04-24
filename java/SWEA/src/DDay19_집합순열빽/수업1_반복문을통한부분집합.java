package DDay19_집합순열빽;

import java.util.Arrays;

public class 수업1_반복문을통한부분집합 {
	public static void main(String[] args) {
		//2^N
		int n = 4;
		int [] sel = new int[n];
		
		for(int i =0; i<2; i++) {
			sel[0]=i;
			for(int j =0; j<2; j++) {
				sel[1] = j;
				for(int k =0; k<2; k++) {
					sel[2] = k;
					for( int l =0; l<2; l++) {
						sel[3] =l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}
	}
}
