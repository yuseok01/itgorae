import java.io.*;
import java.util.*;

public class Softeer_3_우물안개구리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        int[] gym = new int[people + 1];
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
            boolean isLeader = true;
            for (int j = 0; j < list[i].size(); j++) {
                if (gym[i] <= gym[list[i].get(j)]) { //새로운놈이 더크면 
                    isLeader = false;
                    break;
                    
                }
            }
            if (isLeader) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
