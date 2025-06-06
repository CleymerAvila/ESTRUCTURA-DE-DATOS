package trees.AVL;

public class Node<T extends Comparable<T>> {
    private T data;
    private int height = 1;
    private Node<T> left, right;

    public Node(T data) {
        this.data = data;
        this.height = 1;
        this.right = this.left = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public boolean isLeaf(){
        return data != null && left == null && right == null;
    }
}
