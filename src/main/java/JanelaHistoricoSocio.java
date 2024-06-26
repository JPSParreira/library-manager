/********************************
 *    Diogo Abegão Nº 2222184   *
 ********************************/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class JanelaHistoricoSocio extends JDialog{
    private JPanel janelaHistoricoSocio;
    private JButton btnVoltar;
    private JButton btnProcurarButton;
    private JLabel socio;
    private JComboBox comboBoxNomeSocio;
    private JTable tabelaEmprestimosPorSocio;

    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaHistoricoSocio(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaHistoricoSocio);
        pack();
        setLocationRelativeTo(null);

        socio.setText("Sócio");

        comboBoxNomeSocio.addItem(null);
        comboBoxNomeSocio.setSelectedItem(null);
        gb.getSocios().forEach(socio -> comboBoxNomeSocio.addItem(socio.getNome()));

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnProcurarButton.addActionListener(this::btnProcurarButtonActionPerformed);
    }

    private void btnProcurarButtonActionPerformed(ActionEvent actionEvent) {
        String nomeSocio = (String) comboBoxNomeSocio.getSelectedItem();
        if (nomeSocio == null) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um \"Sócio\" no campo \"Sócio\"", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LinkedList<Emprestimo> emprestimos = new LinkedList<>();
        for (Emprestimo e: gb.getEmprestimos()) {
            if (e.getSocio().getNome().equals(nomeSocio)) {
                emprestimos.add(e);
            }
        }
        updateTable(emprestimos);
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        JanelaSocios janelaSocios = new JanelaSocios("Sócios");
        this.setVisible(false);
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);
    }

    public void updateTable(LinkedList<Emprestimo> emprestimos) {
        if (emprestimos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O sócio selecionado não possui histórico de empréstimos", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Titulo");
        model.addColumn("Data de Empréstimo");
        model.addColumn("Data de Devolução");
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");

        for (Emprestimo e: emprestimos) {
            model.addRow(new Object[]{String.valueOf(e.getIdEmprestimo()), e.getTitulo().getTitulo(), format.format(e.getDataEmprestimo()) , e.getDataDevolucao()==null?"--":format.format(e.getDataDevolucao())});
        }
        tabelaEmprestimosPorSocio.setModel(model);
    }

}
