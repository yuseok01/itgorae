package DDay15_완탐;

import java.util.Arrays;

public class 수업_조합__재귀함수 {
	// 데이터 배열 
	int a = Arrays.binarySearch(null, 0)
	static String[] 속 = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] sel;
	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0,0);
	}
	
	//idx : 현재 내가 판단할 재료
	//sidx : 조합할 재료의 인덱스
	public static void combination(int idx, int sidx) {
		//base case
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		//idx가 경계를 벗어날 걱정을 할필요가 없다. 
		
		//recursive case
		for(int i = idx; i<= N-R+sidx; i++) {
			sel[sidx] = 속[i]; //재료 뽑았어요~~
			combination(i+1, sidx+1);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
