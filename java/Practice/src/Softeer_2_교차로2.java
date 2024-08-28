import java.io.*;
import java.util.*;

public class Softeer_2_교차로2 {
	static class Car {
		int id;
		int inTime;
		int outTime;
		int dir;

		Car(int a, int b, char c) {
			id = a;
			inTime = b;
			outTime = -1;
			dir = c - 'A';
		}
	}

	static int N;
	static Car[] carArr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(in.readLine());

		carArr = new Car[N];
		Queue<Car>[] q = new Queue[4];
		for (int i = 0; i < 4; ++i)
			q[i] = new ArrayDeque();
		//큐 사용

		for (int i = 0; i < N; ++i) {
			String[] inputs = in.readLine().split(" "); //0번엔 TIME 1번엔 도로
			carArr[i] = new Car(i, stoi(inputs[0]), inputs[1].charAt(0));
			q[carArr[i].dir].add(carArr[i]);
		}

		int t = 0;
		int[] state = new int[4];
		while (true) {
			// 모든 차량이 통과했다.
			if (q[0].isEmpty() && q[1].isEmpty() && q[2].isEmpty() && q[3].isEmpty())
				break;

			int count = 0;
			for (int i = 0; i < 4; ++i){
				state[i] = exist(q[i], t);
				if(state[i] != -1)
					count++;
			}

			// 모두 대기중이라면 교착상태
			if (state[0] != -1 && state[1] != -1 && state[2] != -1 && state[3] != -1)
				break;

			for (int i = 0; i < 4; ++i) {
				// 해당 방향에 차량이 대기중
				if (state[i] != -1) {
					// 오른쪽 차량도 대기중인경우
					if (state[(i + 3) % 4] != -1)
						continue;
					count--;
					carArr[q[i].poll().id].outTime = t;

					// 반대쪽 차량도 진행 할 수 있는 경우
					if (state[(i + 2) % 4] != -1 && state[(i + 1) % 4]  == -1) {
						carArr[q[(i + 2) % 4].poll().id].outTime = t;
						count--;
					}
					break;
				}
			}

			if(count > 0){
				t++;
			}else{
				int min = 500000;
				for(int i = 0; i < 4; ++i){
					if(!q[i].isEmpty() && q[i].peek().inTime != -1)
						min = Math.min(min, q[i].peek().inTime);
				}
				t = min;
			}
		}
		for (int i = 0; i < N; ++i)
			sb.append(carArr[i].outTime).append("\n");

		System.out.println(sb);
	}

	public static int exist(Queue<Car> q, int time) {
		if (q.isEmpty())
			return -1;
		if (time < q.peek().inTime)
			return -1;
		return q.peek().inTime;
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}