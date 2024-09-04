import java.io.*;
import java.util.*;

public class Softeer_4_자동차테스트 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); //자동차 대수
    	int Q = Integer.parseInt(st.nextToken()); // 질의 갯수
    	
    	int [] carList = new int[N];
    	st = new StringTokenizer(br.readLine());
    	int min = Integer.MAX_VALUE;
    	int max = 0;
    	for(int i = 0 ; i < N ; i++) {
    		carList[i] = Integer.parseInt(st.nextToken());
    		if(carList[i] < min) {
    			min = carList[i];
    		}
    		if(carList[i] > max) {
    			max = carList[i];
    		}
    	}
    	
    	for(int i = 0 ; i < Q ; i++) {
    		int expect = Integer.parseInt(br.readLine());
    		if(expect<min || expect>max  ) {
    			System.out.println(0);
    			continue;
    		}
    		else {
    			
    			dfs(expect,carList,0,0);
    		}
    	}
    	
    }

	private static void dfs(int expect, int[] carList, int possibleCnt, int count) {
		//3개이면서 평균이 expect와 같으면 
		if(possibleCnt == 3 ) {
			
		}
		
	}
}
