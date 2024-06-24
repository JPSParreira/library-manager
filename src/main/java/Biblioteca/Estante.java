package Biblioteca;

public class Estante {
    private int numero;
    private Prateleira[] prateleiras;

    public Estante(int numero, int quantidadePrateleiras) {
        this.numero = numero;
        this.prateleiras = new Prateleira[quantidadePrateleiras];
        for (int i = 0; i < quantidadePrateleiras; i++) {
            prateleiras[i] = new Prateleira(i + 1);
        }
    }

    public int getNumero() {
        return numero;
    }

    public Prateleira[] getPrateleiras() {
        return prateleiras;
    }

    public Prateleira getPrateleira(int numero) {
        return prateleiras[numero - 1];
    }
}
