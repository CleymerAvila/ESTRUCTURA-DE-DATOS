package trees.AVL;

public class AVLTree<T extends Comparable<T>> implements IAVLTree<T>{

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> node, T data){
        if (node == null){
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0){
            node.setLeft(insertRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData())> 0){
            node.setRight(insertRec(node.getRight(), data));
        } else {
            // Nada No se aceptan datos duplicados
            System.out.println("Dato duplicado: "+ data + " !!");
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> applyRotation(Node<T> node){
        int balance = getBalance(node);
        if (balance > 1){
            if (getBalance(node.getLeft())< 0){
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1){
            if (getBalance(node.getRight()) > 0){
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> node){
        Node<T> rightNode = node.getRight();
        Node<T> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private Node<T> rotateRight(Node<T> node){
        Node<T> leftNode = node.getLeft();
        Node<T> centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private int getBalance(Node<T> node){
        return (node == null) ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node<T> node){
        return node == null ? 0 : node.getHeight();
    }
    private void updateHeight(Node<T> node){
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    @Override
    public boolean exists(T data) {
        return existsRec(root, data);
    }

    private boolean existsRec(Node<T> node, T data){
        if (node == null){
            return false;
        }
        if (data.compareTo(node.getData()) == 0){
            return true;
        }
        return data.compareTo(node.getData()) < 0
                ? existsRec(node.getLeft(), data)
                : existsRec(node.getRight(), data);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node){
        if (node != null){
            inOrderRec(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderRec(node.getRight());
        }
    }

    @Override
    public void posOrderTraversal() {
        posOrderRec(root);
        System.out.println();
    }

    private void posOrderRec(Node<T> node){
        if (node != null){
            posOrderRec(node.getLeft());
            posOrderRec(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<T> node){
        if (node != null){
            System.out.print(node.getData()+ " ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    @Override
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> node, T data){
        if (node == null){
            return null;
        }
        if (data.compareTo(node.getData())< 0){
            node.setLeft(deleteRec(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0){
            node.setRight(deleteRec(node.getRight(), data));
        } else {
            if ((node.getLeft() == null) || (node.getRight() == null)){
                Node<T> nodeTemp = node.getLeft() != null ? node.getLeft() : node.getRight();
                if (nodeTemp == null){
                    return null;
                } else {
                    node = nodeTemp;
                }
            } else {
                Node<T> nodeTemp = getMinValueNode(node.getRight());
                node.setData(nodeTemp.getData());
                node.setRight(deleteRec(node.getRight(), nodeTemp.getData()));
            }
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> getMinValueNode(Node<T> node){
        Node<T> current = node;
        while (current.getLeft() != null){
            current = current.getLeft();
        }
        return current;
    }

    @Override
    public int height() {
        return height(root);
    }
}


