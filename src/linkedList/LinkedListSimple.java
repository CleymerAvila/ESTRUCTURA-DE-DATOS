package linkedList;

public class LinkedListSimple {
    

    public static void main(String[] args) {
        List list = new List();
        list.insertAtFirst(new Node("chepa"));
        list.insertAtFirst(new Node("kuki"));
        list.insertAtFirst(new Node("toto"));
        list.insertAtLast(new Node("pepas"));
        list.insertAfter(new Node("pequi"), "kuki");
        list.insertAfter(new Node("Lol"), "pepas");
        list.insertAtLast(new Node("Kakaroto"));

        list.goOverData();

//        list.deleteAtFirst();
//        System.out.println("\nSe elimino primero: ");
//        list.goOverData();
//
//        System.out.println("\nSe elimino ultimo: ");
//        list.deleteAtLast();
//        list.goOverData();
//        System.out.println("\nSe elimino ultimo: ");
//        list.deleteAtLast();
//        list.goOverData();
//
//        System.out.println("\nEliminando por referencia: kuki");
//        list.deleteByReference("kuki");
//        list.goOverData();

        System.out.println("\nEliminar antes de : pequi ");
        list.deleteBeforeReference("pepas");
        list.goOverData();
    }
}
