package com.semana_4.climape.service;

import com.semana_4.climape.client.OpenMeteoClient;
import com.semana_4.climape.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.semana_4.climape.model.RespostaOpenMeteo; // Importante!

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimaService {
    @Autowired
    private OpenMeteoClient assistente;

    private String tradutor(int codigo) {

        switch (codigo) {
            case 0 -> {
                return "Céu Limpo ☀️";
            }
            case 1, 2, 3 -> {
                return "Nublado ☁️";
            }
            case 45, 48 -> {
                return "Nevoeiro 🌫️";
            }
            case 51, 53, 55 -> {
                return "Garoa 🌧️";
            }
            case 61, 63, 65 -> {
                return "Chuva ☔";
            }
            case 80, 81, 82 -> {
                return "Chuva forte ⛈️";
            }
            case 95, 96, 99 -> {
                return "Tempestade ⛈️⛈️";
            }
            default -> {
                return "Desconhecido";
            }
        }
    }

    public List<Cidade> obterClimaPernambuco() {
        List<Cidade> lista = new ArrayList<>();

        try {
            adicionarCidade("Recife", -8.05, -34.88, lista);
            adicionarCidade("Caruaru", -8.28, -35.97, lista);
            adicionarCidade("Petrolina", -9.39, -40.50, lista);
            adicionarCidade("Garanhuns", -8.89, -36.49, lista);
            adicionarCidade("Fernando de Noronha", -3.84, -32.41, lista);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    private void adicionarCidade(String nome, double lat, double lon, List<Cidade> lista) throws Exception {
        var resposta = assistente.pegarClima(lat, lon);

        String clima = tradutor(resposta.getCurrent_weather().getWeathercode());

        lista.add(new Cidade(nome, resposta.getCurrent_weather().getTemperature(), clima, ""));
    }
}

