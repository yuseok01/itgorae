package BeakJoon_순열;

import java.util.*;
import java.io.*;

public class N과M_5 {
	
	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N]; // 입력받은 배열
		printArr = new int[N]; // 출력할 배열
		isVisited = new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순으로 정렬했다.
		
		dfs(0, 0);
	}
	
	static void dfs(int startIdx, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(printArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true; // 자기 자신은 빼고 배열에 담아야 함으로 boolean 배열을 추가해줬다.
				printArr[depth] = arr[i]; //깊이는 M크기만 큼 고정 arr[i]를 삽입
				dfs(i + 1, depth + 1); // 
				isVisited[i] = false; //출력한건 false로 변경 
			}
		}
		
	}
}