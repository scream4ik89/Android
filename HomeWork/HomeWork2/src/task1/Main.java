package task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg){
        int [] array = new int[10];
        for (int i = 0; i < array.length; i++){
            array[i] =(int)(Math.random()*99);
        }
        System.out.println("Исходный массив: ");
            System.out.println(Arrays.toString(array));
        int min = array[0];
        int max = array[0];
        for (int i = 1; i <= array.length-1; i++){
            if(min > array[i])
                min = array[i];
            if (max < array[i])
                max = array[i];
        }
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение = " + max);
        for (int i = 0; i < array.length; i++){
            if (array[i] == min)
                array[i] = 0;
            if (array[i] == max)
                array[i] = 99;
            }
        System.out.println("Результат: " + Arrays.toString(array));
        }

    }

