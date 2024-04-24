package DDay20_그래프;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); //정점의 개수 (시작점이 0인지, 1인지를 문제를 보고 파악)
		int E = sc.nextInt(); //간선의 개수
		
		
		List<Integer>[] adjList = new ArrayList[V]; //인접리스트 ArrayList 배열
		
		for(int i = 0 ; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}//초기화작업
		
		
//		List<ArrayList<>> adjList2 = new 이런식의 구현도 가넝이지만 생각보다 헷갈린다.
		
		
		//간선을 입력 받자
		for(int i = 0 ; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			//가중치를 함께 저장하고 싶으면 사용자정의 클래스를 만들어 넣던지, int[] 형태를 넣던지....
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		
		//인접행렬 vs 인접리스트 
		
		//인접행렬의 장단점
		//정점 대비 간선이 너무나도 없다면... 메모리 낭비가 발생
		//두정점이 인접한지 바로 쳌 가넝
		
		//인접리스트의 장단점
		//메모리 활용도가 높다!
		//두정점이 인접한지 확인을 하려면 반복문을 필요로 한다.
		
		//지금 위에 작성한 장단점은 일부만을 살펴본것! 직접 여러개를 더 생각 해보자~~
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//main
}
