package dataStructures;

/**
 * Operação: Travessia
 *  - Pré Ordem:
 *    - 1: Raiz
 *    - 2: Esquerda
 *    - 3: Direita
 *  - Em Ordem:
 *    - 1: Esquerda
 *    - 2: Raiz
 *    - 3: Direita
 *  - Pós Ordem:
 *    - 1: Esquerda
 *    - 2: Direita
 *    - 3: Raiz
 */

public class Tree {
    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf(Node node) {
            return this.left == null && this.right == null;
        }
    }

    public void insert(int value ) {
        if (this.root == null) {
            root = new Node(value);
            return;
        }

        Node newNode = new Node(value);

        Queue<Node> queue = new Queue<>();
        queue.enqueue(this.root);

        while (queue.getLength() > 0) {
            Node currentNode = queue.dequeue().getValue();

            if (currentNode.left == null) {
                currentNode.left = newNode;
                break;
            } else {
                queue.enqueue(currentNode.left);
            }

            if (currentNode.right == null) {
                currentNode.right = newNode;
                break;
            } else {
                queue.enqueue(currentNode.right);
            }
        }
    }

    public void preOrder() {
        this.preOrder(root);
    }

    private void preOrder(final Node node) {
        // R E D
        if (node == null)
            return;

        System.out.println(node.value);

        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // E R D
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(final Node node) {
        // E R D
        if (node == null)
            return;

        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    public void BFS() {
        if (this.root == null)
            return;

        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);

        while (queue.getLength() > 0) {
            Node node = queue.dequeue().getValue();

            if (node.left != null) queue.enqueue(node.left);
            if (node.right != null) queue.enqueue(node.right);

            System.out.println(node.value);
        }
    }
}
