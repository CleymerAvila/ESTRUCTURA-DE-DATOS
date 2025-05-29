package trees.BTS;

public class BST {

    private Node root;

    void insert(int data){
        Node node = new Node(data);
        if (root == null){
            root = node;
            return;
        }

        Node current = root;
        Node father = null;

        while (current != null){
            father = current;

            if (node.getData()< current.getData()){
                current = current.getLeft();
            } else if (node.getData() > current.getData()) {
                current = current.getRight();
            } else {
                System.out.printf("No se puede ingresar el valor duplicado %d", node.getData());
                return;
            }
        }

        if (node.getData() < father.getData()){
            father.setLeft(node);
        } else {
            father.setRight(node);
        }
    }

    void delete(int data){
        Node current = root;
        Node father = null;

        // Buscar el nodo a eliminar y su padre
        while (current != null && current.getData()!=data){
            father = current;
            if (data < current.getData()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (current == null){
            return;
        }

        // 1. Si el Nodo a eliminar no tiene hijos (es hoja)
        if (current.getLeft() == null && current.getRight()== null){
            if (current == root){
                root = null;
            } else if (father.getRight() == current){
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
            // 2. Si el Nodo a eliminar tiene un hijo
        } else if (current.getLeft() == null || current.getRight() == null){
            Node subTree = current.getLeft()!= null ? current.getLeft() : current.getRight();
            if (current== root){
                root = subTree;
            } else if (father.getLeft() == current){
                father.setLeft(subTree);
            } else {
                father.setRight(subTree);
            }
            // 3. Si el nodo a eliminar tiene dos hijos
        } else {
            Node replacement = current.getRight();
            Node fatherReplacement = current;

            while (replacement.getLeft()!=null){
                fatherReplacement = replacement;
                replacement = replacement.getLeft();
            }

            // Remplazar el dato del nodo actual con el del remplazo
            current.setData(replacement.getData());

            // Eliminar la doble occurrencia del dato remplazado
            if (fatherReplacement.getLeft() == replacement){
                fatherReplacement.setLeft(replacement.getRight());
            } else {
                fatherReplacement.setRight(replacement.getRight());
            }
        }
    }

    public void inOrderTraversal(Node current){
        if (current != null){
            inOrderTraversal(current.getLeft());
            System.out.print("[ "+ current.getData() + " ] ");
            inOrderTraversal(current.getRight());
        }
    }

    public void preOrderTraversal(Node current){
        if (current != null){
            System.out.print("[ "+ current.getData() + " ] ");
            preOrderTraversal(current.getLeft());
            preOrderTraversal(current.getRight());
        }
    }

    public void posOrderTraversal(Node current){
        if (current != null){
            posOrderTraversal(current.getLeft());
            posOrderTraversal(current.getRight());
            System.out.print("[ "+ current.getData() + " ] ");
        }
    }

    public boolean exists(int data){
        if (root==null) {
            System.out.println("Lista vacia");
            return false;
        }
        Node current = root;

        while (current != null){
            if (data == current.getData()){
                return true;
            } else if (data < current.getData()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    boolean isEmpty(){
        return root==null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
