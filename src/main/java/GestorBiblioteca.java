import Biblioteca.Estante;
import Biblioteca.Prateleira;
import Titulo.Exemplar.*;
import Titulo.*;

import java.util.Comparator;
import java.util.LinkedList;

public class GestorBiblioteca {
    /* Singleton */
    public static final GestorBiblioteca instance = new GestorBiblioteca();

    // Configurações
    private int maximoDiasEmprestimo;
    private float valorMultaPorDia;
    private int maximoLivrosEmprestados;
    private float valorAnuidade;

    //Titulo
    private LinkedList<Titulo> titulos;
    private LinkedList<Autor> autores;
    private LinkedList<Genero> generos;

    // Exemplar
    private LinkedList<Editora> editoras;
    private LinkedList<Distribuidor> fornecedores;

    // Biblioteca
    private LinkedList<Estante> estantes;
    private LinkedList<Emprestimo> emprestimos;
    private LinkedList<Reserva> reservas;
    private LinkedList<Socio> socios;

    /* Construtor */
    private GestorBiblioteca() {
        maximoDiasEmprestimo = 15;
        valorMultaPorDia = 1f;
        maximoLivrosEmprestados = 3;
        valorAnuidade = 20.0f;

        titulos = new LinkedList<>();

        autores = new LinkedList<>();
        editoras = new LinkedList<>();
        fornecedores = new LinkedList<>();
        generos = new LinkedList<>();
        estantes = new LinkedList<>();
        socios = new LinkedList<>();
        emprestimos = new LinkedList<>();
        reservas = new LinkedList<>();

        seedApp();
    }

    public void seedApp() {
        //region Seed Estantes / Prateleiras
        for (int i = 1; i <= 20; i++) {
            estantes.add(new Estante(i, 50));
        }
        //endregion

        //region Seed Generos / Subgeneros
        Genero acao = new Genero("Ação");
        acao.addSubgenero(new Subgenero("Ação e Aventura"));
        acao.addSubgenero(new Subgenero("Thriller de Ação"));
        acao.addSubgenero(new Subgenero("Ação Militar"));
        acao.addSubgenero(new Subgenero("Ação Espionagem"));
        generos.add(acao);

        Genero aventura = new Genero("Aventura");
        aventura.addSubgenero(new Subgenero("Aventura Épica"));
        aventura.addSubgenero(new Subgenero("Aventura de Sobrevivência"));
        aventura.addSubgenero(new Subgenero("Aventura Histórica"));
        aventura.addSubgenero(new Subgenero("Aventura de Exploração"));
        generos.add(aventura);

        Genero comedia = new Genero("Comédia");
        comedia.addSubgenero(new Subgenero("Comédia Romântica"));
        comedia.addSubgenero(new Subgenero("Comédia Satírica"));
        comedia.addSubgenero(new Subgenero("Comédia de Situação"));
        comedia.addSubgenero(new Subgenero("Comédia de Humor Negro"));
        generos.add(comedia);

        Genero drama = new Genero("Drama");
        drama.addSubgenero(new Subgenero("Drama Familiar"));
        drama.addSubgenero(new Subgenero("Drama Psicológico"));
        drama.addSubgenero(new Subgenero("Drama Social"));
        drama.addSubgenero(new Subgenero("Drama Histórico"));
        generos.add(drama);

        Genero fantasia = new Genero("Fantasia");
        fantasia.addSubgenero(new Subgenero("Alta Fantasia"));
        fantasia.addSubgenero(new Subgenero("Fantasia Urbana"));
        fantasia.addSubgenero(new Subgenero("Fantasia Sombria"));
        fantasia.addSubgenero(new Subgenero("Fantasia Mitológica"));
        generos.add(fantasia);

        Genero ficcaoCientifica = new Genero("Ficção Científica");
        ficcaoCientifica.addSubgenero(new Subgenero("Distopia"));
        ficcaoCientifica.addSubgenero(new Subgenero("Space Opera"));
        ficcaoCientifica.addSubgenero(new Subgenero("Cyberpunk"));
        ficcaoCientifica.addSubgenero(new Subgenero("Ficção Científica Militar"));
        generos.add(ficcaoCientifica);

        Genero historia = new Genero("História");
        historia.addSubgenero(new Subgenero("História Antiga"));
        historia.addSubgenero(new Subgenero("História Medieval"));
        historia.addSubgenero(new Subgenero("História Moderna"));
        historia.addSubgenero(new Subgenero("História Contemporânea"));
        generos.add(historia);

        Genero horror = new Genero("Horror");
        horror.addSubgenero(new Subgenero("Horror Gótico"));
        horror.addSubgenero(new Subgenero("Horror Psicológico"));
        horror.addSubgenero(new Subgenero("Horror de Monstros"));
        horror.addSubgenero(new Subgenero("Horror Cósmico"));
        generos.add(horror);

        Genero misterio = new Genero("Mistério");
        misterio.addSubgenero(new Subgenero("Mistério Policial"));
        misterio.addSubgenero(new Subgenero("Mistério de Cozy"));
        misterio.addSubgenero(new Subgenero("Mistério Jurídico"));
        misterio.addSubgenero(new Subgenero("Mistério Paranormal"));
        generos.add(misterio);

        Genero romance = new Genero("Romance");
        romance.addSubgenero(new Subgenero("Romance Histórico"));
        romance.addSubgenero(new Subgenero("Romance Contemporâneo"));
        romance.addSubgenero(new Subgenero("Romance Paranormal"));
        romance.addSubgenero(new Subgenero("Romance de Época"));
        generos.add(romance);

        Genero suspense = new Genero("Suspense");
        suspense.addSubgenero(new Subgenero("Suspense Psicológico"));
        suspense.addSubgenero(new Subgenero("Suspense Jurídico"));
        suspense.addSubgenero(new Subgenero("Suspense de Espionagem"));
        suspense.addSubgenero(new Subgenero("Suspense de Crime"));
        generos.add(suspense);

        Genero terror = new Genero("Terror");
        terror.addSubgenero(new Subgenero("Terror Sobrenatural"));
        terror.addSubgenero(new Subgenero("Terror Corporal"));
        terror.addSubgenero(new Subgenero("Terror Psicológico"));
        terror.addSubgenero(new Subgenero("Terror Gore"));
        generos.add(terror);
        //endregion

        //region Seed Titles
        addTitulo("Harry Potter e a Pedra Filosofal", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e a Câmara dos Segredos", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e o Prisioneiro de Azkaban", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e o Cálice de Fogo", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e a Ordem da Fénix", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e o Príncipe Misterioso", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("Harry Potter e os Talismãs da Morte", "J.K. Rowling", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Senhor dos Anéis: A Irmandade do Anel", "J.R.R. Tolkien", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Senhor dos Anéis: As Duas Torres", "J.R.R. Tolkien", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Senhor dos Anéis: O Regresso do Rei", "J.R.R. Tolkien", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Hobbit", "J.R.R. Tolkien", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Silmarillion", "J.R.R. Tolkien", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("A Guerra dos Tronos", "George R.R. Martin", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("A Fúria dos Reis", "George R.R. Martin", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("A Tormenta de Espadas", "George R.R. Martin", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Festim dos Corvos", "George R.R. Martin", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("A Dança dos Dragões", "George R.R. Martin", getGenero("Fantasia"), getGenero("Fantasia").getSubgenero("Alta Fantasia"));
        addTitulo("O Código Da Vinci", "Dan Brown", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("Anjos e Demónios", "Dan Brown", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("Inferno", "Dan Brown", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("O Símbolo Perdido", "Dan Brown", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("Fortaleza Digital", "Dan Brown", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("O Processo", "Franz Kafka", getGenero("Drama"), getGenero("Drama").getSubgenero("Drama Psicológico"));
        addTitulo("O Castelo", "Franz Kafka", getGenero("Drama"), getGenero("Drama").getSubgenero("Drama Psicológico"));
        addTitulo("A Metamorfose", "Franz Kafka", getGenero("Drama"), getGenero("Drama").getSubgenero("Drama Psicológico"));
        addTitulo("O Julgamento", "Franz Kafka", getGenero("Drama"), getGenero("Drama").getSubgenero("Drama Psicológico"));
        addTitulo("O Processo", "Franz Kafka", getGenero("Drama"), getGenero("Drama").getSubgenero("Drama Psicológico"));
        addTitulo("O Nome da Rosa", "Umberto Eco", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("O Pêndulo de Foucault", "Umberto Eco", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("O Cemitério de Praga", "Umberto Eco", getGenero("Mistério"), getGenero("Mistério").getSubgenero("Mistério Policial"));
        addTitulo("O Iluminado", "Stephen King", getGenero("Terror"), getGenero("Terror").getSubgenero("Terror Sobrenatural"));
        addTitulo("Carrie", "Stephen King", getGenero("Terror"), getGenero("Terror").getSubgenero("Terror Sobrenatural"));
        addTitulo("It", "Stephen King", getGenero("Terror"), getGenero("Terror").getSubgenero("Terror Sobrenatural"));
        addTitulo("A Coisa", "Stephen King", getGenero("Terror"), getGenero("Terror").getSubgenero("Terror Sobrenatural"));
        addTitulo("O Cemitério", "Stephen King", getGenero("Terror"), getGenero("Terror").getSubgenero("Terror Sobrenatural"));
        //endregion

        //region Seed Editoras / Distribuidores
        for (int i = 0; i < 10; i++) {
            addEditora(new Editora("Editora " + i));
            addDistribuidor(new Distribuidor("Distribuidor " + i));
        }
        //endregion

        //region Seed Exemplares
        for (Titulo t : titulos) {
            for (int i = 0; i < 10; i++) {
                t.addExemplar(new Exemplar(1234567890123L, 2000, "1ª Edição", t, getEditora("Editora 0"), getDistribuidor("Distribuidor 0")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 1"), getDistribuidor("Distribuidor 1")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 2"), getDistribuidor("Distribuidor 2")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "3ª Edição", t, getEditora("Editora 3"), getDistribuidor("Distribuidor 3")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "2ª Edição", t, getEditora("Editora 4"), getDistribuidor("Distribuidor 4")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 5"), getDistribuidor("Distribuidor 5")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 6"), getDistribuidor("Distribuidor 6")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "4ª Edição", t, getEditora("Editora 7"), getDistribuidor("Distribuidor 7")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 8"), getDistribuidor("Distribuidor 8")));
                t.addExemplar(new Exemplar(1234567890123L, 2001, "1ª Edição", t, getEditora("Editora 9"), getDistribuidor("Distribuidor 9")));
            }
        }
        //endregion

        //region Seed Socios
        Socio socio1 = new Socio("João", "Rua do João", "joao@mail.pt", 123456789, 912345677);
        Socio socio2 = new Socio("Maria", "Rua da Maria", "maria@mail.pt", 987654321, 987654321);
        Socio socio3 = new Socio("Manuel", "Rua do Manuel", "manuel@mail.pt", 128456789, 912345678);
        Socio socio4 = new Socio("Ana", "Rua da Ana", "ana@mail.pt", 987654321, 987654321);
        Socio socio5 = new Socio("Rui", "Rua do Rui", "rui@mail.pt", 125456789, 912345679);
        Socio socio6 = new Socio("Marta", "Rua da Marta", "marta@mail.pt", 984554321, 989854321);

        socios.add(socio1);
        socios.add(socio2);
        socios.add(socio3);
        socios.add(socio4);
        socios.add(socio5);
        socios.add(socio6);
        //endregion
    }

    /* Configurações */
    public int getMaxDias() {
        return maximoDiasEmprestimo;
    }

    public void setMaxDias(int maximoDiasEmprestimo) {
        this.maximoDiasEmprestimo = maximoDiasEmprestimo;
    }

    public float getValorMulta() {
        return valorMultaPorDia;
    }

    public void setValorMulta(float valorMultaPorDia) {
        this.valorMultaPorDia = valorMultaPorDia;
    }

    public int getMaxEmprestimos() {
        return maximoLivrosEmprestados;
    }

    public void setMaxEmprestimos(int maximoLivrosEmprestados) {
        this.maximoLivrosEmprestados = maximoLivrosEmprestados;
    }

    public float getValorAnuidade() {
        return valorAnuidade;
    }

    public void setValorAnuidade(float valorAnuidade) {
        this.valorAnuidade = valorAnuidade;
    }

    //Generos
    public LinkedList<Genero> getGeneros() {
        return generos;
    }

    public Genero getGenero(String nome) {
        for (Genero genero : generos) {
            if (genero.getNome().equals(nome)) {
                return genero;
            }
        }
        return null;
    }

    //Autores
    public LinkedList<Autor> getAutores() {
        return autores;
    }

    //Titulo
    public LinkedList<Titulo> getTitulos() {
        return titulos;
    }

    public Titulo getTitulo(String t) {
        for (Titulo titulo : titulos) {
            if (titulo.getTitulo().equalsIgnoreCase(t)) {
                return titulo;
            }
        }
        return null;
    }

    public void addTitulo(String titulo, String autor, Genero genero, Subgenero subGenero) {

        Autor newAutor = null;
        for (Autor a : autores) {
            if (a.getNome().equalsIgnoreCase(autor)) {
                newAutor = a;
                break;
            }
        }
        if (newAutor == null) {
            newAutor = new Autor(autor);
            autores.add(newAutor);
        }

        Titulo newTitle = new Titulo(titulo, newAutor, genero, subGenero);

        titulos.add((newTitle));
        newAutor.addTitulo(newTitle);
    }

    //Exemplar
    public Exemplar getExemplar(String id) {
        for (Titulo t : titulos) {
            for (Exemplar e : t.getExemplares()) {
                if (e.getId().equalsIgnoreCase(id)) {
                    return e;
                }
            }
        }
        return null;
    }

    //Editora
    public LinkedList<Editora> getEditoras() {
        return editoras;
    }

    public Editora getEditora(String textEditora) {
        for (Editora e : editoras) {
            if (e.getNome().equalsIgnoreCase(textEditora)) {
                return e;
            }
        }
        return null;
    }

    public void addEditora(Editora e) {
        editoras.add(e);
    }

    //Distribuidor
    public LinkedList<Distribuidor> getDistribuidores() {
        return fornecedores;
    }

    public Distribuidor getDistribuidor(String textDistribuidor) {
        for (Distribuidor d : fornecedores) {
            if (d.getNome().equalsIgnoreCase(textDistribuidor)) {
                return d;
            }
        }
        return null;
    }

    public void addDistribuidor(Distribuidor d) {
        fornecedores.add(d);
    }

    //Biblioteca.Estante / Biblioteca.Prateleira
    public int getPrateleirasOcupadas(Estante e) {
        if (e == null) {
            return 0;
        }

        int count = 0;
        for (Prateleira p : e.getPrateleiras()) {
            if (p.isOcupada()) {
                count++;
            }
        }
        return count;
    }

    public Estante getEstanteLivre() {
        for (Estante e : estantes) {
            if (getPrateleirasOcupadas(e) < e.getPrateleiras().length) {
                return e;
            }
        }
        return null;
    }

    public Prateleira getPrateleiraLivre(Estante e) {
        if (e == null) {
            return null;
        }
        for (Prateleira p : e.getPrateleiras()) {
            if (!p.isOcupada()) {
                return p;
            }
        }
        return null;
    }

    // Socios
    public LinkedList<Socio> getSocios() {
        return socios;
    }

    public Socio getSocio(int id) {
        for (Socio s : socios) {
            if (s.getIdSocio() == id) {
                return s;
            }
        }
        return null;
    }

    public void addSocio(Socio s) {
        socios.add(s);
    }

    //Emprestimos
    public LinkedList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Emprestimo getEmprestimo(int id) {
        for (Emprestimo e : emprestimos) {
            if (e.getIdEmprestimo() == id) {
                return e;
            }
        }
        return null;
    }

    public void criarEmprestimo(int idSocio, String idExemplar) {
        Emprestimo e = new Emprestimo(idSocio, idExemplar);
        emprestimos.add(e);
    }

    //Reservas
    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public Reserva getReserva(int id) {
        for (Reserva r : reservas) {
            if (r.getIdReserva() == id) {
                return r;
            }
        }
        return null;
    }

    public void addReserva(Reserva r) {
        reservas.add(r);
    }


    // new methods
    public LinkedList<Titulo> getTitulosMaisEmprestados() {
        titulos.sort((Comparator<Titulo>) (o1, o2) -> -Integer.compare(o1.getEmprestimos(),o2.getEmprestimos()));

        LinkedList<Titulo> titulosMaisEmprestados = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Titulo titulo = titulos.get(i);
            titulosMaisEmprestados.add(titulo);
        }

        return titulosMaisEmprestados;
    }

    public LinkedList<Titulo> getTitulosMaisEmprestados(Autor autor) {
        if (autor == null) {
            return getTitulosMaisEmprestados();
        }

        LinkedList<Titulo> autorTitulos = autor.getTitulos();
        autorTitulos.sort((Comparator<Titulo>) (o1, o2) -> -Integer.compare(o1.getEmprestimos(),o2.getEmprestimos()));

        if (autorTitulos.size() < 10) {
            return autorTitulos;
        }

        LinkedList<Titulo> titulosMaisEmprestados = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Titulo titulo = autorTitulos.get(i);
            titulosMaisEmprestados.add(titulo);
        }

        return titulosMaisEmprestados;
    }

    public LinkedList<Titulo> getTitulosMaisEmprestados(Genero genero) {
        if (genero == null) {
            return getTitulosMaisEmprestados();
        }

        LinkedList<Titulo> generosTitulos = new LinkedList<>();
        for (Titulo titulo : titulos) {
            if (titulo.getGenero().equals(genero)) {
                generosTitulos.add(titulo);
            }
        }
        generosTitulos.sort((Comparator<Titulo>) (o1, o2) -> -Integer.compare(o1.getEmprestimos(),o2.getEmprestimos()));

        if (generosTitulos.size() < 10) {
            return generosTitulos;
        }

        LinkedList<Titulo> titulosMaisEmprestados = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Titulo titulo = generosTitulos.get(i);
            titulosMaisEmprestados.add(titulo);
        }

        return titulosMaisEmprestados;
    }

    public LinkedList<Titulo> getTitulosMaisEmprestados(Subgenero subgenero) {
        if (subgenero == null) {
            return getTitulosMaisEmprestados();
        }

        LinkedList<Titulo> subgenerosTitulos = new LinkedList<>();
        for (Titulo titulo : titulos) {
            if (titulo.getSubGenero().equals(subgenero)) {
                subgenerosTitulos.add(titulo);
            }
        }
        subgenerosTitulos.sort((Comparator<Titulo>) (o1, o2) -> -Integer.compare(o1.getEmprestimos(),o2.getEmprestimos()));

        if (subgenerosTitulos.size() < 10) {
            return subgenerosTitulos;
        }

        LinkedList<Titulo> titulosMaisEmprestados = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Titulo titulo = subgenerosTitulos.get(i);
            titulosMaisEmprestados.add(titulo);
        }

        return titulosMaisEmprestados;
    }

    public Subgenero getSubgenero(String subgenero) {
        for (Genero g : generos) {
            for (Subgenero sg : g.getSubgeneros()) {
                if (sg.getNome().equalsIgnoreCase(subgenero)) {
                    return sg;
                }
            }
        }
        return null;
    }
}
