package DDay16;
import java.util.Arrays;

public class 수업_분할정복07_퀵정렬_호어파티션 {
	static int[] arr = { 5, 22, 32, 26, 57, 19, 32, 55, 84 };

	public static void main(String[] args) {

		quickSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	// 호어파티션
	static int partition(int left, int right) {
		int pivot = arr[left]; // 제일 왼쪽의 값을 피봇이라고 하겠다!

		int L = left + 1, R = right; // 시작은 피봇 한칸 옆부터

		while (L <= R) {
			// L : pivot 보다 큰 값을 찾을 때 까지 이동을하겠다.
			while (L <= R && arr[L] <= pivot)
				L++;
			// R : pivot 보다 작거나 같은 값을 만날때까지 이동하겠다.
			while (arr[R] > pivot)
				R--;

			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		// R이 pivot 위치해야할 곳 까지 이동을 마친 상태
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;

		return R; // 피봇값의 위치

	}
}