import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_9_12919_A와B3 {
	private static String init;
	private static String goal;
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		init = br.readLine();
		goal = br.readLine();
		result = 0;
		isPosible(init, goal, "A", "B");
		System.out.println(result);
		
	}

	private static void isPosible(String init, String goal, String aLogic, String bLogic) {
		
		if(init.length() == goal.length()) {
			if(init.equals(goal)) {
				result = 1;
					return;
				}
			else {
				return;
			}
		}
		//Alogic실행
		if(goal.charAt(goal.length()-1)=='A') {
			isPosible(init, goal.substring(0,goal.length()-1), aLogic, bLogic );
			
		}
		
		if(goal.charAt(0)== 'B') {
			StringBuilder sb = new StringBuilder();
			sb.append(goal.substring(1,goal.length()));
			goal = sb.reverse().toString();
			isPosible(init, goal, aLogic, bLogic);
		}
	}
}
