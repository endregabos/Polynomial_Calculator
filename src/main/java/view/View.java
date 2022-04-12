package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JFrame frmCalculatorPolinomial;
    private JTextField polinomP;
    private JTextField polinomQ;
    private JTextField rezultat;
    private JLabel title;
    private JLabel labelP;
    private JLabel labelQ;
    private JLabel labelOp;
    private JLabel labelRezultat;
    private JLabel labelOpPerm;
    private JButton btnAdd;
    private JButton btnSub;
    private JButton btnMul;
    private JButton btnDiv;
    private JButton btnDer;
    private JButton btnInteg;
    private JButton btnReset;

    public View (Model model) {
        frmCalculatorPolinomial = new JFrame();
        frmCalculatorPolinomial.setTitle("Calculator polinomial");
        frmCalculatorPolinomial.setBounds(100, 100, 613, 412);
        frmCalculatorPolinomial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JLabel("Tema 1 - Calculator polinomial");
        title.setFont(new Font("Verdana", Font.PLAIN, 18));

        labelP = new JLabel("Polinomul P:");
        labelP.setFont(new Font("Verdana", Font.PLAIN, 16));

        polinomP = new JTextField("-3x^1+2x^3-5x^2-4x^0");
        polinomP.setFont(new Font("Verdana", Font.BOLD, 13));
        polinomP.setColumns(10);

        labelQ = new JLabel("Polinomul Q:");
        labelQ.setFont(new Font("Verdana", Font.PLAIN, 16));

        polinomQ = new JTextField("3x^1-2x^2+6x^0");
        polinomQ.setFont(new Font("Verdana", Font.BOLD, 13));
        polinomQ.setColumns(10);

        labelOp = new JLabel("Operatie:");
        labelOp.setFont(new Font("Verdana", Font.PLAIN, 16));

        labelRezultat = new JLabel("Rezultat:");
        labelRezultat.setFont(new Font("Verdana", Font.PLAIN, 16));

        rezultat = new JTextField();
        rezultat.setFont(new Font("Verdana", Font.BOLD, 13));
        rezultat.setColumns(10);

        labelOpPerm = new JLabel("Operatii permise:");
        labelOpPerm.setFont(new Font("Verdana", Font.PLAIN, 16));

        btnAdd = new JButton("Adunare");
        btnAdd.setFont(new Font("Verdana", Font.BOLD, 11));

        btnSub = new JButton("Scadere");
        btnSub.setFont(new Font("Verdana", Font.BOLD, 11));

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Verdana", Font.BOLD, 11));

        btnMul = new JButton("Inmultire");
        btnMul.setFont(new Font("Verdana", Font.BOLD, 11));

        btnDiv = new JButton("Impartire");
        btnDiv.setFont(new Font("Verdana", Font.BOLD, 11));

        btnDer = new JButton("Derivare");
        btnDer.setFont(new Font("Verdana", Font.BOLD, 11));

        btnInteg = new JButton("Integrare");
        btnInteg.setFont(new Font("Verdana", Font.BOLD, 11));

        GroupLayout groupLayout = new GroupLayout(frmCalculatorPolinomial.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(170, Short.MAX_VALUE)
                                .addComponent(title)
                                .addGap(159))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(27)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelOp, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(polinomQ, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelRezultat, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rezultat, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelP, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(polinomP, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18)
                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelOpPerm, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGap(35)
                                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(18)
                                                                                        .addComponent(btnSub, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                                .addComponent(btnDer, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18)
                                                                                                .addComponent(btnInteg, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                                                .addComponent(btnMul, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18)
                                                                                                .addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))))))
                                        .addComponent(labelQ, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addGap(34)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelP)
                                        .addComponent(labelOpPerm, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(polinomP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSub, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addGap(21)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnMul, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(labelQ, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(polinomQ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(labelOp, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addGap(25)
                                                .addComponent(labelRezultat, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnDer, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnInteg, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rezultat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(41, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addGap(34)
                                                .addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20))))
        );
        frmCalculatorPolinomial.getContentPane().setLayout(groupLayout);

        frmCalculatorPolinomial.setVisible(true);
    }

    public void reset(){
        polinomP.setText("-3x^1+2x^3-5x^2-4x^0");
        polinomQ.setText("3x^1-2x^2+6x^0");
        rezultat.setText("");
        labelOp.setText("Operatie:");
    }

    public String getPoliP() {
        return polinomP.getText();
    }

    public String getPoliQ() {
        return polinomQ.getText();
    }

    public void setRezultat(String rez) {
        rezultat.setText(rez);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    //action listeners pt butoane
    public void addAdditionListener(ActionListener add) {
        btnAdd.addActionListener(add);
    }

    public void addSubstractListener(ActionListener sub) {
        btnSub.addActionListener(sub);
    }

    public void addMultiplyListener(ActionListener mul) {
        btnMul.addActionListener(mul);
    }

    public void addDivideListener(ActionListener div) {
        btnDiv.addActionListener(div);
    }

    public void addDerivateListener(ActionListener der) {
        btnDer.addActionListener(der);
    }

    public void addIntegrateListener(ActionListener integ) {
        btnInteg.addActionListener(integ);
    }

    public void addClearListener(ActionListener clr) { btnReset.addActionListener(clr); }

    //metoda ca sa putem seta semnul operatiei efectuate
    public void setLabel(String text) {
        labelOp.setText(text);
    }


}
