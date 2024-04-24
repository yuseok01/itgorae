package DDay13일타싸피;

import java.util.Scanner;

public class ta1p4 {
	static double[] a = new double[2];// 내공
	static double[] b = new double[2];// 넣을공
	static double[] hole = new double[2];// 구멍
	static double x;
	static double y;
	static double z;
	static double angle;
	static double r = 3;
	static double resultDistance;
	static double SuperAngle;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) { // 내공 입력
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < 2; i++) { // 목적구 입력
			b[i] = sc.nextInt();
		}

		for (int i = 0; i < 2; i++) { // 구멍 위치 입력
			hole[i] = sc.nextInt();
		}
		distance(a, hole); // 홀과 내공의 x y 거리 간격 구하기
		pyth(x, y); // 피타고라스: 홀이랑 내 위치 거리 구하기
		double aDistance = z;
		atan(x, y); // 내 공이랑 홀 앵글 구하기
		double aholeAngle = angle;

		distance(b, hole); // 홀과 목적구 x ,y 거리 간격 구하기
		pyth(x, y); // 피타고라스: 홀이랑 목적구 거리 구하기
		double bDistnace = z;
		atan(x, y);
		double bholeAngle = angle;

		double lastAngle;
		if (aholeAngle > bholeAngle) {
			lastAngle = aholeAngle - bholeAngle; // 목적구가 오른쪽
		} else {
			lastAngle = bholeAngle - aholeAngle; // 목적구가 왼쪽
		}

		double lastDistance = bDistnace + 2 * r;
		
		d(aDistance,lastDistance,lastAngle);
		
		finalAngle(aDistance,lastDistance,aholeAngle);
		System.out.println("목적구를 보내야할 각은 :" + SuperAngle + "입니다.");
		System.out.println("목적구 타격점 까지의 거리는" + resultDistance + "입니다");
	}

	ball[0][1]

	static void distance(double[] a, double[] hole) { //거리구하는 공식 
		x = Math.abs(b[0] - a[0]); //절때값 
		y = Math.abs(b[1] - a[1]);
	}

	static void pyth(double x, double y) { // 피타고라스 빗변구하기 
		z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	static void atan(double x, double y) { //직각 앵글 구하기 
		double radian = Math.atan(y/x); //x거리 y거리 atan
		angle = Math.toDegrees(radian); //todegree 하면 앵글 
	}
	
	static void d(double a, double b, double c) { //목적타겟까지의 거리 구하기 인자는 (c거리 , b거리 , angleA) 
		resultDistance =  Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2) - (2*a*b*Math.toRadians(c))); 
		
	}
	static void finalAngle(double a, double b, double c) { //최종각 = 처음각 + acos
		SuperAngle=(c+ ( Math.acos(( Math.pow(a, 2) + Math.pow(resultDistance, 2) - Math.pow(b,2) ) / 2 * a * resultDistance)));
	}


}
