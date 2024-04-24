package DDay13일타싸피;

import java.util.Scanner;

public class 각도메써드 {
	static int [] myball = new int[2] ; // {1,1};
	static int [] targetball1 = new int[2]; // {2,3};
	static int [] targetball2 = new int[2];//{3,1};
	static int [] hole = {10,10};
	
	
	
	static public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i <2 ; i++) {
			myball[i] = sc.nextInt();
		}
		for(int i = 0 ; i <2 ; i++) { //목적구 1 위치 입력받기
			targetball1[i] = sc.nextInt();
		}
		for(int i = 0 ; i <2 ; i++) {//목적구 2 위치입력받기
			targetball2[i] = sc.nextInt();
		}
		 double distanceResult = distance(targetball1,hole); //내공과 타겟볼의 각 
		 double radianResult = radian(targetball1,hole);
		
		System.out.println(distance(targetball1,hole));
		System.out.println(radian(targetball1,hole));
	}

	static double distance(int []targetball , int []hole) {
		int a = Math.abs(hole[0]-myball[0]);
		int b = Math.abs(hole[1]-myball[1]);
		
		return double c = Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));
		
	}
	static double radian(int []targetball , int []hole) {
		int a = Math.abs(hole[0]-myball[0]);
		int b = Math.abs(hole[1]-myball[1]);
		return double radian = Math.atan(b/a);
		
	}
}
