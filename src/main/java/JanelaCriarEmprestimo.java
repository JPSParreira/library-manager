import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;
import java.awt.*;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
            Titulo titulo = (Titulo) comboBoxTitulo.getSelectedItem();
            Socio socio = (Socio) comboBoxSocio.getSelectedItem();

            if (!titulo.isDisponivel()) {
                JOptionPane.showMessageDialog(this, "Não existem exemplares disponíveis para o título selecionado.");
            }
            if (socio.getAnuidadesEmDivida() > 0) {
                JOptionPane.showMessageDialog(this, "O sócio selecionado tem anuidades por pagar.");
            }
            if (socio.getMultasEmDivida() > 0) {
                JOptionPane.showMessageDialog(this, "O sócio selecionado tem multas por pagar.");
            }
            if (socio.getNumEmprestimosAtivos() >= GestorBiblioteca.instance.getMaxEmprestimos()) {
                JOptionPane.showMessageDialog(this, "O sócio selecionado já atingiu o limite de empréstimos ativos.");
            }

            Exemplar exemplar = titulo.getExemplarDisponivel();
            GestorBiblioteca.instance.criarEmprestimo(socio.getIdSocio(), exemplar.getId());
            JOptionPane.showMessageDialog(this, "Empréstimo criado com sucesso.");
            this.setVisible(false);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao criar empréstimo: ");
        }
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}

