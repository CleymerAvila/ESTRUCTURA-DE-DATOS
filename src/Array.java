public class Array {
    int[] A;
    int size;
    int count;

    public Array(int size){
        A = new int[size];
        this.size = size;
        count = 0;
    }

    public void insertLast(int data){
        if (count < size){
            A[count]=data;
            count++;
        } else {
            System.out.println("Vector lleno / Error de desbordamiento");
        }
    }

    public void insertFirst(int data){
        if (count < size){
            if (count > 0){
                for (int i=count;  i >= 1; i--){
                    A[i] = A[i - 1];
                }
            }
            A[0] = data;
            count++;
        } else {
            System.out.println("Vector lleno - desbordamiento");
        }
    }

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
            insertFirst(data);
        } else {
            if (count < size){
                if (count > 0){
                    for (int i=count;  i >= position; i--){
                        A[i] = A[i - 1];
                    }
                    A[position] = data;
                    count++;
                }
            } else {
                System.out.println("Vector lleno - desbordamiento");
            }
        }
    }

    public void insertBeforePosition(int data, int position){
        position = position -1;
        insertAtPosition(data, position);
    }

    public void insertAfterPosition(int data, int position){
        position = position + 1;
        insertAtPosition(data, position);
    }
    public void scrollData(){
        for(int i=0; i<count; i++){
            System.out.println("[ "+ A[i]+" ]");
        }
    }
}
