import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1_2293_동전 {
	  private static int n;
	    private static int k;
	    private static int count = 0; // 가능한 방법의 수를 저장할 변수

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        n = Integer.parseInt(st.nextToken());
	        k = Integer.parseInt(st.nextToken());
	        
	        int[] arr = new int[n];
	        for(int i = 0 ; i < n; i++) {
	            st = new StringTokenizer(br.readLine());
	            arr[i] = Integer.parseInt(st.nextToken());    
	        }
	        
	        // 초기 DFS 호출
	        dfs(0, arr, 0);
	        
	        // 결과 출력
	        System.out.println(count);
	    }

	    // DFS 함수 정의
	    private static void dfs(int sum, int[] arr, int idx) {
	        // 합이 k와 같아지면 방법의 수를 증가시킴
	        if(sum == k) {
	            count++;
	            return;
	        }
	        
	        // 합이 k를 초과하면 더 이상 진행하지 않음
	        if(sum > k) {
	            return;
	        }
	        
	        // 모든 동전을 시도
	        for(int i = idx; i < n; i++) {
	            dfs(sum + arr[i], arr, i); // 같은 동전을 여러 번 사용할 수 있음
	        }
	    }
}
