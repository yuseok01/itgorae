package 월말대비;

import java.util.Arrays;

// 배열

public class Heap {
	static int[] heap = new int[100];
	static int heapSize;

	public static void main(String[] args) {
		heapPush(55);
		heapPush(56);
		heapPush(54);
		heapPush(52);
		
		System.out.println(Arrays.toString(heap));
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
	}

	static void heapPush(int data) { // 삽입
		heap[++heapSize] = data; // 마지막 위치에 넣고자하는 것 삽입
		// 부모와 비교하면서 swap
		int ch = heapSize; // 최하위 자식 노드
		int p = heapSize / 2; // 상위 부모노드

		if (heap[p] < heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			ch = p;
			p = ch / 2;
		}
	}

	// 삭제
	static int heapPop() {
		// 루트에 있는 원소 제거
		int popItem = heap[1];
		// 마지막에 있는 원소 루트로 옮기기
		heap[1] = heap[heapSize++];

		int p = 1;
		int ch = p * 2;

		while (heapSize >= ch && heap[p] < heap[ch]) {
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			// 자식이 더크면 swap
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;
		}
		while (ch <= heapSize && heap[p] < heap[ch]) {

			// 자식이 더크면 스왑
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;
		}
		return popItem;
	}
	
}
