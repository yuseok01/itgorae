import java.util.*;

public class Programmers_5_매뉴리뉴얼 {
	public String[] solution(String[] orders, int[] course) {
		
		for(int i = 0 ; i < course.length ; i++) { 
		
			for(int j = 0 ; j < orders.length ; j++) {
				int size = course[i]; //size만큼 선택할꺼야  
				find(size, 0,0,orders );
				
			}
		}
		
		
        String[] answer = {};
        return answer;
    }
	
	private void find(int size, int depth, int cnt, String[] orders) {
		if(depth == size) {
			
		}
		
	}

	public static void main(String[] args) {
		String [] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int [] course = {2,3,4};
		solution(orders,course);
	}
	
}

