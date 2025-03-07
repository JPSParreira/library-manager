/************************************************************************************
 *    Diogo Abegão Nº 2222184, João Parreira Nº 2221985, Pedro Barbeiro Nº2221986   *
 ************************************************************************************/

import javax.swing.*;
import java.awt.*;
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
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.put("nimbusBase", new Color(243,243,243));
                    UIManager.put("nimbusBlueGrey", new Color(243,243,243));
                    UIManager.put("control", new Color(243,243,243));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        var janelaEmprestimos = new JanelaEmprestimos("Empréstimos");
        janelaEmprestimos.setModal(true);
        janelaEmprestimos.setVisible(true);
    }

    public void reservasButtonActionPerformed(ActionEvent e) {
        var janelaReservas = new JanelaReservas("Reservas");
        janelaReservas.setModal(true);
        janelaReservas.setVisible(true);
    }

    public void sociosButtonActionPerformed(ActionEvent e) {
        var janelaSocios = new JanelaSocios("Sócios");
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);
    }

    public void configuracoesButtonActionPerformed(ActionEvent e) {
        var janelaConfiguracoes = new JanelaConfiguracoes("Configurações");
        janelaConfiguracoes.setModal(true);
        janelaConfiguracoes.setVisible(true);
    }

    public void pesquisarButtonActionPerformed(ActionEvent e) {
        var janelaPesquisarTitulo = new JanelaPesquisarTitulo("Pesquisar Título");
        janelaPesquisarTitulo.setModal(true);
        janelaPesquisarTitulo.setVisible(true);
    }

    public void estatisticasButtonActionPerformed(ActionEvent e) {
        var janelaEstatisticas = new JanelaEstatisticas("Estatísticas");
        janelaEstatisticas.setModal(true);
        janelaEstatisticas.setVisible(true);
    }

    public void adicionarExemplarButtonActionPerformed(ActionEvent e) {
        var janelaAdicionarExemplar = new JanelaCriarExemplar("Adicionar Exemplar");
        janelaAdicionarExemplar.setModal(true);
        janelaAdicionarExemplar.setVisible(true);
    }

    public void adicionarTituloButtonActionPerformed(ActionEvent e) {
        var janelaCriarTitulo = new JanelaCriarTitulo("Criar Título");
        janelaCriarTitulo.setModal(true);
        janelaCriarTitulo.setVisible(true);
    }

}
