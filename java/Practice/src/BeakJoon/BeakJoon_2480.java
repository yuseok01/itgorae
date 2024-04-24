package BeakJoon;

import java.util.Scanner;

public class BeakJoon_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] dice = new int[3];
		for(int i = 0 ; i <dice.length ; i++) {
			int input = sc.nextInt();
			dice [i] = input;
				
		}
		int count = 1;
		for(int i = 0 ; i < dice.length-1 ; i++) {
			if(dice[i] == dice[i+1]) {
				count ++;
			}
			
		}if(count==1) {
			for(int i = 0 ; i < dice.length-2 ; i++) {
				if(dice[i] == dice[i+2]) {
					count++;
				}
			}
		}
		switch (count) {		
			case 1 : 
				int sum=0;
				for(int i = 0 ; i < dice.length; i++) {
					if(sum < dice[i]) {
						sum = dice[i];
					}
						
				}System.out.println(sum*100);
				break;
			case 2 :
				int same = 0;
				for(int i = 0 ; i < dice.length-1; i++) {
					if(dice[i] == dice[i+1]) {
						same = dice[i];
					}
				if(same==0) {
					same = dice[0];
				}
		
				}
				System.out.println((same*100)+1000);
				break;
			case 3 :
				System.out.println(10000+(dice[1]*1000));
				break;
				
		
		}
		
	}

}
