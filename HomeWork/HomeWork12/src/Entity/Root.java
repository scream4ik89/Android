package Entity;

import java.util.Date;
import java.util.List;

public class Root {
    private String name;
    private List<People> people;
    private Gender gender;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;

        Root root = (Root) o;

        if (name != null ? !name.equals(root.name) : root.name != null) return false;
        if (people != null ? !people.equals(root.people) : root.people != null) return false;
        if (gender != root.gender) return false;
        return date != null ? date.equals(root.date) : root.date == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (people != null ? people.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", people=" + people +
                ", gender=" + gender +
                ", date=" + date +
                '}';
    }
}


