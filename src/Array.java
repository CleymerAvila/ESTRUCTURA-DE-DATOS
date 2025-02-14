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

    public void scrollData(){
        for(int i=0; i<count; i++){
            System.out.println("[ "+ A[i]+" ]");
        }
    }
}
