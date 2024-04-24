package BeakJoon_BFS넓이_BFS깊이;
import java.util.*;
import java.io.*;

public class BeakJoon_로또_6603_1 {
	static int k; //집합의 갯수 
	static int s; //원소 
	static int cnt;
	static int [] num; //원소 받는 배열
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) { //0이 들어오기 전까지 계속 입력받아야 해서 while문사용
			k=sc.nextInt(); //원소 갯수 입력받기 
			
			if(k==0) { //집합갯수가 0이면 그만
				break;	
			}
			num = new int[k]; 
			check = new boolean[k];
			
			for(int i = 0 ; i<k ; i++) {
				num[i] = sc.nextInt();
			}
			a(0,0);	
			System.out.println();//다음 입력
			
		}
		
	} //main 끝
	static void a(int dp,int start) {
		if (dp==6) {
			for (int i =0 ; i<k ; i++) { //집합의 갯수까지
				if(check[i]) { //방문했으면 출력 
					System.out.print(num[i]+" ");
				}
			}
			System.out.println();
		}//if 끝
		for(int i = start ; i < k ; i++) { //시작점부터 원소갯수까지
			check[i] =true; //방문 체크
			a(dp+1,i+1); //재귀 
			check[i]=false;	
			
			
		}
	}
	
}