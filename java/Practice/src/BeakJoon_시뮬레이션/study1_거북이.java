package BeakJoon_시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class study1_거북이 {

	static int maxX,maxY,minX,minY,dir,x,y;
	static int dx[]= {0,1,0,-1};
	static int dy[]= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		/*
		 * direction에 거북이 방향을 지정
		 * 델타배열에 인덱스를 direction을 사용함으로서 거북이의 움직임을 제어할 수 있는 문제 
		 */
		String tmp;
		
		for (int tc = 0; tc < testCase; tc++) {
			tmp = br.readLine();
			maxX=0;
			maxY=0;
			minX=0;
			minY=0;
			dir=0;
			x=0;
			y=0;
			for (int i = 0; i < tmp.length(); i++) {
				char t=tmp.charAt(i);
				if(t=='F') {
					x+=dx[dir]; //방향을 정한다 
					y+=dy[dir];
					maxX=Math.max(x, maxX);
					maxY=Math.max(y, maxY);
					minX=Math.min(x, minX);
					minY=Math.min(y, minY);
				}else if(t=='B') {
					x-=dx[dir]; //방향을 뺀다 
					y-=dy[dir];
					maxX=Math.max(x, maxX);
					maxY=Math.max(y, maxY);
					minX=Math.min(x, minX);
					minY=Math.min(y, minY);
				}else if(t=='L') {
					if(dir==0) {
						dir=4;
					}
					dir--;
				}else if(t=='R') {
					dir++;
					if(dir==4) {
						dir=0;
					}
				}
			}
			int width=maxX-minX;
			int height=maxY-minY;
			sb.append(width*height+"\n");
		}
		System.out.println(sb);
	}
}