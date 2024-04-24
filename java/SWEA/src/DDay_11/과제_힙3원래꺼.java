package DDay_11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 아무것도 없는 곳에 최대 합 만드는 문제
 * (tc 1번) , (5번 수행), (삽입 3) , (삽입 2) , (삽입 5) ,(삭제) ,(삭제)
 * 1
 * 5
 * 1 3
 * 1 2
 * 1 5
 * 2
 * 2
 */
public class 과제_힙3원래꺼 {
	static int[] heap; // 허허벌판
	static int size; // 허허벌판2

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;


		int T = Integer.parseInt(br.readLine()); // 테케 받기
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt(br.readLine());

			heap = new int[200003];// 최대
			size = 0;
			Arrays.fill(heap,0);
			// 연산 시작
			for (int i = 0; i < N; i++) { // 입력 시작
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());

				if (c == 1) {
					int x = Integer.parseInt(st.nextToken());
					insert(x); // 삽입 요청 -> x입력받고 x들고 메서드로 ㄱㄱ
				} else {
					sb.append(" "+delete()); // 2 입력 최대값 출력 후 해당 키값 삭제 append에 추가
				}
			}
			System.out.printf("#%d ",tc);
			System.out.println(sb);
		}
		
		
	}

	static void insert(int x) { // 1의 목적 3을 삽입하자 부모와 교환
		heap[++size] = x; // 현재 힙 사이즈를 증가시키고 그 힙 인덱스에 x 삽입 ==> 배열 맨끝에 넣겠다

		int cur = size; // 현재 사이즈를 cur 변수에 넣음
		while (cur > 1) { // 1보다 작으면 비교할 값이 없어서 브레이크 || 1보다 크면 삽입 값이 큰지 작은지 비교해보자
			int parent = cur / 2; // 부모의 위치
			if (heap[parent] < heap[cur]) {
				int tmp = heap[parent]; // 자바에서 위치바꾸려면 임시변수 선언해야하는거 알지?
				heap[parent] = heap[cur];
				heap[cur] = tmp;
				cur = parent;
			} else
				break;
		}
	}

	static int delete() {// 최대 값을 삭제할꺼야 삭제할 값이 없으면 -1 출력
		if (size == 0)
			return -1;
		int firstKing = heap[1]; // 현재 최대값을 ret에 저장

		heap[1] = heap[size]; // 막내의 만행
		heap[size--] = 0; // 힙 사이즈를 하나 줄이고 마지막에 0을 초기화 하겠다

		int now = 1;
		int left = 2;
		int right = 3;

		while (now < size) { // 1보다 힙 크기가 더 크면 while문 들어간다. 만행 수습 || size가 2보다 작으면 수습할것이 없다

			if (heap[left] > heap[right]) {// 좌의정 우의정 비교 ||좌의정이 더 크면 편안

				if (heap[left] <= heap[now]) { // 근데 왕은 좌의정보다 커?
					break; // 편안
				} else {
					int tmp = heap[now]; // 아니면 바꿔야겠지? 바꾸려면 변수 3개
					heap[now] = heap[left];
					heap[left] = tmp;

					now = left; // 왕좌는 우의정에게;;
				}
			} else { // 우의정이 더 크면 바꿔야겠지
				if (heap[right] <= heap[now]) { // 왕이랑 우의정 비교
					break; // 편안
				} else {
					int tmp = heap[now]; // 아니면 바꿔야겠지 변수 3개
					heap[now] = heap[right];
					heap[right] = tmp;

					now = right; // 결국 우의정이 차지
				}
				left = now * 2; // [1 , 2, 3, 4, 5, 6] || 1, 2, 3 비교끝 4, 5, 6 비교 시작
				right = left + 1;

			}

		

		}
		return firstKing;

	}

}
