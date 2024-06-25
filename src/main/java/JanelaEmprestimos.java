import javax.swing.*;
import java.awt.event.ActionEvent;
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

        String colunas[] = {"ID", "Sócio", "ID Exemplar", "Título", "Data de Empréstimo"};
        var model = new DefaultTableModel(colunas, 0);

        for (Emprestimo emprestimo : GestorBiblioteca.instance.getEmprestimos()) {
            model.addRow(new Object[] {
                emprestimo.getIdEmprestimo(),
                emprestimo.getIdSocio(),
                emprestimo.getIdExemplar(),
                GestorBiblioteca.instance.getExemplar(emprestimo.getIdExemplar()).getTitulo(),
                emprestimo.getDataEmprestimo()
            });
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
        janelaCriarEmprestimo.setModal(true);
        janelaCriarEmprestimo.setVisible(true);
    }

    public void devolucaoButtonActionPerformed(ActionEvent e) {

    }
}
