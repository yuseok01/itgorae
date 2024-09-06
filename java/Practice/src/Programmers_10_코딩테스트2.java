import java.io.*;
import java.util.*;

public class Programmers_10_코딩테스트2 {
	
    public static void main(String[] args) {
    	int[][] map = new int[5][5];
    	map.length;
    	
    }
    static class task implements Comparable<task>{
    	int time;
    	int number;
    	int importance;
    	
		public task(int time, int number, int importance) {

			this.time = time;
			this.number = number;
			this.importance = importance;
		}

		@Override
		public int compareTo(task o) {
			if(this.importance==o.importance) {
				return this.number-o.number;
			}
			return o.importance-this.importance;
		}
		
    	
    }

}
