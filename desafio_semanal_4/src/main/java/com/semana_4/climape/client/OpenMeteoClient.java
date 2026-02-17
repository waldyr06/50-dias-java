package com.semana_4.climape.client;

import com.semana_4.climape.model.RespostaOpenMeteo;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class OpenMeteoClient {

    public RespostaOpenMeteo pegarClima(double latitude, double longitude) throws IOException, InterruptedException {

        String base = "https://api.open-meteo.com/v1/forecast?current_weather=true";

        String URL = base + "&latitude=" + latitude + "&longitude=" + longitude;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(4))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .GET()
                .timeout(Duration.ofSeconds(4))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 500) {
            System.out.println("[LOG] Erro 500: Falha no servidor.");
            return null;
        }
        if (response.statusCode() >= 404) {
            System.out.println("[LOG] Erro 404: Não encontrado na API.");
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();

        RespostaOpenMeteo resultado = mapper.readValue(response.body(), RespostaOpenMeteo.class);
        return resultado;
    }
}