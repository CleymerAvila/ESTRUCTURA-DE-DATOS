
public class Main {
    public static void main(String[] args) {

        Array array = new Array(6);

        array.insertLast(1);
        array.insertLast(2);
        array.insertLast(3);
        array.insertAtPosition(5, 1);
        array.insertBeforePosition(0, 2);
        array.insertAfterPosition(9, 1);

        array.scrollData();

        /**
         * Realizar un menu para insertar y eliminar de cada metodo
         * y la lectura de valores por medio de consolas
         */
    }
}
