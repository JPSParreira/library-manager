import Titulo.*;
import Titulo.Exemplar.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GestorBiblioteca {
    /* Configs */
    private int maximoDiasEmprestimo;
    private float valorMultaPorDia;
    private int maximoLivrosEmprestados;
    private float valorAnuidade;

    /* Titulo */
    private LinkedList<Titulo> titulos;
    private LinkedList<Autor> autores;
    private LinkedList<Genero> generos;

    /* Exemplar */
    private LinkedList<Editora> editores;
    private LinkedList<Fornecedor> fornecedores;

    /* Biblioteca */
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

        editores = new LinkedList<>();
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

    public LinkedList<Genero> fillGeneros(){
        LinkedList<Genero> listaGeneros = new LinkedList<>();

        Genero ficcao = new Genero("Ficção");
        ficcao.addSubgenero(new Subgenero("Aventura"));
        ficcao.addSubgenero(new Subgenero("Distopia"));
        ficcao.addSubgenero(new Subgenero("Realismo Mágico"));
        listaGeneros.add(ficcao);

        Genero naoFiccao = new Genero("Não-Ficção");
        naoFiccao.addSubgenero(new Subgenero("Biografia"));
        naoFiccao.addSubgenero(new Subgenero("Ensaios"));
        naoFiccao.addSubgenero(new Subgenero("Jornalismo"));
        listaGeneros.add(naoFiccao);

        Genero romance = new Genero("Romance");
        romance.addSubgenero(new Subgenero("Histórico"));
        romance.addSubgenero(new Subgenero("Contemporâneo"));
        romance.addSubgenero(new Subgenero("Paranormal"));
        listaGeneros.add(romance);

        Genero misterio = new Genero("Mistério");
        misterio.addSubgenero(new Subgenero("Detetive"));
        misterio.addSubgenero(new Subgenero("Suspense"));
        misterio.addSubgenero(new Subgenero("Crime"));
        listaGeneros.add(misterio);

        Genero fantasia = new Genero("Fantasia");
        fantasia.addSubgenero(new Subgenero("Épica"));
        fantasia.addSubgenero(new Subgenero("Urbana"));
        fantasia.addSubgenero(new Subgenero("Sombria"));
        listaGeneros.add(fantasia);

        Genero terror = new Genero("Terror");
        terror.addSubgenero(new Subgenero("Psicológico"));
        terror.addSubgenero(new Subgenero("Sobrenatural"));
        terror.addSubgenero(new Subgenero("Gótico"));
        listaGeneros.add(terror);

        Genero poesia = new Genero("Poesia");
        poesia.addSubgenero(new Subgenero("Lírica"));
        poesia.addSubgenero(new Subgenero("Épica"));
        poesia.addSubgenero(new Subgenero("Visual"));
        listaGeneros.add(poesia);

        Genero drama = new Genero("Drama");
        drama.addSubgenero(new Subgenero("Tragédia"));
        drama.addSubgenero(new Subgenero("Comédia"));
        drama.addSubgenero(new Subgenero("Histórico"));
        listaGeneros.add(drama);

        Genero literaturaInfantil = new Genero("Literatura Infantil");
        literaturaInfantil.addSubgenero(new Subgenero("Contos de Fadas"));
        literaturaInfantil.addSubgenero(new Subgenero("Aventura"));
        literaturaInfantil.addSubgenero(new Subgenero("Educativa"));
        listaGeneros.add(literaturaInfantil);

        Genero autoajuda = new Genero("Autoajuda");
        autoajuda.addSubgenero(new Subgenero("Motivacional"));
        autoajuda.addSubgenero(new Subgenero("Saúde e Bem-Estar"));
        autoajuda.addSubgenero(new Subgenero("Finanças Pessoais"));
        listaGeneros.add(autoajuda);

        return listaGeneros;
    }

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

    public LinkedList<Emprestimo> getListaEmprestimos() {
        return emprestimos;
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

    public LinkedList<Titulo> getTitulos() {
        return titulos;
    }

    public LinkedList<Autor> getAutores() {
        return autores;
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
}
