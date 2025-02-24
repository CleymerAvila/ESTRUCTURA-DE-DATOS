import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /**
         * Realizar un menu para insertar y eliminar de cada metodo
         * y la lectura de valores por medio de consolas
         */
        Scanner sc = new Scanner(System.in);
        Array array = new Array(10);
        int option;
        int number;
        int pos;
        do {
            menu();
            System.out.println("Selecciona una opcion valida: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Digite el numero a insertar: ");
                    number = sc.nextInt();
                    array.insertAtFirst(number);
                    array.printData();
                    break;
                case 2:
                    System.out.print("Digite el numero a insertar: ");
                    number = sc.nextInt();
                    array.insertAtLast(number);
                    array.printData();
                    break;
                case 3:
                    System.out.print("Digite el numero a insertar: ");
                    number = sc.nextInt();
                    System.out.print("Digite el la posicion: ");
                    pos = sc.nextInt();
                    array.insertAtPosition(number, pos);
                    array.printData();
                    break;
                case 4:
                    System.out.print("Digite el numero a insertar: ");
                    number = sc.nextInt();
                    System.out.print("Digite el la posicion: ");
                    pos = sc.nextInt();
                    array.insertBeforePosition(number, pos);
                    array.printData();
                    break;
                case 5:
                    System.out.print("Digite el numero a insertar: ");
                    number = sc.nextInt();
                    System.out.print("Digite el la posicion: ");
                    pos = sc.nextInt();
                    array.insertAfterPosition(number, pos);
                    array.printData();
                    break;
                case 6:
                    array.deleteAtFirst();
                    array.printData();
                    break;
                case 7:
                    array.deleteAtLast();
                    array.printData();
                    break;
                case 8:
                    System.out.println("Digite la posicion a eliminar");
                    pos = sc.nextInt();
                    array.deleteAtPosition(pos);
                    array.printData();
                    break;
                case 9:
                    System.out.println("Eliminar por dato");
                    System.out.println("Ingrese dato: ");
                    number = sc.nextInt();
                    array.deleteFromData(number);
                    array.printData();
                    break;
                case 10:
                    System.out.println("Eliminar antes de una posicion");
                    System.out.println("Ingrese posicion: ");
                    pos = sc.nextInt();
                    array.deleteBefore(pos);
                    array.printData();
                    break;
                case 11:
                    System.out.println("Eliminar despues de una posicion");
                    System.out.println("Ingrese posicion: ");
                    pos = sc.nextInt();
                    array.deleteAfter(pos);
                    array.printData();
                case 12:
                    System.out.println("Buscar posicion de un dato");
                    System.out.println("Ingrese dato: ");
                    number = sc.nextInt();
                    pos = array.searchData(number);
                    if (pos!=-1){
                        System.out.println("El dato ingresado "+ number + " se encuentra en la posicion "+pos);
                    } else {
                        System.out.println("No se encuentra el dato ingresado");
                    }
                case 13:
                    System.out.println("Ordenar vectores en orden Ascendente");
                    array.sortByTrades(true);
                    array.printData();
                    break;
                case 14:
                    System.out.println("Ordenar vectores en orden Descendente");
                    array.sortByTrades(false);
                    array.printData();
                    break;
                case 15:
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción no valida!");
                    break;
            }
        } while (option != 15);

    }

    public static void menu(){
        System.out.println("--------- MENU DE OPCIONES -------");
        System.out.println("1. Insertar al principio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Insertar en una posicion");
        System.out.println("4. Insertar antes de una posicion");
        System.out.println("5. Insertar despues de una posicion");
        System.out.println("6. Eliminar al principio");
        System.out.println("7. Eliminar al final");
        System.out.println("8. Eliminar en una posicion");
        System.out.println("9. Eliminar por un dato");
        System.out.println("10. Eliminar antes de posicion");
        System.out.println("11. Eliminar despues de una posicion");
        System.out.println("12. Buscar posicion de un dato");
        System.out.println("13. Ordenar datos por orden Ascendente");
        System.out.println("14. Ordenar datos por orden Descendente");
        System.out.println("15. Salir de la aplicacion.");
        System.out.println("--------- - -- - -  - - -  -------");
    }
}
