package DDay_11;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
 
public class 과제_힙2은혜 {
 
    static int[] heap = new int[100001];
    static int heapSize;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
 
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb= new StringBuilder();
            heapSize = 0;
            Arrays.fill(heap, 0);
            int N = in.nextInt(); // 연산 수
            for (int i = 0; i < N; i++) {
                int num = in.nextInt(); // 연산 번호
                if(num==1) {
                    int x = in.nextInt(); // 자연수 x
                    heapPush(x);
                } else {
                    sb.append(heapPop()).append(' ');
                }
            }
             
            System.out.printf("#%d ",tc);
            System.out.println(sb);
        }
 
    }
 
    static void heapPush(int data) {
        heap[++heapSize] = data;
 
        int ch = heapSize; // 자식 노드의 인덱스
        int p = heapSize / 2; // 부모 노드의 인덱스
 
        while (p > 0 && heap[ch] > heap[p]) {
            swap(ch, p);
 
            ch = p;
            p = ch / 2;
        }
    }
 
    static int heapPop() {
 
        int popData = 0;
 
        if (heapSize == 0) {
            popData = -1;
            return popData;
        } else
            popData = heap[1];
 
        heap[1] = heap[heapSize--];
 
        int p = 1;
        int ch = p * 2;
         
        if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
            ch++;
        }
 
        while (ch <= heapSize && heap[p] < heap[ch]) {
 
            swap(p, ch);
 
            p = ch;
            ch = p * 2;
             
            if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
                ch++;
            }
        }
 
        return popData;
 
    }
 
    static void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
 
}