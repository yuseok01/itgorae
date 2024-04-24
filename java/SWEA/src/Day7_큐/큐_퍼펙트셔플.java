package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			int n = sc.nextInt();
			String [] input = new String[n];
			String [] arr = new String[n];
			
			Queue<String> queue = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			
			for(int i = 0 ; i <n ; i++) {
				input[i] = sc.next();
				if(n%2 == 0) {
					if( i < (n/2)) {
						queue.add(input[i]);
					}
					else {
						queue2.add(input[i]);
						
					}								
				}
				else {
					if( i < (n/2)+1) {
						queue.add(input[i]);
					}
					else {
						queue2.add(input[i]);
						}
					}
					
				}
			for(int i = 0 ; i < n ;i++) {
				if(i%2==0) {
					arr[i] = queue.poll();
						
				}
				else {
				arr[i]= queue2.poll();
				}
			}
			System.out.print("#"+t+" ");
			for(int i = 0 ; i <n ; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
		}
	}
}
