package Day_4;

//주말에 재도전예정
//주말에 재도전예정
//주말에 재도전예정
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[100][100];// 100x100 크기의 문자열 배열 생성

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			// checkRow checkCol 이라는 메서드에서 나오는 결과가 답임 메서드 ㄱㄱ
//			int resultRow = checkRow(arr);
//			int resultCol = checkCol(arr);
			// 행 메서드, 열 메서드에서나온 값 중 큰게 답임 메서드 ㄱㄱ
//			System.out.printf("#%d %d", t, Math.max(resultRow, resultCol));
		}System.out.println();
	}

}

//	// 0행 부터 한줄씩 탐색하는 메서드!! 나는 0~99부터 회문인지 확인하고 회문일경우 메서드 종료할꺼임!! 리턴값은 가장 큰 열의 수를
//	// 가져오기 위해 당연히 int
//	public static int checkRow(char[][] arr) {
//		int rowMax = 100; // 100부터 회문 검사하고 실패하면 rowMax 값 감소시킬꺼임
//		int evenCnt = 100;
//		int oddCnt = 99;
//		// 맨처음 input받은 arr 배열 부터 가져와보자
//		for (int r = 0; r < 100; r++) {
//			for (int c = 0; c < 100 - 1; c++) {
//				// 짝수개 부터 회문 확인 할꺼임 맨처음 Arr[0][0] == Arr[0][99-c] 가 같은 지부터 비교
//				find_even: if (arr[r][c] == arr[r][99 - c]) {
//					int left = c + 1;
//					int right = 99 - c - 1;
//					//
//					while (left <= right) {
//
//						if (arr[r][left] == arr[r][right]) {
//							left++;
//							right--;
//						} else
//							break find_even;
//
//					}
//				}
//			}
//		}
//	}
//}