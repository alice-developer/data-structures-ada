package dataStructures;

public class Stack<T> {
    private Node top;
    private int height;

    public class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }

        public T getValue() { return this.value; }
        public Node getNext() { return this.next; }
    }

    public Stack() {
        this.height = 0;
    }

    public void print() {
        Node temp = top;

        System.out.print("[TOP] -> ");
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print("[<BOTTOM>]\n");
    }

    // Add
    public void push(T value) {
        Node newNode = new Node(value);

        if (height != 0) {
            newNode.next = this.top;
        }

        this.top = newNode;
        this.height++;
    }

    // Remove
    public Node pop() {
        if (this.height == 0)
            return null;

        Node temp = this.top;
        this.top = temp.next;
        this.height--;
        temp.next = null;

        return temp;
    }

    // Get
    public int getHeight() { return this.height; }
    public Node getTop() { return this.top; }

    public static Stack<Integer> invert(final int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        for (int number : numbers) {
            stack.push(number);
        }

        return stack;
    }
}
