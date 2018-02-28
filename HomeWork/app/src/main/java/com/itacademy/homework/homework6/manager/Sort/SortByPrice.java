package manager.Sort;

import model.entity.Beer;

import java.util.Comparator;

public class SortByPrice implements Comparator<Beer> {

    @Override
    public int compare(Beer o1, Beer o2) {
        Integer price1 = o1.getPrice();
        Integer price2 = o2.getPrice();
        return price1.compareTo(price2);
    }
}
