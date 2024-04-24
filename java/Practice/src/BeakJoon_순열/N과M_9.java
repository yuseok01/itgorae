package BeakJoon_순열;

import java.io.*;
import java.util.*;

public class N과M_9 {
    static int[] arr;
    static int[] print;
    static boolean[] visited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        print = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) 
            arr[i] = Integer.parseInt(st.nextToken()); //int로 받아 정렬

        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int depth){
        if(depth == M){ //깊이와 같아지면
            for(int i = 0; i<M; i++)
                System.out.print(print[i]+" ");
            System.out.println();
        }

        else{
            int before = 0; 
            for(int i = 0; i<N; i++){ // 원소 전체길이 
                if(visited[i]) //방문했으면 
                    continue;

                if(before != arr[i]){ //arr이랑 겹치면 안쓰려는 의도 
                    visited[i] = true; //하나쓸께
                    print[depth] = arr[i]; //출력 저장
                    before = arr[i]; 
                    dfs(depth+1);
                    visited[i] = false; //다썼어
                }
            }
        }
    }
}