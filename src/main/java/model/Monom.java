package model;

import java.util.Objects;

public class Monom {
    private double coeficient;
    private Integer putere;

    public Monom(double coef, Integer pow) {
        this.coeficient = coef;
        this.putere = pow;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public Integer getPutere() {
        return putere;
    }

    public void setPutere(Integer putere) {
        this.putere = putere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return Double.compare(monom.coeficient, coeficient) == 0 && Objects.equals(putere, monom.putere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coeficient, putere);
    }
}

