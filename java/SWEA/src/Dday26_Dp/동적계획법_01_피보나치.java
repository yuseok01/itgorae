import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_01_피보나치 {
	static int[] callFibo = new int[100];
	static int[] memo; //계산값을 저장하기 위한 공간을 할당하겠다.
	
	static {
		memo = new int[1000];
		Arrays.fill(memo, -1); //-1로 초기화 하겠다. 
		memo[0] = 0;
		memo[1] = 1;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo2(N));
		System.out.println(fibo1(N));
//		System.out.println(Arrays.toString(callFibo));
		
	}
	
	public static int fibo3(int n) {
		//큰 값을 구하려면 int 형이 아니라 long 바꾸어서 처리해보자
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i<= n ; i++)
			dp[i] = dp[i-2] + dp[i-1];
		
		return dp[n];
		
		
	}
	
	public static int fibo2(int n) {
		if(memo[n] == -1) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	
	
	
	
	
	
	
	public static int fibo1(int n) {
		callFibo[n]++;
//		if(n == 0) return 0;
//		if(n == 1) return 1;
//		if(n <= 1) return n;
		if(n < 2) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
}
