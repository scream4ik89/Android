package task2;

import java.util.Arrays;

public class Main {
    public static boolean ignore(int[] array, int element, int index) {
        for (int i = 0; i < index; i++) {
            if (array[i] == element)
                return true;
        }
        return false;
    }

    public static void main(String[] arg) {
        int[] array = new int[10];    // Считаю не целесообразно вводить double т.к. они никогда не повторятся!!!
        for (int i = 0; i < array.length; i++) {
            array[i] = 0 + (int) (Math.random() * 10);
        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            if (ignore(array, array[i], i))
                continue;
            int counter = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                }
            }
            if (counter > 1) {


                if (counter % 10 == 2 || counter % 10 == 3 || counter % 10 == 4) {
                    System.out.println(("[" + array[i] + "] - повторяется " + counter + " раза"));
                }
                if (counter % 10 == 5 || counter % 10 == 6 || counter % 10 == 7 || counter % 10 == 8 || counter % 10 == 9 || counter % 10 == 0) {
                    System.out.println(("[" + array[i] + "] - повторяется " + counter + " раз"));
                }


            }
        }
    }
}