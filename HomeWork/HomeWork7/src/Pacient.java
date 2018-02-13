import java.util.Date;
import java.util.GregorianCalendar;

public class Pacient {
    private String name;
    private String sorname;
    private GregorianCalendar birthday;
    public Pacient(String name, String sorname, GregorianCalendar birthday){
        this.name = name;
        this.sorname = sorname;
        this.birthday = birthday;
    }
    public String getName(){
        return name;
    }
    public String getSorname(){
        return sorname;
    }
    public GregorianCalendar getBirthday() { return birthday; }

    public String toString() {

        return "Пациент: " + name + " Фамилия: " + sorname + " дата рождения " +
                birthday.get(GregorianCalendar.YEAR) + "." + (birthday.get(GregorianCalendar.MONTH) + 1);
    }
}
