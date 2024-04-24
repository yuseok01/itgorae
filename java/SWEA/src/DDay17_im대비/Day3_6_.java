package DDay17_im대비;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day3_6_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			int newbie = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			int [] eng = new int[newbie];
			for(int i = 0 ; i <newbie ; i++) {
				eng[i] = sc.nextInt();
			}
			Arrays.sort(eng); 
			for(int i = 0 ; i < newbie ; i++) {
				q.offer(eng[i]);
			}
		}
	}
}
