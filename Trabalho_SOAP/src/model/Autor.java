package model;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private int id;
    private String nome;
    private int anoDeNascimento;
    private ArrayList<Livro> livros = new ArrayList<>();

    public Autor (String nome, int anodeNascimento) {
        setNome(nome);
        setAnoDeNascimento(anodeNascimento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id invalido");
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.trim().isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        if (anoDeNascimento == 0) {
            throw new IllegalArgumentException("Ano de Nascimento inválido");
        }

        this.anoDeNascimento = anoDeNascimento;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        if (livros == null) {
            this.livros = new ArrayList<>();
        }

        this.livros = livros;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
