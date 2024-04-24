package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_피자화덕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		
		int tc = sc.nextInt(); //테스트 케이스입력
		int N = sc.nextInt();//화덕크기
		int M = sc.nextInt();//치즈 양 입력 
		
		for(int t= 1 ; t<tc ; t++) {
				for(int i = 0; i < 3 ; i++) { //화덕 갯수만큼만 회전
					queue.offer(sc.nextInt()); //치즈 양 입력받기
				}
				while(ture) {
					queue.offer(queue.poll()/2); //한바퀴 돌때마다 2분의 1 
					if(queue.peek()==1) {
						queue.poll();
					}
					
				}
		}
	}

}
