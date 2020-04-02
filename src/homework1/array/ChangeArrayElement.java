package homework1.array;

public class ChangeArrayElement <T>{
    private T[] array;

    public ChangeArrayElement(T[] array) {
        this.array = array;
//        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public void getChange(int indexOne, int indexTwo){
        if(indexOne >= 0 && indexTwo >= 0 && indexOne < array.length && indexTwo < array.length && indexOne !=indexTwo) {
            T tmp = this.array[indexOne];
            this.array[indexOne] = this.array[indexTwo];
            this.array[indexTwo] = tmp;
        } else {
            System.out.println("Неверно введены данные");
        }
    }

    public void printArray() {
        String[] partsClassName = array.getClass().getName().split("\\.", 3);
        System.out.println(partsClassName[2]);

        for(T item: array) {
            System.out.println(item);
        }
        System.out.println("-------------------------------");
        System.out.println();
    }
}

