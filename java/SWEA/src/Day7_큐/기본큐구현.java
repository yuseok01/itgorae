package Day7_큐;

import java.util.Queue;

public class 기본큐구현 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>(); // 큐선언 링크드리스트는 구현체

		//삽입
		queue.add(1);//실패시 예외 발생
		queue.offer(1); //실패시 false
		//삭제
		queue.remove(); //실패시 예외 발생
		queue.poll();//실패시 null
		//조회
		queue.element();//실패시 예외 발생
		queue.peek();//실패시 null
		//오류시 프로그램 멈춰야함 위에
		//오류시 계속진행 해야함 아래
	}
}
