package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_3_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int studentNum = Integer.parseInt(st.nextToken());
		int capa = Integer.parseInt(st.nextToken());
		int[][] arr = new int[2][6];

		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[sex][grade - 1]++;
		}
		int result = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] % capa != 0) {
					result += (arr[i][j] / capa) + 1;
				} else {
					result += arr[i][j] / capa;
				}
			}
		}
		System.out.println(result);
	}
}