import java.util.*;

public class Programmers_4_이모티콘할인행사 {

private static int emoticonsNum;
private static int userNum;
private static int [] promotion = {10,20,30,40};






private static int[] solution(int[][] users, int[] emoticons) {
	int subscriber = 0;
	int sale = 0;
	emoticonsNum = emoticons.length;
	userNum = users.length;
	int [] selectedPro = new int[emoticonsNum];
	int []solution = findOptimal(0 , selectedPro, users,emoticons);
	return null;
}


private static int[] findOptimal(int depth, int [] selectedPro,int[][] users, int[] emoticons) {
	if(emoticonsNum == depth) { //모든 이모티콘 할인 적용 완료
		int [] tmpSum = new int[userNum]; 
		int tmpSubscribe = 0;
		for(int i = 0; i < userNum ; i++) {//i 번째 사람이 살지 말지 
			for(int j = 0 ; j < emoticonsNum ; i++) {//j번째 이모티콘 살지 말지
				if(selectedPro[j] <= users[i][0] ) { //사는조건이 맞으면 
					tmpSum[i] +=   emoticons[j] +(emoticons[j] * selectedPro[j] / 100);//i번째 사람 장바구니에 할인된 가격을 넣는다. 
	
				}
			}
			if(tmpSum[i] >= users[i][1]) {
				tmpSum[i] = 0;
				tmpSubscribe++; //산거 초기화하고 임시 구독자에 넣는다. 
			}
		}
	}
	
	
	for(int i = 0 ; i < 4 ; i++) { //4개의 프로모션 
		for(int j = 0 ; j < selectedPro.length ; j++) { //적용상품의 갯수
			selectedPro[j]= promotion[i];
		}
		findOptimal(j,selectedPro); //적용상품의 갯수 프로모션 적용완료
	}
	
	
	return null;
}




































public static void main(String[] args) {
	int [][] users = new int[2][2];
	users[0][0] =40;
	users[0][1] =10000;
	users[1][0] = 25;
	users[1][1] = 10000;
	
	int [] emoticons = {7000,9000};
	
	int[] result = solution(users, emoticons);
	
}
}

