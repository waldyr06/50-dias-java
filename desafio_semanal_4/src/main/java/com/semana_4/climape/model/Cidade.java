package com.semana_4.climape.model;

import lombok.Data;

@Data
public class Cidade {

    private String nome;
    private Double temperatura;
    private String descricao;
    private String icone;

    public Cidade(String nome, Double temperatura, String descricao, String icone) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.descricao = descricao;
        this.icone = icone;
    }
}