package linkedList;

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
            if (frog.getNext()==null){
                lastNode = newNode;
            }
            newNode.setNext(frog.getNext());
            frog.setNext(newNode);
        }
    }

    public void insertBefore(Node newNode, String data){
        Node reference = searchData(data);
        if (reference != null){
            if (reference==firstNode){
                insertAtFirst(newNode);
            }
            Node frog = firstNode;
            while (frog.getNext() != reference){
                frog = frog.getNext();
            }
            frog.setNext(newNode);
            newNode.setNext(reference);
        } else {
            System.out.println("El dato ingresado no existe");
        }
    }

    public void insertAtPosition(Node newNode, int position){
        if (position<0){
            System.out.println("No es posible eliminar en esta posicion");
            return;
        }
        if (position==0){
            insertAtFirst(newNode);
            return;
        }

        Node frog = this.firstNode;
        Node frog2 = this.firstNode;
        int count = 0;
        while (count < position && frog.getNext()!=null){
            frog = frog2;
            frog2 = frog2.getNext();
            count++;
        }
//        // frog.setNext(frog2.getNext());
//        System.out.println("debuggin sapo: "+frog.getData());
//        System.out.println("debuggin sapo 2: "+frog2.getData());
        frog.setNext(newNode);
        newNode.setNext(frog2);
    }

    public void deleteByPosition(int position){
        if (position<0){
            System.out.println("No es posible eliminar en esta posicion");
            return;
        }

        Node frog = this.firstNode;
        Node frog2 = this.firstNode;
        int count = 0;
        while (count < position && frog.getNext()!=null){
            frog = frog2;
            frog2 = frog2.getNext();
            count++;
        }
        frog.setNext(frog2.getNext());
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
                    while (frog.getNext() != reference){
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
                    System.out.println("\nNo es posible la operacion. Ya que la referencia es el primer dato de la lista.");
                } else {
                    Node frog = this.firstNode;
                    Node frog2 = this.firstNode;
                    while (frog2.getNext() != reference){
                        frog = frog2;
                        frog2 = frog2.getNext();
                    }
                    if (frog2==firstNode){
                        deleteAtFirst();
                    }
                    frog.setNext(reference);
                    frog2  = null;
                }
            } else {
                System.out.println("No existe el dato referenciado");
            }
        }
    }

    public void deleteAfterReference(String data){
        if (this.firstNode==null){
            System.out.println("Lista vacía");
        } else {
            // Ojo con las validaciones faltantes
            // 1. Cuando el nodo referencia es el primero
            // 2. Cuando el nodo referencia es el ultimo
            // 3. Cuando el nodo referencia es null (no existe)
            Node reference = this.searchData(data);
            if (reference != null){
                if (reference == lastNode){
                    System.out.println("\nNo es posible la operacion ya que no se puede eliminar datos despues del ultimo Nodo.");
                } else {
//                    Node frog = this.firstNode;
//                    while (frog.getNext() != reference.getNext()){
//                        frog = frog.getNext();
//                    }
                    reference.setNext(reference.getNext().getNext());
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

    public void traverseList(){
        Node frog = this.firstNode;
        int count = 0;
        System.out.println();
        while(frog!=null){
            System.out.print("[["+count++ +"]"+ frog.getData() + "]->");
            frog = frog.getNext();
        }
        System.out.println();
    }

    
}
