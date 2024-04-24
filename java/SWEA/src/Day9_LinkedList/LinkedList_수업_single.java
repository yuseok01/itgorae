package Day9_LinkedList;

class Node {
	String data;
	Node link;

	Node() {
	}

	Node(String data) {
		this.data = data;
		// link = null;
	}
}

class SinglyLinkedList {
	Node head;
	int size;

	SinglyLinkedList() {
		head = new Node();
	}

	// 삽입
	// 제일 앞에 삽입
	void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.link = head.link;
		head.link = newNode;
		
		size++;
	}

	// 제일 뒤에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);

		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		// 반복문이 끝나면 curr는 마지막 노드를 가리킴

		curr.link = newNode;
		// newNode가 마지막 노드가 됨
		
		size++;
	}
	
	// 중간 삽입
	void add(int idx, String data) {
		if (idx < 0 || size < idx) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}
		
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		// curr가 삽입하고자하는 위치 앞 노드를 가리킴
		Node newNode = new Node(data);
		
		newNode.link = curr.link;
		curr.link = newNode;
		
		size++;
	}

	// 삭제
	void remove() {
		
	}
	// 지정한 idx에 해당하는 노드 삭제
	void remove(int idx) {
		if (idx < 0 || size <= idx) {
			System.out.println("삭제할 수 있는 범위를 벗어났습니다.");
			return;
		}
		
		Node curr = head;
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}
		// 반복문이 끝나면 curr는 삭제할 노드 앞 노드를 가리킴
		curr.link = curr.link.link;
		
		size--;
	}

	// 조회

	// 모든 데이터 조회
	void printList() {
		Node curr = head.link;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}
	
	int getSize() {
		Node curr = head;
		int size = 0;
		while (curr.link != null) {
			curr = curr.link;
			size++;
		}
		return size;
	}
}

public class LinkedList_수업_single {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.addFirst("7반 송창용");
		list.addLast("5반 현경찬");
		list.addFirst("8반 박영빈");
		list.addLast("5반 김광현");
		list.printList();
		list.add(5, "8반 엄소현");
		list.printList();
		
	}
}
