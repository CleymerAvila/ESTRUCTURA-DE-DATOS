package doubleLinkedList;


import java.util.Scanner;

public class DoubleLinkedList {

    public static Scanner scanner = new Scanner(System.in);
    public static List list;

    public static void main(String[] args) {
        list = new List();
        int option;
        do {
            mainMenu();
            System.out.print("Selecciona una opcion valida: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    insertionsMethods(list, scanner);
                    break;
                case 2:
                    deleteMethods(list, scanner);
                    break;
                case 3:
                    searchMethod(list, scanner);
                    break;
                case 4:
                    sortingMethods(list, scanner);
                    break;
                case 5:
                    dataTravel(list, scanner);
                    break;
                case 6:
                    System.out.println("\nSaliendo del programa!!");
                    break;
            }
        } while (option != 6);
    }

    public static void mainMenu(){
        System.out.println("\n--- Listas Doblemente Enlazadas Menu Principal ---");
        System.out.println("1. Insercion");
        System.out.println("2. Eliminacion");
        System.out.println("3. Busquedad");
        System.out.println("4. Ordenacion");
        System.out.println("5. Recorrido datos");
        System.out.println("6. Salir de programa");
        System.out.println("--------------------------------------------------");
    }
    public static void insertionMenu(){
        System.out.println("\n\n----- Menu de Inserción -----");
        System.out.println("1. Inserción al principio");
        System.out.println("2. Inserción al final.");
        System.out.println("3. Inserción despues");
        System.out.println("4. Inserción antes");
        System.out.println("5. Inserción en posicion");
        System.out.println("6. Regresar a menu principal");
        System.out.println("---------------------------------");
    }

    public static void deleteMenu(){
        System.out.println("\n----- Menu de Eliminacion -----");
        System.out.println("1. Eliminacion al principio");
        System.out.println("2. Eliminacion al final.");
        System.out.println("3. Eliminación despues");
        System.out.println("4. Eliminacion antes");
        System.out.println("5. Eliminacion en posicion");
        System.out.println("6. Eliminacion por referencia");
        System.out.println("7. Regresar a menu principal");
        System.out.println("---------------------------------");
    }

    public static void sortingMenu(){
        System.out.println("\n\n----- Menu de Ordenamiento ---  ");
        System.out.println("1. Ordenamiento Insercion");
        System.out.println("2. Ordenamiento mergeSort");
        System.out.println("3. Regresar al menu principal");
        System.out.println("-----------------------------------");
    }

    public static void insertionsMethods(List list, Scanner sc){
        int option;
        String data;
        String referenceData;
        int pos;
        list.traverseList();
        do {
            insertionMenu();
            System.out.print("\nIngresa una opcion valida: - ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.print("\nDigite el dato a ingresar: - ");
                    data = sc.nextLine();
                    list.insertAtFirst(new Node(data));
                    list.traverseList();
                    break;
                case 2:
                    System.out.print("\nDigite el dato a ingresar: - ");
                    data = sc.nextLine();
                    list.insertAtLast(new Node(data));
                    list.traverseList();
                    break;
                case 3:
                    System.out.print("\nDigite el dato a referenciar (despues de): - ");
                    referenceData = sc.nextLine();
                    System.out.print("\nDigite el dato a ingresar: - ");
                    data = sc.nextLine();
                    list.insertAfter(new Node(data), referenceData);
                    list.traverseList();
                    break;
                case 4:
                    System.out.print("\nDigite el dato a referenciar (antes de): - ");
                    referenceData = sc.nextLine();
                    System.out.print("\nDigite el dato a ingresar: - ");
                    data = sc.nextLine();
                    list.insertBefore(new Node(data), referenceData);
                    list.traverseList();
                    break;
                case 5:
                    System.out.print("\nDigite la posicion: - ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nDigite el dato a ingresar: - ");
                    data = sc.nextLine();
                    list.insertAtPosition(new Node(data), pos);
                    list.traverseList();
                    break;
                case 6:
                    System.out.println("\nRegresando al menu principal!!");
                    break;
                default:
                    System.out.println("\nOpcion no valida!!");
                    break;
            }
        } while (option != 6);
    }

    public static void deleteMethods(List list, Scanner sc){
        int option;
        String referenceData;
        int pos;
        list.traverseList();
        do {
            deleteMenu();
            System.out.print("\nIngresa una opcion valida: - ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    list.deleteAtFirst();
                    list.traverseList();
                    break;
                case 2:
                    list.deleteAtLast();
                    list.traverseList();
                    break;
                case 3:
                    System.out.print("\nDigite el dato a referenciar (despues de): - ");
                    referenceData = sc.nextLine();
                    list.deleteAfterReference(referenceData);
                    list.traverseList();
                    break;
                case 4:
                    System.out.print("\nDigite el dato a referenciar (antes de): - ");
                    referenceData = sc.nextLine();
                    list.deleteBeforeReference(referenceData);
                    list.traverseList();
                    break;
                case 5:
                    System.out.print("\nDigite la posicion a eliminar: - ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    list.deleteByPosition(pos);
                    list.traverseList();
                    break;
                case 6:
                    System.out.print("\nDigite el dato a eliminar: - ");
                    referenceData = sc.nextLine();
                    sc.nextLine();
                    list.deleteByReference(referenceData);
                    list.traverseList();
                    break;
                case 7:
                    System.out.println("\nRegresando al menu principal!!");
                    break;
                default:
                    System.out.println("\nOpcion no valida!!");
                    break;
            }
        } while (option != 7);
    }

    public static void sortingMethods(List list, Scanner sc){
        int option;
        list.traverseList();
        do {
            sortingMenu();
            System.out.print("\nIngresa una opcion valida: -");
            option = sc.nextInt();
            switch (option){
                case 1:
                    list.insertionSort();
                    list.traverseList();
                    break;
                case 2:
                    list.mergeSort();
                    list.traverseList();
                    break;
                case 3:
                    System.out.println("\nRegresando al menu principal");
                    break;
                default:
                    System.out.println("\nOpción no valida!");
                    break;
            }
        } while (option!=3);
    }

    public static void searchMethod(List list, Scanner scanner){
        list.traverseList();
        System.out.print("\nDigite el dato a buscar: - ");
        String data = scanner.nextLine();
        Node searchedNode = list.searchData(data);
        if (searchedNode==null){
            System.out.println("\nEl dato no existe");
        } else {
            System.out.println("\nDato encontrado: ");
            System.out.println("Dato: "+ searchedNode.getData());
            System.out.println("Siguiente Nodo: "+ searchedNode.getNext().getData());
        }
    }

    public static void dataTravel(List list, Scanner scanner){
        System.out.println("\nDesea mostrar los datos en orden contrario (Si(1), No(0)) ");
        int option = scanner.nextInt();
        if (option==0){
            list.traverseList();
        } else if(option==1){
            list.traverseListBackwards();
        }
    }
}
