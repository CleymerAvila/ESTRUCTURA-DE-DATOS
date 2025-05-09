package doubleLinkedList;

public class Node {
    private String data;
    private Node next;
    private Node previous;

    public Node(String data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(String data, Node next, Node previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
