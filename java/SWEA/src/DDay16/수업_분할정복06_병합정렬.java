package DDay16;
import java.util.Arrays;

public class 수업_분할정복06_병합정렬 {
	static int[] arr = { 5, 22, 32, 26, 57, 19, 32, 55, 84 };
	static int[] sortedArr = new int[arr.length]; // 임시로 저장할 배열

	public static void main(String[] args) {

		System.out.println("정렬 전 : " + Arrays.toString(arr));
		// 값 두개만 인자 넣자
		mergeSort(0, arr.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}

	// left 구간의 시작 위치 / right 구간의 끝 위치
	static void mergeSort(int left, int right) { 
//		if(left >= right) return; 이렇게 컷 하거나
		if (left < right) { //잘된일 
			int mid = (left + right) / 2; //중간 잡기  
			mergeSort(left, mid); //왼쪽먼저
			mergeSort(mid+1, right);//오른쪽 
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽구간의 시작 포인트
		int R = mid+1; //오른쪽구간의 시작 포인트
		int idx = left; //정렬된 원소 저장할 위치
		
		//서로 아직 비교할 수 있는 값들이 남아있을때 
		while(L <= mid && R <= right) { 
			if(arr[L] <= arr[R]) sortedArr[idx++] = arr[L++];
			else sortedArr[idx++] = arr[R++];
		} 
		//왼쪽구간 남았어 ㅠ
		if(L<= mid) {
			for(int i = L; i<=mid; i++)
				sortedArr[idx++] = arr[i];
		}
		//오른쪽구간 남았어 ㅠ
		else {
			for(int i = R; i<=right; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		
		//마지막으로 해야할 행위~~~
		//원본에 반영하기~~~
		for(int i = left; i<=right; i++)
			arr[i] = sortedArr[i];
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
