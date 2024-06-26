/********************************
 *    Diogo Abegão Nº 2222184   *
 ********************************/

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaPagar extends JDialog {
    private JPanel janelaPagar;
    private JButton btnVoltar;
    private JButton btnSubmeter;
    private JComboBox comboBoxNomeSocio;
    private JComboBox comboBoxTipoPagamento;
    private JTextField textFieldValor;

    private GestorBiblioteca gb = GestorBiblioteca.instance;

    public JanelaPagar(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(janelaPagar);
        pack();
        setLocationRelativeTo(null);

        comboBoxNomeSocio.addItem(null);
        comboBoxNomeSocio.setSelectedItem(null);
        gb.getSocios().forEach(socio -> comboBoxNomeSocio.addItem(socio.getNome()));

        comboBoxTipoPagamento.setEnabled(false);
        textFieldValor.setEnabled(false);

        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        comboBoxNomeSocio.addActionListener(this::comboBoxNomeSocioActionPerformed);
        comboBoxTipoPagamento.addActionListener(this::comboBoxTipoPagamentoActionPerformed);
        btnSubmeter.addActionListener(this::btnSubmeterActionPerformed);
    }

    private void btnSubmeterActionPerformed(ActionEvent actionEvent) {
        String nomeSocio = (String) comboBoxNomeSocio.getSelectedItem();
        String tipoPagamento = (String) comboBoxTipoPagamento.getSelectedItem();
        String valor = textFieldValor.getText();

        if (nomeSocio == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Sócio\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipoPagamento == null) {
            JOptionPane.showMessageDialog(null, "O campo \"Tipo\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo \"Valor\" é mandatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float v;
        try{
             v = Float.parseFloat(valor);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "O valor inserido deve ser numérico.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Socio s = gb.getSocio(nomeSocio);
        float divida = 0;
        switch (tipoPagamento) {
            case "Anuidade":
                divida = s.getAnuidadesEmDivida();
                break;
            case "Multa":
                divida = s.getMultasEmDivida();
                break;
            case "Total":
                divida = s.getAnuidadesEmDivida() + s.getMultasEmDivida();
                break;
        }

        if (v > divida) {
            JOptionPane.showMessageDialog(null, "O valor a ser pago deve ser inferior ou igual ao valor da dívida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (v <= 0) {
            JOptionPane.showMessageDialog(null, "O valor a ser pago deve ser superior a 0.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (tipoPagamento){
            case "Anuidade":
                s.setAnuidadesEmDivida(s.getAnuidadesEmDivida() - v);
                break;
            case "Multa":
                s.setMultasEmDivida(s.getMultasEmDivida() - v);
                break;
            case "Total":
                if (v > s.getMultasEmDivida()){
                    s.setMultasEmDivida(0);
                    s.setAnuidadesEmDivida(s.getAnuidadesEmDivida() - (v - s.getMultasEmDivida()));
                }else{
                    s.setMultasEmDivida(s.getMultasEmDivida() - v);
                }
                break;
        }

        JOptionPane.showMessageDialog(null, "Dívida paga com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        JanelaSocios janelaSocios = new JanelaSocios("Sócios");
        this.setVisible(false);
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);


    }

    private void comboBoxTipoPagamentoActionPerformed(ActionEvent actionEvent) {
        String socio = (String) comboBoxNomeSocio.getSelectedItem();
        if (socio != null) {
            Socio s = gb.getSocio(socio);
            String pagamento = (String) comboBoxTipoPagamento.getSelectedItem();
            String divida;
            switch (pagamento) {
                case "Anuidade":
                    divida = String.valueOf(s.getAnuidadesEmDivida());
                    textFieldValor.setText(divida);
                    break;
                case "Multa":
                    divida = String.valueOf(s.getMultasEmDivida());
                    textFieldValor.setText(divida);
                    break;
                case "Total":
                    float total = s.getAnuidadesEmDivida() + s.getMultasEmDivida();
                    textFieldValor.setText(String.valueOf(total));
                    break;
                default:
                    textFieldValor.setText("");
            }
        }

    }

    public void comboBoxNomeSocioActionPerformed(ActionEvent actionEvent) {
        if (comboBoxNomeSocio.getSelectedItem() != null) {
            comboBoxTipoPagamento.setEnabled(true);
            textFieldValor.setEnabled(true);
        } else {
            comboBoxTipoPagamento.setEnabled(false);
            textFieldValor.setEnabled(false);
        }
    }

    public void btnVoltarActionPerformed(ActionEvent actionEvent) {
        JanelaSocios janelaSocios = new JanelaSocios("Sócios");
        this.setVisible(false);
        janelaSocios.setModal(true);
        janelaSocios.setVisible(true);
    }
}
