package Dday24_Dijkstra;

import java.util.*;

public class Test2_서울_05반_박민정2 {
	// 좌표와 누적 위험성, 이전에 shelter를 거쳤는지를 저장하는 class Point 선언
	static class Point {
		public int x; // x좌표
		public int y; // y좌표
		public int danger; // 누적 위험성
		public boolean shelter; // 이전에 shelter를 거쳤는지
		
		Point(int y, int x) { // y와 x만 주어진 경우
			this.y = y; // y 설정
			this.x = x; // x 설정
			this.danger = 0; // danger 0으로 설정
			this.shelter = false; // shelter false로 설정
		}
		
		Point(int y, int x, int danger, boolean sheter) { // y, x, danger, shelter가 주어진 경우
			this.y = y; // y 설정
			this.x = x; // x 설정
			this.danger = danger; // danger 설정
			this.shelter = sheter; // shelter 설정
		}
	}
	
	static int answer; // 정답 answer 선언
	static int N; // 마을 크기 N 선언
	static int M; // shelter 개수 M 선언
	static int[][] map; // 마을 배열 map 선언
	static boolean[][] visited; // 마을 방문 여부 visited 선언
	static Queue<Point> queue; // 방문할 Point 큐 선언
	static Point[] shelters; // shelter 배열 shelters 선언
	
	public static void main(String[] args) {
		
		// scanner 정의
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 받기
		int tc = sc.nextInt();
		
		// 테스트케이스 시작
		for (int t = 1; t <= tc; t++) {
			// answer 변수 초기화
			answer = Integer.MAX_VALUE;
			
			N = sc.nextInt(); // N 받기
			M = sc.nextInt(); // M 받기
			
			map = new int[N][N]; // map 초기화
			visited = new boolean[N][N]; // visited 초기화
			queue = new LinkedList<>(); // queue 초기화
			shelters = new Point[M]; // shelters 초기화
			int sIdx = 0; // shelters의 인덱스를 저장하는 sIdx 초기화
			
			// N*N만큼
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					map[y][x] = sc.nextInt(); // 정수를 받아서 map에 저장
				}
			}
			
			// M만큼
			for (int i= 0; i < M; i++) {
				int y = sc.nextInt(); // y 받기
				int x = sc.nextInt(); // x 받기
				shelters[sIdx++] = new Point(y, x); // shelters에 Point 저장
			}
			
			// queue에 현재 위치 추가
			queue.offer(new Point(0, 0));
			// 너비 탐색 실행
			bfs();				
			// 결과 출력
			System.out.printf("#%d %d\n", t, answer);
		}
		// scanner 종료
		sc.close();
	}
	static int[] dy = {-1, 0, 1, 0}; // y의 이동 위치 dy에 저장
	static int[] dx = {0, 1, 0, -1}; // x의 이동 위치 dx에 저장
	
	// 현 위치가 shelters 안에 있는지 확인하는 함수
	static boolean checkShelter(int y, int x) {
		boolean result = false; // result 초기화
		for (Point shelter: shelters) { // shelters의 각 Point마다
			if (y == shelter.y && x == shelter.x) { // 현 위치와 동일하면
				result = true; // result에 true 저장
				break; // 종료
			}
		}
		return result; // result 반환
	}
	
	// 너비 탐색 진행하는 함수
	static void bfs() {
		while (!(queue.isEmpty())) {
			Point curr = queue.poll();
			
			int x = curr.x; // 현위치 x 저장
			int y = curr.y; // 현위치 y 저장
			int danger = curr.danger + map[y][x]; // 누적 위험성에 현위치 위험성을 더한 값 저장
			boolean shelter = (curr.shelter) || (checkShelter(y, x)); // 이전에 shelter 방문 여부와 현위치의 shelter 여부 저장
			
			//  현위치가 도착 위치이면
			if ((curr.y == N - 1) && (curr.x == N - 1)) {
				if (shelter) answer = Math.min(answer, danger); // 이전에 shelter 방문했을 경우, 최소값 저장
				continue; // 다음 위치로
			}
			
			// 현위치 방문 처리
			visited[y][x] = true;
			
			// 사방으로 이동
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i]; // 이동 예정 y좌표
				int nx = x + dx[i]; // 이동 예정 x좌표
				
				// ny와 nx가 마을 범위 안이고 방문한 적 없으면
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && visited[ny][nx] == false) {
					// queue에 추가
					queue.offer(new Point(ny, nx, danger, shelter));
				}
			}
			
		}
	}
	
}
