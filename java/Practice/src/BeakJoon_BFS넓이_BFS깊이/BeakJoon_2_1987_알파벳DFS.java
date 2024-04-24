package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class BeakJoon_2_1987_알파벳DFS {
    static char[][] arr;
    static Set<Character> s;
    static int R;
    static int C;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int resultCnt;

    public static void main(String[] args) throws IOException {
       	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        s = new HashSet<>();

        for (int i = 0; i < R; i++) {
        	String input = br.readLine();
            for (int j = 0; j < C; j++) {
            	arr[i][j] = input.charAt(j);
            }
        }
        resultCnt = 0;
        dfs(0, 0, 0);
        int result = resultCnt==0?1:resultCnt;
        System.out.println(result);
    }


    private static void dfs(int x, int y, int cnt) {
        if (s.contains(arr[x][y])) {
            resultCnt = Math.max(resultCnt, cnt);
            return;
        }
       
        s.add(arr[x][y]);

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < R && nowY < C) {
                dfs(nowX, nowY, cnt + 1);
            }
        }
        //return 되면 빼주기
        s.remove(arr[x][y]);
    }
}