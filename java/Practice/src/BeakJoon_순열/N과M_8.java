package BeakJoon_순열;

import java.util.*;
import java.io.*;

public class N과M_8 {
	
	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();	
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
		System.out.println(sb);
	}
	static void dfs(int start ,int depth) {//시작 인덱스 , 깊이
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) { //depth를 시작으로 설정함으로써 첫번째 출력 값이 두번째 값보다 안작아짐 
			//true값없으면 자기도 포함 
			printArr[depth] = arr[i];
			dfs(i, depth+1); //자기 자신도 포함하기때문에  i와 start의 의미에 대해서 잘생각해보자
			
		}
		
	}
}