import sun.util.resources.cldr.et.CalendarData_et_EE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static void average(ArrayList<Pacient> pacients){
        int year = 0;
        double countYears  = 0;
        double countMonthes  = 0;
        GregorianCalendar currentDate = new GregorianCalendar();
        for(int i = 0 ; i < pacients.size(); i++) {
            year = currentDate.get(GregorianCalendar.YEAR) - pacients.get(i).getBirthday().get(GregorianCalendar.YEAR);
            if (currentDate.get(GregorianCalendar.MONTH)  < pacients.get(i).getBirthday().get(GregorianCalendar.MONTH) )
                year--;
            countYears += year;
            countMonthes += currentDate.get(GregorianCalendar.MONTH) - pacients.get(i).getBirthday().get(GregorianCalendar.MONTH);
        }
        System.out.println("Средний возраст пациентов: " + countYears/pacients.size() + " лет " + countMonthes/pacients.size() +" месяцев");
    }
    public static Date dateFormat(String birthday) throws ParseException{
        Date data;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        data = sdf.parse(birthday);

        return data;
    }
    public static Pacient input() throws ParseException{
        String name;
        String sorname;
        Date date;
        Scanner inputs = new Scanner(System.in);
        System.out.println("Введите данные пациента");
        System.out.println("Введите имя пациента:");
        name = inputs.next();
        System.out.println("Введите фамилию пациента:");
        sorname = inputs.next();
        System.out.println("Введите дату рождения пациента в формате yyyy-mm");
        date = dateFormat(inputs.next());
        GregorianCalendar birhtday = new GregorianCalendar();
        birhtday.setTime(date);
        return new Pacient(name, sorname, birhtday);
    }

    public static void main(String[] arg) throws ParseException {
        GregorianCalendar calendar = new GregorianCalendar();
        GregorianCalendar calendarTmp = new GregorianCalendar();
        Scanner output = new Scanner(System.in);
        ArrayList<Pacient> pacients = new ArrayList<>();
        for (int i = 0; i <= 0; i++){
            pacients.add(input());            }

        for (int i = 0; i < pacients.size(); i++)
            System.out.println("Пациент №" + (i + 1) + " " + pacients.get(i));
        average(pacients);
    }
}
