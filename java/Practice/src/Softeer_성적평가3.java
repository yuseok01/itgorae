import java.io.*;
import java.util.*;

public class Softeer_성적평가3 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n]; //입력배열 
        int[][] scores = new int[4][3001];
        int[][] answer = new int[4][n]; //결과 배열

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                scores[i][arr[i][j]]++;
                
                arr[3][j] += arr[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            scores[3][arr[3][i]]++;
        }

        Map<Integer, Integer>[] map = new HashMap[4];
        for(int i = 0; i < 4; i++){
            map[i] = new HashMap<>();
        }

        for(int i = 0; i < 4; i++){
            int rank = 1;
            for(int idx = 3000; idx >= 0; idx--){
                if(scores[i][idx] >= 1){
                    map[i].put(idx, rank);
                    rank += scores[i][idx];
                }
            }
        }


        for(int i = 0; i < 4; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = map[i].get(arr[i][j]);
                sb.append(answer[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}