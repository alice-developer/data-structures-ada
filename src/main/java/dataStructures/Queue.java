package dataStructures;

public class Queue<T> {
    private Node first;
    private Node last;
    private int length;

    public class Node {
        T value;
        Node next;

        Node(T _value) {
            this.value = _value;
        }

        public T getValue() { return this.value; }
        public Node getNext() { return this.next; }
    }

    public Queue() {
        this.length = 0;
    }

    public void print() {
        Node temp = first;

        while (temp != null) {
            System.out.print(temp.value + " <- ");
            temp = temp.next;
        }

        System.out.print("[<END>]\n");
    }

    public void enqueue(T value) {
        Node newValue = new Node(value);

        if(this.length == 0) {
            this.first = newValue;
        } else {
            this.last.next = newValue;
        }

        this.last = newValue;
        this.length++;
    }

    public Node dequeue() {
        Node temp = this.first;
        if (temp == null) return null;

        this.first = temp.next;
        this.length--;

        if (this.length == 0) {
            this.last = null;
        }

        temp.next = null;
        return temp;
    }

    public Node getFirst() { return this.first; }
    public Node getLast() { return this.last; }
    public int getLength() { return this.length; }
}
