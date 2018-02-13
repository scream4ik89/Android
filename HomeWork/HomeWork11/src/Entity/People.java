package Entity;

public class People {
    private int age;
    private int id;
    private boolean isDegree;
    private String name;
    private String sorname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setisDegree(boolean isDegree) {
        isDegree = isDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSorname() {
        return sorname;
    }

    public void setSorname(String sorname) {
        this.sorname = sorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (age != people.age) return false;
        if (id != people.id) return false;
        if (isDegree != people.isDegree) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        return sorname != null ? sorname.equals(people.sorname) : people.sorname == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + id;
        result = 31 * result + (isDegree ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sorname != null ? sorname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", id=" + id +
                ", Degree=" + isDegree +
                ", name='" + name + '\'' +
                ", sorname='" + sorname + '\'' +
                '}';
    }
}
