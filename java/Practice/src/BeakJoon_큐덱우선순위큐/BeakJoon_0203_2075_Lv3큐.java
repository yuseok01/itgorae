package BeakJoon_큐덱우선순위큐;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BeakJoon_0203_2075_Lv3큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr = new int[N*N];
		
		for(int i= 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();	
		}
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-(N)]);
		
	}

}
