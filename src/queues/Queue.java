package queues;

import doubleLinkedList.Node;

public class Queue {
    private Node front;
    private Node back;

    public Queue(){
        this.front = null;
        this.back = null;
    }

    public void enqueue(Node newNode){
    }

    public Node dequeue(){
        return new Node("");
    }
}
