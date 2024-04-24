	package 월말대비;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class 배열농작물수확하기 {
		static int [][]arr;
		static int []dx = {-1,1,0,0};
		static int []dy = {0,0,-1,1};
		static int n;
		static boolean [][] check;
		static int sum ;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			
			int tc = Integer.parseInt(br.readLine());
	        for (int t = 1; t <= tc; t++) {
	            n = Integer.parseInt(br.readLine());
	            arr = new int[n][n];
	            check = new boolean[n][n];
	            for (int i = 0; i < n; i++) {
	                String[] input = br.readLine().split("");//입력받기 붙어있는 숫자열
	                for (int j = 0; j < n; j++)
	                    arr[i][j] = Integer.parseInt(input[j]);
	            }sum = 0;
	            int start = n/2;
	            int end = n/2;
	            for(int i =0; i<n;i++) {
	            	for(int j = start; j<=end; j++) {
	            		
	            		sum+=arr[i][j];
	            		
	            	}
	            	if( i<n/2) {
	            		start -=1;
	            		end +=1;
	            	}
	            	else {
	            		start +=1;
	            		end -=1;
	            	}
	            }
	            System.out.println("#"+t+" "+sum);
	            
	            
	        }
		}
		
	
	}
