package Day8_큐;

import java.util.Arrays;

public class 수업 {
	
	static String[] queue = new String[5];
	static int front = 0, rear=0;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(queue));
		enQueue("현경찬");
		System.out.println(Arrays.toString(queue));
		enQueue("김민지");
		System.out.println(Arrays.toString(queue));
		enQueue("이윤주");
		System.out.println(Arrays.toString(queue));
		enQueue("양지웅");
		System.out.println(Arrays.toString(queue));
		deQueue();
		deQueue();
		enQueue("박수진");
		enQueue("김현재");
		System.out.println(Arrays.toString(queue));
	}
	
	//공백상태
	//front와 rear가 같은 위치를 가리키고 있다.
	public static boolean isEmpty() {
		return front == rear;
	}
	//포화상태
	//front가 rear보다 한칸 앞서있는가를 확인
	public static boolean isFull() {
		return front == (rear +1) % queue.length;
		
	}
	//삽입
	public static void enQueue(String data) {
		if (isFull()) {
			System.out.println("큐가 포화상태입니다.");
			return;
		}
		rear = (rear +1 )%queue.length;
		queue[rear]=data;
		
	}
	public static String deQueue() {
		if (isEmpty()) {
			System.out.println("제거할 데이터가 없습니다.");
			return null;
		}
		front = (front +1) % queue.length;
		return queue[front];
	}
}
