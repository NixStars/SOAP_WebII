package service;

import javax.xml.ws.Endpoint;

public class Publisher {

    public static void main(String[] args) {
        String endereco =
                "http://localhost:8080/service";

        Endpoint.publish(
                endereco,
                new AutorServer( )
        );

        System.out.println(
                "Serviço publicado em: " + endereco
        );

        System.out.println(
                "WSDL: " + endereco + "?wsdl"
        );
    }
}
