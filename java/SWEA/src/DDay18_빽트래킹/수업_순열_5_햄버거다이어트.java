package DDay18_빽트래킹;
import java.util.Arrays;

public class 순열_4_비트마스킹 {
	static int[] nums;
	static int N;
	static int[] result; // 순열결과 저장

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 0 };
		N = nums.length;
		result = new int[N];
		
		perm(0, 0);

	}

	// idx : 결과배열에 저장할 위치
	// visited : 사용한 원소를 기록하기 위한 정수
	public static void perm(int idx, int visited) {
//		if(visited == (1<<N)-1) return; //비트가 정신을 이겼을때!
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// 모든 원소를 돌면서 판단 하겠다.
		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) != 0)continue;
			//아래의 코드가 수행이 된다는 것은 해당 i번째 원소 사용x
			result[idx] = nums[i];
			//재귀를 내려보내고
			perm(idx+1, visited | (1<<i));
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	}

}
