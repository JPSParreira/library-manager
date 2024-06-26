/********************************
 *    Diogo Abegão Nº 2222184   *
 ********************************/

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaCriarSocio extends JDialog {
    private JPanel janelaCriarSocio;
    private JButton btnVoltar;
    private JButton btnSubmeterButton;
    private JTextField textFieldNome;
    private JTextField textFieldMorada;
    private JTextField textFieldEmail;
    private JTextField textFieldNifouCC;
    private JTextField textFieldTelemovel;

    public JanelaCriarSocio(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaCriarSocio);
        pack();
        setLocationRelativeTo(null);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        btnSubmeterButton.addActionListener(this::btnSubmeterButtonActionPerformed);
    }

    private void btnSubmeterButtonActionPerformed(ActionEvent actionEvent) {
        String nome = textFieldNome.getText();
        String morada = textFieldMorada.getText();
        String email = textFieldEmail.getText();
        String nifouCC = textFieldNifouCC.getText();
        String telemovel = textFieldTelemovel.getText();
        try {
            if (nome.length() < 3 || nome.length() > 60) {
                JOptionPane.showMessageDialog(null, "O campo \"Sócio\" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "O campo \"Sócio\" não pode ser composto apenas por espaços em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo \"Sócio\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (morada.length() < 3 || morada.length() > 60) {
                JOptionPane.showMessageDialog(null, "O campo \"Morada\" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (morada.isBlank()) {
                JOptionPane.showMessageDialog(null, "O campo \"Morada\" não pode ser composto apenas por espaços em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo \"Morada\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (email.length() < 3 || email.length() > 60) {
                JOptionPane.showMessageDialog(null, "O campo \"Email\" deve ter no mínimo 3 caracteres e no máximo 60 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Socio socio : GestorBiblioteca.instance.getSocios()) {
                if (socio.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(null, "O campo \"Email\" já existe no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            if (email.isBlank()) {
                JOptionPane.showMessageDialog(null, "O campo \"Email\" não pode ser composto apenas por espaços em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo \"Email\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (nifouCC.length() != 9) {
                JOptionPane.showMessageDialog(null, "O campo \"Nif ou CC\" deve ter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Socio socio : GestorBiblioteca.instance.getSocios()) {
                if (socio.getNif() == Integer.parseInt(nifouCC)) {
                    JOptionPane.showMessageDialog(null, "O campo \"Nif ou CC\" já existe no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo \"Nif ou CC\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (telemovel.length() != 9) {
                JOptionPane.showMessageDialog(null, "O campo \"Télemovel\" deve ter 9 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Socio socio : GestorBiblioteca.instance.getSocios()) {
                if (socio.getTelemovel() == Integer.parseInt(telemovel)) {
                    JOptionPane.showMessageDialog(null, "O campo \"Télemovel\" já existe no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "O campo \"Télemovel\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Socio socio = new Socio(nome, morada, email, Long.parseLong(nifouCC), Long.parseLong(telemovel));
        GestorBiblioteca.instance.addSocio(socio);
        JOptionPane.showMessageDialog(null, "Sócio " + nome + " adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        JanelaSocios janelaSocios = new JanelaSocios("Sócios");
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);
    }

    private void btnVoltarActionPerformed(ActionEvent actionEvent) {
        this.setVisible(false);
        JanelaSocios janelaSocios = new JanelaSocios("Sócios");
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);
    }


}
