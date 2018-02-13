package Task2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/*
2) Сделать задание с массивами и System.arraycopy.
Создать массив из 10 переменных любого типа данных.
Создать другой массив с 20-ю переменными такого же типа данных, как и первый.
Далее скопировать первый массив во второй в середину.
 */
public class Main {
    public static void main(String[] arg) {
        int [] array1 = new int[10];
        int [] array2 = new int[20];
        //Random random = new Random();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 100);       }
        System.out.println("Первый массив: \n" + Arrays.toString(array1));
        for (int j = 0; j < array2.length; j++) {            array2[j] = 0;} // для наглядности слияния
        System.out.println("Второй массив: \n" + Arrays.toString(array2));
        System.arraycopy(array1, 0, array2, 5, array1.length);
        System.out.println("Второй массив после слияния: \n" + Arrays.toString(array2));
    }
}
