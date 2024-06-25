import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaCriarEmprestimo extends JDialog {
    private JPanel janelaCriarEmprestimo;
    private JLabel tituloLabel;
    private JLabel socioLabel;
    private JComboBox comboBoxTitulo;
    private JComboBox comboBoxSocio;
    private JButton submeterButton;
    private JButton voltarButton;


    public JanelaCriarEmprestimo(String title) {
        this.setTitle(title);
        setContentPane(janelaCriarEmprestimo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        tituloLabel.setText("Título");
        socioLabel.setText("Sócio");


        for (Socio socio : GestorBiblioteca.instance.getSocios()) {
            comboBoxSocio.addItem(socio.getNome());
        }
        comboBoxSocio.setSelectedItem(0);


        for (Titulo titulo : GestorBiblioteca.instance.getTitulos()) {
            comboBoxTitulo.addItem(titulo.getTitulo());
        }
        comboBoxTitulo.setSelectedItem(0);

        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {
        try {
            String nomeTitulo = (String) comboBoxTitulo.getSelectedItem();
            String nomeSocio = (String) comboBoxSocio.getSelectedItem();

            Titulo titulo = GestorBiblioteca.instance.getTitulo(nomeTitulo);
            Socio socio = GestorBiblioteca.instance.getSocio(nomeSocio);

            if (!socio.isEmDivida()) {
                JOptionPane.showMessageDialog(this, "O sócio selecionado tem dívidas por pagar.");
                return;
            }
            if (!titulo.isDisponivel()) {
                int confirm = JOptionPane.showOptionDialog(
                        this,
                        "Não existem exemplares disponíveis para o título selecionado. Deseja fazer uma reserva?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Sim", "Não"},
                        "Sim"
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    GestorBiblioteca.instance.criarReserva(socio, titulo);
                    JOptionPane.showMessageDialog(this, "Reserva criada com sucesso.");
                }
                return;
            }
            if (socio.getNumEmprestimosAtivos() >= GestorBiblioteca.instance.getMaxEmprestimos()) {
                JOptionPane.showMessageDialog(this, "O sócio selecionado já atingiu o limite de empréstimos ativos.");
                return;
            }

            Exemplar exemplar = titulo.getExemplarDisponivel();
            GestorBiblioteca.instance.criarEmprestimo(socio, titulo, exemplar);
            exemplar.setDisponivel(false);
            socio.incrementaNumEmprestimosAtivos();
            JOptionPane.showMessageDialog(this, "Empréstimo criado com sucesso.");
            var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
            this.setVisible(false);
            janelaEmprestimos.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao criar empréstimo.");
        }
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
        this.setVisible(false);
        janelaEmprestimos.setVisible(true);
    }
}

