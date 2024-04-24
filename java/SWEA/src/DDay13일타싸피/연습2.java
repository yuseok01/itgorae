package DDay13일타싸피;

import java.util.Scanner;

public class 연습2 {
	static double tempX; //X 좌표 거리 
	static double tempY; //Y 좌표 거리
	static double tempZ; //빗변 거리
	static double tempRadian;
	static double tempAngle;
	static double [] myBall = new double[2];
	static double [] purposBall = new double[2];
	static double [] hole = new double[2];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		for(int i =0 ; i <2 ; i++) { //내공 좌표 
			myBall[i] = sc.nextDouble();
		}
		for(int i =0 ; i <2 ; i++) {// 목적구
			purposBall[i]= sc.nextDouble();
		}
		for(int i =0 ; i <2 ; i++) {//목적지
			hole[i] = sc.nextDouble();
		}
		distance(myBall,hole); //빗변 거리 
		z(); //빗변 거리 
		double aDistance = tempZ; 
		double aRadian = tempRadian;
		double aAngle = tempAngle;
		
		distance(purposBall,hole);
		z();
		double bDistance = tempZ;              
		double bRadian = tempRadian;
		double bAngle = tempAngle;
		
		System.out.println(aDistance+ "  "+ aRadian+ "  "+aAngle+" ");
		System.out.println(bDistance+ "  "+ bRadian+ "  "+bAngle+" ");
	}
	static void distance(double [] a, double [] b) {
		tempX = Math.abs(b[0]-a[0]);
		tempY = Math.abs(b[1]-a[1]);
	}
	static void z() {
		tempZ = Math.sqrt(Math.pow(tempX, 2) + Math.pow(tempY, 2));
	}
	static void Radian() {
		tempRadian = Math.atan(tempY/tempX);
	}
	static void Angle() {
		tempAngle = Math.toDegrees(tempRadian);
	}
	
	//공 위치를 받고 이동하는게 어떻게
	

}
