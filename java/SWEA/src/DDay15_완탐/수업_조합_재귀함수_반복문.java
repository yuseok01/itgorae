package DDay15_완탐;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 수업_조합_재귀함수_반복문 {
	// 데이터 배열
	static String[] 속 = { "상추", "패티", "치즈", "피클" };
	static int N, R;
	static String[] sel;
	static List<String[]> list = new ArrayList<>();
	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0,0);
		System.out.println("----------------------내가 모은 결과 총출동");
		for(String[] s : list) {
			System.out.println(Arrays.toString(s));
		}
	}
	
	//idx : 현재 내가 판단할 재료
	//sidx : 조합할 재료의 인덱스
	public static void combination(int idx, int sidx) {
		//base case
		if(sidx == R) {//다 뽑았어 (햄버거 완성~~)
			//deepcopy
			String[] tmp = new String[R];
			for(int i = 0 ; i<R; i++) {
				tmp[i] = sel[i];
			}
			System.out.println(Arrays.toString(sel));
			list.add(tmp);
			return;
		}
		if(idx == N) { //몰라 재료는 다 고려했어! 미안~~
			return;
		}

		//재료넣었어~~~!!!
		sel[sidx] = 속[idx]; //서5 이승철 집중력 굿 (대4 김진현 까비)
		combination(idx+1, sidx+1); //해당 idx번쨰 재료 sidx 위치에 넣었어요~
//		sel[sidx] = null; 	//이거 필요해? 굳이 원복하지 않아도 OK 덮어버림
		combination(idx+1, sidx); //해당 idx번쨰 재료 sidx 위치에 안넣었어요~
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
