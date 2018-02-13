package Task2;

public class People {
    private String FIO;

    public People(String FIO) {
        this.FIO = FIO;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        return FIO != null ? FIO.equals(people.FIO) : people.FIO == null;
    }

    @Override
    public int hashCode() {
        return FIO != null ? FIO.hashCode() : 0;
    }
}
