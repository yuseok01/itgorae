package Day9_LinkedList;

import java.util.NoSuchElementException;

// 노드 클래스 정의
class Node1<T> { 
    T data;
    Node1<T> next;

    // 생성자로 데이터를 받아서 노드를 생성
    public Node1(T data) {
        this.data = data;
        this.next = null;
    }
}

// 연결 큐 클래스 정의
public class LinkedList_수업_연결큐<T> {
    private Node1<T> front; // 큐의 앞쪽
    private Node1<T> rear;  // 큐의 뒤쪽
    private int size;      // 큐의 크기

    // 연결 큐 생성자
    public LinkedList_수업_연결큐() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // 큐에 요소 추가 (enqueue)
    public void enqueue(T data) {
        Node1<T> newNode = new Node1<>(data); //node 객체 생성
        if (isEmpty()) { //큐가 비어있다면
            front = newNode; //프론트 리어 새로운 객체 생성
            rear = newNode;
        } else {
            rear.next = newNode;//큐가 비어있지 않다면 뒤의 다음 노드를 설정
            rear = newNode;// 리어를 새로운 노드로 업데이트
        }
        size++;
    }

    // 큐에서 요소 제거 (dequeue)
    public T dequeue() {
        if (isEmpty()) { //큐가 비어있으면 큐가 비었습니다.
            throw new NoSuchElementException("큐가 비어있습니다.");
        }

        T removedData = front.data; 
        front = front.next; //프론트를 다음 노드로 업데이트 
        size--; //사이즈 감소

        if (isEmpty()) { //큐가 비어있는지?
            rear = null;
        }

        return removedData;
    }

    // 큐의 맨 앞 요소 조회 (peek)
    public T peek() {
        if (isEmpty()) { //비워져있으면 
            throw new NoSuchElementException("큐가 비어있습니다.");
        }
        return front.data; //비워져 있지않다면 
    }

    // 큐가 비어 있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 큐의 크기 반환
    public int size() {
        return size;
    }

    // 메인 메서드: 간단한 예제 실행
    public static void main(String[] args) {
        LinkedList_수업_연결큐<Integer> queue = new LinkedList_수업_연결큐<>();

        // 큐에 요소 추가
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 큐의 크기 출력
        System.out.println("Queue size: " + queue.size()); // 3

        // 큐에서 요소 제거하고 출력
        System.out.println("Dequeue: " + queue.dequeue()); // 1

        // 큐의 맨 앞 요소 조회하고 출력
        System.out.println("Peek: " + queue.peek()); // 2

        // 큐의 크기 출력
        System.out.println("Queue size: " + queue.size()); // 2
        
        System.out.println(queue.isEmpty());
    }
}