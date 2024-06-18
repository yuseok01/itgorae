import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_9_12919_A와B2 {
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
		isPosible(init+aLogic, goal, aLogic, bLogic );
		if(result == 1) return;
		
		init += bLogic;
		StringBuilder sb = new StringBuilder(init);
		sb.reverse();
		init = sb.toString();
		isPosible(init, goal, aLogic,bLogic);
		if(result == 1) return;
		
		
	}
}
