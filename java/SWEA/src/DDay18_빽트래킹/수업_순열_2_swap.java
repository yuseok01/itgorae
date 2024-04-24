package DDay18_빽트래킹;
import java.util.Arrays;

public class 순열_3_방문체크 {
	static int[] nums;
	static int N;
	static boolean[] visited; // 해당 원소 사용 유무
	static int[] result; // 순열결과 저장

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		
		perm(0);

	}
	
	//idx : 결과 배열에 저장할 위치
	public static void perm(int idx) {
		if(idx == N) {//다뽑았어~~
			System.out.println(Arrays.toString(result));
			return;
		}
		
		//N개의 원소를 가지고 판단 하려고!
		for(int i = 0 ; i<N; i++) {
			//이거 썼지롱!
			if(visited[i])continue;
			//아래의 코드가 실행이 된다는 뜻은? 안썼지롱이면 실행한다.
			result[idx] = nums[i];
			visited[i] = true; //이제 썼지롱!
			perm(idx+1);//다음 자리 판단 해줘잉~
			visited[i] = false; //이제 다시 안쓴척....
		}
		
	}
	
}
