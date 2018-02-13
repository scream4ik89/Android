public class Mbt extends Tehnika {
    private String marka;
    public Mbt(int weight, String name, String country, boolean state, String marka) {
        super(weight, name, country, state);
        this.marka = marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getMarka() {
        return marka;
    }
    @Override
    public String toString() {
        if (getState() == true){
            return "Новая техника";
        }
        else return "Техника б.у.";
    }
}

