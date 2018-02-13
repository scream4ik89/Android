package task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] arg){
        int array[] = {4, 7, 9 ,42 ,36, 75, 12};
        System.out.println("input array:     " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("reversed array : " + Arrays.toString(array));
}
}
