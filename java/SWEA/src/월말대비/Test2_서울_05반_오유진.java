package 월말대비;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2_서울_05반_오유진 {
	static int ans;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());// testcase 개수
		for (int tc = 1; tc <= t; tc++) {
			arr= new int[3][9]; //3일차동안 각각 물건 9개니까 
			for (int i=0; i<3;i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j=0; j<9;j++) {
					int a = Integer.parseInt(st.nextToken());
					arr[i][j]=a; // 배열에저장 
				}
			}
			ans =Integer.MIN_VALUE; // 최대 수익 (돈은 무조건 0이상이므로 최솟값을 0이라고 설정한다. ) 
			combination(0, 0, 0, 0, 0);
			System.out.println("#" + tc + " " +ans);
		}
	}
	// 총 판매개수, 1일차 /2일차/ 3일차 판매개수 , 매출액을 변수로 받는다. 
	public static void combination(int cnt, int first, int second, int third,int money) {
		if(cnt ==9) {
			if(money>ans) ans =money;  // 정답 갱신 
			return;
		}
		// 하루당 3개씩 판매할 수 있으므로, 하루에 판매한양이 3개를 넘지않는다면 가능한 경우의수를 다 따져본다. 
		if(first<3) combination(cnt+1, first+1, second, third, money+arr[0][cnt]);
		if(second<3) combination(cnt+1, first, second+1, third, money+arr[1][cnt]);
		if(third<3) combination(cnt+1, first, second, third+1, money+arr[2][cnt]);
	}
}
