import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1_13_30023_전구상태바꾸기 {
    private static int n;
    private static char[] arr;
    private static int maxMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = input.charAt(i);
        }
        maxMin = Integer.MAX_VALUE;

        result(arr.clone(), 'R', 0, 0);
        result(arr.clone(), 'G', 0, 0);
        result(arr.clone(), 'B', 0, 0);

        System.out.println(maxMin == Integer.MAX_VALUE ? -1 : maxMin);
    }

    private static void result(char[] copy, char goal, int cnt, int idx) {
        // 전구가 마지막 부분일 경우
        if (idx > n - 3) { // idx가 n-3 이상일 때
            boolean allSame = true;
            for (int i = 0; i < n; i++) {
                if (copy[i] != goal) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                maxMin = Math.min(maxMin, cnt);
            }
            return;
        }

        if (copy[idx] == goal) {
            result(copy, goal, cnt, idx + 1);
        } else {
            flip(copy, idx);
            result(copy, goal, cnt + 1, idx + 1);
            flip(copy, idx); // 백트래킹을 위해 원상복구
        }
    }

    private static void flip(char[] arr, int index) {
        for (int i = index; i < index + 3 && i < n; i++) { // 범위 체크
            arr[i] = nextColor(arr[i]);
        }
    }

    private static char nextColor(char color) {
        switch (color) {
            case 'R':
                return 'G';
            case 'G':
                return 'B';
            case 'B':
                return 'R';
            default:
                return color;
        }
    }
}
