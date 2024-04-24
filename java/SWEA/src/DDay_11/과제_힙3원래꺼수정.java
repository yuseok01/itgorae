package DDay_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class 과제_힙3원래꺼수정 {
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

			// 연산 시작
			for (int i = 0; i < N; i++) { // 입력 시작
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());

				if (c == 1) {
					int x = Integer.parseInt(st.nextToken());
					insert(x); // 삽입 요청 -> x입력받고 x들고 메서드로 ㄱㄱ
				} else {
					sb.append(" " + delete()); // 2 입력 최대값 출력 후 해당 키값 삭제 append에 추가
				}
			}
			System.out.printf("#%d", tc);
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
		int popData = 0;

		if (size == 0) {
			popData = -1;
			return popData;
		} else
			popData = heap[1];

		heap[1] = heap[size--];

		int p = 1;
		int ch = p * 2;

		if (ch + 1 <= size && heap[ch] < heap[ch + 1]) {
			ch++;
		}

		while (ch <= size && heap[p] < heap[ch]) {

			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;

			if (ch + 1 <= size && heap[ch] < heap[ch + 1]) {
				ch++;
			}
		}

		return popData;

	}
}
