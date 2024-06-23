import Titulo.Genero;

import javax.swing.*;
import java.util.LinkedList;

public class JanelaAdicionarExemplar extends JDialog {
    private JPanel JanelaAdicionarExemplar;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;

    public JanelaAdicionarExemplar(String title) {
        setTitle(title);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(JanelaAdicionarExemplar);
        pack();
        setLocationRelativeTo(null);

        LinkedList<Genero> generos = GestorBiblioteca.instance.getGeneros();
        for (Genero genero : generos) {
            comboGenero.addItem(genero.getNome());
        }
        comboGenero.setSelectedItem(null);
    }

}
