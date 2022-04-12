package model;

import java.util.Comparator;

public class ComparatorMonom implements Comparator<Monom> {

    @Override
    public int compare(Monom o1, Monom o2) {
        return (Integer.compare(o1.getPutere(), o2.getPutere())*(-1)); //imi sorteaza descrescator in functie de putere
    }
}
