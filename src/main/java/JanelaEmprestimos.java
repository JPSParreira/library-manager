import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaEmprestimos extends JDialog {
    private JPanel janelaEmprestimos;
    private JList<Emprestimo> listaEmprestimos;
    private JButton voltarButton;
    private JButton novoEmprestimoButton;
    private JButton devolucaoButton;
    private JScrollPane containerEmprestimos;

    public JanelaEmprestimos(String title) {
        this.setTitle(title);
        setContentPane(janelaEmprestimos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

//        DefaultListModel<Emprestimo> model = new DefaultListModel<>();
//        for (Emprestimo emprestimo : GestorBiblioteca.instance.getListaEmprestimos()) {
//            model.addElement(emprestimo);
//        }
//
//        listaEmprestimos = new JList<>(model);
//        listaEmprestimos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        containerEmprestimos.setViewportView(listaEmprestimos);

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
