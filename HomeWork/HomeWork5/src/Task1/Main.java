public class Main {
    public static void main(String[] arg){

        Cleaner cleaner = new Cleaner(40, "Техника", "Japan", true, "Panasonic", 400);
        System.out.println("Мощность пылесоса " + cleaner.getPower() + "W");
    }
}
