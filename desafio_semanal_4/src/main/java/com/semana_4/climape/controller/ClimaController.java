package com.semana_4.climape.controller;

import com.semana_4.climape.model.Cidade;
import com.semana_4.climape.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClimaController {

    @Autowired
    private ClimaService service;

    @GetMapping("/climape")
    public String abrirPagina(Model model) {

        List<Cidade> listaDeCidades = service.obterClimaPernambuco();

        model.addAttribute("cidades", listaDeCidades);

        return "pagina-clima";
    }
}