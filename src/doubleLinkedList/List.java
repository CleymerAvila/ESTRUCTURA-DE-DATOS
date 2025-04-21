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
            newNode.setPrevious(this.lastNode);
            this.lastNode = newNode;
        }
    }

    public void insertAfter(Node newNode, String data){
        Node reference = searchData(data);
        if (reference==null) {
            System.out.println("El dato no fue encontrado en la lista.");
        } else {
            if (reference==lastNode){
                insertAtLast(newNode);
                return;
            }
            newNode.setNext(reference.getNext());
            reference.getNext().setPrevious(newNode);
            reference.setNext(newNode);
            newNode.setPrevious(reference);
        }
    }

    public void insertBefore(Node newNode, String data){
        Node reference = searchData(data);
        if (reference==null){
            System.out.println("El dato no fue encontrado en la lista");
        } else {
            if (reference==firstNode){
                insertAtFirst(newNode);
                return;
            }
            reference.getPrevious().setNext(newNode);
            newNode.setNext(reference);
            newNode.setPrevious(reference.getPrevious());
            reference.setPrevious(newNode);
        }
    }

    public void insertAtPosition(Node newNode, int position){
        if (position<0){
            System.out.println("\nNo es posible insertar en esta posicion: ");
            return;
        }
        if (position==0){
            insertAtFirst(newNode);
            return;
        }
        Node frog = this.firstNode;
        int pos = 0;
        while (pos < position && frog.getNext() != null){
            frog = frog.getNext();
            pos++;
        }
        if (pos != position){
            System.out.println("\nNo se puede insertar el dato en la posicion indicada");
        } else {
            frog.getPrevious().setNext(newNode);
            newNode.setPrevious(frog.getPrevious());
            newNode.setNext(frog);
            frog.setPrevious(newNode);
        }

    }

    public void deleteByPosition(int position){
        if (position<0){
            System.out.println("\nNo es posible eliminar posiciones negativas");
            return;
        }

        if (position==0){
            deleteAtFirst();
        } else {
            Node frog = this.firstNode;
            int pos = 0;
            while (pos < position && frog.getNext()!=null){
                frog = frog.getNext();
                pos++;
            }
            if (pos != position){
                System.out.println("\nNo es posible eliminar la posicion indicada ya que no existe");
            } else {
                frog.getPrevious().setNext(frog.getNext());
                if (frog.getNext()!=null) {
                    frog.getNext().setPrevious(frog.getPrevious());
                }
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
                this.firstNode.setPrevious(null);
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
                    reference.getNext().setPrevious(frog);
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
                    if (reference.getPrevious()==firstNode){
                        deleteAtFirst();
                    } else {
                        reference.getPrevious().getPrevious().setNext(reference);
                        reference.setPrevious(reference.getPrevious().getPrevious());
                    }
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
                    System.out.println("\nNo es posible la operacion. Ya que la referencia es el ultimo dato de la lista.");
                } else {
                    if (reference.getNext()==lastNode){
                        deleteAtLast();
                    } else {
                        reference.setNext(reference.getNext().getNext());
                        reference.getNext().setPrevious(reference);
                    }
                }
            } else {
                System.out.println("No existe el dato referenciado");
            }
        }
    }

    public void insertionSort(){
        if(firstNode == null || firstNode.getNext() == null) return;

        Node currentNode = firstNode.getNext();
        while (currentNode != null){
            Node temp = currentNode;
            Node nodeToMove = currentNode.getPrevious();

            // Guarda el siguiente nodo antes de que se pierda
            currentNode = currentNode.getNext();

            // Desconectar el nodo temporal para moverlo
            nodeToMove.setNext(temp.getNext());

            if (temp.getNext() != null){
                temp.getNext().setPrevious(nodeToMove);
            }

            // Buscar la posicion correcta para atrás
            Node pos = nodeToMove;
            while (pos!=null && temp.getData().compareTo(pos.getData()) < 0){
                pos = pos.getPrevious();
            }

            // Insertar al inicio
            if (pos==null){
                temp.setNext(firstNode);
                firstNode.setPrevious(temp);
                temp.setPrevious(null);
                firstNode = temp;
            } else {
                temp.setNext(pos.getNext());
                if (pos.getNext()!= null){
                    pos.getNext().setPrevious(temp);
                }
                pos.setNext(temp);
                temp.setPrevious(pos);
            }
        }
        updateLastNode();
    }

    public void mergeSort(){
        firstNode = mergeSortReact(firstNode);
        updateLastNode();
    }
    private Node mergeSortReact(Node start){
        if (start==null || start.getNext()== null) return start;

        Node middle = getMiddle(start);
        Node nextMiddle = middle.getNext();
        middle.setNext(null);
        if (nextMiddle != null) nextMiddle.setPrevious(null);

        Node left = mergeSortReact(start);
        Node right = mergeSortReact(nextMiddle);
        return merge(left, right);
    }

    private Node getMiddle(Node node){
        Node slow = node;
        Node fast = node;

        while (fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    private Node merge(Node l1, Node l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.getData().compareTo(l2.getData())<0){
            l1.setNext(merge(l1.getNext(), l2));
            if (l1.getNext() != null) l1.getNext().setPrevious(l1);
            l1.setPrevious(null);
            return l1;
        } else {
            l2.setNext(merge(l1, l2.getNext()));
            if (l2.getNext() != null) l2.getNext().setPrevious(l2);
            l2.setPrevious(null);
            return l2;
        }
    }

    private void updateLastNode(){
        if (firstNode == null){
            lastNode = null;
            return;
        }
        Node current = firstNode;
        while (current.getNext()!=null){
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
        System.out.println();
        int pos = 0;
        while(frog!=null){
            System.out.print("<-[["+ pos++ +"]"+ frog.getData() + "]->");
            frog = frog.getNext();
        }
        System.out.println();
    }

    public void traverseListBackwards(){
        Node frog = this.lastNode;
        System.out.println();
        int pos = 0;
        while(frog!=null){
            System.out.print("<-[["+ pos++ +"]"+ frog.getData() + "]->");
            frog = frog.getPrevious();
        }
        System.out.println();
    }
}
