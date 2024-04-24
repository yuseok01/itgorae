package BeakJoon_재귀;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1별찍기20 {
	
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new char[4 * n - 3][4 * n - 3];
		star (n, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != '*') sb.append(' ');
				else sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void star (int n, int x, int y) {
		if (n == 0) return;
		
		for (int i = x; i < x + 4 * n - 3; i++) {
			arr[i][y] = '*';
			arr[i][y + 4 * n - 4] = '*';
		}
		
		for (int j = y; j < y + 4 * n - 3; j++) {
			arr[x][j] = '*';
			arr[x + 4 * n - 4][j] = '*';
		}
		
		star (n - 1, x + 2, y + 2);
	}
}
