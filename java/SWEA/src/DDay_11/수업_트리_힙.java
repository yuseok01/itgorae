package DDay_11;

import java.util.Arrays;

public class 수업_트리_힙 {

	static int[] heap = new int[100];
	static int heapSize;

	public static void main(String[] args) {

		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(32);
		heapPush(1);
		heapPush(11);

		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());

	}

	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}

	// 삽입
	static void heapPush(int data) {
		// 마지막 위치에 노드 추가
		heap[++heapSize] = data;

		// 부모와 비교하면서 swap
		int ch = heapSize;
		int p = heapSize / 2;

		while (p > 0 && heap[p] < heap[ch]) {
			// swap
			swap(p, ch);

			ch = p;
			p = ch / 2;
		}
	}

	// 삭제
	static int heapPop() { 
		// 루트에 있는 원소 제거
		int popItem = heap[1];
		// 마지막에 있는 원소 루트로 옮기기
		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2;

		// 리프노드로 가면 자식이 없을 수도 있으니까 ch가 heapSize 이하인지 확인
		while (ch <= heapSize && heap[p] < heap[ch]) {
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			// 자식이 더 크면 swap
			// swap 메소드 구현
			swap(p, ch);

			p = ch;
			ch = p * 2;
		}

		return popItem;
	}

}
