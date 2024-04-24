package Day9_LinkedList;

import java.util.LinkedList;

public class LinkedList_수업_연결스택_Int<T> {

    private LinkedList<T> list;

    public LinkedList_수업_연결스택_Int() {
        this.list = new LinkedList<>();
    }

    // 스택에 요소 추가
    public void push(T item) {
        list.addFirst(item);
    }

    // 스택에서 요소 제거 및 반환
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        return list.removeFirst();
    }

    // 스택의 맨 위 요소 확인
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        return list.getFirst();
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 스택의 크기 확인
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        LinkedList_수업_연결스택_Int<Integer> stack = new LinkedList_수업_연결스택_Int<>();

        // 스택에 요소 추가
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 스택에서 요소 제거 및 출력
        System.out.println( stack.pop()); // 출력: Pop: 3
        System.out.println( stack.pop()); // 출력: Pop: 2

        // 스택의 맨 위 요소 확인
        System.out.println( stack.peek()); // 출력: Peek: 1

        // 스택이 비어있는지 확인
        System.out.println( + stack.isEmpty()); // 출력: Is Empty: false

        // 스택의 크기 확인
        System.out.println( stack.size()); // 출력: Size: 1
    }
}