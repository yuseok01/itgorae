package Day9_LinkedList;

public class LinkedList_생활코딩 {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		private Object data;
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toStirng() {
			return String.valueOf(this.data);
		}
	}
	public void addFirst (Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	public void addLast (Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	Node node(int index) {
		Node x = head;
		for(int i = 0 ; i < index ; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k , Object input) {
		if(k==)
	}
}
