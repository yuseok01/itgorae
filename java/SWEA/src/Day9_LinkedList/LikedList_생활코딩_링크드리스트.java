package Day9_LinkedList;



public class LikedList_생활코딩_링크드리스트 {
	public static void main(String[] args) {
		LinkedList numbers = new LinkedList();
		numbers.addFirst(30);
		numbers.addFirst(20);
		numbers.addFirst(10);
		
		numbers.addLast(10);
		numbers.addLast(10);
		numbers.addLast(10);
		
		System.out.println(numbers.node(1));
	}

}
