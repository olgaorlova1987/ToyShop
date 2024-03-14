package ru.gb.toyshop.model.toy;

import ru.gb.toyshop.model.toylist.ToyItem;

import java.util.Comparator;

public class ToyComparator<E extends ToyItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        if (o1.getFrequency() < o2.getFrequency())
            return 1;
        if (o1.getFrequency() > o2.getFrequency())
            return -1;
        return 0;
    }

}
