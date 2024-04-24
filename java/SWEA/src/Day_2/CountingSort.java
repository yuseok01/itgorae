	package Day_2;
	
	import java.util.Scanner;
	
	public class CountingSort {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int tc = sc.nextInt();
			
			for(int t=1 ; t <= tc ; t++) {
				int n = sc.nextInt();
				int []arr = new int[n];	
				int max=0;
				for(int i = 0 ; i < n ; i++) {
					arr[i]= sc.nextInt();
					if(arr[i] > max) {
						max = arr[i]; //최대값 찾고 
					}
				}
				int [] count = new int[max+1]; 
				for(int i = 0 ; i < n ; i++) { //최대값이 크기인 배열 만들고 숫자 추가
					count[arr[i]] += 1;
				}
				for(int i = 1 ; i < count.length; i++) { //i-1 값 누적 합 1은 볼필요없음
					count[i] += count[i-1];
				}
				int [] sortedArr = new int [n];
				for(int i =arr.length-1 ; i >=0 ; i--) { //원래 배열 값 -> 카운팅 배열의 인덱스 -> 그 인덱스의 갯수 에 arr[i] 삽입
					sortedArr[--count[arr[i]]] = arr[i]; // 카운트 값 빼주기 
				}
				System.out.print("#"+t+" ");
				for(int i = 0 ; i < arr.length; i++) {
					System.out.print(sortedArr[i]+" ");
				}
				System.out.println();
			}
			
			
		}
	
	}
