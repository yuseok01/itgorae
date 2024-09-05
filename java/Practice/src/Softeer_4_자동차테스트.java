import java.io.*;
import java.util.*;

public class Softeer_4_자동차테스트 {
    private static int N;
    private static int Q;
    private static double[] carList; // carList를 double로 변경
    private static int totalCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // Number of cars
        Q = Integer.parseInt(st.nextToken()); // Number of queries

        carList = new double[N]; // carList 배열을 double로 선언
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            carList[i] = Double.parseDouble(st.nextToken()); // 자동차 속도를 double로 입력 받음
        }

        // Process each query
        for (int i = 0; i < Q; i++) {
            double expect = Double.parseDouble(br.readLine()); // expect를 double로 처리
            totalCnt = 0;
            dfs(expect, 0, 0.0, 0, new ArrayList<>()); // sum을 double로 처리
            System.out.println(totalCnt);
        }
    }

    // DFS to generate all combinations of three cars
    private static void dfs(double expect, int possibleCnt, double sum, int start, List<Double> selected) {
        // When we select 3 cars, check if the average is equal to the expected value
        if (possibleCnt == 3) {
            if (Math.round(sum / 3) == expect) { // sum / 3이 double이므로 double expect와 비교
                totalCnt++;
            }
            return;
        }

        // Iterate through the list starting from the current index
        for (int i = start; i < N; i++) {
            selected.add(carList[i]);  // 선택된 자동차 추가
            dfs(expect, possibleCnt + 1, sum + carList[i], i + 1, selected);
            selected.remove(selected.size() - 1);  // 백트래킹
        }
    }
}
