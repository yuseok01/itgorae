package BeakJoon_정렬;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MergeSort2 {
	static int[] tmp;
	static StringTokenizer st;
	static int K;
	static StringBuilder str = new StringBuilder(); 
	static int count =0;
	public static void mergeSort(int[] arr, int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start,mid,end);	
		}
	}
	public static void merge(int[] arr, int start,int mid,int end) {
		int newStart= start;
		int newMid= mid+1;
		int index=0;
		
		while(newStart<=mid && newMid<=end) {
			if(arr[newStart]<=arr[newMid]) {
				tmp[index++] = arr[newStart++];
			}else {
				tmp[index++] = arr[newMid++];
			}
		}
		while(newStart<=mid) {
			tmp[index++]= arr[newStart++];
		}
		while(newMid<=end) {
			tmp[index++]= arr[newMid++];
		}
		
		newStart= start; index=0;
		
		while(newStart<=end) {
			arr[newStart++] = tmp[index++];
			count++;
			if(count==K) {
				for(int i=0;i<arr.length;i++) {
					str.append(String.valueOf(arr[i]+" "));
				}
				break;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		tmp= new int[N];	
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		mergeSort(arr,0,arr.length-1);
		bw.write(str.toString());
		if(count<K) {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}