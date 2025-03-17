package linkedList;

public class LinkedListSimple {
    

    public static void main(String[] args) {
        List list = new List();
        list.insertAtFirst(new Node("chepa"));
        list.insertAtFirst(new Node("kuki"));
        list.insertAtFirst(new Node("toto"));
        list.insertAtLast(new Node("pepas"));
        list.insertAfter(new Node("pequi"), "kuki");

        list.goOverData();
    }
}
