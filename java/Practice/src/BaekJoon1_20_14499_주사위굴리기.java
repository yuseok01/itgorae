import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BaekJoon1_20_14499_주사위굴리기 {
	static class location{
		int x;
		int y;
		public location(int x, int y) {

			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		int [] dice = new int[7];
		Arrays.fill(dice, 0);
		Queue<location> list = new ArrayList<>();
		list.add(new location(startX, startY));
		
		int[][] arr = new int[x][y];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < cnt; i++) {
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				location now = list.poll();
				if(now.x+1 < y) {
					
				}
				break;

			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			}
		}
	}
}
