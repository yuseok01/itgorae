import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			b[i] = -Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < n; i++) {
			sum += a[i] * -b[i];
		}
		System.out.println(sum);

	}

}
