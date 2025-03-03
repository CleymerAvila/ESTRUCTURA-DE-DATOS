import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /**
         * Realizar un menu para insertar y eliminar de cada metodo
         * y la lectura de valores por medio de consolas
         */
        Scanner sc = new Scanner(System.in);
        Array array = new Array(10);
        int mainOption;
        int number;
        int pos;
        do {
            mainMenu();
            System.out.print("Selecciona una opcion valida: - ");
            mainOption = sc.nextInt();
            switch (mainOption) {
                case 1:
                    int insertionOption;
                    do{
                        insertionMenu();
                        System.out.print("Selecciona una opcion: - ");
                        insertionOption = sc.nextInt();
                        switch (insertionOption){
                            case 1:
                                System.out.print("Digite el numero a insertar: - ");
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
                                System.out.print("digite la posicion: ");
                                pos = sc.nextInt();
                                array.insertAtPosition(number, pos);
                                array.printData();
                                break;
                            case 4:
                                System.out.print("Digite el numero a insertar: - ");
                                number = sc.nextInt();
                                System.out.print("digite la posicion: - ");
                                pos = sc.nextInt();
                                array.insertBeforePosition(number, pos);
                                array.printData();
                                break;
                            case 5:
                                System.out.print("Digite el numero a insertar: - ");
                                number = sc.nextInt();
                                System.out.print("digite la posicion: - ");
                                pos = sc.nextInt();
                                array.insertAfterPosition(number, pos);
                                array.printData();
                                break;
                            case 6:
                                System.out.println("\nRegresando al menu principal");
                                break;
                            default:
                                System.out.println("Opcion no valida!!");
                                break;

                        }
                    } while (insertionOption != 6);
                    break;
                case 2:
                    int eliminationOption;
                    do{
                        eliminationMenu();
                        System.out.print("Selecciona una opcion: - ");
                        eliminationOption = sc.nextInt();
                        switch (eliminationOption){
                            case 1:
                                array.deleteAtFirst();
                                array.printData();
                                break;
                            case 2:
                                array.deleteAtLast();
                                array.printData();
                                break;
                            case 3:
                                System.out.print("Digite la posicion a eliminar: - ");
                                pos = sc.nextInt();
                                array.deleteAtPosition(pos);
                                array.printData();
                                break;
                            case 4:
                                System.out.println("Eliminar antes de una posicion");
                                System.out.print("Ingrese posicion: - ");
                                pos = sc.nextInt();
                                array.deleteBefore(pos);
                                array.printData();
                                break;
                            case 5:
                                System.out.println("Eliminar despues de una posicion");
                                System.out.println("Ingrese posicion: - ");
                                pos = sc.nextInt();
                                array.deleteAfter(pos);
                                array.printData();
                                break;
                            case 6:
                                System.out.println("Eliminar por dato");
                                System.out.print("Ingrese dato: - ");
                                number = sc.nextInt();
                                array.deleteFromData(number);
                                array.printData();
                                break;
                            case 7:
                                System.out.println("Eliminacion datos repetidos de un valor");
                                System.out.print("Ingresa un valor: - ");
                                number = sc.nextInt();
                                ArrayList<Integer> positions = array.searchDuplicatesData(number);
                                array.deleteDuplicateData(positions);
                                System.out.println(positions);
                                break;
                            case 8:
                                System.out.println("\nRegresando al menu principal");
                                break;
                            default:
                                System.out.println("Opcion no valida!!");
                                break;

                        }
                    } while (eliminationOption != 8);
                    break;
                case 3:
                    int sortingOption;
                    do{
                        sortingMenu();
                        System.out.print("Selecciona una opcion: - ");
                        sortingOption = sc.nextInt();
                        switch (sortingOption){
                            case 1:
                                array.sortByTrades(true);
                                array.printData();
                                break;
                            case 2:
                                array.sortBySelection();
                                array.printData();
                                break;
                            case 3:
                                array.sortByInsertion();
                                array.printData();
                                break;
                            case 4:
                                array.quickSort(0, array.count-1);
                                array.printData();
                                break;
                            case 5:
                                System.out.println("\nRegresa al menu principal\n");
                                break;
                            default:
                                System.out.println("Opcion no valida!!");
                                break;

                        }
                    } while (sortingOption != 5);
                    break;
                case 4:
                    System.out.println("----- MENU BUSCAR ARRAY -------");
                    System.out.println("1. Buscar dato dentro del array");
                    System.out.println("2. Buscar repeticiones datos");
                    int searchOption = sc.nextInt();
                    if (searchOption == 1){
                        System.out.println("Ingresa un valor: - ");
                        number = sc.nextInt();
                        pos = array.searchData(number);
                        if (pos!=-1){
                            System.out.println("El dato ingresado "+ number + " se encuentra en la posicion "+pos);
                        } else {
                            System.out.println("No se encuentra el dato ingresado");
                        }
                    } else if (searchOption ==2){
                        System.out.println("\nBuscar repeticiones posicion de un dato");
                        System.out.print("Ingrese dato: - ");
                        number = sc.nextInt();
                        array.searchDuplicatesData(number);
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;
                case 5:
                    array.printData();
                    break;
                case 6:
                    System.out.println("Gracias por usar la aplicacion. Cerrando... ");
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    break;
            }
        } while (mainOption != 6);

    }

    public static void mainMenu(){
        System.out.println("\n\n--------  MENU OPCIONES ARRAY  ------");
        System.out.println("1. Inserción de datos");
        System.out.println("2. Eliminacion datos");
        System.out.println("3. Ordenacion datos");
        System.out.println("4. Busqueda datos");
        System.out.println("5. Impresión y Recorrido datos");
        System.out.println("6. Cerrar Aplicacion");
        System.out.println("- -- | --- | ---- |--- |  -------|---");
    }

    public static void insertionMenu(){
        System.out.println("\n\n---- MENU INSERCION DATOS ARRAY----");
        System.out.println("1. Insertar Dato al principio");
        System.out.println("2. Insertar Dato al final");
        System.out.println("3. Insertar Dato en posicion");
        System.out.println("4. Insertar Dato antes de posicion");
        System.out.println("5. Insertar Dato despúes de posicion");
        System.out.println("6. Regresar a menu principal");
        System.out.println("------------------------------------");
    }

    public static void eliminationMenu(){
        System.out.println("\n\n---- MENU ELIMINACION DATOS ARRAY----");
        System.out.println("1. Eliminacion Dato al principio");
        System.out.println("2. Eliminacion Dato al final");
        System.out.println("3. Eliminacion Dato en posicion");
        System.out.println("4. Eliminacion Dato antes de posicion");
        System.out.println("5. Eliminacion Dato despues de posicion");
        System.out.println("6. Eliminacion Dato por Valor");
        System.out.println("7. Eliminacioin Dato repetidos de un valor");
        System.out.println("8. Regresar a menu principal");
        System.out.println("------------------------------------");
    }

    public static void  sortingMenu(){
        System.out.println("\n\n------ MENU ORDENACION DATOS ARRAY -----");
        System.out.println("1. Metodo Burbuja \n(intercambio directo)");
        System.out.println("2. Metodo por seleccion");
        System.out.println("3. Metodo Insercion");
        System.out.println("4. Metodo ordenacion rapida- quicksort");
        System.out.println("5. Regresar a menu principal");
        System.out.println("----------------------------------------");
    }

    public static void insertionMethods(Array array, Scanner sc){
        int number;
        int pos;
        int insertionOption;
        do{
            insertionMenu();
            System.out.print("Selecciona una opcion: - ");
            insertionOption = sc.nextInt();
            switch (insertionOption){
                case 1:
                    System.out.print("Digite el numero a insertar: - ");
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
                    System.out.print("digite la posicion: ");
                    pos = sc.nextInt();
                    array.insertAtPosition(number, pos);
                    array.printData();
                    break;
                case 4:
                    System.out.print("Digite el numero a insertar: - ");
                    number = sc.nextInt();
                    System.out.print("digite la posicion: - ");
                    pos = sc.nextInt();
                    array.insertBeforePosition(number, pos);
                    array.printData();
                    break;
                case 5:
                    System.out.print("Digite el numero a insertar: - ");
                    number = sc.nextInt();
                    System.out.print("digite la posicion: - ");
                    pos = sc.nextInt();
                    array.insertAfterPosition(number, pos);
                    array.printData();
                    break;
                case 6:
                    System.out.println("\nRegresando al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida!!");
                    break;

            }
        } while (insertionOption != 6);
    }

    public static void eliminationMethods(Array array, Scanner sc){
        int eliminationOption;
        int pos;
        int number;
        do{
            eliminationMenu();
            System.out.print("Selecciona una opcion: - ");
            eliminationOption = sc.nextInt();
            switch (eliminationOption){
                case 1:
                    array.deleteAtFirst();
                    array.printData();
                    break;
                case 2:
                    array.deleteAtLast();
                    array.printData();
                    break;
                case 3:
                    System.out.print("Digite la posicion a eliminar: - ");
                    pos = sc.nextInt();
                    array.deleteAtPosition(pos);
                    array.printData();
                    break;
                case 4:
                    System.out.println("Eliminar antes de una posicion");
                    System.out.print("Ingrese posicion: - ");
                    pos = sc.nextInt();
                    array.deleteBefore(pos);
                    array.printData();
                    break;
                case 5:
                    System.out.println("Eliminar despues de una posicion");
                    System.out.println("Ingrese posicion: - ");
                    pos = sc.nextInt();
                    array.deleteAfter(pos);
                    array.printData();
                    break;
                case 6:
                    System.out.println("Eliminar por dato");
                    System.out.print("Ingrese dato: - ");
                    number = sc.nextInt();
                    array.deleteFromData(number);
                    array.printData();
                    break;
                case 7:
                    System.out.println("\nRegresando al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida!!");
                    break;

            }
        } while (eliminationOption != 7);
    }

    public static void sortingMethods(Array array, Scanner sc){
        int sortingOption;
        do{
            sortingMenu();
            System.out.print("Selecciona una opcion: - ");
            sortingOption = sc.nextInt();
            switch (sortingOption){
                case 1:
                    array.sortByTrades(true);
                    array.printData();
                    break;
                case 2:
                    array.sortBySelection();
                    array.printData();
                    break;
                case 3:
                    array.sortByInsertion();
                    array.printData();
                    break;
                case 4:
                    array.quickSort(0, array.count-1);
                    array.printData();
                    break;
                case 5:
                    System.out.println("\nRegresa al menu principal\n");
                    break;
                default:
                    System.out.println("Opcion no valida!!");
                    break;

            }
        } while (sortingOption != 5);
    }
}
