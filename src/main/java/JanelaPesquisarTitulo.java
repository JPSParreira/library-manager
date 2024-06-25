import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import Titulo.*;
import Titulo.Exemplar.*;

public class JanelaPesquisarTitulo extends JDialog {
    private JPanel JanelaPesquisarTitulo;
    private JButton btnVoltar;
    private JButton btnPesquisarTitulo;
    private JLabel Titulo;
    private JTextField textFieldTitulo;
    private JTable tablePesquisarTitulo;
    private JLabel totalCount;

    public JanelaPesquisarTitulo(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(JanelaPesquisarTitulo);
        pack();
        setLocationRelativeTo(null);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnPesquisarTitulo.addActionListener(this::btnPesquisarTituloActionPerformed);
    }

    public void btnPesquisarTituloActionPerformed(ActionEvent actionEvent) {
        String titulo = textFieldTitulo.getText();
        try {
            if (titulo.length() < 3 || titulo.length() > 50) {
                JOptionPane.showMessageDialog(null, "O campo \"Título\" deve ter no mínimo 3 caracteres e no máximo 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (titulo.isBlank()) {
                JOptionPane.showMessageDialog(null, "O campo \"Título\" não pode ser composto apenas por espaços em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "O campo \"Título\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LinkedList<Exemplar> exemplares = new LinkedList<>();
        for (Titulo t : GestorBiblioteca.instance.getTitulos()) {
            if (t.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                exemplares.addAll(t.getExemplares());
            }
        }
        if (exemplares.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foram encontrados exemplares correspondentes ao \"Titulo\" preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            updateTable(exemplares);
            totalCount.setText(String.valueOf(exemplares.size()));
        }
    }

    public void updateTable(LinkedList<Exemplar> exemplares) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Exemplar");
        model.addColumn("ISBN");
        model.addColumn("Estante");
        model.addColumn("Prateleira");
        model.addColumn("Estado");
        for (Exemplar e : exemplares) {
            String isbn = String.valueOf(e.getISBN());
            String status = e.isDisponivel() ? "Disponível" : "Indisponível";
            model.addRow(new Object[]{e.getTitulo().getTitulo(), isbn, String.valueOf(e.getEstante().getNumero()), String.valueOf(e.getPrateleira().getNumero()), status});
        }
        tablePesquisarTitulo.setModel(model);
    }

    public void btnVoltarActionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
    }
}
