import java.util.*;
import java.io.*;


public class Softeer_0_성적평가{
    static int N;
    static int[] sums;
    static int[] nowIndex;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        

        List<Integer> grade = new ArrayList<>(); 
        N = Integer.parseInt(br.readLine());
        sums = new int[N];
        

        for (int i = 0; i < 3; i++) { // 대회 갯수 
            st = new StringTokenizer(br.readLine());
            grade.clear();

            nowIndex = new int[N];
            for (int j = 0; j < N; j++) { // 고려할 사람 
                nowIndex[j] = Integer.parseInt(st.nextToken());
                grade.add(nowIndex[j]);
                sums[j] += nowIndex[j]; //j번째 사람 점수 더하기 
            }

            grade.sort(Collections.reverseOrder());

            for (int j = 0; j < N; j++) {
                bw.append((grade.indexOf(nowIndex[j]) + 1) + " ");
            }
            bw.append("\n");
        }

        grade.clear();
        nowIndex = new int[N];
        for (int j = 0; j < N; j++) {
            grade.add(sums[j]); // 누적합 더해주기 
        }

        Collections.sort(grade);
        Collections.reverse(grade);

        for (int j = 0; j < N; j++) {
            bw.append((grade.indexOf(sums[j]) + 1) + " ");
        }

        bw.flush();   
    }
}