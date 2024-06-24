import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaEstatisticas extends JDialog {
    private JPanel janelaEstatisticas;
    private JButton btnVoltar;
    private JButton btnProcurar;
    private JComboBox comboBoxAutores;
    private JComboBox comboBoxGenero;
    private JComboBox comboBoxSubGenero;
    private JTable table1;
    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaEstatisticas(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaEstatisticas);
        pack();
        setLocationRelativeTo(null);

        comboBoxAutores.addItem("-");
        comboBoxAutores.setSelectedItem("-");
        gb.getAutores().forEach(autor -> comboBoxAutores.addItem(autor.getNome()));

        comboBoxGenero.addItem("-");
        comboBoxGenero.setSelectedItem("-");
        gb.getGeneros().forEach(genero -> comboBoxGenero.addItem(genero.getNome()));

        comboBoxSubGenero.addItem("-");
        comboBoxSubGenero.setSelectedItem("-");

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnProcurar.addActionListener(this::btnProcurarActionPerformed);
        comboBoxGenero.addActionListener(this::comboBoxGeneroActionPerformed);
    }

    private void comboBoxGeneroActionPerformed(ActionEvent actionEvent) {
        comboBoxSubGenero.removeAllItems();
        comboBoxSubGenero.addItem("-");
        comboBoxSubGenero.setSelectedItem("-");
        String selectedItem = (String) comboBoxGenero.getSelectedItem();
        if (!selectedItem.equals("-")) {
            gb.getGenero(selectedItem).getSubgeneros().forEach(subgenero -> comboBoxSubGenero.addItem(subgenero.getNome()));
        } else {
            return;
        }
    }

    private void btnProcurarActionPerformed(ActionEvent actionEvent) {

    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
    }
}
