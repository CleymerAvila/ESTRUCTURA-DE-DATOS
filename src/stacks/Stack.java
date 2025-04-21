package stacks;

import linkedList.Node;

public class Stack {
    private Node top;

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public void push(String data){
        Node newNode = new Node(data);
        if (isEmpty()){
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
    }

    public Node pop(){
        if (isEmpty()){
            return null;
        } else {
            Node poppedNode = top;
            top = top.getNext();
            return poppedNode;
        }
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void peek(){
        System.out.println("Cima de la pila: "+ top.getData());
    }

    public void reverse(){
        if (isEmpty()) return;

        String temp = pop().getData();
        reverse();
        insertAtBottom(temp);
    }
    private void insertAtBottom(String data){
        if (isEmpty()){
            push(data);
            return;
        }
        String temp = pop().getData();
        insertAtBottom(data);
        push(temp);
    }

    public void deleteByPosition(int pos){
        if (isEmpty()){
            System.out.println("\nLa lista esta vacia no hay datos a eliminar");
            return;
        }

        Node current = top;
        Node beforeCurrent = top;
        int count = 0;
        while (count != pos && current.getNext()!=null){
            beforeCurrent = current;
            current = current.getNext();
            count++;
        }

        if (count != pos || pos > count){
            System.out.println("Posicion No encontrada!");
            return;
        }
        if (current==top){
            pop();
            return;
        }
        if (current.getNext()==null){
            Node aux = top;
            while (aux.getNext()!=current){
                aux = aux.getNext();
            }
            aux.setNext(null);
            current = null;
            return;
        }
        beforeCurrent.setNext(current.getNext());
    }

    public void deleteByData(String data){
        if (isEmpty()){
            System.out.println("La lista esta vacia no hay elementos a eliminar");
            return;
        }
        Node current = top;
        Node beforeCurrent = top;
        while (!current.getData().equals(data) && current.getNext()!=null){
            beforeCurrent = current;
            current = current.getNext();
        }

        if (current==top){
            pop();
            return;
        }
        if (current.getNext()==null){
            Node aux = top;
            while (aux.getNext()!=current){
                aux = aux.getNext();
            }
            aux.setNext(null);
            current = null;
            return;
        }
        beforeCurrent.setNext(current.getNext());
    }

    public void insertByPosition(int pos, String data){
        if (isEmpty()){
            System.out.println("\nLa lista esta vacia no hay datos a eliminar");
            return;
        }

        if (pos<0){
            System.out.println("\nla posicion no puede ser negativa");
            return;
        }
        Node current = top;
        Node beforeCurrent = top;
        int count = 0;
        while (count != pos && current.getNext()!=null){
            beforeCurrent = current;
            current = current.getNext();
            count++;
        }

        if (pos!=count){
            System.out.println("La posicion referenciada no existe");
            return;
        }
        if (current==top){
            push(data);
            return;
        }
        Node node = new Node(data);
        beforeCurrent.setNext(node);
        node.setNext(current);
    }

    public void insertByData(String dataReference, String data){
        if (isEmpty()){
            System.out.println("La lista esta vacia no hay elementos a eliminar");
            return;
        }
        Node current = top;
        Node beforeCurrent = top;
        while (!current.getData().equals(dataReference) && current.getNext()!=null){
            beforeCurrent = current;
            current = current.getNext();
        }

        if (!current.getData().equals(dataReference)){
            System.out.println("\nDato referenciado no encontrado");
            return;
        }
        if (current==top){
            push(data);
            return;
        }
        Node node = new Node(data);
        beforeCurrent.setNext(node);
        node.setNext(current);
    }

    public void print(){
        Node node = top;
        int count = 0;
        System.out.println();
        while (node!=null){
            System.out.println("||"+ count++ + "| "+node.getData()+"|");
            node = node.getNext();
        }
    }
}
