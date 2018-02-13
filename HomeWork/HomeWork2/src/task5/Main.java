package task5;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 99);
        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = array[i];
            }

        }
        System.out.println(" массив: ");
        System.out.println(Arrays.toString(array));
    }
}
