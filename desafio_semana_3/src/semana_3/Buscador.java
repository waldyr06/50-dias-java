package semana_3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Buscador {

    private static final String URL_Path = "https://rickandmortyapi.com/api/character/";

    public String buscarPorId(int id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_Path + id))
                .GET()
                .timeout(Duration.ofSeconds(3))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 500){
            System.out.println("[LOG] Erro 500: Falha no servidor do Rick and Morty.");
            return null;
        }
        if (response.statusCode() >= 404){
            System.out.println("[LOG] Erro 404: Não encontrado na API.");
            return null;
        }

        return response.body();
    }

    public String buscarPorNome(String nomeUsuario) throws IOException, InterruptedException {

        String nomeFormatado = nomeUsuario.replace(" ", "%20");

        String linkFinal = URL_Path + "?name=" + nomeFormatado;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkFinal))
                .GET()
                .timeout(Duration.ofSeconds(3))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 500){
            System.out.println("[LOG] Erro 500: Falha no servidor do Rick and Morty.");
            return null;
        }
        if (response.statusCode() >= 404){
            System.out.println("[LOG] Erro 404: Não encontrado na API.");
            return null;
        }

        return response.body();
    }

    public String buscarPagina(int numPagina) throws IOException, InterruptedException {

        String urlFinal = URL_Path + "?page=" + numPagina;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlFinal))
                .GET()
                .timeout(Duration.ofSeconds(3))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 500){
            System.out.println("[LOG] Erro 500: Falha no servidor do Rick and Morty.");
            return null;
        }
        if (response.statusCode() >= 404){
            System.out.println("[LOG] Erro 404: Não encontrado na API.");
            return null;
        }

        return response.body();
    }
}