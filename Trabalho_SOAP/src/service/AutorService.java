package service;

import model.Autor;
import model.Livro;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AutorService {

    @WebMethod
    String cadastrarAutor(String nome, int dataNascimento);

    @WebMethod
    String listarAutores();

    @WebMethod
    String buscarAutorPorID(int id);

    @WebMethod
    boolean atualizarAutor(int id, String nome, int dataNascimento);

    @WebMethod
    boolean deletarAutor(int id);

    @WebMethod
    String cadastrarLivro(int idAutor, String nome, int anoLancamento);

    @WebMethod
    String listarLivrosPorAutor(int idAutor);

    @WebMethod
    String listarLivros();

    @WebMethod
    boolean atualizarLivro(int idAutor, int idLivro, String nome, int dataLancamento);

    @WebMethod
    boolean removerLivro(int idAutor, int idLivro);
}
