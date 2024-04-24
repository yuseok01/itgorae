package DDay16;

public class 병합정렬수도연습 {
	public static void mergsort(int left, int right) {
		if(left<right) {
			int mid= (left+right)/2;
			mergsort(left,mid);
			mergsort(mid,right);
			merge(left,mid,right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L <= mid && R <=right) {
			if(arr[L] <=right) newArr[idx++] = arr[L++];
			else newArr[idx++] = arr[R++]; //바꿔야행
		}
			if(L<=mid) {
				for(int i =L; i<=mid ; i++)
					sortedArr[idx++] = arr[i];
			}
			else {
				for(int i =R ; i<=right; i++)
			}
	}

}
