package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_5_2251_물의양 {
	//6가지 이동 케이스를 표현하기 위한 배열
	static int [] Sender = {0,0,1,1,2,2};
	static int [] Receiver = {1,2,0,2,0,1};
	static boolean visited[][];
	static boolean answer[];
	static int now[];
	
		//A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		now = new int[3]; //a b c의 물의양을 저장할 배열 
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		
		visited = new boolean[201][201];	
		answer = new boolean[201]; //결과 배열
		
		BFS();
		
		for (int i = 0 ; i < answer.length; i++) {
			if(answer[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	 static void BFS() {
		 Queue<AB> q = new LinkedList<>();
		 q.add(new AB(0,0));
		 visited[0][0] = true;
		 answer[now[2]] = true;
		 while(!q.isEmpty()) {
			 AB p = q.poll();
			 int A = p.A;
			 int B = p.B;
			 int C = now[2]-A-B;
			 							   //C는 전체 물의 양에서 A와 B를 뺀 것
			 for(int k = 0; k < 6 ; k++) { //A->B, A->C, B->A, B->C, C->A, C->B
				 int[] next = {A, B, C};
				 next[Receiver[k]] += next[Sender[k]];
				 next[Sender[k]] = 0;
				 
				 if(next[Receiver[k]] > now[Receiver[k]]) {
					 //물이 넘칠 때
					 //초과 하는 만큼 다시 이전 물통에 넣어준다.
					 next[Sender[k]] =next[Receiver[k]] - now[Receiver[k]];
					 next[Receiver[k]] = now[Receiver[k]];
				 }
				 if(!visited[next[0]][next[1]]) {
					 visited[next[0]][next[1]] = true;
					 q.add(new AB(next[0],next[1]));
					 if(next[0] == 0) {
						 answer[next[2]] = true;
					 }
				 }
			 }
		 }
		
	}
}
//A와 B의 값만 지니고 있으면 C는 유추할 수 있으므로 두 변수만 사용하기
class AB{
	int A;
	int B;
	public AB(int A, int B) {
		this.A = A;
		this.B = B;
	}
}