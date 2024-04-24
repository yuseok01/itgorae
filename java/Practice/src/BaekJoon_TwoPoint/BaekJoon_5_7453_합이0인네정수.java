package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 생각하기
 * n의 최대 크기는 4000
 * 두개 합치면 16000
 * 정수의 최대값은 2^28 
 * 최악의 케이스일때 16000* 16000 *16000 * 16000 = int 초과
 */
public class BaekJoon_5_7453_합이0인네정수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int [] a = new int[n];
		int [] b = new int[n];
		int [] c = new int[n];
		int [] d = new int[n];
		
		for(int i = 0 ; i < n ;i ++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		int [] ab = new int[n*n];
		int [] cd = new int[n*n];
		//ab합 cd합
		int tmp = 0; 
		for(int i = 0 ;i<n ; i++) {
			for(int j = 0 ; j< n ;j++) {
				ab[tmp] = a[i] + b[j];
				cd[tmp] = c[i] + d[j];
				tmp++;
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		long cnt =0;
		int start = 0;
		int end = (n*n)-1;
		while(start < n*n && end >= 0) {
			if(ab[start]+cd[end]>0) {
				end--;
			}
			else if(ab[start]+cd[end]<0){
				start++;
			}
			else {
				long startCnt =1;
				long endCnt = 1;
				while(start+1<n*n && (ab[start]==ab[start+1])) { //왼쪽+1이 경계에 안걸리고 다음 스타트지점이 같을때
					startCnt++;
					start++;
				}
				while(end>0 &&(cd[end]==cd[end-1])) {
					endCnt++;
					end--;
				}
				cnt += startCnt * endCnt;
				start++;
			}
		}
		System.out.println(cnt);
	}

}
