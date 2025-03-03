import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    int[] A;
    int size;
    int count;

    public Array(int size){
        A = new int[size];
        this.size = size;
        count = 0;
    }

    // insertar al final
    public void insertAtLast(int data){
        if (count < size){
            A[count]=data;
            count++;
            System.out.println("Numero "+ data+ " insertado al final con exito!");
        } else {
            System.out.println("Vector lleno / Error de desbordamiento");
        }
    }
    // insertar al principio
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
        if (position >= count){
            System.out.println("Error no esta permitido el ingreso en esta posicion");
            return;
        }

        if (position < 0){
            System.out.println("Error la posición no puede ser negativa");
            return;
        }
        if (count < size){
            for (int i = count; i > position; i--) {
                A[i] = A[i - 1];
            }
            A[position] = data;
            count++;
            System.out.println("Numero "+ data+ " insertado en la posicion " + position + " con exito!");
        } else {
            System.out.println("Vector lleno - desbordamiento");
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
            deleteAtPosition(pos);
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
    // Ordenamiento Burbuja (intercambio directo)
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
//       Ordenamiento por intercambio directo con for
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
    // Ordenamiento por seleccion
    public void sortBySelection(){
        for (int i=0; i < count; i++){
            int theShorter = i;
            for (int j= i + 1; j < count; j++){
                if (A[theShorter]>A[j]){
                    theShorter = j;
                }
            }
            // Intercambio
            int tempVariable = A[i];
            A[i] = A[theShorter];
            A[theShorter] = tempVariable;
            System.out.println(Arrays.toString(A));
        }
    }
    // Ordenamiento por Inserción
    public void sortByInsertion(){
        for(int i = 1; i < count; i++){
            int currentElement = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > currentElement ){
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = currentElement;
        }
    }
    // Ordenamiento rapido. Metodo quickSort
    public void quickSort(int left, int right){
        int pivot = A[left];
        int i = left;
        int j = right;
        int auxiliary;

        while(i < j){
            while (A[i] <= pivot && i < j) i++;
            while (A[j] > pivot) j--;
            if (i < j){
                auxiliary = A[i];
                A[i] = A[j];
                A[j] = auxiliary;
            }
        }
        A[left] = A[j];
        A[j] = pivot;
        System.out.println(Arrays.toString(A));
        if (left < j-1)
            quickSort(left, j-1);
        if (j+1 < right)
            quickSort(j+1, right);
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

    public int binarySearch(int value) {
        quickSort(0, count-1); // Assuming this method sorts the vector in ascending order
        int start = 0, end = size - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (middle == value) {
                return middle;
            }

            if (middle < value) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1; // Value not found
    }

    public ArrayList<Integer> searchDuplicatesData(int data){
        StringBuilder duplicatePositions = new StringBuilder("Posicion duplicadas: ");
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < count; i++){
                if (A[i]==data) {
                    duplicatePositions.append(" - ").append(i);
                    positions.add(i);
                }
        }
        if (positions.isEmpty()) {
            System.out.println("No se encontraron valores duplicados");
        } else {
            System.out.println(duplicatePositions);
        }
    
        return positions;
    }

    public void deleteDuplicateData(ArrayList<Integer> positions){
        for(int i= 1; i< positions.size(); i++){
            deleteAtPosition(positions.get(i));
        }
    }

    public void modifyByValue(int oldValue, int newValue) {
        int position = searchData(oldValue);
        if (position != -1) {
            A[position] = newValue;
        } else {
            System.out.println("Value not found.");
        }
    }

    public void modifyByPosition(int position, int newValue) {
        if (position >= 0 && position < size) {
            A[position] = newValue;
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void printData(){
        System.out.println("Impresión Elementos\n\n");

        for(int i=0; i<count; i++){
            System.out.print("[ "+ A[i]+" ]");
        }
        System.out.println("\n\n");
    }
}
