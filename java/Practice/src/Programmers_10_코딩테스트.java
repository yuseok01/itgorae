import java.io.*;
import java.util.*;

public class Programmers_10_코딩테스트 {
    public static void main(String[] args) {
        int[][] grid = { { 2, 2, 0, 0, 0 }, { 0, 3, 1, 0, 0 }, { 0, 0, 3, 3, 2 }, { 0, 0, 3, 0, 0 },
                { 0, 0, 0, 2, 0 } };
        int a = 10;
        int b = 20;

        int result = solution(grid, a, b);
        System.out.println("최종 결과: " + result);
    }
    

    private static int solution(int[][] grid, int a, int b) {
        /*
         * a 택배 없을 때 b 택배 있을 때 0 벽 1 창고 2 집 3 빈칸
         */
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Warehouse warehouseLocation = null;
        int houseCnt = 0;

        // 창고 위치와 집의 수를 찾기
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    warehouseLocation = new Warehouse(i, j);
                    
                } else if (grid[i][j] == 2) {
                    houseCnt++;
                }
            }
        }

        // houseDistance 배열 선언
        int[] houseDistance = new int[houseCnt];
        Arrays.fill(houseDistance, 0); // 거리 초기화 (0: 갈 수 없는 집)

        // BFS로 창고에서 집까지의 최단 거리 계산
        int[][] distances = bfs(grid, warehouseLocation);

        // 집들의 최단 거리를 houseDistance 배열에 저장
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    if (distances[i][j] != -1) {
                        houseDistance[index] = distances[i][j]; // 도달 가능한 경우 거리 저장
                    } else {
                        houseDistance[index] = 0; // 도달 불가능한 경우 0으로 저장
                    }
                    System.out.println("집 " + (index + 1) + "까지의 거리: " + houseDistance[index]); // 거리 출력
                    index++;
                }
            }
        }
        
     // 0을 제외한 마지막 집을 찾기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int lastNonZeroIndex = -1;
        for (int i = 0; i < houseDistance.length; i++) {
            if (houseDistance[i] != 0) {
            	pq.add(houseDistance[i]);
//                lastNonZeroIndex = i; // 마지막 0이 아닌 값을 가진 인덱스를 저장
            }
        }

     // 최종 결과 계산
        int total = 0;
//        for (int i = 0; i < houseDistance.length; i++) {
//            if (i == lastNonZeroIndex) {
//                // 마지막 집에서는 창고로 돌아갈 필요가 없으므로 (거리 * a)만 계산
//                total += (houseDistance[i] * b);
//            } else {
//                // 나머지 집들은 창고로 돌아가므로 (거리 * a) + (거리 * b)를 계산
//                total += (houseDistance[i] * a) + (houseDistance[i] * b);
//            }
//        }
        while(!pq.isEmpty()) {
        	int nowDistance = pq.poll();
        	if(!pq.isEmpty()) {
        		total+= (a+b)*nowDistance;
        	}else {
        		total+= b*nowDistance;
        	}
        }

        return total;
    }

    // BFS로 창고에서 각 지점까지의 최단 거리 계산
    private static int[][] bfs(int[][] grid, Warehouse start) {
        int[][] distances = new int[grid.length][grid[0].length];
        for (int[] row : distances) Arrays.fill(row, -1); // 거리 초기화 (도달 불가능한 경우 -1)

        int[] dx = { -1, 1, 0, 0 };  // 상하좌우 이동
        int[] dy = { 0, 0, -1, 1 };

        Queue<Warehouse> queue = new LinkedList<>();
        queue.add(start);
        distances[start.x][start.y] = 0; // 창고에서 시작점의 거리는 0

        while (!queue.isEmpty()) {
            Warehouse current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 좌표인지, 벽이 아닌지, 아직 방문하지 않았는지 확인
                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length
                        && grid[nx][ny] != 0 && distances[nx][ny] == -1) {
                    distances[nx][ny] = distances[x][y] + 1; // 거리 업데이트
                    queue.add(new Warehouse(nx, ny));
                }
            }
        }

        return distances;
    }

    static class Warehouse {
        int x;
        int y;

        public Warehouse(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
