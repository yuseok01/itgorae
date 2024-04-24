package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_3_2660_회장뽑기 {
    static ArrayList<Integer>[] map;
    static int n;
    static int min;
    static int[] candidate;

    static class Node {
    	int to;
    	int depth;
    	
    	public Node(int to, int depth) {
    		this.to = to;
    		this.depth = depth;
    	}
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n];
        candidate = new int[n];
        min = 50;

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        while (true) {
        	st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1)
                break;

            map[a - 1].add(b - 1);
            map[b - 1].add(a - 1);
        }

        for (int i = 0; i < n; i++) {
            int tmp = bfs(i); //확인할 노드 

            candidate[i] = tmp;
            min = Math.min(min, tmp);
        }

        int count = 0;

        for (int i = 0; i < candidate.length; i++) {
            if (candidate[i] == min)
                count++;
        }

        System.out.println(min + " " + count);

        for (int i = 0; i < candidate.length; i++) {
            if (candidate[i] == min)
                System.out.print(i + 1 + " ");
        }
    }

    private static int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        boolean[] visit = new boolean[n];
        visit[start] = true;
        int count = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < map[now.to].size(); i++) { //now랑 연결된거 찾기 
                if (!visit[map[now.to].get(i)]) {
                    q.add(new Node(map[now.to].get(i), now.depth + 1));
                    visit[map[now.to].get(i)] = true;
                }
            }
            count = now.depth;
        }
        return count;
    }

}