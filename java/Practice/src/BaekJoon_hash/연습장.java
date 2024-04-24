package BaekJoon_hash;

import java.util.HashMap;

public class 연습장 {
	public static void main(String[] args) {
		
		HashMap<Integer,String> map = new HashMap<>();
		
		map.put(1,"유석");
	
		System.out.println(map.get(1));
		//========================================
		for(int i = 0 ; i< map.size() ; i++) {
			String find = "유석";
			if(map.get(i) == "유석") {
				//map.getkey??
			}
		}
	}

}
