package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Polinom {
    private static DecimalFormat dec = new DecimalFormat("#.##"); //ca sa afisez cu 2 zecimale

    private List<Monom> polinom = new ArrayList<>(); //lista de monoame din care este format polinomul

    public Polinom(List<Monom> list){
        this.polinom = list;
    }

    public Polinom() {

    }

    @Override
    public String toString() {
        String rez = "";
        for(Monom m : this.polinom) {
            rez += "+" + dec.format(m.getCoeficient()) + "x^" + m.getPutere() ; //pt afisarea polinomului
        }
        rez = rez.replace("+-", "-");
        rez = rez.replace("++", "+");
        rez = rez.replace("--", "-");
        rez = rez.replace("x^0", ""); //ca sa nu imi afiseze ...x^0
        return rez;
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

}
