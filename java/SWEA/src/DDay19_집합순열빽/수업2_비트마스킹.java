package DDay19_집합순열빽;

public class 수업2_비트마스킹 {
	public static void main(String[] args) {
		int []arr = {1,2,3,4};
		int n = arr.length;

		for(int i = 0; i< (1<<n);i++) {
			int tmp =0;
			for(int j =0; j<n ;j++) {
				if((i & (1<<j))> 0) {
					tmp = arr[j];
					System.out.print(tmp+" ");
				}
			}
			System.out.println();
		}
	}

}
