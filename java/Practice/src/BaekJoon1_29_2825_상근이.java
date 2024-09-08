import java.io.DataInputStream;
import java.io.IOException;

public class BaekJoon1_29_2825_상근이 {
    private static void solution() throws Exception {
        int n = Integer.parseInt(nextLine());
        int[] arr = new int[1<<10];
        while (n-->0) {
            String cur = nextLine();
            int groupNum = 0;
            for (int i = 0; i < cur.length(); i++)
                groupNum |= 1<<(cur.charAt(i) - '0');
            arr[groupNum]++;
        }

        long answer = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++)
                if ((i&j)!=0)   answer += 1l * arr[i] * arr[j];
            if (arr[i] >= 2)
                answer += 1l * arr[i] * (arr[i]-1) / 2;
        }

        System.out.println(answer);
    }

  
}