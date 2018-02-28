package model.entity;

import java.util.ArrayList;

public class Pub {
    private String name;
    private String location;
    private ArrayList<String> emails;
    private ArrayList<Beer> goods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<Beer> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Beer> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pub)) return false;

        Pub pub = (Pub) o;

        if (name != null ? !name.equals(pub.name) : pub.name != null) return false;
        if (location != null ? !location.equals(pub.location) : pub.location != null) return false;
        if (emails != null ? !emails.equals(pub.emails) : pub.emails != null) return false;
        return goods != null ? goods.equals(pub.goods) : pub.goods == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (emails != null ? emails.hashCode() : 0);
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "Pub: "  +
                "'" + name + '\'' + "\n" +
                "Location - '" + location + '\'' +
                ", Emails : " + emails + "\n" +
                "Goods:" + goods;

    }
}
