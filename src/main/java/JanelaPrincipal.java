import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

    private JPanel janelaPrincipal;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton sociosButton;
    private JButton configuracoesButton;
    private JButton pesquisarButton;
    private JButton estatisticasButton;
    private JButton adicionarExemplarButton;
    private JButton adicionarTituloButton;

    public static void main(String[] args) {
        new JanelaPrincipal("JanelaPrincipal").setVisible(true);
    }

    public JanelaPrincipal(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(janelaPrincipal);
        pack();
        setLocationRelativeTo(null);

        emprestimosButton.addActionListener(this::emprestimosButtonActionPerformed);
        reservasButton.addActionListener(this::reservasButtonActionPerformed);
        sociosButton.addActionListener(this::sociosButtonActionPerformed);
        configuracoesButton.addActionListener(this::configuracoesButtonActionPerformed);
        pesquisarButton.addActionListener(this::pesquisarButtonActionPerformed);
        estatisticasButton.addActionListener(this::estatisticasButtonActionPerformed);
        adicionarExemplarButton.addActionListener(this::adicionarExemplarButtonActionPerformed);
        adicionarTituloButton.addActionListener(this::adicionarTituloButtonActionPerformed);
    }

    public void emprestimosButtonActionPerformed(ActionEvent e) {
    }

    public void reservasButtonActionPerformed(ActionEvent e) {
    }

    public void sociosButtonActionPerformed(ActionEvent e) {
    }

    public void configuracoesButtonActionPerformed(ActionEvent e) {
        JanelaConfiguracoes janelaConfiguracoes = new JanelaConfiguracoes("Configurações");
    }

    public void pesquisarButtonActionPerformed(ActionEvent e) {
    }

    public void estatisticasButtonActionPerformed(ActionEvent e) {
    }

    public void adicionarExemplarButtonActionPerformed(ActionEvent e) {
    }

    public void adicionarTituloButtonActionPerformed(ActionEvent e) {
    }

}
