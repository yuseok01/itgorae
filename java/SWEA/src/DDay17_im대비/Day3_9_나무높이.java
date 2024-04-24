package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_9_나무높이 {
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int treeNum	= Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int [] map = new int[treeNum];
			for(int i =0; i < treeNum ; i++) {
				map[i]= Integer.parseInt(st.nextToken());
			}
		}
	}
}
