package DDay18_빽트래킹;
public class 수업_순열_1_반복문 {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					for (int k = 0; k < N; k++) {
						if (i != k && j != k) {
							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
						}
					}
				}
			}
		}
	}
}
