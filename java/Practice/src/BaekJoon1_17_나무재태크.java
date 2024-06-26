import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1_17_나무재태크 {
   static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
    }

    private static int n;
    private static int m;
    private static int k;
    private static int[][] add;
    private static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 필드 크기
        m = Integer.parseInt(st.nextToken()); // 나무 갯수
        k = Integer.parseInt(st.nextToken()); // k년 후

        field = new int[n][n];
        add = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = 5;
                add[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }
        
        
//        trees.sort(Comparator.comparingInt((Tree t) -> t.age).reversed()); //반대 정렬 애기나무가 맨뒤에 
        //시간초과 포인트1 *************************
        
        while (k > 0) {
            List<Tree> nutrition = new ArrayList<>(); //봄에 죽은나무 저장배열 
            List<Tree> newTrees = new ArrayList<>(); //봄에 새로운 애기나무 저장 배열

            // 봄
            for (int i = trees.size() - 1; i >= 0; i--) {//나무제거해도 문제없도록 맨뒤에서부터 (iterator)
                Tree tree = trees.get(i);
                int x = tree.x;
                int y = tree.y;
                int age = tree.age;

                if (field[x][y] >= age) {
                    field[x][y] -= age;
                    tree.age++;
                    // 가을에 새로운 나무 추가를 위해 리스트에 저장
                    if (tree.age % 5 == 0) {
                        newTrees.add(tree);
                    }
                } else {
                    // 여름
                    nutrition.add(tree);
                    trees.remove(i);
                }
            }

            // 여름 - 죽은 나무를 양분으로 변환
            for (Tree tree : nutrition) {
                int x = tree.x;
                int y = tree.y;
                field[x][y] += tree.age / 2;
            }

            // 가을 - 새로운 나무 심기
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (Tree tree : newTrees) {
                int x = tree.x;
                int y = tree.y;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        trees.add(new Tree(nx, ny, 1));
                    }
                }
            }

            // 겨울 - 양분 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    field[i][j] += add[i][j];
                }
            }

            // 다음 해로 넘어감
            k--;
        }

        // 남은 나무의 개수 출력
        System.out.println(trees.size());
    }
}
