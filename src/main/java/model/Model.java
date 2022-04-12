package model;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    // aici facem operatiile
    private Pattern p= Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");
    private Scanner scanner;

    private Monom aux = new Monom(0, 0);

    private Polinom poliAfisare = new Polinom();
    private Polinom polinomP = new Polinom();
    private Polinom polinomQ = new Polinom();
    private Polinom polinomRez = new Polinom();

    public Model() {
        reset();
    }

    public Polinom generarePolinom(String P, Polinom polinomAux){
        List<Monom> auxPoli = new ArrayList<>();
        Matcher m = p.matcher(P);
        while (m.find()) {
            String nou = m.group(1);
            nou = nou.replace("x^", " ");

            scanner = new Scanner(nou);
            while(scanner.hasNextInt()) {
                aux = new Monom(0, 0);
                aux.setCoeficient(scanner.nextInt());
                aux.setPutere(scanner.nextInt());
                auxPoli.add(aux);
            }
            polinomAux = new Polinom(auxPoli);
            scanner.close();
        }

        return polinomAux;
    }

    public void adunare(String P, String Q) {
        //generare polinomP
        polinomP=generarePolinom(P, polinomP);
        polinomQ=generarePolinom(Q, polinomQ);
        if(polinomP.getPolinom().isEmpty() || polinomQ.getPolinom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ai respectat formatul!");
        }
        polinomRez = adunareImplementare(polinomP, polinomQ);
        poliAfisare = new Polinom(polinomRez.getPolinom());
    }

    public void scadere(String P, String Q) {
        polinomP=generarePolinom(P, polinomP);
        polinomQ=generarePolinom(Q, polinomQ);
        if(polinomP.getPolinom().isEmpty() || polinomQ.getPolinom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ai respectat formatul!");
        }
        polinomRez = scadereImplementare(polinomP, polinomQ);
        poliAfisare = new Polinom(polinomRez.getPolinom());
    }

    public void derivare(String P, String Q) {
        polinomP=generarePolinom(P, polinomP);
        polinomQ=generarePolinom(Q, polinomQ);
        if(polinomP.getPolinom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ai respectat formatul!");
        }
        polinomRez = derivareImplementare(polinomP);
        //polinomRez = derivareImplementare(polinomQ); daca vrem sa derivam al doilea polinom
        poliAfisare = new Polinom(polinomRez.getPolinom());
    }

    public void integrare(String P, String Q){
        polinomP=generarePolinom(P, polinomP);
        polinomQ=generarePolinom(Q, polinomQ);
        if(polinomP.getPolinom().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu ai respectat formatul!");
        }
        polinomRez = integrareImplementare(polinomP);
        //polinomRez = integrareImplementare(polinomQ); daca vrem sa derivam al doilea polinom
        poliAfisare = new Polinom(polinomRez.getPolinom());
    }

    public Polinom adunareImplementare(Polinom auxP, Polinom auxQ) {  //calculam rezultatul adunarii a 2 polinoame
        //sortam cele doua polinoame
        List<Monom> P = auxP.getPolinom();
        List<Monom> Q = auxQ.getPolinom();

        sorteazaPolinom((P));
        sorteazaPolinom((Q));

        //calculam rezultatul adunarii a celor doua polinoame
        int iteratorP = 0;
        int iteratorQ = 0;

        while(iteratorP<P.size() && iteratorQ<Q.size())
        {
            if( P.get(iteratorP).getPutere() > Q.get(iteratorQ).getPutere()) { //grad P > grad Q
                polinomRez.getPolinom().add(P.get(iteratorP));
                iteratorP++;
            } else if(P.get(iteratorP).getPutere() < Q.get(iteratorQ).getPutere()) { //grad P < grad Q
                polinomRez.getPolinom().add(Q.get(iteratorQ));
                iteratorQ++;
            }
            else{
                if(P.get(iteratorP).getCoeficient() + Q.get(iteratorQ).getCoeficient() != 0){
                    aux = new Monom(P.get(iteratorP).getCoeficient() + Q.get(iteratorQ).getCoeficient(), P.get(iteratorP).getPutere());
                    polinomRez.getPolinom().add(aux);
                }
                iteratorP++;
                iteratorQ++;
            }
        }

        while(iteratorP<P.size()){
            polinomRez.getPolinom().add(P.get(iteratorP));
            iteratorP++;
        }

        while(iteratorQ<Q.size()){
            polinomRez.getPolinom().add(Q.get(iteratorQ));
            iteratorQ++;
        }

        return polinomRez;
    }

    public Polinom scadereImplementare(Polinom auxP, Polinom auxQ){
        //sortam cele doua polinoame
        List<Monom> P = auxP.getPolinom();
        List<Monom> Q = auxQ.getPolinom();

        sorteazaPolinom((P));
        sorteazaPolinom((Q));

        //calculam rezultatul adunarii a celor doua polinoame
        int iteratorP = 0;
        int iteratorQ = 0;

        while(iteratorP<P.size() && iteratorQ<Q.size())
        {
            if( P.get(iteratorP).getPutere() > Q.get(iteratorQ).getPutere()) { //grad P > grad Q
                polinomRez.getPolinom().add(P.get(iteratorP));
                iteratorP++;
            } else if(P.get(iteratorP).getPutere() < Q.get(iteratorQ).getPutere()) { //grad P < grad Q
                polinomRez.getPolinom().add(Q.get(iteratorQ));
                iteratorQ++;
            }
            else{
                aux = new Monom(P.get(iteratorP).getCoeficient() - Q.get(iteratorQ).getCoeficient(), P.get(iteratorP).getPutere());
                polinomRez.getPolinom().add(aux);
                iteratorP++;
                iteratorQ++;
            }
        }

        while(iteratorP<P.size()){
            polinomRez.getPolinom().add(P.get(iteratorP));
            iteratorP++;
        }

        while(iteratorQ<Q.size()){
            Q.get(iteratorQ).setCoeficient(Q.get(iteratorQ).getCoeficient()*(-1));
            polinomRez.getPolinom().add(Q.get(iteratorQ));
            iteratorQ++;
        }

        return polinomRez;
    }

    public Polinom derivareImplementare(Polinom auxP){
        sorteazaPolinom(auxP.getPolinom());

        int i = 0;
        while(i<auxP.getPolinom().size()){
            if(auxP.getPolinom().get(i).getPutere() != 0){ //daca avem polinom cu grad diferit de 0
                aux = new Monom(auxP.getPolinom().get(i).getCoeficient()*auxP.getPolinom().get(i).getPutere(), auxP.getPolinom().get(i).getPutere()-1);
                polinomRez.getPolinom().add(aux);
            }
            i++;
        }

        return polinomRez;
    }

    public Polinom integrareImplementare(Polinom auxP){
        sorteazaPolinom(auxP.getPolinom());

        int i = 0;
        while(i<auxP.getPolinom().size()){
            aux = new Monom(auxP.getPolinom().get(i).getCoeficient()/(auxP.getPolinom().get(i).getPutere()+1), auxP.getPolinom().get(i).getPutere()+1);
            polinomRez.getPolinom().add(aux);
            i++;
        }
        return polinomRez;
    }

//    public Polinom getPolinomP() {
//        return polinomP;
//    }
//
//    public Polinom getPolinomQ() {
//        return polinomQ;
//    }

    public void sorteazaPolinom(List<Monom> P) {
        //sortam monoamele din polinom descrescator in functie de putere
        P.sort(new ComparatorMonom());
    }

    public Polinom getPoliAfisare() {
        return poliAfisare;
    }

    public void reset() {
        polinomRez.getPolinom().clear();
    }
}

