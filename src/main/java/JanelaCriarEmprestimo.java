import javax.swing.*;
import java.awt.event.ActionEvent;
import Titulo.Titulo;

public class JanelaCriarEmprestimo extends JDialog {
    private JComboBox comboBoxTitulo;
    private JPanel janelaCriarEmprestimo;
    private JComboBox comboBoxSocio;
    private JButton submeterButton;
    private JButton voltarButton;
    private JLabel tituloLabel;
    private JLabel socioLabel;

    public JanelaCriarEmprestimo(String title) {
        this.setTitle(title);
        setContentPane(janelaCriarEmprestimo);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        DefaultComboBoxModel<Titulo> modelTitulo = new DefaultComboBoxModel<>();
        for (Titulo titulo : GestorBiblioteca.instance.getTitulos()) {
            modelTitulo.addElement(titulo);
        }
        comboBoxTitulo.setModel(modelTitulo);

        DefaultComboBoxModel<Socio> modelSocio = new DefaultComboBoxModel<>();
        for (Socio socio : GestorBiblioteca.instance.getSocios()) {
            modelSocio.addElement(socio);
        }
        comboBoxSocio.setModel(modelSocio);

        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {

    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
}
