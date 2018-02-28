package manager.Sort;

import model.entity.Beer;

import java.util.Comparator;

public class SortByCountry implements Comparator<Beer> {

    @Override
    public int compare(Beer o1, Beer o2) {
        String country1 = o1.getCountry();
        String country2 = o2.getCountry();
        return country1.compareTo(country2);
    }
}
