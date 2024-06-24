import Biblioteca.Estante;
import Biblioteca.Prateleira;
import Titulo.Exemplar.Editora;
import Titulo.Exemplar.Distribuidor;
import Titulo.Exemplar.Exemplar;
import Titulo.Titulo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.LinkedList;

public class JanelaCriarExemplar extends JDialog {
    private JPanel JanelaAdicionarExemplar;
    private JButton voltarButton;
    private JButton submeterButton;
    private JComboBox comboTitulo;
    private JComboBox comboEditora;
    private JComboBox comboDistribuidor;
    private JTextField textAno;
    private JTextField textEdicao;
    private JTextField textISBN;
    private JButton btnNewFornecedor;
    private JButton btnNewEditora;

    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaCriarExemplar(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(JanelaAdicionarExemplar);
        pack();
        setLocationRelativeTo(null);

        for (Titulo t : gb.getTitulos()) {
            comboTitulo.addItem(t.getTitulo());
        }

        for (Editora e : gb.getEditoras()) {
            comboEditora.addItem(e.getNome());
        }

        for (Distribuidor f : gb.getDistribuidores()) {
            comboDistribuidor.addItem(f.getNome());
        }

        voltarButton.addActionListener(this::voltarButtonActionPerformed);
        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        btnNewFornecedor.addActionListener(this::btnNewFornecedorActionPerformed);
        btnNewEditora.addActionListener(this::btnNewEditoraActionPerformed);
    }

    private void btnNewEditoraActionPerformed(ActionEvent actionEvent) {
        String editora = JOptionPane.showInputDialog(null, "Nome da nova Editora: ");

        if (editora.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Editora\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (editora.length() < 3) {
            JOptionPane.showMessageDialog(null, "O campo \"Editora\" deve ter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (editora.length() > 50) {
            JOptionPane.showMessageDialog(null, "O campo \"Editora\" deve ter no máximo 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LinkedList<Editora> editoras = gb.getEditoras();
        for (Editora e : editoras) {
            if (e.getNome().equalsIgnoreCase(editora)) {
                JOptionPane.showMessageDialog(null, "A editora '" + editora + "' já existe no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Editora e = new Editora(editora);
        gb.addEditora(e);
        comboEditora.addItem(e.getNome());
        JOptionPane.showMessageDialog(null, "Editora " + editora + " adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnNewFornecedorActionPerformed(ActionEvent actionEvent) {
        String distribuidor = JOptionPane.showInputDialog(null, "Nome do novo fornecedor: ");

        if (distribuidor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Fornecedor\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (distribuidor.length() < 3) {
            JOptionPane.showMessageDialog(null, "O campo \"Fornecedor\" deve ter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (distribuidor.length() > 50) {
            JOptionPane.showMessageDialog(null, "O campo \"Fornecedor\" deve ter no máximo 50 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LinkedList<Distribuidor> distribuidores = gb.getDistribuidores();
        for (Distribuidor f : distribuidores) {
            if (f.getNome().equalsIgnoreCase(distribuidor)) {
                JOptionPane.showMessageDialog(null, "O distribuidor '" + distribuidor + "' já existe no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Distribuidor d = new Distribuidor(distribuidor);
        gb.addDistribuidor(d);
        JOptionPane.showMessageDialog(null, "Distribuidor " + distribuidor + " adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        comboDistribuidor.addItem(d.getNome());
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {

        String textTitulo = (String) comboTitulo.getSelectedItem();
        if (textTitulo == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Título\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Titulo titulo = gb.getTitulo(textTitulo);

        String textEditora = (String) comboEditora.getSelectedItem();
        if (textEditora == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Editora\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Editora editora = gb.getEditora(textEditora);

        String textDistribuidor = (String) comboDistribuidor.getSelectedItem();
        if (textDistribuidor == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Distribuidor\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Distribuidor distribuidor = gb.getDistribuidor(textDistribuidor);


        int ano;
        try {
            ano = Integer.parseInt(textAno.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O campo \"Ano\" deve ser um inteiro positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (ano <= 1000 || ano > anoAtual) {
            JOptionPane.showMessageDialog(null, "O campo \"Ano\" não é válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String edicao = textEdicao.getText();
        if (edicao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Edição\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (edicao.length() > 10) {
            JOptionPane.showMessageDialog(null, "O campo \"Edição\" deve ter no máximo 10 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long isbn;
        try {
            isbn = Long.parseLong(textISBN.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O campo \"ISBN\" deve ser um inteiro positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (String.valueOf(isbn).length() != 13) {
            JOptionPane.showMessageDialog(null, "O campo \"ISBN\" deve ter 13 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Exemplar exemplar = new Exemplar(isbn, ano, edicao, titulo, editora, distribuidor);
        titulo.addExemplar(exemplar);

        Estante estanteLivre = gb.getEstanteLivre();
        Prateleira prateleiraLivre = gb.getPrateleiraLivre(estanteLivre);

        prateleiraLivre.addExemplar(exemplar);

        exemplar.setEstante(estanteLivre);
        exemplar.setPrateleira(prateleiraLivre);

        JOptionPane.showMessageDialog(null, "Exemplar adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }

}
