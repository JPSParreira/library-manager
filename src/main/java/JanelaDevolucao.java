import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class JanelaDevolucao extends JDialog {
    private JPanel janelaDevolucao;
    private JComboBox comboBoxID;
    private JButton submeterButton;
    private JButton voltarButton;
    private JLabel Id;

    public JanelaDevolucao(String title) {
        this.setTitle(title);
        setContentPane(janelaDevolucao);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        Id.setText("ID Devolução");

        for (Emprestimo emprestimo : GestorBiblioteca.instance.getEmprestimos()) {
            if (!emprestimo.isDevolvido()) {
                comboBoxID.addItem(emprestimo.getIdEmprestimo());
            }
        }
        comboBoxID.setSelectedItem(0);

        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {
        try {
            int idEmprestimo = (int) comboBoxID.getSelectedItem();

            Emprestimo emprestimo = GestorBiblioteca.instance.getEmprestimo(idEmprestimo);

            emprestimo.setDevolvido(true);
            emprestimo.getExemplar().setDisponivel(true);
            emprestimo.setDataDevolucao(new Date());
            int tempoEmprestimo = (int) ((emprestimo.getDataDevolucao().getTime() - emprestimo.getDataEmprestimo().getTime()) / (1000 * 60 * 60 * 24));

            if (tempoEmprestimo > GestorBiblioteca.instance.getMaxDias()) {
                var valorMulta = (tempoEmprestimo - GestorBiblioteca.instance.getMaxDias()) * GestorBiblioteca.instance.getValorMulta();
                emprestimo.setMulta(valorMulta);
                emprestimo.getSocio().setMultasEmDivida(emprestimo.getSocio().getMultasEmDivida() + valorMulta);

                int confirm = JOptionPane.showOptionDialog(
                        this,
                        "O sócio " + emprestimo.getSocio().getNome() + " entregou o livro com " + (tempoEmprestimo - GestorBiblioteca.instance.getMaxDias()) + " dias de atraso. Valor da multa: " + valorMulta + "€. Pretende efetuar o pagamento?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Sim", "Não"},
                        "Sim"
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    emprestimo.getSocio().setMultasEmDivida(emprestimo.getSocio().getMultasEmDivida() - valorMulta);
                    JOptionPane.showMessageDialog(this, "Pagamento efetuado com sucesso.");
                }
                return;
            }

            JOptionPane.showMessageDialog(this, "Devolução efetuada com sucesso.");

            var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
            this.setVisible(false);
            janelaEmprestimos.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao efetuar a devolução.");
            var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
            this.setVisible(false);
            janelaEmprestimos.setVisible(true);
        }
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
        this.setVisible(false);
        janelaEmprestimos.setVisible(true);
    }
}
