package Task1;

public class Main {
    public static void main(String[] arg){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                    Main main = new Main();
                    main.print10();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                    Main main = new Main();
                    main.print10();
            }
        });
        thread.start();
        thread2.start();
    }
    public static void print10() {
            for (int i = 0; i < 10; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i * 10 + 1; j < i * 10 + 11; j++) {
                    sb.append(j);
                    sb.append(" ");
                }
                System.out.println(Thread.currentThread().getName() + " " + sb.toString());
                try {
                    Thread.sleep((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}