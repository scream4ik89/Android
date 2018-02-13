package Task2;

import java.util.Scanner;
public class Main {
    public static int counter(int N){
        int count = 0;
        int page = 0;
        for(int i = 0 ; i < N; i++)
        {
            count ++;
            if(count == 10) {
                page++;
                count = 0;
            }
        }
        if(count > 0)
            page++;
        return page;
    }
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(counter(num) + " страниц ");
    }
}


