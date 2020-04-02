package homework1;


import homework1.array.ArrayToArrayList;
import homework1.array.ChangeArrayElement;

public class MainArray {
    public static void main(String[] args) {

        Integer[] arrayInteger = new Integer[]{1,2,3,4};
        String[] arrayString = new String[]{"one", "two", "three", "four"};
        Double[] arrayDouble = new Double[]{1.0, 2.0, 3.0, 4.0};

        ChangeArrayElement<Integer> integerChangeArrayElement = new ChangeArrayElement<>(arrayInteger);
        ChangeArrayElement<String> stringChangeArrayElement = new ChangeArrayElement<>(arrayString);
        ChangeArrayElement<Double> doubleChangeArrayElement = new ChangeArrayElement<>(arrayDouble);

        ArrayToArrayList<Double> doubleArrayToArrayList = new ArrayToArrayList<>(arrayDouble);

        //
        integerChangeArrayElement.getChange(0,3);
        stringChangeArrayElement.getChange(0, 2);
        doubleChangeArrayElement.getChange(3,2);

        integerChangeArrayElement.printArray();
        stringChangeArrayElement.printArray();
        doubleChangeArrayElement.printArray();

        System.out.println("Array list");
        System.out.println(doubleArrayToArrayList.getList());
    }
}

