package Day_2;

import java.util.Arrays;
import java.util.Scanner;
 
public class Dump2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int re = 0; re < 10; re++) { // 10번 반복
            int cnt = sc.nextInt(); // 덤프 수
            int[] bh = new int[101];
            int[] bd = new int[101];
            int result = 0;
 
            for (int bc = 0; bc < 100; bc++) {
                int h = sc.nextInt(); // 박스의 높이 입력받음
                bh[h]++; // 해당하는 높이의 빈도수에 추가
                bd[101 - h]++; // 해당하는 높이의 역순 배열의 빈도수에 추가
            }
 
            int[] temp1 = new int[101]; // 박스 낮은거부터 쌓기 위해 찾기
            int[] pmet1 = new int[101]; // 박스 높은거부터 없애기 위해 찾기
            for (int tc = 1; tc < 101; tc++) {
                temp1[tc] = temp1[tc - 1] + bh[tc]; // 각 높이를 가진 박스의 끝순서 구하기
                pmet1[tc] = pmet1[tc - 1] + bd[tc];
            }
            int[] temp2 = new int[101]; // 앞순서의 박스가 올라올 경우를 위해 중첩해주는 배열
            int[] pmet2 = new int[101];
            for (int tc = 1; tc < 101; tc++) {
                temp2[tc] = temp2[tc - 1] + temp1[tc]; // 각 높이를 가진 박스를 올리기 위해서 필요한 cnt구하기
                pmet2[tc] = pmet2[tc - 1] + pmet1[tc];
            }
 
            int ubidx = 0; // 낮은 높이부터 배열한 배열의 인덱스값
            int dbidxp = 0; // 높은 높이부터 배열한 배열의 인덱스값
 
            for (int ic = 1; ic < 101; ic++) {
                if (cnt < temp2[ic]) {
                    ubidx = ic; // 입력받은 덤프 횟수보다 올리기 위해 필요한 박스의 cnt값이 커질경우 해당 인덱스 저장
                    break;
                }
            }
 
            for (int ic = 1; ic < 101; ic++) {
                if (cnt < pmet2[ic]) { // 입력받은 덤프 횟수보다 내리기 위해 필요한 박스의 cnt값이 커질경우 해당 인덱스 저장
                    dbidxp = ic;
                    break;
                }
            }
 
            int dbidx = 101 - dbidxp; // 역순으로 저장했기 때문에 다시 원래 높이값으로 변환
            result = dbidx - ubidx; // 차이를 결과값으로
            System.out.println("#" + (re + 1) + " " + result);
        }
 
    }
 
}