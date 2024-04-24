package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>(); //tc 안에서 선언
			
			
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			while(true) {
				int now = 0;
				for(int i = 1 ; i <=5; i++ ) {
					now = queue.poll()-i;
					if (now<=0) {
						now = 0;
						queue.offer(now);
						break; //for문 탈출문
					}
					queue.offer(now); //0이 아니면
				}
				if(now==0) { // ============while탈출문 
					break;
				}
		
				
			}
			System.out.print("#"+t+" ");
			
			for(int i = 0 ; i < 8 ;i++) {
				System.out.print(queue.poll()+" ");
			}System.out.println();
			
			
		}
		
		

	}

}
