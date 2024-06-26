/********************************
 *    João Parreira Nº 2221985   *
 ********************************/

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaConfiguracoes extends JDialog {
    private JPanel janelaConfiguracoes;
    private JTextField maxDias;
    private JTextField valorMulta;
    private JTextField maxEmprestimos;
    private JTextField valorAnuidade;
    private JButton voltarButton;
    private JButton submeterButton;

    public JanelaConfiguracoes(String title) {
        setTitle(title);
        setContentPane(janelaConfiguracoes);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        maxDias.setText(String.valueOf(GestorBiblioteca.instance.getMaxDias()));
        valorMulta.setText(String.valueOf(GestorBiblioteca.instance.getValorMulta()));
        maxEmprestimos.setText(String.valueOf(GestorBiblioteca.instance.getMaxEmprestimos()));
        valorAnuidade.setText(String.valueOf(GestorBiblioteca.instance.getValorAnuidade()));

        voltarButton.addActionListener(this::voltarButtonActionPerformed);
        submeterButton.addActionListener(this::submeterButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {
        try {
            var valor = Integer.parseInt(maxDias.getText());
            if (valor < 7 || valor > 30) {
                throw new NumberFormatException();
            }
            GestorBiblioteca.instance.setMaxDias(valor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O valor dos dias tem de ser um inteiro no intervalo [7, 30].");
            return;
        }

        try {
            var valor = Float.parseFloat(valorMulta.getText());
            if (valor < 0.0 || valor > 2.5) {
                throw new NumberFormatException();
            }
            GestorBiblioteca.instance.setValorMulta(valor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O valor da multa tem de ser um decimal no intervalo [0.0, 2.5].");
            return;
        }

        try {
            var valor = Integer.parseInt(maxEmprestimos.getText());
            if (valor < 1 || valor > 5) {
                throw new NumberFormatException();
            }
            GestorBiblioteca.instance.setMaxEmprestimos(valor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O valor dos empréstimos tem de ser um inteiro no intervalo [1, 5].");
            return;
        }

        try {
            var valor = Float.parseFloat(valorAnuidade.getText());
            if (valor < 10.0 || valor > 100.0) {
                throw new NumberFormatException();
            }
            GestorBiblioteca.instance.setValorAnuidade(valor);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O valor da anuidade tem de ser um decimal no intervalo [10.0, 100.0].");
            return;
        }
        JOptionPane.showMessageDialog(null, "Configurações guardadas com sucesso.");
        this.setVisible(false);
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
