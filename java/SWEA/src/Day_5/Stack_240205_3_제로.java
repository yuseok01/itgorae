package Day_5;

import java.util.Scanner;
import java.util.Stack;

public class Stack_240205_3_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			int k = sc.nextInt();
			
			for(int i = 0 ; i < k; i++) {
				int input = sc.nextInt();
				
				if(input==0) {
					stack.pop();
				}
				else {
					stack.push(input);
				}
				
			}int result =0 ;
			while(!stack.isEmpty()) {
				result +=stack.pop();
				
			}
			System.out.print("#"+t+" "+result);
			System.out.println();
		}
		
	}

}
