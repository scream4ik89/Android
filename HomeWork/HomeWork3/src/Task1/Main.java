package Task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static public int[] input(int array[]){
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public static void print(int array[])
    {
        for(int i  = 0 ; i <  array.length; i++)
            System.out.print(" |" + array[i] + "| ");
        System.out.println();
    }
     public static int[] sort1(int array[]){
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( array[j] > array[j+1] ){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
    public static int[] sort2(int array[]){
        for (int i = 0; i <  array.length; i++) {
            int min =  array[i];
            int min_i = i;
            for (int j = i+1; j <  array.length; j++) {
                if ( array[j] < min) {
                    min =  array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array [min_i] = tmp;
            }
        }
        return array;
    }
    public static int[] sortarray(int array[]){
        Arrays.sort(array);
        return array;
    }
    public static void main(String[] arg){
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        int[] array  = new int [N];
        array = input(array);
        System.out.println(" Исходный массив: ");
        print(array);
        array = sort1(array);
        System.out.println("Сортировка методом пузырька: ");
        print(array);
        array = sort2(array);
        System.out.println("Сортировка методом выбора: ");
        print(array);
        array = sortarray(array);
        System.out.println("Сортировка классом Arrays: ");
        print(array);
    }
}