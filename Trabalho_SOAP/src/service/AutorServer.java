package service;

import model.Autor;
import model.Livro;
import repository.AutorRepository;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "service.AutorService")
public class AutorServer implements AutorService {

    private static final AutorRepository repository =
            new AutorRepository();
    
    // autores


    @Override
    public String cadastrarAutor(String nome, int dataNascimento) {

        Autor autor = new Autor(nome, dataNascimento);

        repository.cadastrarAutor(autor);
        return autor.getNome();
    }


    @Override
    public String listarAutores() {
        return repository.listarAutores().toString();
    }


    @Override
    public String buscarAutorPorID(int id) {
        return repository.buscarAutorPorID(id).getNome();
    }


    @Override
    public boolean atualizarAutor(int id, String nome, int dataNascimento) {

        Autor autor = new Autor(nome, dataNascimento);
        autor.setId(id);

        return repository.atualizarAutor(autor);
    }


    @Override
    public boolean deletarAutor(int id) {
        return repository.deletarAutor(id);
    }
    
    // livros


    @Override
    public String cadastrarLivro(int idAutor, String nome, int anoLancamento) {

        Livro livro = new Livro(nome, anoLancamento);

        return repository.cadastrarLivro(idAutor, livro).getNome();
    }


    @Override
    public String listarLivrosPorAutor(int idAutor) {
        return repository.listarLivrosPorAutor(idAutor).toString();
    }


    @Override
    public String listarLivros() {
        return repository.listarLivros().toString();
    }


    @Override
    public boolean atualizarLivro(int idAutor, int idLivro, String nome, int dataLancamento) {

        Livro livro = new Livro(nome, dataLancamento);
        livro.setId(idLivro);

        return repository.atualizarLivro(idAutor, livro);
    }


    @Override
    public boolean removerLivro(int idAutor, int idLivro) {
        return repository.removerLivro(idAutor, idLivro);
    }
}
