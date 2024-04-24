package BaekJoon_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 목적
 * map에서 key값으로 value 값얻기
 *  	  value값으로 key 값얻기 
 *  방법1 Hash.Entry<Integer,String>으로 복사 
 *  방법2 Hash 두개만들기 
 */
public class BaekJoon_2_1620_나는포켓몬마스터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer, String> HashKey = new HashMap<>();
		HashMap<String, Integer> HashValue = new HashMap<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<= n ; i++) {
			String tmp = br.readLine();
			HashKey.put(i, tmp);
			HashValue.put(tmp, i);
		}
		for(int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if(tmp.charAt(0) - 'A' >= 0) {
				System.out.println(HashValue.get(tmp));
			}
			else {
				System.out.println(HashKey.get(Integer.parseInt(tmp)));
			}
		}
	}

}
