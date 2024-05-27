package BaekJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_dijkstra_특정한최단경로 {
    private static int N, E, Ans; // N:정점, E:간선
    private static int INF = 200000000; //200,000 * 1,000
    private static ArrayList<Node>[] adjList;
    private static int[] cost;
    private static boolean[] visited;
    private static class Node implements Comparable<Node>{
        int to, cost; //dest: 목적지, cost: 거리
        public Node(int to, int w){
            this.to = to;
            this.cost = w;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost; //cost 기준 오름차순 정렬
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Ans = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        cost = new int[N+1];
        visited = new boolean[N+1];

        
        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            //양방향
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }
        //반드시 갈곳
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0; 
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        int ans2 = 0; 
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        if(ans1 >= INF && ans2 >= INF) Ans = -1; //경로가 없는 경우
        else Ans = Math.min(ans1, ans2); //경로가 있을 경우 더 작은 값

        bw.write(Ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private static int dijkstra(int start, int end){
        //최저비용 기준 탐색경로 저장 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(visited, false); //방문여부 체크 배열 false로 초기화
        Arrays.fill(cost, INF); //cost 배열 INF로 초기화

        cost[start] = 0; //시작점이기 때문에 거리 0으로 셋팅
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(visited[now.to]) continue; //방문했던 정점이면 스킵
            visited[now.to] = true; //미방문이면 방문으로(true)로 셋팅하고 for문 처리

            //간선 탐색
            for (Node next:adjList[now.to]) {
                if(cost[next.to] > next.cost + now.cost){
                    cost[next.to] = next.cost + now.cost;
                    pq.add(new Node(next.to, cost[next.to]));
                }
            }
        }

        return cost[end]; //목적지 end 까지의 최단거리
    }
}