package controller;

import model.Model;
import view.View;

import javax.swing.*;
import java.awt.event.*;

public class Controller {
    private Model aux_model;
    private View aux_view;

    public Controller(Model m_model, View m_view) {
        this.aux_model = m_model;
        this.aux_view = m_view;

        m_view.addClearListener(new ClearListener());
        m_view.addAdditionListener(new AdditionListener());
        m_view.addSubstractListener(new SubstractListener());
        m_view.addMultiplyListener(new MultiplyListener());
        m_view.addDivideListener(new DivideListener());
        m_view.addDerivateListener(new DerivateListener());
        m_view.addIntegrateListener(new IntegrateListener());
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                aux_view.reset();
                aux_model.reset();
            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare.");
                exception.printStackTrace();
            }

        }
    }

    class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String P = ""; //polinomul P
            String Q = ""; //polinomul Q

            try {
                aux_view.setLabel("Operatie: +");
                P = aux_view.getPoliP();
                Q = aux_view.getPoliQ();
                if(P.equals("") || Q.equals("")){
                    JOptionPane.showMessageDialog(null, "Campuri goale.");
                }
                aux_model.adunare(P, Q);
                aux_view.setRezultat(aux_model.getPoliAfisare().toString());

            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la insumare.");
                exception.printStackTrace();
            }
        }
    }

    class SubstractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String P = aux_view.getPoliP(); //polinomul P
            String Q = aux_view.getPoliQ(); //polinomul Q
            try {
                aux_view.setLabel("Operatie: -");
                P = aux_view.getPoliP();
                Q = aux_view.getPoliQ();
                if(P.equals("") || Q.equals("")){
                    JOptionPane.showMessageDialog(null, "Campuri goale.");
                }
                aux_model.scadere(P, Q);
                aux_view.setRezultat(aux_model.getPoliAfisare().toString());

            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la scadere.");
                exception.printStackTrace();
            }
        }
    }

    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                aux_view.setLabel("Operatie: *");

                aux_view.showError("Nu este implementat.");
            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la inmultire.");
                exception.printStackTrace();
            }
        }
    }

    class DivideListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                aux_view.setLabel("Operatie: /");

                aux_view.showError("Nu este implementat.");
            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la impartire.");
                exception.printStackTrace();
            }
        }
    }

    class DerivateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String P = aux_view.getPoliP();
            String Q = aux_view.getPoliQ();
            try {
                aux_view.setLabel("Operatie: d/dx");
                P = aux_view.getPoliP();
                Q = aux_view.getPoliQ();
                if(P.equals("")){
                    JOptionPane.showMessageDialog(null, "Campuri goale.");
                }
                aux_model.derivare(P, Q);
                aux_view.setRezultat(aux_model.getPoliAfisare().toString());
            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la derivare.");
                exception.printStackTrace();
            }
        }
    }

    class IntegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String P = aux_view.getPoliP();
            String Q = aux_view.getPoliQ();
            try {
                aux_view.setLabel("Operatie: ∫ dx");
                P = aux_view.getPoliP();
                Q = aux_view.getPoliQ();
                if(P.equals("")){
                    JOptionPane.showMessageDialog(null, "Campuri goale.");
                }
                aux_model.integrare(P, Q);
                aux_view.setRezultat(aux_model.getPoliAfisare().toString() + "+C");
            } catch (Exception exception) {
                aux_view.showError("A aparut o eroare la integrare.");
                exception.printStackTrace();
            }
        }
    }
}
