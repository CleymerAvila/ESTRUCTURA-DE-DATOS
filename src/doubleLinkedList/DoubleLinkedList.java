package doubleLinkedList;

public class DoubleLinkedList {

    public static void main(String[] args) {
        List list = new List();
        list.insertAtFirst(new Node("Lucas"));
        list.insertAtFirst(new Node("Lucho"));
        list.traverseList();
        System.out.println();
        list.traverseListBackwards();
    }

}
