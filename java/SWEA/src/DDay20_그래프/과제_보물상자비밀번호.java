package DDay20_그래프;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
/*
1 
12 10
1B3B3B81F75E
*/
public class 과제_보물상자비밀번호 {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine()); //테케 입력 
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken()); //숫자의 갯수
			K=Integer.parseInt(st.nextToken()); // k 번째 큰 수 찾기
			
			Set <String> set = new HashSet<>();  //중복 불가 
			String number=br.readLine();
			int size=N/4; //각 4개의 변
			
			for(int i=0; i<size; i++) { //회전 수
				int begin=0;
				int end=size;
				for(int j=0; j<4; j++) { //잘라내는 숫자 
					/*
					 * 4개씩 짤라서 해쉬셋에 넣을꺼임 
					 * 중복 알아서 제거 되고 
					 * 원형 subString으로 한칸식 돌릴 꺼임 
					 * set에 문자열 다넣고 list에 넣어
					 * 리버스오더 갈기고 k번째 큰수 10진수로 반환해서 출력 
					 */
					set.add(number.substring(begin, end)); //number 스트링의 begin부터 end까지 짜름 
					begin+=size; 
					end+=size;
				}
				//number 오른쪽으로 한칸씩 이동 //마지막 문자열 반환                +  마지막 전 문자열 
				number=number.substring(number.length()-1,number.length())+number.substring(0,number.length()-1); //새로운 문자열만듬
				
			}
			List<String> list = new ArrayList<>(set); //set을 포함하는 Arraylist 추가 
			Collections.sort(list, Collections.reverseOrder()); //list를 반대로 정렬할꺼임
			sb.append("#"+tc+" "+Integer.parseInt(list.get(K-1),16)+"\n"); //리스트 큰수 16진수로 변환 해서 반환 
			
		}
		System.out.println(sb);
	}
}
