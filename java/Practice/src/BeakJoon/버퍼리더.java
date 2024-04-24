package BeakJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 버퍼리더 {
    public static void main(String[] args) throws IOException { //쓰루 
        // BufferedReader와 BufferedWriter를 사용하여 입력과 출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //리더 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//라이터 선언

        // 테스트케이스의 개수 T를 입력받음
        int T = Integer.parseInt(br.readLine());

        // T만큼 반복
        for (int i = 0; i < T; i++) {
            // 각 테스트케이스의 두 정수 A와 B를 StringTokenizer를 사용하여 공백으로 구분하여 입력받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // A와 B를 더한 결과를 BufferedWriter를 통해 출력
            bw.write(A + B + "\n");
        }

        // 출력 버퍼 비우기
        bw.flush();

        // BufferedReader와 BufferedWriter를 닫음
        br.close();
        bw.close();
    }
}