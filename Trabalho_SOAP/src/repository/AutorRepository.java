package repository;

import model.Autor;
import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class AutorRepository {

    private ArrayList<Autor> autores = new ArrayList<>();
    private int proximoIdAutor = 1;
    private int proximoIdLivro = 1;

    public Autor cadastrarAutor(Autor autor) {
        autor.setId(proximoIdAutor);
        proximoIdAutor++;
        autores.add(autor);
        return autor;
    }

    public ArrayList<Autor> listarAutores() {
        return autores;
    }

    public Autor buscarAutorPorID(int id) {
        for (Autor a : autores) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean atualizarAutor (Autor autorAtualizado) {
        Autor autor = buscarAutorPorID(autorAtualizado.getId());

        if (autor != null) {
            autor.setNome(autorAtualizado.getNome());
            autor.setAnoDeNascimento(autorAtualizado.getAnoDeNascimento());
            return true;
        }
        return false;

    }

    public boolean deletarAutor(int id) {
        Autor autor = buscarAutorPorID(id);

        if (autor != null) {
            autores.remove(autor);
            return true;
        }
        return false;
    }

    public Livro cadastrarLivro(int idAutor, Livro livro) {
        Autor autor = buscarAutorPorID(idAutor);

        if (autor == null) {
            return null;
        }

        livro.setId(proximoIdLivro);
        proximoIdLivro++;

        autor.getLivros().add(livro);
        return livro;
    }

    public ArrayList<Livro> listarLivrosPorAutor(int idAutor) {
        Autor autor = buscarAutorPorID(idAutor);

        if (autor == null) {
            return new ArrayList<>();
        }
        return autor.getLivros();
    }

    public ArrayList<Livro> listarLivros() {
        ArrayList<Livro> todos = new ArrayList<>();
        for (Autor a : autores) {
            todos.addAll(a.getLivros());
        }
        return todos;
    }

    public boolean atualizarLivro(int idAutor, Livro livroAtualizado) {
        Autor autor = buscarAutorPorID(idAutor);

        if (autor == null) {
            return false;
        }

        for (Livro l : autor.getLivros()) {
            if (l.getId() == livroAtualizado.getId()) {
                l.setNome(livroAtualizado.getNome());
                l.setAnoLancamento(livroAtualizado.getAnoLancamento());
                return true;
            }
        }
        return false;
    }

    public boolean removerLivro(int idAutor, int idLivro) {
        Autor autor = buscarAutorPorID(idAutor);

        if (autor != null) {
            return autor.getLivros().removeIf(l -> l.getId() == idLivro);
        }
        return false;
    }

}
