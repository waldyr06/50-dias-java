package com.semana_4.climape.service;

import com.semana_4.climape.client.OpenMeteoClient;
import com.semana_4.climape.model.Cidade;
import com.semana_4.climape.model.RespostaOpenMeteo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClimaServiceTest {

    @Mock
    private OpenMeteoClient clientDublê;

    @InjectMocks
    private ClimaService service;

    //TESTE 1: Caminho Feliz (Sol)
    @Test
    void deveriaRetornarListaDeCidadesQuandoAAPIResponde() throws Exception {
        // CENÁRIO
        RespostaOpenMeteo respostaFalsa = new RespostaOpenMeteo();
        RespostaOpenMeteo.CurrentWeather climaFalso = new RespostaOpenMeteo.CurrentWeather();
        climaFalso.setTemperature(30.0);
        climaFalso.setWeathercode(0);
        respostaFalsa.setCurrent_weather(climaFalso);

        when(clientDublê.pegarClima(anyDouble(), anyDouble())).thenReturn(respostaFalsa);

        List<Cidade> resultado = service.obterClimaPernambuco();

        assertFalse(resultado.isEmpty());
        assertEquals(8, resultado.size());
        assertEquals("Céu Limpo ☀️", resultado.get(0).getDescricao());
    }

    //TESTE 2: Tradução de Chuva
    @Test
    void deveriaTraduzirCodigoDeChuva() throws Exception {
        RespostaOpenMeteo respostaChuva = new RespostaOpenMeteo();
        RespostaOpenMeteo.CurrentWeather climaChuva = new RespostaOpenMeteo.CurrentWeather();
        climaChuva.setTemperature(22.0);
        climaChuva.setWeathercode(61);
        respostaChuva.setCurrent_weather(climaChuva);

        when(clientDublê.pegarClima(anyDouble(), anyDouble())).thenReturn(respostaChuva);

        List<Cidade> resultado = service.obterClimaPernambuco();

        assertEquals("Chuva ☔", resultado.get(0).getDescricao());
    }

    //TESTE 3: Código Desconhecido
    @Test
    void deveriaLidarComCodigoDesconhecido() throws Exception {
        RespostaOpenMeteo respostaEstranha = new RespostaOpenMeteo();
        RespostaOpenMeteo.CurrentWeather climaEstranho = new RespostaOpenMeteo.CurrentWeather();
        climaEstranho.setTemperature(25.0);
        climaEstranho.setWeathercode(999);
        respostaEstranha.setCurrent_weather(climaEstranho);

        when(clientDublê.pegarClima(anyDouble(), anyDouble())).thenReturn(respostaEstranha);

        List<Cidade> resultado = service.obterClimaPernambuco();

        assertEquals("Desconhecido", resultado.get(0).getDescricao());
    }

    //TESTE 4: Erro na API (Caminho Triste)
    @Test
    void naoDeveriaQuebrarSeAApiFalhar() throws Exception {
        when(clientDublê.pegarClima(anyDouble(), anyDouble()))
                .thenThrow(new RuntimeException("Erro de conexão simulado"));

        List<Cidade> resultado = service.obterClimaPernambuco();

        assertTrue(resultado.isEmpty());
    }
}