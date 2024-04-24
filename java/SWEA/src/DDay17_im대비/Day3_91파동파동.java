package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_91파동파동 {
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //배열크기
			int M = Integer.parseInt(st.nextToken()); //파동 시작 값
			int R = Integer.parseInt(st.nextToken()); //행
			int C = Integer.parseInt(st.nextToken()); //열
			int D = Integer.parseInt(st.nextToken()); //증감
			
		}
	}
}
