import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_8_1717_집합의표현 {
	/*
	 * 반례
10 5
0 1 2
0 2 3
0 3 4
1 1 4
1 1 3
	 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new LinkedList[n + 1]; // n + 1 크기로 생성

        for (int i = 0; i <= n; i++) { // 0부터 n까지 초기화
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int resultN = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (resultN) {
                case 0:
                    list[a].add(b);
                    list[b].add(a);
                    break;
                case 1:
                    boolean isContain = false;

                    for (int k = 0; k < list[a].size(); k++) {
                        if (list[a].get(k) == b) {
                            isContain = true;
                            System.out.println("YES");
                            break;
                        }
                    }
                    if (!isContain) {
                        System.out.println("NO");
                    }
                    break;
            }
        }
    }
}
