package DDay13일타싸피;

public class a1_일타싸피연습 {
	public static void main(String[] args) {
		int [] start = {1,1};
		int [] end = {2,2};
		int a = Math.abs(end[0] - start[0]); //x좌표의 차이
		int b = Math.abs(end[1]- start[1]); //y좌표의 차이
		
		double c = Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2)); //거리구하기  //직각 삼각형 
		
		
		//아크탄젠트는 math.atan로 구하기 결과는 라디안 -> degree가 필요함 math.toDegree가 필요 
		double radian = Math.atan(b/a); //레디안 
		radian = Math.atan(a/b); //레디안 
		System.out.printf("%f, %f",c, Math.toDegrees(radian));  //거리 1.4 //45각 
		
		double result = Math.pow(c, 2) +  
		
	}

}
