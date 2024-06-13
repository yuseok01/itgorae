import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_4_10971_외판원순회 {
	private static int n;
	private static int[][] map;
	private static boolean[] isSelected;
	private static int min;
	private static int sum;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); //도시 갯수
		map = new int[n][n];
		isSelected = new boolean[n];
		min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < n ; i++) { // 출발점이 관리되어야함 
			isSelected[i] = true;
			bruteForce(i,i,0,1);
			isSelected[i] = false;
		}
		System.out.println(min);
		
	}

	private static void bruteForce(int start, int current, int sum, int count) {
		
		if(count == n ) {
			 if (map[current][start] != 0) { //항상 출발점으로 돌아올 수 있는 경우만 고려 하기 위해 넣어야함 
	                sum += map[current][start];
	                min = Math.min(min, sum);
	            }
			return;
		}
		for(int next = 0 ; next < n ; next++) {
			if(!isSelected[next] && map[current][next] != 0 ) { //자기 자신인 경우는 고려되면안됨 
				isSelected[next]= true;
				bruteForce(start, next, sum + map[current][next], count+1);
				isSelected[next]= false;
			}
		}
		
	}

}
