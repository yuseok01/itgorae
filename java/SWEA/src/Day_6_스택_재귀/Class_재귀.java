package Day_6_스택_재귀;

public class Class_재귀 {
	
	public static void main(String[] args) {
		int result = fibo(10);
		System.out.println(result);
	}
	public static int fibo(int N) {
		return fibo(N-1) + fibo(N-2);
	}
}
