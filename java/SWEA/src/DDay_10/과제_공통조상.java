package DDay_10;

import java.util.Scanner;

public class 과제_공통조상 {

    static class Node {
        int num;
        Node left;
        Node right;

        Node() {
        }
    }

    static Node[] nodes = new Node[14]; // 노드 타입 배열 선언
    static int[] count = new int[14];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int a = sc.nextInt(); // 첫 번째 정점
            int b = sc.nextInt(); // 두 번째 정점

            for (int i = 1; i < E; i++) { // 노드 객체 생성
                nodes[i] = new Node();
                nodes[i].num = i	;
            }

            for (int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                count[child]++; // 인덱스가 차일드 번호 값이 갯수 이 문제에서는 1

                if (nodes[parent].left == null) { // 부모 자식 받을때 납치
                    nodes[parent].left = nodes[child]; // 처음 온놈이면 왼쪽방
                } else {
                    nodes[parent].right = nodes[child]; // 두번째 온놈이면 오른쪽방
                }
            }

            int ourParent = findOurParent(nodes[1], a, b);
            int subtreeSize = countSubtree(nodes[ourParent]); // 수정된 부분

            System.out.println("#" + t + " " + ourParent + " " + subtreeSize);
        }
    }

    private static int countSubtree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countSubtree(root.left) + countSubtree(root.right);
    }

    private static int findOurParent(Node root, int a, int b) {
        if (root == null) {
            return -1;
        }

        if (root.num == a || root.num == b) {
            return root.num;
        }

        int leftOurParent = findOurParent(root.left, a, b);
        int rightOurParent = findOurParent(root.right, a, b);

        if (leftOurParent != -1 && rightOurParent != -1) {
            return root.num;
        }

        return (leftOurParent != -1) ? leftOurParent : rightOurParent;
    }
}