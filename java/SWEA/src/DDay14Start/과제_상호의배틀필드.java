package DDay14Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과제_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String[] dimensions = br.readLine().split(" ");
            int h = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            char[][] map = new char[h][w];

			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			int order = Integer.parseInt(br.readLine());
			char[] command = new char[order];
			String input = br.readLine();
			for (int i = 0; i < order; i++) {
				command[i] = input.charAt(i);
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {

					if (map[i][j] == '<') {
						for (int k = 0; k < order; k++) {
							if (command[k] == 'S') {
								for (int d = 0; d < map[0].length; d++) {
									if (map[i][j - d] == '*' && 0 <= j - d) { //한계설정
										map[i][j - d] = '.';
									}
								}
							} else if (command[k] == 'R') {
								map[i][j] = '>';
								if (map[i][j + 1] == '.') {
									map[i][j + 1] = '>';
									map[i][j] = '.';
								}
							} else if (command[k] == 'L') {
								map[i][j] = '<';
								if (map[i][j - 1] == '.') {
									map[i][j - 1] = '<';
									map[i][j] = '.';
								}
							} else if (command[k] == 'D') {
								map[i][j] = 'v';
								if (map[i - 1][j] == '.') {
									map[i - 1][j] = 'v';
									map[i][j] = '.';
								}
							} else if (command[k] == 'U') {
								map[i][j] = '^';
								if (map[i + 1][j] == '.') {
									map[i + 1][j] = '^';
									map[i][j] = '.';
								}
							}
						}
					} else if (map[i][j] == '^') {
						for (int k = 0; k < order; k++) {
							if (command[k] == 'S') {
								for (int d = 0; d < map.length; d++) {
									if (map[i+d][j] == '*' && map.length >i + d) {
										map[i][j + d] = '.';
									}
								}

							} else if (command[k] == 'R') {
								map[i][j] = '>';
								if (map[i][j + 1] == '.') {
									map[i][j + 1] = '>';
									map[i][j] = '.';
								}
							} else if (command[k] == 'L') {
								map[i][j] = '<';
								if (map[i][j - 1] == '.') {
									map[i][j - 1] = '<';
									map[i][j] = '.';
								}
							} else if (command[k] == 'D') {
								map[i][j] = 'v';
								if (map[i - 1][j] == '.') {
									map[i - 1][j] = 'v';
									map[i][j] = '.';
								}
							} else if (command[k] == 'U') {
								map[i][j] = '^';
								if (map[i + 1][j] == '.') {
									map[i + 1][j] = '^';
									map[i][j] = '.';
								}
							}
						}
					} else if (map[i][j] == '>') {
						for (int k = 0; k < order; k++) {
							if (command[k] == 'S') {
								for (int d = 0; d < map[0].length; d++) {
									if (map[i][j + d] == '*' && map[0].length >= j + d) {
										map[i][j + d] = '.';
									}
								}
							} else if (command[k] == 'R') {
								map[i][j] = '>';
								if (map[i][j + 1] == '.') {
									map[i][j + 1] = '>';
									map[i][j] = '.';
								}
							} else if (command[k] == 'L') {
								map[i][j] = '<';
								if (map[i][j - 1] == '.') {
									map[i][j - 1] = '<';
									map[i][j] = '.';
								}
							} else if (command[k] == 'D') {
								map[i][j] = 'v';
								if (map[i - 1][j] == '.') {
									map[i - 1][j] = 'v';
									map[i][j] = '.';
								}
							} else if (command[k] == 'U') {
								map[i][j] = '^';
								if (map[i + 1][j] == '.') {
									map[i + 1][j] = '^';
									map[i][j] = '.';
								}
							}
						}

					} else if (map[i][j] == 'v') {
						for (int k = 0; k < order; k++) {
							if (command[k] == 'S') {
								for (int d = 0; d < map.length; d++) {
									if (map[i-d][j] == '*' && 0 <= i - d) {
										map[i-d][j] = '.';
									}
								}

							} else if (command[k] == 'R') {
								map[i][j] = '>';
								if (map[i][j + 1] == '.') {
									map[i][j + 1] = '>';
									map[i][j] = '.';
								}
							} else if (command[k] == 'L') {
								map[i][j] = '<';
								if (map[i][j - 1] == '.') {
									map[i][j - 1] = '<';
									map[i][j] = '.';
								}
							} else if (command[k] == 'D') {
								map[i][j] = 'v';
								if (map[i - 1][j] == '.') {
									map[i - 1][j] = 'v';
									map[i][j] = '.';
								}
							} else if (command[k] == 'U') {
								map[i][j] = '^';
								if (map[i + 1][j] == '.') {
									map[i + 1][j] = '^';
									map[i][j] = '.';
								}
							}
						}

					}

				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print("#"+tc+" "+map[i][j]);
					}
				System.out.println();
				}
		}
	}
}