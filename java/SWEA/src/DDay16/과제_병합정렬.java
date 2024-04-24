package DDay16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과제_병합정렬 {
	static int[] arr;
	static int[] sortedArr;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			sortedArr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}cnt=0;
			mergeSort(0, arr.length - 1);
			System.out.println("#"+tc+" "+arr[arr.length / 2]+ " "+cnt);
		}
	}

	static void mergeSort(int left, int right) {
		if (left < right) { //오른쪽이 왼쪽에 붙으면 종료 정렬할께없음 
			int mid = (left + right-1) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽의 시작
		int R = mid + 1; //오른쪽 시작
		int idx = left;
		
		if(arr[mid]> arr[right]) cnt++;
		
		while (L <= mid && R <= right) { // L이 미드에 붙고 R이 right에 붙으면 정렬할께없음 
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++]; //L이 R에 붙을때까지 L++
			} else
				sortedArr[idx++] = arr[R++];//
		}
		if (L <= mid) { //왼쪽남음
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		} else { //오른쪽남음 
			for (int i = R; i <= right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}
	}
}
