/********************************
 *    João Parreira Nº 2221985   *
 ********************************/

import Socios.Reserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class JanelaReservas extends JDialog {
    private JPanel janelaReservas;
    private JScrollPane containerReservas;
    private JTable listaReservas;
    private JButton voltarButton;
    private JButton anularReservaButton;

    public JanelaReservas(String title) {
        this.setTitle(title);
        setContentPane(janelaReservas);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        String[] colunas = {"ID reserva", "Sócio", "Título", "Data de Socios.Reserva"};
        var model = new DefaultTableModel(colunas, 0);
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        for (Reserva reserva : GestorBiblioteca.instance.getReservas()) {
            if (reserva.isAtiva()) {
                model.addRow(new Object[]{
                        reserva.getIdReserva(),
                        reserva.getSocio().getNome(),
                        reserva.getTitulo().getTitulo(),
                        format.format(reserva.getDataReserva())
                });
            }
        }

        listaReservas.setModel(model);
        containerReservas.setViewportView(listaReservas);

        voltarButton.addActionListener(this::voltarButtonActionPerformed);
        anularReservaButton.addActionListener(this::anularReservaButtonActionPerformed);
    }

    public void voltarButtonActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public void anularReservaButtonActionPerformed(ActionEvent e) {
        var janelaAnularReserva = new JanelaAnularReserva("Anular Socios.Reserva");
        this.setVisible(false);
        janelaAnularReserva.setVisible(true);
    }
}
