package trees.BTS;

public class BinarySearchTree implements IBinarySearchTree<Employee>{

    private Employee value;

    private BinarySearchTree left, right;

    private BinarySearchTree father;

    public Employee getValue() {
        return value;
    }

    @Override
    public void insert(Employee data){
        insertImpl(data, null);
    }

    private void insertImpl(Employee emp, BinarySearchTree father) {
        if (value == null){
            this.value = emp;
            this.father = father;
        } else {
            if (emp.compareTo(value) < 0){
                if (left == null) left = new BinarySearchTree();
                left.insertImpl(emp, this);
            } else if (emp.compareTo(value) > 0){
                if (right == null) right = new BinarySearchTree();
                right.insertImpl(emp, this);
            } else {
                throw new RuntimeException("No fue posible ingresar el empleado, no se permiten datos duplicados");
            }
        }
    }

    @Override
    public boolean exists(long id) {
        if (value != null){
            if (id == value.getId()){
                return true;
            } else if (id < value.getId() && left != null){
                return left.exists(id);
            } else if (id > value.getId() && right != null){
                return right.exists(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Employee get(long id) {
        if (value != null){
            if (id == value.getId()){
                return value;
            } else if (id < value.getId() && left != null){
                return left.get(id);
            } else if (id > value.getId() && right != null){
                return right.get(id);
            } else {
                System.out.println("EL Empleado con el ID "+ id + " no ha sido encontrado");
                return null;
            }
        } else {
            System.out.println("EL Empleado con el ID "+ id + " no ha sido encontrado");
            return null;
        }
    }

    @Override
    public boolean isLeaf(long id) {
        return getBTSNode(id) != null
                ? getBTSNode(id).isNodeLeaf()
                : false;
    }
    private boolean isNodeLeaf(){
        return value != null && left == null && right == null;
    }
    private BinarySearchTree getBTSNode(long id){
        if (value != null){
            if (id == value.getId()){
                return this;
            } else if (id < value.getId() && left != null){
                return left.getBTSNode(id);
            } else if (id > value.getId() && right != null){
                return right.getBTSNode(id);
            } else {
                System.out.println("EL Empleado con el ID "+ id + " no ha sido encontrado");
                return null;
            }
        } else {
            System.out.println("EL Empleado con el ID "+ id + " no ha sido encontrado");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public void inOrderTraversal() {
        if (value != null){
            if (left != null) left.inOrderTraversal();
            System.out.println(value);
            if(right != null) right.inOrderTraversal();
        }
    }

    @Override
    public void preOrderTraversal() {
        if (value != null){
            System.out.println(value);
            if (left != null) left.preOrderTraversal();
            if (right != null) right.preOrderTraversal();
        }
    }

    @Override
    public void posOrderTraversal() {
        if (value != null){
            if (left != null) left.preOrderTraversal();
            if (right!= null) right.preOrderTraversal();
            System.out.println(value);
        }
    }

    @Override
    public void delete(long id) {
        if (value != null){
            if (id == value.getId()){
                deleteImpl(id);
            } else if (id < value.getId() && left != null){
                left.delete(id);
            } else if ((id > value.getId() && right != null)){
                right.delete(id);
            }
        }
    }

    private BinarySearchTree findTheMinimum(){
        if (left != null && left.isEmpty()){
            return left.findTheMinimum();
        } else {
            return this;
        }
    }

    private void deleteImpl(long id){
        if (left != null && right != null){
            // Eliminar con dos hijos
            BinarySearchTree minimum = right.findTheMinimum();
            this.value = minimum.value;
            right.delete(minimum.value.getId());
        } else if (left != null || right != null){
            // Eliminar con un solo hijo
            BinarySearchTree replacement = left != null ? left : right;
            this.value = replacement.value;
            this.left = replacement.left;
            this.right= replacement.right;
        } else {
            // Eliminar con 0 hijos
            if (father != null){
                if (this == father.left) father.left = null;
                if (this == father.right) father.right = null;
                father = null;
            }
            value = null;
        }
    }
}
