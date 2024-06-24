import Biblioteca.Estante;
import Biblioteca.Prateleira;
import Titulo.*;
import Titulo.Exemplar.*;

import java.util.LinkedList;

public class GestorBiblioteca {

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

    public static final GestorBiblioteca instance = new GestorBiblioteca();

    private GestorBiblioteca() {
        maximoDiasEmprestimo = 15;
        valorMultaPorDia = 1f;
        maximoLivrosEmprestados = 3;
        valorAnuidade = 20.0f;

        titulos = new LinkedList<>();

        autores = new LinkedList<>();

        editoras = new LinkedList<>();
        fornecedores = new LinkedList<>();

        generos = fillGeneros();

        estantes = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            estantes.add(new Estante(i, 50));
        }

        emprestimos = new LinkedList<>();
        reservas = new LinkedList<>();

        socios = new LinkedList<>();
    }

    //Configurações
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

    //Emprestimos
    public LinkedList<Emprestimo> getListaEmprestimos() {
        return emprestimos;
    }

    //Generos
    public LinkedList<Genero> fillGeneros() {
        LinkedList<Genero> listaGeneros = new LinkedList<>();

        Genero acao = new Genero("Ação");
        acao.addSubgenero(new Subgenero("Ação e Aventura"));
        acao.addSubgenero(new Subgenero("Thriller de Ação"));
        acao.addSubgenero(new Subgenero("Ação Militar"));
        acao.addSubgenero(new Subgenero("Ação Espionagem"));
        listaGeneros.add(acao);

        Genero aventura = new Genero("Aventura");
        aventura.addSubgenero(new Subgenero("Aventura Épica"));
        aventura.addSubgenero(new Subgenero("Aventura de Sobrevivência"));
        aventura.addSubgenero(new Subgenero("Aventura Histórica"));
        aventura.addSubgenero(new Subgenero("Aventura de Exploração"));
        listaGeneros.add(aventura);

        Genero comedia = new Genero("Comédia");
        comedia.addSubgenero(new Subgenero("Comédia Romântica"));
        comedia.addSubgenero(new Subgenero("Comédia Satírica"));
        comedia.addSubgenero(new Subgenero("Comédia de Situação"));
        comedia.addSubgenero(new Subgenero("Comédia de Humor Negro"));
        listaGeneros.add(comedia);

        Genero drama = new Genero("Drama");
        drama.addSubgenero(new Subgenero("Drama Familiar"));
        drama.addSubgenero(new Subgenero("Drama Psicológico"));
        drama.addSubgenero(new Subgenero("Drama Social"));
        drama.addSubgenero(new Subgenero("Drama Histórico"));
        listaGeneros.add(drama);

        Genero fantasia = new Genero("Fantasia");
        fantasia.addSubgenero(new Subgenero("Alta Fantasia"));
        fantasia.addSubgenero(new Subgenero("Fantasia Urbana"));
        fantasia.addSubgenero(new Subgenero("Fantasia Sombria"));
        fantasia.addSubgenero(new Subgenero("Fantasia Mitológica"));
        listaGeneros.add(fantasia);

        Genero ficcaoCientifica = new Genero("Ficção Científica");
        ficcaoCientifica.addSubgenero(new Subgenero("Distopia"));
        ficcaoCientifica.addSubgenero(new Subgenero("Space Opera"));
        ficcaoCientifica.addSubgenero(new Subgenero("Cyberpunk"));
        ficcaoCientifica.addSubgenero(new Subgenero("Ficção Científica Militar"));
        listaGeneros.add(ficcaoCientifica);

        Genero historia = new Genero("História");
        historia.addSubgenero(new Subgenero("História Antiga"));
        historia.addSubgenero(new Subgenero("História Medieval"));
        historia.addSubgenero(new Subgenero("História Moderna"));
        historia.addSubgenero(new Subgenero("História Contemporânea"));
        listaGeneros.add(historia);

        Genero horror = new Genero("Horror");
        horror.addSubgenero(new Subgenero("Horror Gótico"));
        horror.addSubgenero(new Subgenero("Horror Psicológico"));
        horror.addSubgenero(new Subgenero("Horror de Monstros"));
        horror.addSubgenero(new Subgenero("Horror Cósmico"));
        listaGeneros.add(horror);

        Genero misterio = new Genero("Mistério");
        misterio.addSubgenero(new Subgenero("Mistério Policial"));
        misterio.addSubgenero(new Subgenero("Mistério de Cozy"));
        misterio.addSubgenero(new Subgenero("Mistério Jurídico"));
        misterio.addSubgenero(new Subgenero("Mistério Paranormal"));
        listaGeneros.add(misterio);

        Genero romance = new Genero("Romance");
        romance.addSubgenero(new Subgenero("Romance Histórico"));
        romance.addSubgenero(new Subgenero("Romance Contemporâneo"));
        romance.addSubgenero(new Subgenero("Romance Paranormal"));
        romance.addSubgenero(new Subgenero("Romance de Época"));
        listaGeneros.add(romance);

        Genero suspense = new Genero("Suspense");
        suspense.addSubgenero(new Subgenero("Suspense Psicológico"));
        suspense.addSubgenero(new Subgenero("Suspense Jurídico"));
        suspense.addSubgenero(new Subgenero("Suspense de Espionagem"));
        suspense.addSubgenero(new Subgenero("Suspense de Crime"));
        listaGeneros.add(suspense);

        Genero terror = new Genero("Terror");
        terror.addSubgenero(new Subgenero("Terror Sobrenatural"));
        terror.addSubgenero(new Subgenero("Terror Corporal"));
        terror.addSubgenero(new Subgenero("Terror Psicológico"));
        terror.addSubgenero(new Subgenero("Terror Gore"));
        listaGeneros.add(terror);

        return listaGeneros;
    }

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
}

