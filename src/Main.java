
public class Main {
    public static void main(String[] args) {

        Array array = new Array(10);

        array.insertLast(20);
        array.insertLast(10);
        array.insertLast(0);
        array.insertLast(-10);
        array.insertLast(-20);
        array.insertLast(-30);
        array.insertLast(-40);
        array.insertLast(-50);
        array.insertLast(-60);
        array.insertLast(-80);
        array.insertLast(-90);

        array.scrollData();
    }
}