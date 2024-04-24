package DDay14Start;

import java.util.Scanner;

class Solution
{
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = (1 << N) - 1;
            if ((M & X) == X) System.out.printf("#%d ON\n", tc);
            else System.out.printf("#%d OFF\n", tc);
        }
    }
}