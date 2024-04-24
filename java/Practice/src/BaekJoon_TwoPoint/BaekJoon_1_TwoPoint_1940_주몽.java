package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1_TwoPoint_1940_주몽 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i <N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = arr.length-1;
		int sum = 0;
		int cnt =0;
		Arrays.sort(arr);
		while(start < end) {//둘이 붙으면 끝
			sum = arr[start] + arr[end];
			if(sum < M) {//목적 값보다 작을때 
				start++;
			}
			else if(sum == M) {//같으면 둘다 이동 cnt ++
				start++;
				end--;
				cnt++;
			}
			else { // 값이 더 크면 왼쪽으로 한칸 
				end--;
			}
			//이모든게 정렬했기때문에 가능한이야기
			
		}
		System.out.println(cnt);
	}
	
}
