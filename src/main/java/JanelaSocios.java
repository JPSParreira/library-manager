/********************************
 *    Diogo Abegão Nº 2222184   *
 ********************************/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class JanelaSocios extends JDialog {
    private JPanel janelaSocios;
    private JButton btnAdicionarSocio;
    private JButton btnPagamentos;
    private JButton btnHistoricoSocio;
    private JButton btnNotificarSocio;
    private JButton btnVoltar;
    private JCheckBox btnFiltrarSociosDividas;
    private JTable tableListaSocios;

    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaSocios(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaSocios);
        pack();
        setLocationRelativeTo(null);

        updateTable(gb.getSocios());
        btnNotificarSocio.setEnabled(false);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnFiltrarSociosDividas.addActionListener(this::btnFiltrarSociosDividasActionPerformed);
        btnNotificarSocio.addActionListener(this::btnNotificarSocioActionPerformed);
        btnAdicionarSocio.addActionListener(this::btnAdicionarSocioActionPerformed);
    }
    private void btnAdicionarSocioActionPerformed(ActionEvent actionEvent) {
        JanelaCriarSocio janelaCriarSocio = new JanelaCriarSocio("Adicionar Sócio");
        this.setVisible(false);
        janelaCriarSocio.setModal(true);
        janelaCriarSocio.setVisible(true);
    }

    private void btnNotificarSocioActionPerformed(ActionEvent actionEvent) {
        try {
            JOptionPane.showMessageDialog(null, "Notificação enviada com sucesso.", "Notificação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao enviar as notificações por email. Por favor, tente novamente mais tarde.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnFiltrarSociosDividasActionPerformed(ActionEvent actionEvent) {
        if (btnFiltrarSociosDividas.isSelected()) {
            LinkedList<Socio> sociosComDividas = gb.getSociosComDividas();
            if (sociosComDividas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há sócios com valores em dívida.", "Erro", JOptionPane.ERROR_MESSAGE);
                btnFiltrarSociosDividas.setSelected(false);
            } else {
                updateTable(sociosComDividas);
                btnNotificarSocio.setEnabled(true);
            }
        } else {
            updateTable(gb.getSocios());
            btnNotificarSocio.setEnabled(false);
        }
    }

    public void btnVoltarActionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
    }

    public void updateTable(LinkedList<Socio> socios) {
        if (socios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem sócios registados", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Multa em Divida");
        model.addColumn("Anuidade em Divida");
        for (Socio s : socios) {
            model.addRow(new Object[]{String.valueOf(s.getIdSocio()), s.getNome(), String.valueOf(s.getMultasEmDivida()), String.valueOf(s.getAnuidadesEmDivida())});
        }
        tableListaSocios.setModel(model);
    }

}
