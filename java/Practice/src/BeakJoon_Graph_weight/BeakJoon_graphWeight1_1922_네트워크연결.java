package BeakJoon_Graph_weight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;

class Edge implements Comparable<Edge>{
	int from, to; 
	long weight;

	public Edge(int from, int to, long weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.weight,o.weight);
	}
	
}
public class BeakJoon_graphWeight1_1922_네트워크연결 {
	static Edge [ ] edgeList;
	static int[] parents;
	static int V,E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		//step1 자기자신
		//step2 find 머리찾기
		//step3 union
		parents = new int [V+1];
		edgeList = new Edge[E]; // 타입이 엣지임 
		
		for(int i = 0; i<E; i++) {//간선만큼
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from,to, weight); //i라는 부모에 달려있는거임
		}
		make();
		
		Arrays.sort(edgeList); //weight 기준으로 정렬됨 
		int result = 0; 
		int count=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result += edge.weight;
				if(++count == V-1) { //정점 -1만큼돌았으면 생각해봐 우리는 최단거리찾는거임
					break;
				}
			}
		}
		System.out.println(result);
	}
	
	
	
	private static void make() { //모두가 자기자신을 부모로 삼도록 맨처음 단한번
		for(int i = 0; i <V ; i++) {
			parents[i]=i;
		}
		
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);//a대가리 찾기
		int bRoot = find(b);//b 대가리 찾기
		if(aRoot == bRoot) return false; //둘이 대장이 같으면 ㅠㅠ 합칠수없어 우린같은팀
		
		parents[bRoot] = aRoot;
		return true;
		
	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
}
