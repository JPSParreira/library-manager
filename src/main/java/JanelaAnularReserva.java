/********************************
 *    João Parreira Nº 2221985   *
 ********************************/

import Socios.Reserva;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaAnularReserva extends JDialog {
    private JPanel janelaAnularReserva;
    private JLabel reservaLabel;
    private JComboBox comboBoxReserva;
    private JButton submeterButton;
    private JButton voltarButton;

    public JanelaAnularReserva(String title) {
        this.setTitle(title);
        setContentPane(janelaAnularReserva);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        reservaLabel.setText("Socios.Reserva");

        for (Reserva reserva : GestorBiblioteca.instance.getReservas()) {
            if (reserva.isAtiva()) {
                comboBoxReserva.addItem(reserva.getIdReserva());
            }
        }
        comboBoxReserva.setSelectedItem(0);

        submeterButton.addActionListener(this::submeterButtonActionPerformed);
        voltarButton.addActionListener(this::voltarButtonActionPerformed);
    }

    public void submeterButtonActionPerformed(ActionEvent e) {
        try {
            int idReserva = (int) comboBoxReserva.getSelectedItem();
            Reserva reserva = GestorBiblioteca.instance.getReserva(idReserva);
            reserva.setAtiva(false);
            JOptionPane.showMessageDialog(this, "Socios.Reserva anulada com sucesso.");
            var janelaReservas = new JanelaReservas("Reservas");
            this.setVisible(false);
            janelaReservas.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao anular reserva.");
        }
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        var janelaReservas = new JanelaReservas("Reservas");
        this.setVisible(false);
        janelaReservas.setVisible(true);
    }
}
