package BaekJoon_hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/*
 * hash특징 
 * Map Put 삽입 key-value 형태의 한쌍 저장
 * Set add 삽입 하나 저장 
 * contain remove
 * 자체 정렬 불가능 list에 넣기 
 */
public class BaekJoon_1_Hash_7785_회사에있는사람 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, String> hash = new HashMap<String, String>();
		for (int i = 0; i < N; i++) 
		{
			String key = sc.next();
			String value = sc.next();
			if (hash.containsKey(key)) {
				hash.remove(key); //최초 입력이 아니면 나간거
			}
			else hash.put(key, value); //최초 입력이면 들어온거
		}
		ArrayList<String> list = new ArrayList<String>(hash.keySet()); //key를 arraylist로 변경
		Collections.sort(list, Collections.reverseOrder()); //내림차순으로 정렬
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

