import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * Queue<Tree>, 작업 순서 중시 선입 선출 
 * List<Tree> , 인덱스 찾기 []
 * Deque<Tree>, 양방향 처리 아기 나무 앞으로 넣기 
 * 
 * ===구현체==
 * 추가 삭제 多 -> linkedlist
 * 검색 多 -> ArrayList
 */

public class BaekJoon1_17_나무재태크2 {
	static class Tree implements Comparable<Tree> {
		int x, y, age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] add = new int[N + 1][N + 1]; // 추가 양분
        int[][] field = new int[N + 1][N + 1]; // 현재 양분
        Deque<Tree> trees = new LinkedList<>(); // 나무 리스트

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                field[i][j] = 5; // 초기 양분 설정
            }
        }

        // 나무 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        while (K > 0) {
            Queue<Tree> nutrition = new LinkedList<>(); // 여름 처리를 위한 나무 리스트
            Deque<Tree> nextTrees = new LinkedList<>(); // 다음 봄에 사용할 나무 리스트

            // 봄
            while (!trees.isEmpty()) {
                Tree tree = trees.poll();
                if (field[tree.x][tree.y] >= tree.age) {
                    field[tree.x][tree.y] -= tree.age;
                    tree.age++;
                    nextTrees.add(tree);
                } else {
                    nutrition.add(tree);
                }
            }

            // 여름
            while (!nutrition.isEmpty()) {
                Tree tree = nutrition.poll();
                field[tree.x][tree.y] += tree.age / 2;
            }

            // 가을
            Deque<Tree> newTrees = new LinkedList<>();
            while (!nextTrees.isEmpty()) {
                Tree tree = nextTrees.poll();
                if (tree.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nx = tree.x + dx[d];
                        int ny = tree.y + dy[d];
                        if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                            newTrees.add(new Tree(nx, ny, 1));
                        }
                    }
                }
                newTrees.add(tree);
            }

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    field[i][j] += add[i][j];
                }
            }

            // 다음 년도로
            trees = newTrees;
            K--;
        }

        // 남은 나무 개수 출력
        bw.write(trees.size() + "\n");
        bw.flush();
        bw.close();
    }
}
