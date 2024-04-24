package DDay16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과제_백만개의정수정렬 {
	static int[] arr = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0, arr.length-1);
		System.out.println(arr[500000]);
	}

	static void quickSort(int left, int right) { // 5, 1, 2, 3, 4
		if (left < right) {    //왼쪽 오른쪽이 붙으면 false 종료 
			int pivot = partition(left, right); // 중심점에 메서드값 초기화
			quickSort(left, pivot - 1); // 
			quickSort(pivot + 1, right);

		}

	}

	static int partition(int left, int right) {
		int pivot = arr[left]; //중심점은 0이다 

		int L = left + 1;
		int R = right; // 왼쪽 한칸씩이동 오른쪽은 고정

		while (L <= R) { 
			while (L <= R && arr[L] <= pivot) 
				L++;
			while (arr[R] > pivot)
				R--;
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;

		return R;
	}
}
