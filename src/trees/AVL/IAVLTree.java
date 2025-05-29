package trees.AVL;

public interface IAVLTree<T extends Comparable<T>>{
    void insert(T data);
    boolean exists(T data);
    boolean isEmpty();
    void inOrderTraversal();
    void posOrderTraversal();
    void preOrderTraversal();
    void delete(T data);
    int height();
}
