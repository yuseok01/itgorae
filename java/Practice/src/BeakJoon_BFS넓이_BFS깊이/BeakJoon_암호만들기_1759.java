package BeakJoon_BFS넓이_BFS깊이;

import java.util.Arrays;
import java.util.Scanner;

public class BeakJoon_암호만들기_1759 {
	static int L; //조합할 수 
	static int C; // 후보 char
	static char [] arr;	
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[C];
		check = new boolean[C];
		for(int i = 0 ; i < arr.length; i++) {
			arr[i]= sc.next().charAt(0);
		}
		Arrays.sort(arr);
		
		dfs(0,0);

	}
	static void dfs(int start, int count) {
		if(count == 1) {
			String word = "";
			int a = 0; // 자음 갯수 담는 칸
			int b = 0; //모음 개수 담는 칸 
			
			for (int i =0; i<C ;i++) {
				if(check[i]) {
					word += arr[i];
					
					if (arr[i]=='a' || arr[i]=='e' ||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') {
						a++; //자음
					
					}else { 
						b++;
					}
				}
			}
			if( a>= 1 && b>=2) { //어차피 완탐임  
				System.out.println(word);
			}
		}
		for(int i = start; i < C; i++) {
			check[i]=true;
			dfs(start+1 , count +1);
			check[i] =false;
			
		}
	}

}
