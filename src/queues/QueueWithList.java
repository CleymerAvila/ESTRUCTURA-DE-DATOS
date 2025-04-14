package queues;


import java.util.Scanner;

public class QueueWithList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            mainMenu();
            System.out.print("\n\nIngresa una opcion valida: - ");
            option = scanner.nextInt();
            scanner.nextLine();
            String data;
            switch (option){
                case 1:
                    System.out.print("\nIngrese el dato a encolar:  - ");
                    data = scanner.nextLine();
                    queue.enQueue(data);
                    queue.print();
                    break;
                case 2:
                    System.out.print("\nElemento desencolador: "+ queue.deQueue());
                    System.out.println();
                    queue.print();
                    break;
                case 3:
                    System.out.println("\nInsertar por posicion en la cola: ");
                    System.out.print("\nIngresa la posicion: - ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingresa el dato: - ");
                    data = scanner.nextLine();
                    queue.enQueueByPosition(pos, data);
                    queue.print();
                    break;
                case 4:
                    System.out.println("\nInsertar por dato referenciado en la cola: ");
                    System.out.print("\nIngresa el dato referencia: - ");
                    String dataReference = scanner.nextLine();
                    System.out.print("Ingresa el dato: - ");
                    data = scanner.nextLine();
                    queue.enQueueByData(dataReference, data);
                    queue.print();
                    break;
                case 5:
                    System.out.println("\nEliminar por posicion en la cola");
                    System.out.print("\nIngresa la posicion: - ");
                    pos = scanner.nextInt();
                    queue.deQueueByPosition(pos);
                    queue.print();
                    break;
                case 6:
                    System.out.println("\nEliminar por dato en la cola");
                    System.out.print("\nIngresa el dato referencia: - ");
                    dataReference = scanner.nextLine();
                    queue.deQueueByData(dataReference);
                    queue.print();
                    break;
                case 7:
                    queue.reverse();
                    queue.print();
                    break;
                case 8:
                    queue.print();
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
        System.out.println("----------- Menu principal Colas -------");
        System.out.println("1. Encolar");
        System.out.println("2. Desencolar");
        System.out.println("3. Insertar por posicion en la cola");
        System.out.println("4. Insertar por dato referenciado en la cola");
        System.out.println("5. Eliminar por posicion en la cola");
        System.out.println("6. Eliminar por dato referenciado en la cola");
        System.out.println("7. Invertir cola");
        System.out.println("8. Imprimir cola");
        System.out.println("9. Salir de la aplicacion.");
        System.out.println("-----------------------------------------");
    }
}
