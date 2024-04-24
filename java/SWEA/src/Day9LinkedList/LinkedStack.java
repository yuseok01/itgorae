package Day9LinkedList;

class Node {
    String data;
    Node link;

    Node() {
    }

    Node(String data) {
        this.data = data;
    }
}

class Linkstack {
    Node top;
    int size;


    void push(String data) {
        Node newNode = new Node(data); 
        if (isEmpty()) {
            top = newNode;
            size++;
            return;
        }
        newNode.link = top; 
        top = newNode; /

        size++;
    }

    String pop() {
        if (isEmpty()) {
            System.out.println("삭제할 데이터가 없습니다.");
            return null;
        }
        
        String data = top.data;
        top = top.link;
        return data;
    }

    String peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
            return null;
        }
        return top.data;
    }

    boolean isEmpty() {
        return top == null; // top이 가리키는 것이 더이상 없을 때가 비어있는 것임
    }
}

public class LinkedStack {

    public static void main(String[] args) {
        Linkstack linkstack = new Linkstack();

        linkstack.push("a");
        linkstack.push("b");
        System.out.println(linkstack.peek());
        String data = linkstack.pop();
        System.out.println(data);
        System.out.println(linkstack.peek());
        String data2 = linkstack.pop();
        System.out.println(data2);
        linkstack.push("c");
        System.out.println(linkstack.peek());
    }
}