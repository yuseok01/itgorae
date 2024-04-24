package DDay_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7
//1번통해 감염되는 갯수
public class 연습_2진트리탐색DFS {
	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static int computer;
	static int M;
	static boolean [] cnt;
	static Node[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		computer = Integer.parseInt(st.nextToken()); // 컴터 갯수 입력 받기
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 노드 갯수
		arr = new Node[computer + 1]; // 컴퓨터 갯수 만큼 배열 생성
		cnt = new boolean[computer+1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int numberNode = Integer.parseInt(st.nextToken());// 부모 노드 인덱스 받음
			if (arr[numberNode] == null) {
				arr[numberNode] = new Node(0, 0);
			}	
			if (arr[numberNode].left == 0) {
				arr[numberNode].left = Integer.parseInt(st.nextToken());
			} else {
				
				arr[numberNode].right = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1);
		int result = 0;
		for(int i = 0 ; i < computer+1 ; i++) {
			if(cnt[i]){
				result++;
			}
			
		}System.out.println(result);

	}

	static void dfs(int num) {
		if (arr[num] != null) {
			if (arr[num].left != 0) {
				cnt[arr[num].left] = true;
				dfs(arr[num].left);

				if (arr[num].right != 0) {
					cnt[arr[num].right] = true;
					dfs(arr[num].right);
				}

			}
		}
	}
}