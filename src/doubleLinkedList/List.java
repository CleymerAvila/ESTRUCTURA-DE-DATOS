package doubleLinkedList;



public class List {

    private Node firstNode;
    private Node lastNode;

    public List(){
        this.firstNode = null;
        this.lastNode = null;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public void insertAtFirst(Node newNode){
        if(firstNode==null){
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            newNode.setNext(this.firstNode);
            this.firstNode.setPrevious(newNode);
            this.firstNode = newNode;
        }
    }

    public void insertAtLast(Node newNode){
        if(this.firstNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }
    }

    public void insertAfter(Node newNode, String data){
        Node frog = searchData(data);

        if (frog==null) {
            System.out.println("El dato no fue encontrado en la lista.");
        } else {
            newNode.setNext(frog.getNext());
            frog.setNext(newNode);
        }
    }


    public void deleteAtFirst(){
        if (this.firstNode==null){
            System.out.println("Lista vacía");
        } else {
            if (this.firstNode.getNext()==null){
                this.firstNode =null;
                this.lastNode = null;
            } else {
                Node aux = this.firstNode;

                this.firstNode = this.firstNode.getNext();
                aux = null;
            }
        }
    }

    public void deleteAtLast(){
        if (this.firstNode==null){
            System.out.println("Lista vacía");
        } else {
            if (this.firstNode.getNext()==null){
                this.firstNode =null;
                this.lastNode = null;
            } else {
                Node frog = this.firstNode;
                while (frog.getNext() != lastNode){
                    frog = frog.getNext();
                }
                frog.setNext(null);
                this.lastNode = frog;
            }
        }
    }

    public void deleteByReference(String data){
        if (this.firstNode==null){
            System.out.println("Lista vacía");
        } else {
            // Ojo con las validaciones faltantes
            // 1. Cuando el nodo referencia es el primero
            // 2. Cuando el nodo referencia es el ultimo
            // 3. Cuando el nodo referencia es null (no existe)
            Node reference = this.searchData(data);
            if (reference != null){
                if (reference == firstNode){
                    deleteAtFirst();
                } else if (reference == lastNode){
                    deleteAtLast();
                } else {
                    Node frog = this.firstNode;
                    while (frog.getNext() != lastNode){
                        frog = frog.getNext();
                    }
                    frog.setNext(reference.getNext());
                    reference  = null;
                }
            } else {
                System.out.println("No existe el dato referenciado");
            }
        }
    }

    public void deleteBeforeReference(String data){
        if (this.firstNode==null){
            System.out.println("Lista vacía");
        } else {
            // Ojo con las validaciones faltantes
            // 1. Cuando el nodo referencia es el primero
            // 2. Cuando el nodo referencia es el ultimo
            // 3. Cuando el nodo referencia es null (no existe)
            Node reference = this.searchData(data);
            if (reference != null){
                if (reference == firstNode){
                    deleteAtFirst();
                } else if (reference == lastNode){
                    deleteAtLast();
                } else {
                    Node frog = this.firstNode;
                    Node frog2 = this.firstNode;
                    while (frog2.getNext() != reference){
                        frog = frog2;
                        frog2 = frog2.getNext();
                    }
                    frog.setNext(reference);
                    frog2  = null;
                }
            } else {
                System.out.println("No existe el dato referenciado");
            }
        }
    }


    public Node searchData(String data){
        Node frog = this.firstNode;

        while(frog!=null){
            if(frog.getData().equals(data)){
                break;
            }
            frog = frog.getNext();
        }
        return frog;
    }

    public void rollData(){
        Node frog = this.firstNode;

        while(frog!=null){
            System.out.print("<-["+ frog.getData() + "]->");
            frog = frog.getNext();
        }
    }

    public void rollbackData(){
        Node frog = this.lastNode;

        while(frog!=null){
            System.out.print("<-["+ frog.getData() + "]->");
            frog = frog.getPrevious();
        }
    }
}
