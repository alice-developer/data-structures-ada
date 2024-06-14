package dataStructures;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        public T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.length = 0;
    }

    // Add
    public void append(T data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.length++;
    }

    public void prepend(T data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
        }

        this.head = newNode;
        this.length++;
    }

    public boolean insert(int index, T data) {
        if (this.length < index + 1 || index < 0)
            return false;

        if (index == 0) {
            this.prepend(data);
            return true;
        }

        if (index == this.length - 1) {
            this.append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = this.get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;

        return true;
    }

    // Remove
    public Node pop() {
        if (length == 0)
            return null;

        Node pre = this.head;
        Node temp;

        while(pre.next != tail) {
            pre = pre.next;
        }

        temp = pre.next;
        pre.next = null;
        this.tail = pre;

        this.length--;
        if (length == 0) {
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public Node shift() {
        if (length == 0)
            return null;

        Node temp = this.head;
        this.head = head.next;
        temp.next = null;

        length--;
        if (length == 0) {
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index + 1 >= this.length) return null;
        if (index == 0) return this.shift();
        if (index == length - 1) return this.pop();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    // Update
    public Node set(int index, T data) {
        Node temp = this.get(index);

        if (temp != null) {
            temp.data = data;
        }

        return temp;
    }

    // Others methods
    public void print() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print("[<end>]\n");
    }

    // Get
    public Node getTail() { return this.tail; }
    public Node getHead() { return this.head; }
    public int getLength() { return this.length; }

    public Node get(int index) {
        if (this.length < index + 1 || index < 0)
            return null;

        Node temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
