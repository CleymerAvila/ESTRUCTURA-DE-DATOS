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
        Node reference = searchData(data);
        if (reference==null) {
            System.out.println("El dato no fue encontrado en la lista.");
        } else {
            if (reference.getNext()==null){
                lastNode = newNode;
            }
            newNode.setNext(reference.getNext());
            reference.setNext(newNode);
        }
    }

    public void insertBefore(Node newNode, String data){
        Node reference = searchData(data);
        if (reference != null){
            if (reference==firstNode){
                insertAtFirst(newNode);
                return;
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
            System.out.println("No es posible ingresar en esta posicion");
            return;
        }
        if (position==0){
            insertAtFirst(newNode);
        } else {
            Node frog = this.firstNode;
            Node frog2 = this.firstNode;
            int pos = 0;
            while (pos < position && frog2.getNext()!=null){
                frog = frog2;
                frog2 = frog2.getNext();
                pos++;
            }
            if (pos!=position){
                System.out.println("\nNo es posible insertar en la posicion indicada");
            } else {
                frog.setNext(newNode);
                newNode.setNext(frog2);
            }
        }
    }

    public void deleteByPosition(int position){
        if (position<0){
            System.out.println("No es posible eliminar en esta posicion");
            return;
        }

        if (position==0){
            deleteAtFirst();
        } else {
            Node frog = this.firstNode;
            Node frog2 = this.firstNode;
            int pos = 0;
            while (pos < position && frog.getNext()!=null){
                frog = frog2;
                frog2 = frog2.getNext();
                pos++;
            }
            if (frog2==null){
                System.out.println("La posicion indicada no existe");
            } else {
                frog.setNext(frog2.getNext());
            }
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
                    reference.setNext(reference.getNext().getNext());
                }
            } else {
                System.out.println("No existe el dato referenciado");
            }
        }
    }

    public void bubbleSort(){
        if (firstNode == null || firstNode.getNext() == null) return;
        boolean changed;
        do {
            changed = false;
            Node currentNode = firstNode;
            while (currentNode.getNext()!=null){
                if (currentNode.getData().compareTo(currentNode.getNext().getData()) > 0){
                    String temp = currentNode.getData();
                    currentNode.setData(currentNode.getNext().getData());
                    currentNode.getNext().setData(temp);
                    changed = true;
                }
                currentNode = currentNode.getNext();
            }
        } while (changed);
    }

    public void insertionSort(){
        Node orderedNode = null;
        Node currentNode = firstNode;

        while (currentNode != null){
            Node nextNode = currentNode.getNext();
            orderedNode = insertOrdered(orderedNode, currentNode);
            currentNode = nextNode;
        }
        firstNode = orderedNode;
        updateLastNode();
    }

    private Node insertOrdered(Node orderedNode, Node newNode){
        if (orderedNode == null || newNode.getData().compareTo(orderedNode.getData())<0){
            newNode.setNext(orderedNode);
            return newNode;
        }
        Node currentNode = orderedNode;
        while (currentNode.getNext() != null &&
               currentNode.getNext().getData().compareTo(newNode.getData())<0){
            currentNode = currentNode.getNext();
        }
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        return orderedNode;
    }

    public void mergeSort(){
        firstNode = mergeSortRect(firstNode);
        updateLastNode();
    }

    private Node mergeSortRect(Node start){
        if (start == null || start.getNext()== null) return start;

        Node middle = getMiddle(start);
        Node middleNext = middle.getNext();
        middle.setNext(null);

        Node left = mergeSortRect(start);
        Node right = mergeSortRect(middleNext);

        return merge(left, right);
    }

    private Node getMiddle(Node start){
        if (start == null ) return null;

        Node slow = start;
        Node fast = start.getNext();

        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private Node merge(Node l1, Node l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node result;
        if (l1.getData().compareTo(l2.getData()) < 0 ){
            result = l1;
            result.setNext(merge(l1.getNext(), l2));
        } else {
            result =  l2;
            result.setNext(merge(l1, l2.getNext()));
        }
        return result;
    }

    private void updateLastNode(){
        if (firstNode == null){
            lastNode = null;
            return;
        }
        Node current = firstNode;
        while (current.getNext() != null){
            current = current.getNext();
        }
        lastNode = current;
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
        int pos = 0;
        System.out.println();
        while(frog!=null){
            System.out.print("[["+pos++ +"]"+ frog.getData() + "]->");
            frog = frog.getNext();
        }
        System.out.println();
    }

    
}
