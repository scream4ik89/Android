package manager.Sort;

import model.entity.Beer;

import java.util.Comparator;
import java.util.Date;

public class SortByYear implements Comparator<Beer>{
    @Override
    public int compare(Beer o1, Beer o2) {
        Date year1 = o1.getYear();
        Date year2 = o2.getYear();
        return year1.compareTo(year2);
    }
}
