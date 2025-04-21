package queues;

import doubleLinkedList.Node;

public class Queue {
    private Node front;
    private Node back;

    public Node getBack() {
        return back;
    }

    public void setBack(Node back) {
        this.back = back;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Queue(){
        this.front = null;
        this.back = null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enQueue(String data){
        Node newNode = new Node(data);
        if (front == null){
            this.front= newNode;
        } else {
            this.back.setNext(newNode);
        }
        newNode.setPrevious(back);
        this.back = newNode;
    }

    public String deQueue(){
        String frontData = "";
        if (front!=null){
            frontData = front.getData();
            Node deletingNode = front;
            front = front.getNext();
            deletingNode.setNext(null);
            if (front ==null){
                back = null;
            } else {
                front.setPrevious(null);
            }
        }
        return frontData;
    }

    public void reverse(){
        Node current = front;
        Node temp = null;

        // Intercambior los punteros siguientes y anterior en cada nodo
        while (current != null){
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);

            current = current.getPrevious(); // por que ya intercambiamos los punteros
        }

        // Al final, intercambiamos cabeza y cola
        if (temp != null){
            front = temp.getPrevious();
            back = front;

            // Recorrer  desde nueva cabeza para encontrar la nueva cola
            while (back != null && back.getNext()!= null){
                back = back.getNext();
            }
        }
    }

    // Pendiente me canse (uffasldjfa)
    public void deQueueByPosition(int pos){
        if (pos<0){
            System.out.println("posicion no valida");
            return;
        }
        int count = 0;
        Node current = front;
        while (count != pos && current.getNext()!=null ){
            count++;
            current = current.getNext();
        }
        if (count!=pos  || pos > count){
            System.out.println("posicion no encontrada!");
            return;
        }
        if (current.getNext()==null){
            current.getPrevious().setNext(null);
            back = current;
            current = null;
            return;
        }
        if (current.getPrevious()==null){
            current.getNext().setPrevious(null);
            front = current.getNext();
            current = null;
            return;
        }
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
    }


    public void deQueueByData(String data){
        Node current = front;

        while (!current.getData().equals(data) && current.getNext()!=null){
            current = current.getNext();
        }

        if (!current.getData().equals(data)){
            System.out.println("No se encontro el dato referenciado");
            return;
        }
        if (current.getNext()==null){
            current.getPrevious().setNext(null);
            back = current;
            current = null;
            return;
        }
        if (current.getPrevious()==null){
            current.getNext().setPrevious(null);
            front = current.getNext();
            current = null;
            return;
        }
        current.getNext().setPrevious(current.getPrevious());
        current.getPrevious().setNext(current.getNext());
    }

    public void enQueueByPosition(int pos, String data){
        if (pos<0){
            System.out.println("posicion no valida");
            return;
        }
        int count = 0;
        Node current = front;
        while (count != pos && current.getNext()!=null ){
            count++;
            current = current.getNext();
        }
        if (count!=pos || pos>count){
            System.out.println("posicion no encontrada!");
            return;
        }
        Node newNode = new Node(data);
        if (current.getPrevious()==null){
            newNode.setNext(current);
            current.setPrevious(newNode);
            front = newNode;
            return;
        }
        if (current.getNext()==null){
            current.getPrevious().setNext(newNode);
            newNode.setNext(current);
            return;
        }
        current.getPrevious().setNext(newNode);
        newNode.setNext(current);
    }

    public void enQueueByData(String dataReference, String data){
        Node current = front;
        while (!current.getData().equals(dataReference) && current.getNext()!=null ){
            current = current.getNext();
        }
        if (!current.getData().equals(dataReference)){
            System.out.println("Dato referenciado no encontrado!");
            return;
        }
        Node newNode = new Node(data);
        if (current.getPrevious()==null){
            newNode.setNext(current);
            current.setPrevious(newNode);
            front = newNode;
            return;
        }
        if (current.getNext()==null){
            current.getPrevious().setNext(newNode);
            newNode.setNext(current);
            return;
        }
        current.getPrevious().setNext(newNode);
        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        current.setPrevious(newNode);
    }

    public void print(){
        Node current = front;
        int count = 0;
        System.out.println();
        while (current!=null){
            System.out.println("|("+ count++ +")" + current.getData()+" |");
            current = current.getNext();
        }
    }
}
