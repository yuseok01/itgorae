package BackJoon_tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_2_5639_이진검색트리 {
	static int[] tree = new int[10000];
    // start : 현재 서브트리의 루트노드 , end : 해당 서브트리의 끝노드의 다음 인덱스
	static void postOrder(int start, int end) {
		int i;
        // 서브트리가 비어있거나 노드가 하나인 경우는 바로 리턴해 아무 작업도 수행하지 않는다. 
		if (start >= end) {
			return;
		}
		for (i = start+1; i < end; i++) {
			System.out.println();
			if(tree[start] < tree[i] )break;
		}
        // i를 기준으로 왼쪽 서브트리를 후위순회
		postOrder(start+1, i);
        // i를 기준으로 오른쪽 서브트리를 후위순회
		postOrder(i, end);
        // 현재 노드값 출력
		System.out.println(tree[start]);
		return ;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0; 
		String input;
		// 입력받기
		while((input = br.readLine()) != null)  {
        	tree[i++] = Integer.parseInt(input);
         }
		// 후위순회 호출
		postOrder(0, i);
	}
}