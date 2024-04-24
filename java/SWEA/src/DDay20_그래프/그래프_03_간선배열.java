package DDay20_그래프;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_03_간선배열 {

	static class Edge {
		int A, B; // 시작과 끝노드

		public Edge(int a, int b) {
			A = a;
			B = b;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + "]";
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 정점의 개수 (시작점이 0인지, 1인지를 문제를 보고 파악)
		int E = sc.nextInt(); // 간선의 개수

		Edge[] edges = new Edge[E]; //객체 배열
		List<Edge> edges2 = new ArrayList<>(); //리스트로 만들기
		
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			edges[i] = new Edge(A, B);
		}
		
		//나는 객체 싫은데?
		int[][] edges3 = new int[E][2]; // [i][0] : 시작정점, [i][1] : 끝정점
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}// main
}
