package DDay16;
public class 수업_분할정복04_이진검색_재귀 {
	static int[] arr;
	static int key;

	public static void main(String[] args) {
		// 정렬된 상태라고 가정 //정렬을 따로 해줘야 한다!
		arr = new int[] { 2, 4, 6, 8, 9, 17, 28 };
		key = 7;

	}

	public static boolean binarySearch(int st, int ed) {
		if(st > ed) return false; //못찾았어 (교차가 되버리니 고만훼)
		
		int mid = (st+ed) / 2; //학습용ㅇ (범위를 고려해주면 더좋아)
		
		//같다면
		if(arr[mid] == key) return true;
		//크다면(왼쪽구간으로)
		else if(arr[mid] > key) return binarySearch(st, mid-1);
		//작다면(오른쪽구간으로)
		else return binarySearch(mid+1, ed);
	}
}
