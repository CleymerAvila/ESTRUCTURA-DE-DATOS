public class Array {
    int[] A;
    int size;
    int count;

    public Array(int size){
        A = new int[size];
        this.size = size;
        count = 0;
    }

    // insertar al principio
    public void insertAtLast(int data){
        if (count < size){
            A[count]=data;
            count++;
            System.out.println("Numero "+ data+ " insertado al final con exito!");
        } else {
            System.out.println("Vector lleno / Error de desbordamiento");
        }
    }

    // insertar al final
    public void insertAtFirst(int data){
        if (count < size){
            if (count > 0){
                for (int i=count;  i >= 1; i--){
                    A[i] = A[i - 1];
                }
            }
            A[0] = data;
            count++;
            System.out.println("Numero "+ data+ " insertado al principio con exito!");
        } else {
            System.out.println("Vector lleno - desbordamiento");
        }
    }

    // insertar en una posicion
    public void insertAtPosition(int data, int position){
        // Validación posicion mayor que tamaño
        if (position > size ){
            System.out.println("El tamaño del vector no es suficiente para la posicion");
            return;
        }
        // Validacion position mayor que cantidad elemento
        if (position > count){
            System.out.println("Error no esta permitido el ingreso en esta posicion");
            return;
        }

        if (position < 0){
            System.out.println("Error la posición no puede ser negativa");
            return;
        }
        if (position == 0){
            insertAtFirst(data);
        } else {
            if (count < size){
                if (count > 0){
                    for (int i=count;  i >= position; i--){
                        A[i] = A[i - 1];
                    }
                    A[position] = data;
                    count++;
                    System.out.println("Numero "+ data+ " insertado en la posicion " + position + " con exito!");
                }
            } else {
                System.out.println("Vector lleno - desbordamiento");
            }
        }
    }

    // Insertar antes de una posicion
    public void insertBeforePosition(int data, int position){
        position = position -1;
        insertAtPosition(data, position);
    }

    // Insertar después de una posicion
    public void insertAfterPosition(int data, int position){
        position = position + 1;
        insertAtPosition(data, position);
    }

    // Eliminar al final
    public  void deleteAtLast(){
        if (count == 0){
            System.out.println("Error , no hay elementos a eliminar!!");
            return;
        }
        count--;
        System.out.println("Elemento eliminado en la posicion final");
    }

    // Eliminar al principio
    public void deleteAtFirst(){
        if (count == 0){
            System.out.println("No hay elementos a eliminar");
            return;
        }
        if (count > 0){
            for (int i=0;  i < count-1; i++){
                A[i] = A[i + 1];
            }
            count--;
            System.out.println("Elemento eliminado al principio del vector");
        }
    }

    // Eliminar en una posicion
    public void deleteAtPosition(int position){
        if (position < 0){
            System.out.println("No es posible eliminar en la posicion especificada");
        }
        if (position > count){
            System.out.println("No existe la posicion indicada");
            return;
        }
        if (position > size){
            System.out.println("La posición indicada excede el tamaño del vector");
        }
        if (position == 0){
            deleteAtFirst();
        } else {
            for (int i=position; i < count -1; i++){
                A[i] = A[i + 1];
            }
            count--;
            System.out.println("Elemento eliminado en la posicion: " + position);
        }
    }

    public void deleteFromData(int data){
        int pos = searchData(data);
        if (pos!=-1){
            deleteAtPosition(data);
        } else {
            System.out.println("El dato no existe dentro del vector");
        }
    }

    public void deleteBefore(int position){
        position--;
        deleteAtPosition(position);
    }

    public void deleteAfter(int position){
        position++;
        deleteAtPosition(position);
    }

    public void sortByTrades(boolean byAscOrder){
        // 1. Creamos unas variables para contar los intercambios y para verificar que este ordenado
        int trades = 0;
        boolean sorter=false;
        if (byAscOrder){
            // Ordenar datos de menor a mayor
            while (!sorter){
                for (int currentElement = 0; currentElement < (count-1); currentElement++){
                    int followingElement = currentElement + 1;
                    if (A[currentElement] > A[followingElement]){
                        //  Realizamos un intercambio
                        int temporalVariable = A[currentElement];
                        A[currentElement] = A[followingElement];
                        A[followingElement] = temporalVariable;
                        // Aumentamos la cantidad de intercambios
                        trades++;
                    }
                }

                if (trades == 0){
                    sorter = true;
                }

                trades = 0;
            }
        } else {
            // Ordenar de mayor a menor
            while (!sorter){
                for (int currentElement = 0; currentElement < (count-1); currentElement++){
                    int followingElement = currentElement + 1;
                    if (A[currentElement] < A[followingElement]){
                        //  Realizamos un intercambio
                        int temporalVariable = A[currentElement];
                        A[currentElement] = A[followingElement];
                        A[followingElement] = temporalVariable;
                        // Aumentamos la cantidad de intercambios
                        trades++;
                    }
                }

                if (trades == 0){
                    sorter = true;
                }

                trades = 0;
            }
        }
//        for(int i=0; i < count - 1; i++){
//            for (int currentElement=0; j < (count -1); currentElement++){
//                int followingElement = currentElement + 1;
//                if (A[currentElement]>A[followingElement]){
//                    temporalVariable = A[currentElement];
//                    A[currentElement]=A[followingElement];
//                    A[followingElement]=temporalVariable;
//                }
//            }
//        }
    }

    public void sortBySelection(boolean byAscOrder){
        int tempVariable;
        int theShorter = 0;
        for (int i=0; i < (count - 1); i++){
            for (int j=0; j < (count - 1); j++){
                if (A[j]<A[j+1]){
                    tempVariable = A[]
                    theShorter = A[j];
                }
            }
            A[i]=theShorter;
        }
    }

    public int searchData(int data){
        int position = -1;
        if (count == size){
            System.out.println("Vector lleno");
        } else {
            for(int i=0; i < count; i++){
                if (A[i]==data){
                    position=i;
                    break;
                }
            }
        }
        return position;
    }


    public void printData(){
        System.out.println("Impresión Elementos\n\n");

        for(int i=0; i<count; i++){
            System.out.print("[ "+ A[i]+" ]");
        }
        System.out.println("\n\n");
    }
}
