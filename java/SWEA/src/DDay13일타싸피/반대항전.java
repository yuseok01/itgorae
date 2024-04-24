package DDay13일타싸피;

public class 반대항전 {
	static double[][] holes = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	static double[][] balls = new double[6][2]; // 1, 3, 8
	// 2, 4, 8

	static double targetangle;

	public static void main(String[] args) {
		////////////////
		balls[0][0] = 1;
		balls[0][1] = 1;
		balls[1][0] = 20;
		balls[1][1] = 60;

		/////////////////
		double whiteball_x = balls[0][0]; // x 길이
		double whiteball_y = balls[0][1]; // y 길이

		double targetball_x = balls[1][0]; // x 길이
		double targetball_y = balls[1][1]; // y 길이

		// 거리

		double x = Math.abs(holes[5][0] - whiteball_x); // x 길이
		double y = Math.abs(holes[5][1] - whiteball_y); // y 길이
		double z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double tempRadian = Math.atan(y / x);
		double tempAngle = Math.toDegrees(tempRadian);

		double myBallRadian = tempRadian;
		double myBallAngle = tempAngle;
		double myBallz = z;

		x = Math.abs(holes[5][0] - targetball_x);
		y = Math.abs(holes[5][1] - targetball_y);
		z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		tempRadian = Math.atan(y / x);
		tempAngle = Math.toDegrees(tempRadian);

		double targetBallradian = tempRadian;
		double targetBallAngle = tempAngle;
		double targetBallz = z;

		double angle2 = 90 -((90 -myBallAngle  )+(90-targetBallAngle));
		double targetdistance = Math.sqrt(Math.pow(myBallz, 2)+ Math.pow(targetBallz+5.73, 2)-(2*myBallz*targetBallz*Math.toRadians(angle2)));
		double targetangle = myBallAngle +  Math.acos((Math.pow(myBallz, 2)+ Math.pow(targetdistance, 2)- Math.pow(targetBallz+5.73, 2))/2* myBallz * targetdistance);

		System.out.println(angle2);
		System.out.println(targetdistance);
		System.out.println(targetangle);
	}
}

//	static void targetDistacne() {
//		targetdistance = Math.sqrt(Math.pow(myBallz, 2) + Math.pow(targetBallz + 5.73, 2)
//				- (2 * myBallz * targetBallz * Math.sin(Math.toRadians(angle2))));
//	}
//
//	static void targetAngle() {
//		double numerator = Math.pow(myBallz, 2) + Math.pow(targetdistance, 2) - Math.pow(targetBallz + 5.73, 2);
//		double denominator = 2 * myBallz * targetdistance;
//
//		// Check for potential issues to avoid NaN
//		if (denominator != 0) {
//			double cosValue = numerator / denominator;
//
//			// Check if the value is within the valid range for acos function
//			if (cosValue >= -1 && cosValue <= 1) {
//				targetangle = myBallAngle + Math.toDegrees(Math.acos(cosValue));
//			} else {
//				System.out.println("Invalid cosine value. Cannot calculate targetangle.");
//			}
//		} else {
//			System.out.println("Denominator is zero. Cannot calculate targetangle.");
//		}

