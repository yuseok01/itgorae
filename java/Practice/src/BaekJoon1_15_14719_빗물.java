import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon1_15_14719_빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[y];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < y ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean isPosible = false;
		int cnt = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			if(isPosible) {
				if(arr[i] == 0) {
					cnt ++;
				}
			}else {//첫방문 마지막방문
				if(arr[i]!=0) {
					isPosible=true;
				}
			}
		}
		
	}
}
