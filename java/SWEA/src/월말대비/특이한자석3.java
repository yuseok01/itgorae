package 월말대비;

import java.util.LinkedList;
import java.util.Scanner;

public class 특이한자석3 {
	private static LinkedList<Integer> first; 	//첫번째 톱니바퀴
	private static LinkedList<Integer> second; 	//두번째 톱니바퀴
	private static LinkedList<Integer> third; 	//세번째 톱니바퀴
	private static LinkedList<Integer> forth; 	//넷번째 톱니바퀴

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int s = 8;
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			first = new LinkedList<Integer>();
			second = new LinkedList<Integer>();
			third = new LinkedList<Integer>();
			forth = new LinkedList<Integer>();
			for (int i = 0; i < s; i++) {
				first.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				second.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				third.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				forth.add(sc.nextInt());
			}
			for (int k = 0; k < K; k++) {
				int arr[] = new int[5];

				int number = sc.nextInt();		//회전시킬 톱니바퀴
				int type = sc.nextInt();		// 1일경우 시계방향, -1일 경우 반시계방향
				switch (number) {
				case 1:					//첫번째 톱니바퀴 회전
					arr[1] = type;
					type *= -1;
					if (first.get(2) != second.get(6)) {
						arr[2] = type;
						type *= -1;
						if (second.get(2) != third.get(6)) {
							arr[3] = type;
							type *= -1;
							if (third.get(2) != forth.get(6)) {
								arr[4] = type;
							}
						}
					}
					break;
				case 2:				//두번째 톱니바퀴 회전
					arr[2] = type;
					type *= -1;
					if (second.get(6) != first.get(2)) {
						arr[1] = type;
					}
					if (second.get(2) != third.get(6)) {
						arr[3] = type;
						type *= -1;
						if (third.get(2) != forth.get(6)) {
							arr[4] = type;
							type *= -1;
						}
					}
					break;
				case 3:				//세번째 톱니바퀴 회전
					arr[3] = type;
					type *= -1;
					if (third.get(2) != forth.get(6)) {
						arr[4] = type;
					}
					if (third.get(6) != second.get(2)) {
						arr[2] = type;
						type *= -1;
						if (second.get(6) != first.get(2)) {
							arr[1] = type;
							type *= -1;
						}
					}
					break;
				case 4:					//네번째 톱니바퀴 회전
					arr[4] = type;
					type *= -1;
					if (forth.get(6) != third.get(2)) {
						arr[3] = type;
						type *= -1;
						if (third.get(6) != second.get(2)) {
							arr[2] = type;
							type *= -1;
							if (second.get(6) != first.get(2)) {
								arr[1] = type;
							}
						}
					}
					break;
				}
				for (int i = 1; i <= 4; i++) { //arr에 저장되어 있는 회전방향을 이용해서 회전시키기
					if (arr[i] != 0) {
						spin(i, arr[i]);
					}
				}
			}
			int result = 0;
			result += first.get(0) * 1;
			result += second.get(0) * 2;
			result += third.get(0) * 4;
			result += forth.get(0) * 8;
			System.out.println("#" + t + " " + result);
		}
	}

	private static void spin(int i, int j) {
		switch (i) {
		case 1:
			if (j == -1) {
				first.add(first.poll());
			} else {
				first.addFirst(first.pollLast());
			}
			break;
		case 2:
			if (j == -1) {
				second.add(second.poll());
			} else {
				second.addFirst(second.pollLast());
			}
			break;
		case 3:
			if (j == -1) {
				third.add(third.poll());
			} else {
				third.addFirst(third.pollLast());
			}
			break;
		case 4:
			if (j == -1) {
				forth.add(forth.poll());
			} else {
				forth.addFirst(forth.pollLast());
			}
			break;
		}

	}
}