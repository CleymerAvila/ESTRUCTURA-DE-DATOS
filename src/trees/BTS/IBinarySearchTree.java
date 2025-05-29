package trees.BTS;

public interface IBinarySearchTree<T extends Comparable<T>>{

    void insert(T data);
    boolean exists(long id);
    T get(long id);
    boolean isLeaf(long id);
    boolean isEmpty();
    void inOrderTraversal();
    void preOrderTraversal();
    void posOrderTraversal();
    void delete(long id);
}
