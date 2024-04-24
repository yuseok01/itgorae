package DDay18_빽트래킹;

import java.util.Scanner;

public class 수업_순열_4_비트마스킹 {
	static int N, L;
	static int[] cals;
	static int[] scores;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N 과 L이 입력되고. N줄에 걸쳐서 칼로리. 맛점수가 각각 입력됨 (1 ≤ N ≤ 20, 1 ≤ L ≤ 10000)
			N = sc.nextInt(); //재료의수
			L = sc.nextInt(); //칼로리제한
			cals = new int[N];
			scores = new int[N];
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			ans = 0;
			burger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	//idx : 내가 이번에 고려할 재료
	//sumCal : 지금까지 만들어진 햄버거의 중간 칼로리
	//sumScore : 지금까지 만들어진 햄버거의 중간 맛
	static void burger(int idx, int sumCal, int sumScore) {
		//내가 지금 어떠한 햄버거를 만들고 있는데.. 이미 제한 칼로리를 넘어서버렸다.!!!
		if (sumCal > L)
			return;
		//칼로리 안전한 햄버거가 완성이 되었습니다..
		if (idx == N) {
			if (ans < sumScore)
				ans = sumScore;
			return;
		}
		//이번 재료 뽑았어~~
		burger(idx + 1, sumCal + cals[idx], sumScore + scores[idx]);
		//이번 재료 안뽑았어~~
		burger(idx + 1, sumCal, sumScore);
	}

}
