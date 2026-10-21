package model;

public class Livro {

    private int id;
    private String nome;
    private int anoLancamento;

    public Livro() {
    }

    public Livro(String nome, int anoLancamento) {
        setNome(nome);
        setAnoLancamento(anoLancamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }

        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.trim().isBlank()) {

            throw new IllegalArgumentException("Nome Invalido");
        }

        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento == 0) {
            throw new IllegalArgumentException("Ano de Lancamento Invalido");
        }

        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
