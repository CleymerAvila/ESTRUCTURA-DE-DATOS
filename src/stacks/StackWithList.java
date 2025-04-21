package stacks;

import java.util.Scanner;

public class StackWithList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);

        /*
        Cleymer Avila Pushaina
        Breiner Montes Petro
        Juan Torres Torres
        * */
        int option;
        do {
            mainMenu();
            System.out.print("\n\nIngresa una opcion valida: - ");
            option = scanner.nextInt();
            scanner.nextLine();
            String data;
            switch (option){
                case 1:
                    System.out.print("\nIngrese el dato a apilar:  - ");
                    data = scanner.nextLine();
                    stack.push(data);
                    stack.print();
                    break;
                case 2:
                    System.out.print("\nElemento desapilado: "+ stack.pop().getData());
                    System.out.println();
                    stack.print();
                    break;
                case 3:
                    System.out.println("\nInsertar por posicion en la pila: ");
                    System.out.print("\nIngresa la posicion: - ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingresa el dato: - ");
                    data = scanner.nextLine();
                    stack.insertByPosition(pos, data);
                    stack.print();
                    break;
                case 4:
                    System.out.println("\nInsertar por dato referenciado en la pila");
                    System.out.print("\nIngresa el dato referencia: - ");
                    String dataReference = scanner.nextLine();
                    System.out.print("Ingresa el dato: - ");
                    data = scanner.nextLine();
                    stack.insertByData(dataReference, data);
                    stack.print();
                    break;
                case 5:
                    System.out.println("\nEliminar por posicion en la pila");
                    System.out.print("\nIngresa la posicion: - ");
                    pos = scanner.nextInt();
                    stack.deleteByPosition(pos);
                    stack.print();
                    break;
                case 6:
                    System.out.println("\nEliminar por dato en la pila");
                    System.out.print("\nIngresa el dato referencia: - ");
                    dataReference = scanner.nextLine();
                    stack.deleteByData(dataReference);
                    stack.print();
                    break;
                case 7:
                    stack.reverse();
                    stack.print();
                    break;
                case 8:
                    stack.print();
                    break;
                case 9:
                    System.out.println("\nSaliendo de la aplicacion!!");
                    break;
                default:
                    System.out.println("\nOpción no valida!!");
                    break;
            }
        } while (option!=9);
    }

    public static void mainMenu(){
        System.out.println("----------- Menu principal Pilas -------");
        System.out.println("1. Apilar");
        System.out.println("2. Desapilar");
        System.out.println("3. Insertar por posicion en la pila");
        System.out.println("4. Insertar por dato referenciado en la pila");
        System.out.println("5. Eliminar por posicion en la pila");
        System.out.println("6. Eliminar por dato referenciado en la pila");
        System.out.println("7. Invertir pila");
        System.out.println("8. Imprimir pila");
        System.out.println("9. Salir de la aplicacion.");
        System.out.println("-----------------------------------------");
    }
}
