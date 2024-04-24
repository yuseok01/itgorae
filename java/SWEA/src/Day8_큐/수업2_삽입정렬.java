package Day8_큐;

import java.util.Arrays;

public class 수업2_삽입정렬 {
	public static void main(String[] args) {
// 맨앞 고정 하나씩 비교
		int[] data = { 69, 10, 30, 2, 7, 16, 8, 31, 22 };

		for (int i = 1; i < data.length; i++) {

			int key = data[i];

			int j;
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}
			// 반복문 안에서 key가 들어갈 위치 찾았는데...
			data[j + 1] = key;
		}
		System.out.println(Arrays.toString(data));
	}

}
