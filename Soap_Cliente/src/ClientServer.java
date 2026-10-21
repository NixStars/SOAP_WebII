import service.AutorService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class ClientServer {

        public static void main(String[] args) throws Exception {

            URL url = new URL(
                    "http://localhost:8080/service?wsdl"
            );

            QName qname = new QName(
                    "http://service/",
                    "AutorServerService"
            );

            Service ws = Service.create(url, qname);

            AutorService service =
                    ws.getPort(AutorService.class);

            titulo("cadastrarAutor");
            System.out.println(service.cadastrarAutor("Machado de Assis", 1839));
            System.out.println(service.cadastrarAutor("Clarice Lispector", 1920));

            int idMachado = 1;
            int idClarice = 2;

            titulo("listarAutores");
            System.out.println(service.listarAutores());

            titulo("buscarAutorPorID");
            System.out.println(service.buscarAutorPorID(idMachado));
            System.out.println(service.buscarAutorPorID(idClarice));

            titulo("atualizarAutor");
            boolean autorAtualizado = service.atualizarAutor(idMachado, "Machado de Assis (Atualizado)", 1839);
            System.out.println("Atualizado: " + autorAtualizado);
            System.out.println(service.buscarAutorPorID(idMachado));

            titulo("cadastrarLivro (Machado de Assis)");
            System.out.println(service.cadastrarLivro(idMachado, "Dom Casmurro", 1899));
            System.out.println(service.cadastrarLivro(idMachado, "Memórias Póstumas de Brás Cubas", 1881));

            titulo("cadastrarLivro (Clarice Lispector)");
            System.out.println(service.cadastrarLivro(idClarice, "A Hora da Estrela", 1977));
            System.out.println(service.cadastrarLivro(idClarice, "Perto do Coração Selvagem", 1943));
            System.out.println(service.cadastrarLivro(idClarice, "A Paixão Segundo G.H.", 1964));

            titulo("listarLivrosPorAutor (Machado de Assis)");
            System.out.println(service.listarLivrosPorAutor(idMachado));

            titulo("listarLivrosPorAutor (Clarice Lispector)");
            System.out.println(service.listarLivrosPorAutor(idClarice));

            titulo("listarLivros (todos os autores)");
            System.out.println(service.listarLivros());

            int idLivro = 1;

            titulo("atualizarLivro");
            boolean livroAtualizado = service.atualizarLivro(idMachado, idLivro, "Dom Casmurro (Edição Revisada)", 1900);
            System.out.println("Atualizado: " + livroAtualizado);
            System.out.println(service.listarLivrosPorAutor(idMachado));

            titulo("removerLivro");
            boolean livroRemovido = service.removerLivro(idMachado, idLivro);
            System.out.println("Removido: " + livroRemovido);

            titulo("listarLivros (após remover um livro do Machado)");
            System.out.println(service.listarLivros());

            
            titulo("deletarAutor (Machado de Assis)");
            boolean autorDeletado = service.deletarAutor(idMachado);
            System.out.println("Deletado: " + autorDeletado);

            titulo("listarAutores (após deletar)");
            System.out.println(service.listarAutores());

            titulo("listarLivros (após deletar o autor)");
            System.out.println(service.listarLivros());
        }

    private static void titulo(String metodo) {
        System.out.println("\n===== " + metodo + " =====");
    }

}


