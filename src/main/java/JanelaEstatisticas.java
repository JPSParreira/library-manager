import Titulo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaEstatisticas extends JDialog {
    private JPanel janelaEstatisticas;
    private JButton btnVoltar;
    private JButton btnProcurar;
    private JComboBox comboBoxAutores;
    private JComboBox comboBoxGenero;
    private JComboBox comboBoxSubGenero;
    private JTable table;

    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaEstatisticas(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaEstatisticas);
        pack();
        setLocationRelativeTo(null);

        updateTable(gb.getTop10());

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
        comboBoxAutores.addActionListener(this::comboBoxAutoresActionPerformed);
    }

    private void updateTable(LinkedList<Titulo> titulosMaisEmprestados) {
        if(titulosMaisEmprestados.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existem titulos para mostrar", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Titulos");
        model.addColumn("Emprestimos");
        for (Titulo t : titulosMaisEmprestados) {
            String emprestimos = String.valueOf(t.getEmprestimos());
            model.addRow(new Object[]{t.getTitulo(), emprestimos});
        }
        table.setModel(model);
    }

    private void comboBoxAutoresActionPerformed(ActionEvent actionEvent) {
        if (comboBoxAutores.getSelectedItem().equals("-")) {
            comboBoxGenero.setEnabled(true);
            comboBoxSubGenero.setEnabled(true);
        } else {
            comboBoxGenero.setSelectedItem("-");
            comboBoxSubGenero.setSelectedItem("-");
            comboBoxGenero.setEnabled(false);
            comboBoxSubGenero.setEnabled(false);
        }
    }
    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
    }
    private void comboBoxGeneroActionPerformed(ActionEvent actionEvent) {
        comboBoxSubGenero.removeAllItems();
        comboBoxSubGenero.addItem("-");
        comboBoxSubGenero.setSelectedItem("-");
        String selectedItem = (String) comboBoxGenero.getSelectedItem();
        if (!selectedItem.equals("-")) {
            gb.getGenero(selectedItem).getSubgeneros().forEach(subgenero -> comboBoxSubGenero.addItem(subgenero.getNome()));
            comboBoxAutores.setSelectedItem("-");
            comboBoxAutores.setEnabled(false);
        } else {
            comboBoxAutores.setEnabled(true);
        }
    }
    private void btnProcurarActionPerformed(ActionEvent actionEvent) {
        String autor = (String) comboBoxAutores.getSelectedItem();
        String genero = (String) comboBoxGenero.getSelectedItem();
        String subgenero = (String) comboBoxSubGenero.getSelectedItem();

        if (autor.equals("-") && genero.equals("-") && subgenero.equals("-")) {
            updateTable(gb.getTop10());
        }

        if (!autor.equals("-") && genero.equals("-") && subgenero.equals("-")) {
            for (Autor a : gb.getAutores()) {
                if (a.getNome().equalsIgnoreCase(autor)) {
                    updateTable(gb.getTop10(a));
                }
            }
        }

        if (autor.equals("-") && !genero.equals("-") && subgenero.equals("-")) {
            for (Genero g : gb.getGeneros()) {
                if (g.getNome().equalsIgnoreCase(genero)) {
                    updateTable(gb.getTop10(g));
                }
            }
        }

        if (autor.equals("-") && !genero.equals("-") && !subgenero.equals("-")) {
            Subgenero sg = gb.getSubgenero(subgenero);
            if (sg.getNome().equalsIgnoreCase(subgenero)) {
                    updateTable(gb.getTop10(sg));
            }
        }
    }
}
