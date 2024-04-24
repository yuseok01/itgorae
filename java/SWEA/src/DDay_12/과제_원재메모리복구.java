package DDay_12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 과제_원재메모리복구 { //sc.next 받고 charAt()

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			char before = '0';
			String memory = sc.next();
			int count = 0;
			for(int i = 0 ; i< memory.length(); i++) {
				if(before != memory.charAt(i)) {
					count++;
					before = memory.charAt(i);
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}

}