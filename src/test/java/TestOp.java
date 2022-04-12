import model.Model;
import model.Monom;
import model.Polinom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestOp {
    @Test
    public void adunareTest(){
        Model calcModel = new Model();
        List<Monom> listP = new ArrayList<>();
        List<Monom> listQ = new ArrayList<>();
        List<Monom> listAsteptat = new ArrayList<>();
        List<Monom> listRez = new ArrayList<>();


        Monom m1 = new Monom(2, 3);
        Monom m2 = new Monom(-2, 1);
        Monom m3 = new Monom(4, 0);
        listP.add(m1);
        listP.add(m2);
        listP.add(m3);

        Monom m4 = new Monom(5, 3);
        Monom m5 = new Monom(-1, 1);
        Monom m6 = new Monom(3, 0);
        listQ.add(m4);
        listQ.add(m5);
        listQ.add(m6);

        Monom m7 = new Monom(7, 3);
        Monom m8 = new Monom(-3, 1);
        Monom m9 = new Monom(7, 0);

        listAsteptat.add(m7);
        listAsteptat.add(m8);
        listAsteptat.add(m9);

        Polinom pFinal = new Polinom(listP);
        Polinom qFinal = new Polinom(listQ);
        Polinom rezultat = new Polinom();

        rezultat = calcModel.adunareImplementare(pFinal, qFinal);
        assertEquals(rezultat.getPolinom(), listAsteptat);
    }

    @Test
    public void scadereTest(){
        Model calcModel = new Model();
        List<Monom> listP = new ArrayList<>();
        List<Monom> listQ = new ArrayList<>();
        List<Monom> listAsteptat = new ArrayList<>();
        List<Monom> listRez = new ArrayList<>();

        Monom m1 = new Monom(2, 3);
        Monom m2 = new Monom(-2, 1);
        Monom m3 = new Monom(4, 0);
        listP.add(m1);
        listP.add(m2);
        listP.add(m3);

        Monom m4 = new Monom(5, 3);
        Monom m5 = new Monom(-1, 1);
        Monom m6 = new Monom(3, 0);
        listQ.add(m4);
        listQ.add(m5);
        listQ.add(m6);

        Monom m7 = new Monom(-3, 3);
        Monom m8 = new Monom(-1, 1);
        Monom m9 = new Monom(1, 0);

        listAsteptat.add(m7);
        listAsteptat.add(m8);
        listAsteptat.add(m9);

        Polinom pFinal = new Polinom(listP);
        Polinom qFinal = new Polinom(listQ);
        Polinom rezultat = new Polinom();

        rezultat = calcModel.scadereImplementare(pFinal, qFinal);
        assertEquals(rezultat.getPolinom(), listAsteptat);
    }

    @Test
    public void derivareTest(){
        Model calcModel = new Model();
        List<Monom> listP = new ArrayList<>();
        List<Monom> listAsteptat = new ArrayList<>();
        List<Monom> listRez = new ArrayList<>();

        Monom m1 = new Monom(4, 3);
        Monom m2 = new Monom(-2, 1);
        Monom m3 = new Monom(4, 0);
        listP.add(m1);
        listP.add(m2);
        listP.add(m3);

        Monom m4 = new Monom(12, 2);
        Monom m5 = new Monom(-2, 0);
        listAsteptat.add(m4);
        listAsteptat.add(m5);

        Polinom pFinal = new Polinom(listP);
        Polinom rezultat = new Polinom();

        rezultat = calcModel.derivareImplementare(pFinal);
        assertEquals(rezultat.getPolinom(), listAsteptat);
    }

    @Test
    public void integrareTest(){
        Model calcModel = new Model();
        List<Monom> listP = new ArrayList<>();
        List<Monom> listAsteptat = new ArrayList<>();
        List<Monom> listRez = new ArrayList<>();

        Monom m1 = new Monom(4, 3);
        Monom m2 = new Monom(-2, 1);
        Monom m3 = new Monom(4, 0);
        listP.add(m1);
        listP.add(m2);
        listP.add(m3);

        Monom m4 = new Monom(1, 4);
        Monom m5 = new Monom(-1, 2);
        Monom m6 = new Monom(4, 1);
        listAsteptat.add(m4);
        listAsteptat.add(m5);
        listAsteptat.add(m6);

        Polinom pFinal = new Polinom(listP);
        Polinom rezultat = new Polinom();

        rezultat = calcModel.integrareImplementare(pFinal);
        assertEquals(rezultat.getPolinom(), listAsteptat);
    }
}
