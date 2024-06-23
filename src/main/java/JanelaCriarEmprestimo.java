import javax.swing.*;
import java.awt.event.ActionEvent;
import Titulo.Titulo;

public class JanelaCriarEmprestimo {
    private JComboBox comboBoxTitulo;
    private JPanel janelaCriarEmprestimo;
    private JComboBox comboBoxSocio;
    private JButton submeterButton;
    private JButton voltarButton;
    private JLabel tituloLabel;
    private JLabel socioLabel;

    public JanelaCriarEmprestimo(String title) {
        JFrame frame = new JFrame(title);
        frame.setContentPane(janelaCriarEmprestimo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        DefaultComboBoxModel<Titulo> modelTitulo = new DefaultComboBoxModel<>();
//        for (Titulo titulo : GestorBiblioteca.instance.getTitulos()) {
//            modelTitulo.addElement(titulo);
//        }
//        comboBoxTitulo.setModel(modelTitulo);
//
//        DefaultComboBoxModel<Socio> modelSocio = new DefaultComboBoxModel<>();
//        for (Socio socio : GestorBiblioteca.instance.getSocios()) {
//            modelSocio.addElement(socio);
//        }
//        comboBoxSocio.setModel(modelSocio);

        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {

    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(janelaCriarEmprestimo);
        frame.dispose();
    }
}
