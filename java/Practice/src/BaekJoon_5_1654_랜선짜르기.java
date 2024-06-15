import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BaekJoon_5_1654_랜선짜르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		long min = 0;
		long max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			
		}	
		max ++; //max가 1인경우 mid값이 0이됨
		while(min < max) { //11의 끝 찾기 => 12까지 탐색 
			//임시Cnt가 cnt보다 크면 min = mid 
			// 작으면 max = mid
			long mid = (min + max)/2; 
			
			long resultCnt = 0;
			for(int i = 0; i < n ; i++) {
				resultCnt += arr[i]/mid; 
			}
//			System.out.println("현재 cnt ="+resultCnt + " 찾을 cnt ="+ cnt );
			if (resultCnt < cnt) {
				max = mid;
			}
			else { //붙었을때 한개씩 올려줘야해 
				min = mid+1;
			}

			
		}
		System.out.println(min-1);
		
	}
}
