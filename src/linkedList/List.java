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
            newNode.setNext(frog.getNext());
            frog.setNext(newNode);
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

    public void goOverData(){
        Node frog = this.firstNode;

        while(frog!=null){
            System.out.print("["+ frog.getData() + "]->");
            frog = frog.getNext();
        }

    }

    
}
