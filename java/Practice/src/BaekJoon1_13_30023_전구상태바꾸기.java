import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1_13_30023_전구상태바꾸기 {
    private static int n;
    private static char[] arr;
    private static int maxMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        String input = br.readLine();
        for(int i = 0 ; i< n; i++) {
            arr[i] = input.charAt(i);
        }
        maxMin = Integer.MAX_VALUE;
        result(arr.clone(), n , 'R',0,1);
        result(arr.clone(), n , 'G',0,1);
        result(arr.clone(), n , 'B',0,1);
        System.out.println(maxMin==Integer.MAX_VALUE ? -1:maxMin);
    }


    private static void result(char[] copy, int n, char goal, int cnt ,int idx) {
        if(idx==n-1) {//맨 끝 인덱스 앞까지 고려했다면
            int tmp = 0;
            for(int i = 0 ; i < n ; i++) {
//				System.out.print(copy[i]);
                if(copy[i]== goal) {
                    tmp++;
                }

            }
//			System.out.println();
            if(tmp == n) { //다 같은 문자라는 뜻
                if(cnt < maxMin) {
                    maxMin = cnt;
                }
                return;

            }
            return;
        }
        if(copy[idx-1] == goal) {//바꿀필요없음 
            result(copy, n , goal,cnt,idx+1);
        }
        else { //바꿔야함
            int tmp = 0;
            while(copy[idx-1] != goal) {
                transform(copy, idx - 1);
                tmp++;
            }
            int newCnt =tmp;
            while(tmp != 0) {
                for(int i = idx; i <= idx+1 ; i++) {
                	transform(copy, i);
                }tmp--;
            }
            result(copy, n , goal, cnt+ newCnt ,idx+1);
        }
    }

    
    private static void transform(char[] copy, int idx) {
        switch (copy[idx]) {
            case 'R':
                copy[idx] = 'G';
                break;
            case 'G':
                copy[idx] = 'B';
                break;
            case 'B':
                copy[idx] = 'R';
                break;
        }
    }
}

