import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

import javax.xml.namespace.QName;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Programmers_6_주차요금계산 {
	public static void main(String[] args) {
		int [] fees = {180,5000,10,600}; //기본시간 , 기본요금, 단위시간, 단위요금
		String [] record = {"05:34 5961 IN", "06:00 0000 IN",
				"06:34 0000 OUT", "07:59 5961 OUT",
				"07:59 0148 IN", "18:59 0000 IN",
				"19:09 0148 OUT", "22:59 5961 IN",
				"23:00 5961 OUT"};
		int [] result = solution(fees,record);
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(result[i]);
			}
	}
	
	
	static int inCnt = 0;
    public static int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int Time = fees[2];
        int fee = fees[3];
        
        List<carManager>[] carList = new LinkedList[10000];
        for(int i = 0 ; i < 10000 ; i++) {
        	carList[i] = new LinkedList<>();
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < records.length ; i++) {
        	String input = records[i];
        	String [] splited = input.split(" ");
        	String time = splited[0];
        	String []timeMin = time.split(":");
        	//시간 끝 
        	int min = Integer.parseInt(timeMin[0]) * 60 + Integer.parseInt(timeMin[1]);
        	
        	int carNum = Integer.parseInt(splited[1]);
        	q.add(carNum);
        	String isInOUT = splited[2];
        	carList[carNum].add(new carManager(min));
        	if(isInOUT.equals("IN")) {
        		inCnt++;
        	}
        }
        int [] answer = new int[inCnt];
        for(int i = 0 ; i < inCnt ; i++) {
        	int nowCarNum = q.poll();
        	int tmp = 0; 
        	for(int j = 0 ; j < carList[nowCarNum].size() ; j++) {
        		//기본요금 차감
        		if(j ==0) {
        			carManager car = carList[nowCarNum].get(j);
        			int carIntime = car.time;
        			tmp = carIntime;
        			carIntime = basicTime;
        			answer[i] += basicFee;
        		}else {
        			carManager car = carList[nowCarNum].get(j);
        			int carOuttime = car.time;
        			carOuttime = carOuttime - tmp;
        			answer[i] += (carOuttime /Time) * fee;
        		}
        	}
        	
        }   
        return answer;
    }
    static class carManager{
    	int time;
    	
		public carManager( int time) {
			this.time = time;
		}
    	
    }
}
    