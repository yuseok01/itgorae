package 월말대비;

import java.util.Collection;
import java.util.LinkedList;

public class linkedlist {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.offer(6);
		list.offer(7);
		list.offer(8);
		list.offer(9);
		
		System.out.println(list.pop());
		
	}

}
