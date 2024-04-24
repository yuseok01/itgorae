package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_6_DNA비밀번호 {
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int result = 0;
		char a[] = new char[5];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0; 
		a = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] ==0)
				checkSecret++;
		}
		for(int i = 0; i< p; i++) {
			Add(a[i]);
		}
		if(checkSecret == 4)
			result++;
		for(int i = p; i<s; i++) {
			int j = i- p;
			Add(a[i]);
			remove(a[j]);
			if(checkSecret ==4)
				result++;
		}
		System.out.println(result);
	}

	private static void remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0]==checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C' :
			if(myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T' :
			if(myArr[3]==checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
		
	}

	private static void Add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}
	}
}
