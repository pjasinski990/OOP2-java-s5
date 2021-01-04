class Node<T> {
    Node(T data) {
        this.data = data;
    }
    T data;
    Node<T> next = null;
}

public class Stos<T> {
    private Node<T> top = null;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;

        top = newNode;
    }

    public T pop() {
        Node<T> res = top;
        top = top.next;
        return res.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = top;
        while (current != null) {
            sb.append("{").append(current.data).append("} ");
            current = current.next;
        }
        return sb.toString();
    }
}
