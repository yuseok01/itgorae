package BaekJoon_이분탐색;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_5_이분탐색_2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			if (start < a[i]) {
				start = a[i];
			}
			while (start <= end) {
				int middle = (start + end) / 2;
				int sum = 0;
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (sum + a[i] > middle) {
						count++;
						sum = 0;
					}
					sum = sum + a[i];
				}
				if (sum != 0)
					count++;
				if (count > m)
					start = middle + 1;
				else
					end = middle - 1;
			}
			System.out.println(start);
		}
	}
}
