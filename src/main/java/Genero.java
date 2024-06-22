public enum Genero {
    AVENTURA(SubGeneroAventura.class),
    FICCAO(SubGeneroFiccao.class),
    TERROR(SubGeneroTerror.class),
    ROMANCE(SubGeneroRomance.class),
    DRAMA(SubGeneroDrama.class),
    SUSPENSE(SubGeneroSuspense.class),
    AUTOAJUDA(SubGeneroAutoajuda.class),
    BIOGRAFIA(SubGeneroBiografia.class),
    INFANTIL(SubGeneroInfantil.class),
    RELIGIAO(SubGeneroReligiao.class),
    OUTRO(SubGeneroOutro.class);

    private Class<? extends Enum<?>> subGenero;

    Genero(Class<? extends Enum<?>> subGenero) {
        this.subGenero = subGenero;
    }

    public Class<? extends Enum<?>> getSubGenero() {
        return subGenero;
    }

    public enum SubGeneroAventura {
        EPICO, MISSAO, MILITAR
    }

    public enum SubGeneroFiccao {
        SCI_FI, FANTASIA, DISTOPIA
    }

    public enum SubGeneroTerror {
        GOTICO, PARANORMAL, SLASHER
    }

    public enum SubGeneroRomance {
        CONTEMPORANEO, HISTORICO, PARANORMAL
    }

    public enum SubGeneroDrama {
        TRAGEDIA, MELANCOLIA, SOCIAL
    }

    public enum SubGeneroSuspense {
        THRILLER, CRIME, MISTERIO
    }

    public enum SubGeneroAutoajuda {
        MOTIVACIONAL, BEM_ESTAR, FINANCEIRO
    }

    public enum SubGeneroBiografia {
        HISTORICA, AUTOBIOGRAFIA, MEMORIAS
    }

    public enum SubGeneroInfantil {
        LIVRO_ILUSTRADO, CONTO_DE_FADAS, EDUCACIONAL
    }

    public enum SubGeneroReligiao {
        ESPIRITUAL, ESCRITURA, TEOLOGIA
    }

    public enum SubGeneroOutro {
        GENERICO
    }
}
