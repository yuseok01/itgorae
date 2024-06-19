import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1_10_20040_사이클게임 {
	
	private static int n;
	private static int m;
	private static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		
		for(int i = 0 ; i < n ; i++) {
			list[i] = new ArrayList<>();
		}
		int result = 0;
		start : for(int i = 1 ; i <= m ; i++) {
			st= new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			list[nodeA].add(nodeB);
			list[nodeB].add(nodeA);
			
			while(isCycle()) {
				result = i;
				break start;
			}
		}
		System.out.println(result);
	}

	private static boolean isCycle() {
		//boolean => 이전노드 더 이전 노드 확인용 
		//parent => 직전노드 확인용 
        boolean[] visited = new boolean[n]; 

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int current, int before, boolean[] visited) {
        visited[current] = true;

        for (int neighbor : list[current]) {
            if (!visited[neighbor]) {//다음 노드가 방문하지 않았다면 
                if (dfs(neighbor, current, visited)) {//다음 노드 탐색 
                    return true;
                }
            } else if (neighbor != before) { //방문 한 곳이면서 이전 노드가 아니라면 //사이클발견 
                return true;
            }
        }
        return false;
    }
}
