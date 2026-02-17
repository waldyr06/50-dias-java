package com.semana_4.climape.controller;

import com.semana_4.climape.model.Cidade;
import com.semana_4.climape.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired; // Importante
import org.springframework.stereotype.Controller; // Importante
import org.springframework.ui.Model; // Importante (cuidado para não pegar o Model errado)
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClimaController {

    @Autowired
    private ClimaService service;

    @GetMapping("/climape") // O endereço do seu site
    public String abrirPagina(Model model) {

        // 1. Pede a lista para o Service
        List<Cidade> listaDeCidades = service.obterClimaPernambuco();

        // 2. Coloca na "bandeja" pro HTML comer
        // "cidades" é o apelido que vamos usar lá no HTML
        model.addAttribute("cidades", listaDeCidades);

        // 3. Diz qual arquivo HTML abrir
        return "pagina-clima";
    }
}