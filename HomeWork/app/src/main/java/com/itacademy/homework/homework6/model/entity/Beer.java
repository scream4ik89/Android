package model.entity;

import java.util.Date;

public class Beer {
    private int id;
    private String name;
    private String country;
    private Date year;
    private Integer price;
    private boolean visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beer)) return false;

        Beer beer = (Beer) o;

        if (id != beer.id) return false;
        if (price != beer.price) return false;
        if (visible != beer.visible) return false;
        if (name != null ? !name.equals(beer.name) : beer.name != null) return false;
        if (country != null ? !country.equals(beer.country) : beer.country != null) return false;
        return year != null ? year.equals(beer.year) : beer.year == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (visible ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "Beer: " +
                "id=" + id +
                ", name - '" + name + '\'' +
                ", country - '" + country + '\'' +
                ", year - " + year +
                ", price - " + price +
                " visible - " + visible;

    }

}
