import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaEmprestimos {
    private JPanel janelaEmprestimos;
    private JList<Emprestimo> listaEmprestimos;
    private JButton voltarButton;
    private JButton novoEmprestimoButton;
    private JButton devolucaoButton;
    private JScrollPane containerEmprestimos;

    public JanelaEmprestimos(String title) {
        JFrame frame = new JFrame(title);
        frame.setContentPane(janelaEmprestimos);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        DefaultListModel<Emprestimo> model = new DefaultListModel<>();
        for (Emprestimo emprestimo : GestorBiblioteca.instance.getListaEmprestimos()) {
            model.addElement(emprestimo);
        }

        listaEmprestimos = new JList<>(model);
        listaEmprestimos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        containerEmprestimos.setViewportView(listaEmprestimos);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
        novoEmprestimoButton.addActionListener(this::novoEmprestimoButtonActionPerformed);
        devolucaoButton.addActionListener(this::devolucaoButtonActionPerformed);
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(janelaEmprestimos);
        frame.dispose();
    }

    public void novoEmprestimoButtonActionPerformed(ActionEvent e) {
        JanelaCriarEmprestimo janelaCriarEmprestimo = new JanelaCriarEmprestimo("Novo Empréstimo");
    }

    public void devolucaoButtonActionPerformed(ActionEvent e) {

    }
}
