package BeakJoon_정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeSort이해 {
	static int[] tmp;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		tmp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + "\n") ;
			/*
			 * 5 1 2 3 4 5
			 */
		}
		System.out.println(sb);
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid); // 전반부 정렬
			mergeSort(arr, mid + 1, end); // 후반부 정렬
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int newStart = start;
		int newMid = mid + 1;
		int index = 0;
//		System.out.print("현재 배열 "+start +" 부터 "+end+" 까지: ");
//		for (int i = start; i <= end; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.print("\n");

		while (newStart <= mid && newMid <= end) {
			if (arr[newStart] <= arr[newMid]) {
//				System.out.println("NewStart가 더 작음! 현재 index: "+index+ " 바꿀 자리: "+newStart+", "+arr[newStart]);
				tmp[index++] = arr[newStart++];
			} else {
//				System.out.println("NewMid가 더 작음! 현재 index: "+index+ " 바꿀 자리: "+newMid+", "+arr[newMid]);
				tmp[index++] = arr[newMid++];
			}
		}
		while (newStart <= mid) { // 왼쪽 배열 부분이 남은 경우
//			System.out.println("왼쪽 배열 남음! 현재 index: "+index+ " 남은 자리: "+newStart+", "+arr[newStart]);
			tmp[index++] = arr[newStart++];
		}
		while (newMid <= end) { // 오른쪽 배열 부분이 남은 경우
//			System.out.println("오른쪽 배열 남음! 현재 index: "+index+ " 남은 자리: "+newMid+", "+arr[newMid]);
			tmp[index++] = arr[newMid++];
		}
		newStart = start;
		index = 0;
		while (newStart <= end) { // 결과를 A[]에 저장
			arr[newStart++] = tmp[index++];
		}
	}

}