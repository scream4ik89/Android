public class Cleaner extends Mbt {
private int power;
public Cleaner(int weight, String name, String country, boolean state, String marka, int power){
    super(weight, name, country, state, marka);
    this.power = power;
}
    public int getPower() {
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
}