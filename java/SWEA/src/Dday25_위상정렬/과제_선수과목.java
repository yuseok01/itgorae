package Dday25_위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 과제_선수과목 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr[] = new ArrayList[V + 1];
		
		for (int i = 1; i <= V; i++)
			arr[i] = new ArrayList<Integer>();
		int graph[] = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to); //위치 담는 배열
			graph[to]++; //몇개 들어오는지 체크 
		}
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= V; i++)
			if (graph[i] == 0) //루트노드면 
				que.add(i); 
		int answer[] = new int[V + 1]; //결과담는 배열 
		int tmp = 1;
		while (!que.isEmpty()) { //큐가 빌때까지 
			int size = que.size(); //현재 0인애들 갯수 만큼 사이즈 
			while (size-- != 0) { //후위 연산자 : 비교하고 사용 
				int now = que.poll(); //사용 
				answer[now] = tmp; 
				for (int child : arr[now])
					if (--graph[child] == 0)
						que.add(child);
			}
			tmp++;
		}
		for(int i = 1 ; i <= V ; i++) 
			System.out.print(answer[i]+" ");
		
	}

}