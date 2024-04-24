package 월말대비;

import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class tree2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		int n= Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i <= n; i++) {
			list.add(i);
		}
		sb.append('<');
		
		
		int cnt = 1; 
		while(!list.isEmpty()) {
			if(cnt == k) {
				if(list.size()==1) {
					sb.append(list.poll());
				}
				else {
					sb.append(list.poll()).append(", ");
					cnt = 1;
				}
			}
			else {
				list.add(list.poll());
				cnt++;
			}
		}
		sb.append('>');
		
		System.out.println(sb);
		
		
	}

}
