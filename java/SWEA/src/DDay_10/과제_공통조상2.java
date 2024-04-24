package DDay_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
class Node {
    int num;
    Node left;
    Node right;
    Node parent;
     
    Node(){}
     
    Node(int num){
        this.num = num;
    }
}
 
public class 과제_공통조상2 {
     
    static Node[] nodes;
    static int[] count;
    static int countnode;
    static int std;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt(); 
            for(int t=1; t<=T; t++) {
 
                int V = sc.nextInt();
                int E = sc.nextInt();
                int X = sc.nextInt();
                int Y = sc.nextInt();
                 
                nodes = new Node[V+1];
                count = new int[V+1];
                countnode = 0;
                 
                for(int i=1; i<=V; i++) {
                    nodes[i] = new Node();
                    nodes[i].num = i;
                }
                 
                // 간선의 정보가 E
                for(int i=0; i<E; i++) {
                    int parent = sc.nextInt();
                    int child = sc.nextInt();
                     
                    count[child]++;
                     
                    if(nodes[parent].left == null) {
                        nodes[parent].left = nodes[child];
                        nodes[child].parent = nodes[parent]; 
                    } else {
                        nodes[parent].right = nodes[child];
                        nodes[child].parent = nodes[parent]; //왼쪽 오른쪽에 넣기 
                    }
                }
                 
                Node temp = nodes[X];
                List<Integer> xParents = new ArrayList<>();
                while(temp.num != 1) {
                    xParents.add(temp.parent.num);
                    temp = temp.parent;
                }
                 
                Node temp2 = nodes[Y];
                List<Integer> yParents = new ArrayList<>();
                while(temp2.num != 1) {
                    yParents.add(temp2.parent.num);
                    temp2 = temp2.parent;
                }
                 
                int ourparents = 0;
                out :for(int i=0; i<xParents.size(); i++) {
                    for(int j=0; j<yParents.size(); j++) {
                        if(xParents.get(i).equals(yParents.get(j))) {
                            ourparents = xParents.get(i);
                            break out;
                        }
                    }
                }
                 
                std = nodes[ourparents].num;
                count(nodes[ourparents]);
                 
                System.out.println("#" + t + " " + ourparents + " " + countnode);
        }
    }
     
    static void count(Node node) { //노드 크기 
        if(node == null) {
            return;
        }
         
        count(node.left);
         
        countnode++;
         
        count(node.right);
         
    }
     
}