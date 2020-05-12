package homework6;

import java.util.Arrays;

public class MainClass {
    public int[] subArray(int[] inputArray) throws RuntimeException {
        int count = -1;
        int desiredТumber = 4;
        int[] outputArray = null;

        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] == desiredТumber){
                count = i;
            }

            outputArray = Arrays.copyOfRange(inputArray, count + 1, inputArray.length);
        }
        if(count == -1) { throw new RuntimeException();}

        return outputArray;
    }

    public boolean checkArray(int[] inputArray) {
        boolean result = false;
        int searchNumber_1 = 1;
        int searchNumber_4 = 4;

        for(int item: inputArray){
            if(item == searchNumber_1) {result = true;}
            if(item == searchNumber_4) {result = true;}
        }

        return result;
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        int[] inputTestArray = new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] inputTestArray2 = new int[] {1, 2, 7, 6, 2, 3, 5, 1, 7};
        int[] inputTestArray3 = new int[] {3, 2, 7, 6, 2, 3, 5, 8, 7};
        int[] outputTestArray = mainClass.subArray(inputTestArray);
        int[] outputTestArray2 = new int[0];
        try {
            outputTestArray2 = mainClass.subArray(inputTestArray2);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        for (int item:outputTestArray) {
            System.out.println(": " + item);
        }

        for (int item:outputTestArray2) {
            System.out.println(": " + item);
        }

        System.out.println(mainClass.checkArray(inputTestArray));
        System.out.println(mainClass.checkArray(inputTestArray3));
    }
}
