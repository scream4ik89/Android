import javax.xml.soap.Text;

public abstract class Tehnika {
    private int weight;
    private String name;
    private String country;
    private boolean state; // новый или старый
    public Tehnika (int weight, String name, String country, boolean state){
    this.weight = weight;
    this.name = name;
    this.country = country;
    this.state = state;    }
    public int getWeight(){        return weight;    }
    public String getName(){        return name;    }
    public String getCountry(){        return country;    }
    public boolean getState(){        return state;    }
    public void setWeight(int weight){        this.weight =weight;    }
    public void setName(String name){ this.name = name;}
    public void setCountry(String country){ this.country = country;}
    public void setState(boolean state){ this.state = state;}
    public abstract String toString();

}
