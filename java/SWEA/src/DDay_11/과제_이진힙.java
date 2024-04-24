package DDay_11;

import java.util.Arrays;
import java.util.Scanner;

public class 과제_이진힙 {
	static int[] heap;
	static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			size = 0;
			heap = new int[N + 1];
			for (int i = 0; i < N; i++) {
				insult(sc.nextInt());

			}
//			for (int i = 1; i <= N; i++) {
//				System.out.print(heap[i] + " ");

			int result = 0;
			while (size >= 1) {
				size /= 2;
				result += heap[size];
			}
			System.out.println("#" + t + " " + result);

		}

	}

	static void insult(int k) {
		heap[++size] = k;

		int children = size;
		int parent = children / 2;
		while (parent > 0 && heap[children] < heap[parent]) {
			int temp = heap[children];
			heap[children] = heap[parent];
			heap[parent] = temp;
			children = parent;
			parent = children / 2;
		}
	}

}
