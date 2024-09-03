import java.io.*;
import java.util.*;

public class Softeer_3_우물안개구리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int people = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());
        
        int[] gym = new int[people + 1];
        boolean[] visited = new boolean[people + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= people; i++) {
            gym[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[] list = new LinkedList[people + 1];
        for (int i = 1; i <= people; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a); // 양방향 그래프이므로 반대 방향도 추가합니다.
        }

        int cnt = 0;
        for (int i = 1; i <= people; i++) {
            if (!visited[i]) {
                cnt += findLeader(i, list, gym, visited);
            }
        }

        System.out.println(cnt);
    }

    private static int findLeader(int start, List<Integer>[] list, int[] gym, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        int maxGym = gym[start];
        int maxNode = start;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            for (int j = 0; j < list[current].size(); j++) {
                int neighbor = list[current].get(j);
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);

                    if (gym[neighbor] > maxGym) {
                        maxGym = gym[neighbor];
                        maxNode = neighbor;
                    }
                }
            }
        }

        // 컴포넌트에서 가장 큰 점수를 가진 사람이 start인 경우 리더로 카운트
        return maxNode == start ? 1 : 0;
    }
}
