package BeakJoon_순열;

import java.util.*;
import java.io.*;

public class N과M_6 {
	
	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N]; // 입력받은 배열
		printArr = new int[M]; // 출력할 배열
		visit = new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순으로 정렬했다.
		
		dfs(0, 0);
	}
	
	static void dfs(int depth, int start) {//시작 인덱스 , 깊이
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(printArr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true; // 자기 자신은 빼고 배열에 담아야 함으로 boolean 배열을 추가해줬다.
				printArr[depth] = arr[i]; //깊이는 M크기만 큼 고정 arr[i]를 삽입
				dfs(depth+1, i); // 
				visit[i] = false; //출력한건 false로 변경 
			}	
		}
		
	}
}