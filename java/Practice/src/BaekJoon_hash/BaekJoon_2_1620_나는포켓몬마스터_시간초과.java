package BaekJoon_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * 목적
 * map에서 key값으로 value 값얻기
 *  	  value값으로 key 값얻기 
 */
public class BaekJoon_2_1620_나는포켓몬마스터_시간초과 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int result = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map = new HashMap<>();
		for(int i = 1 ; i<=n; i++) {
			String value = br.readLine();
			int num = i;
			map.put(num,value) ;
		}
//		System.out.println(map.entrySet());
		for(int i = 0; i<result ; i++) { //확인하고자 하는 key value의 갯수
			String tmp = br.readLine(); //integer 혹은 String
			
			for(Map.Entry<Integer, String> copy : map.entrySet()) { //기존 map을 Map.Entry에 copy
				if(tmp.charAt(0) - 'A' >= 0) { //string이므로 key값출력 
					/* A=65
					 * 얻고자하는 값의 첫글자가 string인지 integer인지
					 * B(66) - 'A'(65) = 1 반환 
					 * a(97) - 'A'(65) = 32 반환
					 */
					if(copy.getValue().equals(tmp)) { //벨류 값이 tmp와 같다면
						System.out.println(copy.getKey());  //키값 출력 
					}
				}else { //int값을 호출
					if(copy.getKey()==Integer.parseInt(tmp)) {
						System.out.println(copy.getValue());
					}
				}
			}
			/*
			 * 기존 map에서는 key값으로 value를 찾는것은 가능하나 value로 key 값을 찾는 건 불가능
			 * Map.Entry에 복사해서 하나의 키와 값을 객체로 
			 */
		}
	}
}
