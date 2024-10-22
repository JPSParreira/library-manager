/********************************
 *    João Parreira Nº 2221985   *
 ********************************/

import Socios.Emprestimo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class JanelaEmprestimos extends JDialog {
    private JPanel janelaEmprestimos;
    private JButton voltarButton;
    private JButton novoEmprestimoButton;
    private JButton devolucaoButton;
    private JScrollPane containerEmprestimos;
    private JTable listaEmprestimos;

    public JanelaEmprestimos(String title) {
        this.setTitle(title);
        setContentPane(janelaEmprestimos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        String[] colunas = {"ID empréstimo", "Sócio", "Título", "Data de Empréstimo"};
        var model = new DefaultTableModel(colunas, 0);

        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        for (Emprestimo emprestimo : GestorBiblioteca.instance.getEmprestimos()) {
            if (!emprestimo.isDevolvido()){
                model.addRow(new Object[] {
                        emprestimo.getIdEmprestimo(),
                        emprestimo.getSocio().getNome(),
                        emprestimo.getTitulo().getTitulo(),
                        format.format(emprestimo.getDataEmprestimo())
                });
            }
        }

        listaEmprestimos.setModel(model);
        containerEmprestimos.setViewportView(listaEmprestimos);

        voltarButton.addActionListener(this::voltarButtonActionPerformed);
        novoEmprestimoButton.addActionListener(this::novoEmprestimoButtonActionPerformed);
        devolucaoButton.addActionListener(this::devolucaoButtonActionPerformed);
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public void novoEmprestimoButtonActionPerformed(ActionEvent e) {
        var janelaCriarEmprestimo = new JanelaCriarEmprestimo("Novo Empréstimo");
        this.setVisible(false);
        janelaCriarEmprestimo.setVisible(true);
    }

    public void devolucaoButtonActionPerformed(ActionEvent e) {
        var janelaDevolucao = new JanelaDevolucao("Nova Devolução");
        this.setVisible(false);
        janelaDevolucao.setVisible(true);
    }
}
