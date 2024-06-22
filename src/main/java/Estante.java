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

    private class Prateleira {
        private int numero;

        public Prateleira(int numero) {
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }

    }
}
