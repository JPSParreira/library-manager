/********************************
 *  Pedro Barbeiro Nº 2221986   *
 ********************************/

import Titulo.Genero;
import Titulo.Subgenero;
import Titulo.Titulo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaCriarTitulo extends JDialog {
    private JButton btnVoltar;
    private JButton btnSubmeter;
    private JTextField textAutor;
    private JTextField textTitulo;
    private JComboBox comboGenero;
    private JComboBox comboSubGenero;
    private JPanel janelaCriarTitulo;

    public JanelaCriarTitulo(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaCriarTitulo);
        pack();
        setLocationRelativeTo(null);

        /* Preencher generos */
        LinkedList<Genero> generos = GestorBiblioteca.instance.getGeneros();
        for (Genero genero : generos) {
            comboGenero.addItem(genero.getNome());
        }
        comboGenero.setSelectedItem(null);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        comboGenero.addActionListener(this::comboGeneroActionPerformed);
        btnSubmeter.addActionListener(this::btnSubmeterActionPerformed);

    }

    public void btnSubmeterActionPerformed(ActionEvent actionEvent) {
        String titulo = textTitulo.getText();
        String autor = textAutor.getText();
        String genero = (String) comboGenero.getSelectedItem();
        String subGenero = (String) comboSubGenero.getSelectedItem();

        if (titulo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Título\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (titulo.length() < 3) {
            JOptionPane.showMessageDialog(null, "O campo \"Título\" deve ter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (titulo.length() > 50) {
            JOptionPane.showMessageDialog(null, "O campo \"Título\" deve ter no máximo 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Titulo t : GestorBiblioteca.instance.getTitulos()) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, "O título '" + titulo + "' já existe no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (autor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Autor\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (autor.length() < 3) {
            JOptionPane.showMessageDialog(null, "O campo \"Autor\" deve ter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (autor.length() > 50) {
            JOptionPane.showMessageDialog(null, "O campo \"Autor\" deve ter no máximo 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (genero == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Género\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (subGenero == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Subgénero\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Genero newGenero = GestorBiblioteca.instance.getGenero(genero);
        Subgenero newSubgenero = newGenero.getSubgenero(subGenero);

        GestorBiblioteca.instance.addTitulo(titulo, autor, newGenero, newSubgenero);
        String successMessage = "Título '" + titulo + "' adicionado com sucesso.";
        JOptionPane.showMessageDialog(null, successMessage, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        JanelaCriarTitulo.this.setVisible(false);
    }

    public void btnVoltarActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public void comboGeneroActionPerformed(ActionEvent e) {
        String genero = (String) comboGenero.getSelectedItem();
        LinkedList<Subgenero> subGeneros = GestorBiblioteca.instance.getGenero(genero).getSubgeneros();
        comboSubGenero.removeAllItems();
        for (Subgenero subGenero : subGeneros) comboSubGenero.addItem(subGenero.getNome());
    }

}
