package Day_2;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Mid {
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			int tc = sc.nextInt();
			int [] arr = new int[tc];
			for(int i = 0 ; i < tc ; i++) {
				int input = sc.nextInt();
				arr[i] = input;
			}
			Arrays.sort(arr);
			System.out.println(arr[tc/2]);
		
	}

}
