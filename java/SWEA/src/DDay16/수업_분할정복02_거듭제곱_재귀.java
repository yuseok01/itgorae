package DDay16;

public class 수업_분할정복02_거듭제곱_재귀 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;

		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
		System.out.println(pow3(C, N));
	}

	public static int pow(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;

		// 재귀부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) {
			return pow(C, N / 2) * pow(C, N / 2);
		} else {// 서5 양지웅 훌륭
			return pow(C, (N - 1) / 2) * pow(C, (N - 1) / 2) * C;
		}
	}

	public static int pow2(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;

		int tmp;
		// 재귀부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) {
			tmp = pow2(C, N / 2);
			return tmp * tmp;
		} else {// 서5 양지웅 훌륭
			tmp = pow2(C, (N - 1) / 2);
			return tmp * tmp * C;
		}
	}
	
	
	
	
	

	public static int pow3(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;

		int tmp = pow3(C, N / 2);
		// 재귀부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) {
			return tmp * tmp;
		} else {// 서5 양지웅 훌륭
			return tmp * tmp * C;
		}
	}
}
