package A형대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 특이한자석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc =1 ; tc<= t ; tc++) {
			int k = Integer.parseInt(br.readLine()); //회전 수 
			LinkedList<Integer> dq1 = new LinkedList<>();
			LinkedList<Integer> dq2 = new LinkedList<>();
			LinkedList<Integer> dq3 = new LinkedList<>();
			LinkedList<Integer> dq4 = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 8 ; i++) {
				dq1.offer(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 8 ; i++) {
				dq2.offer(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 8 ; i++) {
				dq3.offer(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 8 ; i++) {
				dq4.offer(Integer.parseInt(st.nextToken()));
			}
			
			for(int kk=0; kk < k ; kk++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());// 자석 번호
				int b = Integer.parseInt(st.nextToken());// 회전 정보 
				
				if(a==1) {//1번 톱니바퀴
					if(b==1) { // 정배
						
					}
				}
				
			}
		
			
		}
	}
}
