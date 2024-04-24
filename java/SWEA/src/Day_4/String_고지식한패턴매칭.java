package Day_4;

public class String_고지식한패턴매칭 {  //일치하는 단어 찾기
	public static void main(String[] args) {
		String text = "this iss abook";  //text =  ---------------------
		                                //pater = -----
		String pattern = "iss";
		
		
		int result = patterMatching(text.toCharArray(), pattern.toCharArray()); // 문자열 배열로 만들기
		
		System.out.println(result);
	}
	
	public static int patterMatching(char[] text, char[] pattern){
		// i : 패턴 비교 시작위치
		// j : 문자 하나씩 비교하는 인덱스 
		start: for(int i = 0 ; i <= text.length - pattern.length ; i++) { //라벨링
			pattern: for ( int j = 0; j < pattern.length; j++) {
				if(text[i+j] != pattern[j]) {
					continue start;
				}
				
			}
			//break 되지 않고 for문이 완료되면 패턴매칭 성공
			return i;  // 다시 for문 돌아가지않고 리턴
		}	
		return -1; //다돌았는데 안되면 음수 
	}
}
